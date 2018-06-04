package entity;
// Generated 31/05/2018 09:05:04 AM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Historial generated by hbm2java
 */
public class Historial  implements java.io.Serializable {


     private String curppHistorial;
     private Paciente paciente;
     private Date fecha;
     private String contenido;
     private Set generarHistorials = new HashSet(0);

    public Historial() {
    }

	
    public Historial(Paciente paciente, Date fecha, String contenido) {
        this.paciente = paciente;
        this.fecha = fecha;
        this.contenido = contenido;
    }
    public Historial(Paciente paciente, Date fecha, String contenido, Set generarHistorials) {
       this.paciente = paciente;
       this.fecha = fecha;
       this.contenido = contenido;
       this.generarHistorials = generarHistorials;
    }
   
    public String getCurppHistorial() {
        return this.curppHistorial;
    }
    
    public void setCurppHistorial(String curppHistorial) {
        this.curppHistorial = curppHistorial;
    }
    public Paciente getPaciente() {
        return this.paciente;
    }
    
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getContenido() {
        return this.contenido;
    }
    
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    public Set getGenerarHistorials() {
        return this.generarHistorials;
    }
    
    public void setGenerarHistorials(Set generarHistorials) {
        this.generarHistorials = generarHistorials;
    }




}

