/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasoexamen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.SortedMap;
import static repasoexamen.LecturaCSV.lecturaFicheroCSV;
import static repasoexamen.LecturaJSON.leerFicheroJSON;

/**
 *
 * @author GR6
 */
public class Programa {

    public static void main(String[] args) throws IOException {

        //Ejercicio1
        SortedMap<String, String> inicialesDescripcion = lecturaFicheroCSV("nombresModulos.csv");

        inicialesDescripcion.forEach((clave, valor) -> System.out.println("Clave: " + clave + " -- Objeto: " + valor));

        System.out.println("----------------------");

        //Ejercicio2
        ArrayList<RegistroJSON> listaAlumnosCalificaciones = leerFicheroJSON("calificacionesGrupo.json");

        System.out.println("---- Lista de calificaciones de los alumnos ----");
        listaAlumnosCalificaciones.forEach((listaCalificacion) -> {
            System.out.println(listaCalificacion);
        });

        System.out.println("----------------------");

        //Ejercicio3
    }

}
