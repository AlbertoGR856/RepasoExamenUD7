/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;
// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root[] root = om.readValue(myJsonString, Root[].class); */
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collector;

/**
 *
 * @author GR6
 */
public class RegistroJSON {

    @JsonProperty("Alumno/a")
    private String alumnoA;
    @JsonProperty("OACV")
    private String oACV;
    @JsonProperty("EA")
    private String eA;
    @JsonProperty("TII")
    private String tII;
    @JsonProperty("TC")
    private String tC;
    @JsonProperty("ING")
    private String iNG;
    @JsonProperty("FOL")
    private String fOL;
    @JsonProperty("CEAC")
    private String cEAC;

    public RegistroJSON(String alumnoA, String oACV, String eA, String tII, String tC, String iNG, String fOL, String cEAC) {
        this.alumnoA = alumnoA;
        this.oACV = oACV;
        this.eA = eA;
        this.tII = tII;
        this.tC = tC;
        this.iNG = iNG;
        this.fOL = fOL;
        this.cEAC = cEAC;
    }

    public RegistroJSON() {
    }

    public String getAlumnoA() {
        return alumnoA;
    }

    public void setAlumnoA(String alumnoA) {
        this.alumnoA = alumnoA;
    }

    public String getoACV() {
        return oACV;
    }

    public void setoACV(String oACV) {
        this.oACV = oACV;
    }

    public String geteA() {
        return eA;
    }

    public void seteA(String eA) {
        this.eA = eA;
    }

    public String gettII() {
        return tII;
    }

    public void settII(String tII) {
        this.tII = tII;
    }

    public String gettC() {
        return tC;
    }

    public void settC(String tC) {
        this.tC = tC;
    }

    public String getiNG() {
        return iNG;
    }

    public void setiNG(String iNG) {
        this.iNG = iNG;
    }

    public String getfOL() {
        return fOL;
    }

    public void setfOL(String fOL) {
        this.fOL = fOL;
    }

    public String getcEAC() {
        return cEAC;
    }

    public void setcEAC(String cEAC) {
        this.cEAC = cEAC;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.alumnoA);
        hash = 37 * hash + Objects.hashCode(this.oACV);
        hash = 37 * hash + Objects.hashCode(this.eA);
        hash = 37 * hash + Objects.hashCode(this.tII);
        hash = 37 * hash + Objects.hashCode(this.tC);
        hash = 37 * hash + Objects.hashCode(this.iNG);
        hash = 37 * hash + Objects.hashCode(this.fOL);
        hash = 37 * hash + Objects.hashCode(this.cEAC);
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
        final RegistroJSON other = (RegistroJSON) obj;
        if (!Objects.equals(this.alumnoA, other.alumnoA)) {
            return false;
        }
        if (!Objects.equals(this.oACV, other.oACV)) {
            return false;
        }
        if (!Objects.equals(this.eA, other.eA)) {
            return false;
        }
        if (!Objects.equals(this.tII, other.tII)) {
            return false;
        }
        if (!Objects.equals(this.tC, other.tC)) {
            return false;
        }
        if (!Objects.equals(this.iNG, other.iNG)) {
            return false;
        }
        if (!Objects.equals(this.fOL, other.fOL)) {
            return false;
        }
        return Objects.equals(this.cEAC, other.cEAC);
    }

    @Override
    public String toString() {
        return "RegistroJSON{" + "alumnoA=" + alumnoA + ", oACV=" + oACV + ", eA=" + eA + ", tII=" + tII + ", tC=" + tC + ", iNG=" + iNG + ", fOL=" + fOL + ", cEAC=" + cEAC + '}';
    }

    public Collector<RegistroJSON, ?, Map<Object, RegistroJSON>> getKey() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
