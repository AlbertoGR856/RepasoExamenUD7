/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import java.util.Objects;

import java.util.SortedMap;

/**
 *
 * @author GR6
 */
public class Alumnado implements Comparable<Alumnado> {

    @JsonProperty("Nombre de alumno/a")
    private String nombreAlumno;
    @JsonProperty("InicialModulo: calificación")
    private SortedMap<String, String> mapIncialDescripcion;

    public Alumnado(String nombreAlumno, SortedMap<String, String> mapIncialDescripcion) {
        this.nombreAlumno = nombreAlumno;
        this.mapIncialDescripcion = mapIncialDescripcion;
    }

    public Alumnado() {
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public SortedMap<String, String> getMapIncialDescripcion() {
        return mapIncialDescripcion;
    }

    public void setMapIncialDescripcion(SortedMap<String, String> mapIncialDescripcion) {
        this.mapIncialDescripcion = mapIncialDescripcion;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.nombreAlumno);
        hash = 59 * hash + Objects.hashCode(this.mapIncialDescripcion);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Alumnado other = (Alumnado) obj;
        if (!Objects.equals(this.nombreAlumno, other.nombreAlumno)) {
            return false;
        }
        return Objects.equals(this.mapIncialDescripcion, other.mapIncialDescripcion);
    }

    @Override
    public String toString() {
         String modulosNotas ="";
         //Formato del Map, para que aparezca como en el ejemplo
         //[Nombre de alumno/a]
         //[InicialModulo: calificación] [InicialModulo: calificación] [InicialModulo: calificación]...
        for (Map.Entry<String, String> entry : mapIncialDescripcion.entrySet()) {
            modulosNotas+="["+entry.getKey()+": "+entry.getValue()+"] ";
        }
        return "[" + this.nombreAlumno + "]\n" + modulosNotas;

    }

    @Override
    public int compareTo(Alumnado a) {
        return this.nombreAlumno.compareTo(a.nombreAlumno);

    }

}
