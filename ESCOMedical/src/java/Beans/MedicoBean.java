package Beans;

import entity.Administrador;
import entity.HibernateUtil;
import entity.Medico;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.PrimeFaces;

@ManagedBean
@ViewScoped
public class MedicoBean implements Serializable {

    private String nombre;
    private String apellidop;
    private String apellidom;
    private int edad;
    private String correo;
    private String contra;
    private String rcontra;
    private int consultorio;
    private String curp;
    private String telefono;
    private String especialidad;
    private Date fecha = new Date();
    private final FacesContext fc;
    private final HttpServletRequest request;
    private List lstMedicos;
    private final Session hibernateSession = HibernateUtil.getSessionFactory().openSession();

    public MedicoBean() {
        fc = FacesContext.getCurrentInstance();
        request = (HttpServletRequest) fc.getExternalContext().getRequest();
        Query consultaM = hibernateSession.createQuery("from Medico");
        lstMedicos = consultaM.list();
    }

    public String validate() {
        Transaction t = hibernateSession.beginTransaction();
        //Revisamos que todos los campos esten llenos
        if (nombre.equals("") || apellidop.equals("") || apellidom.equals("") || correo.equals("") || contra.equals("") || rcontra.equals("") || edad == 0 || telefono.equals("") || especialidad.equals("") || consultorio == 0) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Revisar", "Debe llenar todos los campos.");
            PrimeFaces.current().dialog().showMessageDynamic(message);
            return null;
        } else if (!contra.equals(rcontra)) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Revisar", "Las constraseñas no coinciden.");
            PrimeFaces.current().dialog().showMessageDynamic(message);
            return null;
        }
        String idAd = (String) request.getSession().getAttribute("idcurp");
        Administrador ad = (Administrador) hibernateSession.createQuery("from Administrador where CURPA = '" + idAd + "' ").uniqueResult();
        Medico me = new Medico(curp, ad, nombre, apellidop, apellidom, edad, correo, telefono, contra, especialidad, consultorio, fecha);
        hibernateSession.save(me);
        t.commit();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro exitoso", "Médico Agregado");
        PrimeFaces.current().dialog().showMessageDynamic(message);
        lstMedicos.clear();
        lstMedicos = hibernateSession.createQuery("from Medico").list();
        return null;
    }

    public String eliminarPersona(String curpD) {
        Transaction t = hibernateSession.beginTransaction();
        Medico me = (Medico) hibernateSession.load(Medico.class, curpD);
        hibernateSession.delete(me);
        t.commit();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Teacher deleted", "Review changed");
        PrimeFaces.current().dialog().showMessageDynamic(message);
        lstMedicos.clear();
        Query consulta = hibernateSession.createQuery("from Medico");
        lstMedicos = consulta.list();
        return null;
    }

    public String guardar(Medico me) {
        Transaction t = hibernateSession.beginTransaction();
        me.setEditable(false);
        String hql = "update Medico set nombre = :nombre, appat = :appat, apmat = :apmat, consultorio = :consultorio, curpm = :curpm where curpm = '" + me.getCurpm() + "'";
        System.out.println(hql);
        Query guarda = hibernateSession.createQuery(hql);
        guarda.setParameter("nombre", me.getNombre());
        guarda.setParameter("appat", me.getAppat());
        guarda.setParameter("apmat", me.getApmat());
        guarda.setParameter("consultorio", me.getConsultorio());
        guarda.setParameter("curpm", me.getCurpm());
        guarda.executeUpdate();
        t.commit();
        lstMedicos.clear();
        lstMedicos = hibernateSession.createQuery("from Medico").list();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Change saved", "Verify that all is okey");
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

    public int getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(int consultorio) {
        this.consultorio = consultorio;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List getLstMedicos() {
        return lstMedicos;
    }

    public void setLstMedicos(List lstMedicos) {
        this.lstMedicos = lstMedicos;
    }

    public String editAction(Medico m) {
        m.setEditable(true);
        return null;
    }

}
