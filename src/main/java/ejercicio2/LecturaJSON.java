/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author GR6
 */
/*
Ejercicio 2 – Lectura de datos JSON (2 puntos)

Crea una clase, llamada LecturaJSON, que contenga un método que permita la lectura del fichero JSON que hay en
la raíz de tu proyecto. Este método recibe el nombre y ruta del fichero a leer y se encarga de devolver una estructura
de tipo ArrayList de objetos RegistroJSON, que es una clase POJO para almacenar la información del fichero. Ten en
cuenta que algunas calificaciones son “APRO” o “NE” y otras son de tipo entero entre 0 y 10. Es recomendable
guardarlas todas como String. No te preocupes por la codificación de caracteres del archivo.
Realiza una prueba de lectura en la clase Programa y muestra por consola el resultado obtenido. Presta atención al
control de excepciones.

La definición de la clase LecturaJSON, la firma del método de lectura y el tipo devuelto son
correctos. No existen atributos innecesarios
0,15

La definición de atributos y métodos de la clase RegistroJSON es correcta y contiene las
anotaciones JSON necesarias para su tratamiento con las librerías estudiadas
0,75

El proyecto incluye en sus dependencias las referencias a las librerías que posibilitan el
tratamiento de ficheros JSON
0,1

La lectura del fichero se realiza correctamente, se utilizan las clases apropiadas y se
guardan todos los registros en una lista. Se liberan los recursos una vez finalizada la
lectura
1
 */
public class LecturaJSON {

    public static ArrayList<RegistroJSON> leerFicheroJSON(String fichero) throws IOException {

        //Se crea y se inicializa un objeto de tipo  ObjectMapper 
        ObjectMapper mapeador = new ObjectMapper();

        //Permite a mapeador usar fechas según java time
        mapeador.registerModule(new JavaTimeModule());

        //Se crea la lista de objetos App y se procede a utilizar la funcion .readValue()
        //Esta funcion se le pasa la ruta del archivo json a leer y el objeto de tipo mapeador (Incluyendo la clase App y la lista)
        ArrayList<RegistroJSON> listaCalificaciones = mapeador.readValue(new File(fichero),
                mapeador.getTypeFactory().constructCollectionType(ArrayList.class, RegistroJSON.class));

//        //Se recorre la lista con un for-each y se imprime por consola
//        System.out.println("---- Lista de Calificaciones ----");
//
//        for (RegistroJSON listaCalificacion : listaCalificaciones) {
//
//            System.out.println(listaCalificacion);
//        }
        return listaCalificaciones;
    }

    public static void main(String[] args) throws IOException {
        
         ArrayList<RegistroJSON> listaAlumnosCalificaciones = leerFicheroJSON("calificacionesGrupo.json");
         
          System.out.println("---- Lista de calificaciones de los alumnos ----");
         listaAlumnosCalificaciones.forEach((listaCalificacion) -> {
             System.out.println(listaCalificacion);
        });

    }
}
