package Beans;

import entity.HibernateUtil;
import entity.Paciente;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.PrimeFaces;

@ManagedBean
@RequestScoped
public class SignInBean implements Serializable {

    private String nombre;
    private String apellidop;
    private String apellidom;
    private int edad;
    private String correo;
    private String contra;
    private String rcontra;
    private String curp;
    private String telefono;
    private String enfermedad;

    public String validate() {
        //Revisamos que todos los campos esten llenos
        if (nombre.equals("") || apellidop.equals("") || apellidom.equals("") || correo.equals("") || contra.equals("") || rcontra.equals("") || edad == 0 || telefono.equals("") || enfermedad.equals("")) {
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
        Paciente p = new Paciente(curp, nombre, apellidop, apellidom, edad, correo, telefono, contra, enfermedad);
        hibernateSession.save(p);
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public String getRcontra() {
        return rcontra;
    }

    public void setRcontra(String rcontra) {
        this.rcontra = rcontra;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

}
