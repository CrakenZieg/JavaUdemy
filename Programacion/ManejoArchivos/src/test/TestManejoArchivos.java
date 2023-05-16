
package test;

import static manejoarchivos.ManejoArchivos.*;

public class TestManejoArchivos {
    public static void main(String[] args) {
        var nombreArchivo = "prueba.txt";
//        crearArchivo(nombreArchivo); ya esta creado, ahora debemos escribir con:
        escribirArchivo(nombreArchivo, "Tarasca papaya1");
        anexarArchivo(nombreArchivo, "Tarasca papaya2");
        leerArchivo(nombreArchivo);
    }
}
