package Beans;

import entity.HibernateUtil;
import entity.Medico;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.PrimeFaces;

@ManagedBean
@RequestScoped
public class MedicoBean implements Serializable {

    private String nombre;
    private String apellidop;
    private String apellidom;
    private int edad;
    private String correo;
    private String contra;
    private String rcontra;
    private int consulatorio;
    private String curp;
    private String telefono;
    private String especialidad;

    public MedicoBean() {
    }

    public String validate() {
        //Revisamos que todos los campos esten llenos
        if (nombre.equals("") || apellidop.equals("") || apellidom.equals("") || correo.equals("") || contra.equals("") || rcontra.equals("") || edad == 0 || telefono.equals("") || especialidad.equals("")|| consulatorio == 0) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Revisar", "Debe llenar todos los campos.");
            PrimeFaces.current().dialog().showMessageDynamic(message);
            return null;
        } else if (!contra.equals(rcontra)) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Revisar", "Las constraseñas no coinciden.");
            PrimeFaces.current().dialog().showMessageDynamic(message);
            return null;
        }
        Session hibernateSession;
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Transaction t = hibernateSession.beginTransaction();
       Medico me = new Medico
        hibernateSession.save(me);
        t.commit();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro exitoso", "Inicie Sesión para comenzar");
        PrimeFaces.current().dialog().showMessageDynamic(message);
        return null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidop() {
        return apellidop;
    }

    public void setApellidop(String apellidop) {
        this.apellidop = apellidop;
    }

    public String getApellidom() {
        return apellidom;
    }

    public void setApellidom(String apellidom) {
        this.apellidom = apellidom;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getRcontra() {
        return rcontra;
    }

    public void setRcontra(String rcontra) {
        this.rcontra = rcontra;
    }

    public int getConsulatorio() {
        return consulatorio;
    }

    public void setConsulatorio(int consulatorio) {
        this.consulatorio = consulatorio;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    
}
