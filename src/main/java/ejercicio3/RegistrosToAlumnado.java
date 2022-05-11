/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3;

import static ejercicio2.LecturaJSON.leerFicheroJSON;
import ejercicio2.RegistroJSON;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 *
 * @author GR6
 */
/*
Ejercicio 3 – Mapeo de datos (2,5 puntos)

En una nueva clase llamada RegistrosToAlumnado, implementa un método que reciba la lista de objetos de tipo
RegistroJSON y devuelva una nueva lista de objetos de tipo Alumnado. La clase Alumnado contiene como atributos:
el nombre del alumno/a en cuestión y una estructura Map ordenada donde cada inicial de módulo (key) se mapea
con su calificación (value). Implementa la interfaz <<Comparable>> usando el atributo nombre del alumno/a. La
clase Alumnado es de tipo POJO y su método toString devuelve, para cada alumno/a la siguiente información, en dos
líneas:
[Nombre de alumno/a]
[InicialModulo: calificación] [[InicialModulo: calificación] [InicialModulo: calificación]...

Realiza una prueba de conversión de la lista de registros JSON en una lista de objetos Alumnado ORDENADA, en la
clase Programa y muestra por consola el resultado obtenido.

La definición de la clase RegistroToAlumnado, la firma del método de conversión y el tipo
devuelto son correctos. No existen atributos innecesarios
0,15

La definición de la clase Alumnado, junto con la declaración de atributos y métodos es
correcta. No existen atributos innecesarios.
0,15

La clase Alumnado implementa correctamente la interfaz y el método correspondiente 
0,2

El método toString de la clase Alumnado devuelve la información con el formato solicitado 
0,25

El método que convierte objetos RegistroJSON en objetos Alumnado realiza
correctamente su función y devuelve la lista de objetos. El método es legible y eficiente
1,25
 */
public class RegistrosToAlumnado {

    public static ArrayList<Alumnado> registrosAlumnos(ArrayList<RegistroJSON> listaRegistros) {

        ArrayList<Alumnado> alumnados = new ArrayList<>();
        for (RegistroJSON registro : listaRegistros) {
            Alumnado alumno = new Alumnado();

            alumno.setNombreAlumno(registro.getAlumnoA());
            SortedMap<String, String> notas = new TreeMap<>();

            notas.put("ACV", registro.getoACV());
            notas.put("EA", registro.geteA());
            notas.put("TII", registro.gettII());
            notas.put("TC", registro.gettC());
            notas.put("ING", registro.getiNG());
            notas.put("FOL", registro.getfOL());
            notas.put("CEAC", registro.getcEAC());

            alumno.setMapIncialDescripcion(notas);

            alumnados.add(alumno);
        }

        Collections.sort(alumnados);

        return alumnados;
    }

    public static void main(String[] args) throws IOException {

        ArrayList<RegistroJSON> listaAlumnosCalificaciones = leerFicheroJSON("calificacionesGrupo.json");
        ArrayList<Alumnado> listaAlumnado = registrosAlumnos(listaAlumnosCalificaciones);

        for (Alumnado alumnado : listaAlumnado) {

            System.out.println(alumnado.toString());
        }
    }

}
