package entity;
// Generated 31/05/2018 09:05:04 AM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Administrador generated by hbm2java
 */
public class Administrador  implements java.io.Serializable {


     private String curpa;
     private String nombre;
     private String appat;
     private String apmat;
     private int edad;
     private String correo;
     private String telefono;
     private String contrasena;
     private Date fechaIngreso;
     private Set medicos = new HashSet(0);

    public Administrador() {
    }

	
    public Administrador(String curpa, String nombre, String appat, String apmat, int edad, String correo, String telefono, String contrasena, Date fechaIngreso) {
        this.curpa = curpa;
        this.nombre = nombre;
        this.appat = appat;
        this.apmat = apmat;
        this.edad = edad;
        this.correo = correo;
        this.telefono = telefono;
        this.contrasena = contrasena;
        this.fechaIngreso = fechaIngreso;
    }
    public Administrador(String curpa, String nombre, String appat, String apmat, int edad, String correo, String telefono, String contrasena, Date fechaIngreso, Set medicos) {
       this.curpa = curpa;
       this.nombre = nombre;
       this.appat = appat;
       this.apmat = apmat;
       this.edad = edad;
       this.correo = correo;
       this.telefono = telefono;
       this.contrasena = contrasena;
       this.fechaIngreso = fechaIngreso;
       this.medicos = medicos;
    }
   
    public String getCurpa() {
        return this.curpa;
    }
    
    public void setCurpa(String curpa) {
        this.curpa = curpa;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getAppat() {
        return this.appat;
    }
    
    public void setAppat(String appat) {
        this.appat = appat;
    }
    public String getApmat() {
        return this.apmat;
    }
    
    public void setApmat(String apmat) {
        this.apmat = apmat;
    }
    public int getEdad() {
        return this.edad;
    }
    
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getCorreo() {
        return this.correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getContrasena() {
        return this.contrasena;
    }
    
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public Date getFechaIngreso() {
        return this.fechaIngreso;
    }
    
    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    public Set getMedicos() {
        return this.medicos;
    }
    
    public void setMedicos(Set medicos) {
        this.medicos = medicos;
    }




}


