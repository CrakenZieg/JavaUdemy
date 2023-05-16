
package dominio;

public class Cliente {
    
//Los atributos van a ser los mismos que los que figuran en la base de datos, va a 
//ser la version objeto de java de cada fila que recuperemos de la DDBB
    private int idCliente;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private Double saldo;
    
//constructores:
    //vacio
    public Cliente() {
    }
    //para borrar un cliente solo necesitamos su Id
    public Cliente(int idCliente) {
        this.idCliente = idCliente;
    }
    //para agregar un cliente necesitamos todos sus datos menos su Id (lo asigna la DDBB)
    public Cliente(String nombre, String apellido, String email, String telefono, Double saldo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.saldo = saldo;
    }
    //para modificar un cliente necesitamos todos los datos a cambiar y tambien su Id 
    public Cliente(int idCliente, String nombre, String apellido, String email, String telefono, Double saldo) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.saldo = saldo;
    }
    
//getters y setters
    //Id
    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    //nombre
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //apellido
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    //email
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    //telefono
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    //saldo
    public Double getSaldo() {
        return saldo;
    }
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
//sobrescribimos toString
    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", telefono=" + telefono + ", saldo=" + saldo + '}';
    } 
    
}
