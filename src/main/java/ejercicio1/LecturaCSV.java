/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 *
 * @author GR6
 */
/*
Ejercicio 1 – Lectura de datos CSV (1 puntos)
Crea una clase, llamada LecturaCSV, que contenga un método que permita la lectura del fichero CSV de la raíz de tu
proyecto. Este método recibe el nombre y ruta del fichero a leer y se encarga de devolver una estructura de tipo Map
ordenada de forma que las iniciales de los módulos sean las claves y el nombre completo de cada módulo sean los
valores asociados a dichas claves.
Realiza una prueba de lectura en la clase Programa y muestra por consola el resultado obtenido. Presta atención al
control de excepciones.

La definición de la clase LecturaCSV, la firma del método de lectura y el tipo devuelto son
correctos. No existen atributos innecesarios
0,15

La lectura del fichero se realiza correctamente: se utilizan las clases apropiadas, se
recorren todos los registros y se liberan los recursos una vez finalizada la lectura. El
método es eficiente
0,45

La creación de la estructura Map es correcta: se crea una estructura TreeMap y se
mapean correctamente los campos del fichero en los pares clave-valor de la estructura
0,4
 */
public class LecturaCSV {

    //Leer los ficheros de la carpeta “copias” e ir guardando los objetos en una lista de vehículos.
    public static SortedMap<String, String> lecturaFicheroCSV(String fichero) {

        //Variables para almacenar lo que se lee por Scanner
        String linea;
        String[] tokens;

        SortedMap<String, String> inicialesDescripcion = new TreeMap<>();

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo. Hace uso del sistema UTF-8
        //Se uso de la clase Scanner
        //ESTRUCTURA PRINCIPAL DE LECTURA CON SCANNER
        try ( Scanner datosFichero = new Scanner(new File(fichero), "ISO-8859-1")) {
            // hasNextInt devuelve true mientras haya enteros por leer
            datosFichero.nextLine();
            while (datosFichero.hasNextLine()) {

                //Se añade el contenido del fichero a la variable String linea
                linea = datosFichero.nextLine();

                //Se separa el contenio de la variable linea con : usando la funcion .split() 
                tokens = linea.split(";");

                Modulo modulo = new Modulo();

                modulo.setInicial(tokens[0]);
                modulo.setDescripcion(tokens[1]);

                inicialesDescripcion.put(modulo.getInicial(), modulo.getDescripcion());
            }

            //Excepcion de tipo FileNotFoundException, en caso de que no exitiera el archivo a leer
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return inicialesDescripcion;
    }

    public static void main(String[] args) {

        SortedMap<String, String> inicialesDescripcion = lecturaFicheroCSV("nombresModulos.csv");

        //inicialesDescripcion.forEach(System.out::println);
        inicialesDescripcion.forEach((clave, valor) -> System.out.println("Clave: " + clave + " -- Objeto: " + valor));

    }

}
