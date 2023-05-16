package web;

import datos.*;
import dominio.Cliente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

//el ServletControlador tiene que recuperar la lista de clientes y compartirala con 
//clientes.jsp y redireccionarnos allí
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar" ->
                    this.editarCliente(request, response);
                case "eliminar" ->
                    this.eliminarCliente(request, response);
                default ->
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }
//abstraemos de los metodos un bloque importante de acciones ya que van a repetirse en diferente metodos

    private void accionDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //creamos un objeto ClienteDaoJDBC y llamamos a su metodo listar, que nos devuelve
        //la lista de los clientes que está en la base de datos
        List<Cliente> clientes = new ClienteDaoJDBC().listar();
        //System.out.println("clientes = " + clientes);

        //lo agregamos a la request
        //request.setAttribute("clientes", clientes);
        //pasamos el atributo totalClientes
        //request.setAttribute("totalClientes", clientes.size());
        //pasamos el atributo saldoTotal
        //request.setAttribute("saldoTotal", calcularSaldoTotal(clientes));
        //redireccionamos a clientes.jsp y le devolvemos la request con .fordward()
        //request.getRequestDispatcher("clientes.jsp").forward(request, response);
        //como forward solo modifica del lado del server y queremos que se renueve la url usaremos redirect()
        //como redirect() manda un get nuevo, nuestro scope de request queda vacio, por lo
        //tanto debemos buscar session para lograr que se mantengan los datos
        HttpSession sesion = request.getSession();
        //agregamos clientes a la sesion
        sesion.setAttribute("clientes", clientes);
        //pasamos el atributo totalClientes
        sesion.setAttribute("totalClientes", clientes.size());
        //pasamos el atributo saldoTotal
        sesion.setAttribute("saldoTotal", calcularSaldoTotal(clientes));
        response.sendRedirect("clientes.jsp");

    }

    private double calcularSaldoTotal(List<Cliente> clientes) {
        double saldoTotal = 0;
        for (Cliente cliente : clientes) {
            saldoTotal += cliente.getSaldo();
        }
        return saldoTotal;
    }

    private void editarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //recuperamos el idCliente
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        //recuperamos los otros valores de la DDBB y creamos un obj cliente   
        Cliente cliente = new ClienteDaoJDBC().encontrar(new Cliente(idCliente));
        //lo agregamos al scope
        request.setAttribute("cliente", cliente);
        String jspEditar = "/WEB-INF/paginas/cliente/editarCliente.jsp";
        //enviamos y redireccionamos a un jsp para editarCliente 
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }
    
    private void eliminarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //recuperamos los valores del formulario
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        //creamos un obj cliente con los datos recuperados
        Cliente cliente = new Cliente(idCliente);
        
        //lo eliminamos de la DDBB
        int registrosModificados = new ClienteDaoJDBC().eliminar(cliente);
        
        System.out.println("Registros Modificados = " + registrosModificados);
        //redirigimos hacia accion por default
        this.accionDefault(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar" ->
                    this.insertarCliente(request, response);
                case "modificar" ->
                    this.modificarCliente(request, response);
                default ->
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void insertarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //recuperamos los valores del formulario
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        double saldo = 0;
        String saldoString = request.getParameter("saldo");
        if (saldoString != null && !"".equals(saldoString)) {
            saldo = Double.parseDouble(saldoString);
        }
        //creamos un obj cliente con los datos recuperados
        Cliente cliente = new Cliente(nombre, apellido, email, telefono, saldo);
        //lo insertamos en la DDBB
        int registrosModificados = new ClienteDaoJDBC().insertar(cliente);
        System.out.println("Registros Modificados = " + registrosModificados);
        //redirigimos hacia accion por default
        this.accionDefault(request, response);
    }
    
    private void modificarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //recuperamos los valores del formulario
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        double saldo = 0;
        String saldoString = request.getParameter("saldo");
        if (saldoString != null && !"".equals(saldoString)) {
            saldo = Double.parseDouble(saldoString);
        }
        //creamos un obj cliente con los datos recuperados
        Cliente cliente = new Cliente(idCliente, nombre, apellido, email, telefono, saldo);
        //lo insertamos en la DDBB
        int registrosModificados = new ClienteDaoJDBC().actualizar(cliente);
        System.out.println("Registros Modificados = " + registrosModificados);
        //redirigimos hacia accion por default
        this.accionDefault(request, response);
    }

}
