package Beans;

import entity.Administrador;
import entity.HibernateUtil;
import entity.Medico;
import entity.Paciente;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Session;
import org.primefaces.PrimeFaces;

@ManagedBean
@RequestScoped

public class LoginBean implements Serializable {

    private final HttpServletRequest request;
    private String curp;
    private String psw;
    private String tipo;
    private final FacesContext fc;

    public LoginBean() {
        fc = FacesContext.getCurrentInstance();
        request = (HttpServletRequest) fc.getExternalContext().getRequest();
    }

    public String validate() {
        System.out.println("Holaa");
        int tipoU = 0;
        Administrador ad = null;
        Medico me = null;
        Paciente pa = null;
        String idcurp, correo, nombre;
        Session hibernateSession;
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        hibernateSession.beginTransaction();

        if (psw.equals("") || curp.equals("")) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Revisar", "Llenar ambos campos");
            PrimeFaces.current().dialog().showMessageDynamic(message);
            return null;
        } else {
            if (tipo.equals("Administrador")) {
                tipoU = 1;
                ad = (Administrador) hibernateSession.createQuery("from Administrador where curpa = '" + curp + "' and contrasena = '" + psw + "'").uniqueResult();
                try {
                    request.getSession().setAttribute("idcurp", ad.getCurpa());
                    nombre = ad.getNombre() + " " + ad.getAppat() + " " + ad.getApmat();
                    request.getSession().setAttribute("nombre", nombre);
                    System.out.println(nombre + " desde login");
                    request.getSession().setAttribute("correo", ad.getCorreo());
                } catch (Exception e) {
                    FacesMessage message0 = new FacesMessage(FacesMessage.SEVERITY_INFO, "Revisar", "CURP, contraseña o tipo incorrecto");
                    PrimeFaces.current().dialog().showMessageDynamic(message0);
                    return "index";
                }
            } else {
                if (tipo.equals("Medico")) {
                    tipoU = 2;
                    me = (Medico) hibernateSession.createQuery("from Medico where curpm = '" + curp + "' and contrasena = '" + psw + "'").uniqueResult();
                    try {
                        request.getSession().setAttribute("idcurp", me.getCurpm());
                        nombre = me.getNombre() + " " + me.getAppat() + " " + me.getApmat();
                        request.getSession().setAttribute("nombre", nombre);
                        request.getSession().setAttribute("correo", me.getCorreo());
                    } catch (Exception e) {
                        FacesMessage message1 = new FacesMessage(FacesMessage.SEVERITY_INFO, "Revisar", "CURP, contraseña o tipo incorrecto");
                        PrimeFaces.current().dialog().showMessageDynamic(message1);
                        return "index";
                    }
                } else {
                    tipoU = 3;
                    pa = (Paciente) hibernateSession.createQuery("from Paciente where curpp = '" + curp + "' and contrasena = '" + psw + "'").uniqueResult();
                    try {
                        request.getSession().setAttribute("idcurp", pa.getCurpp());
                        nombre = pa.getNombre() + " " + pa.getAppat() + " " + pa.getApmat();
                        request.getSession().setAttribute("nombre", nombre);
                        request.getSession().setAttribute("correo", pa.getCorreo());
                    } catch (Exception e) {
                        FacesMessage message2 = new FacesMessage(FacesMessage.SEVERITY_INFO, "Revisar", "CURP, contraseña o tipo incorrecto");
                        PrimeFaces.current().dialog().showMessageDynamic(message2);
                        return "index";
                    }
                }
            }
            if (tipoU == 0) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Revisar", "Constraseña o Usuario incorrecto");
                PrimeFaces.current().dialog().showMessageDynamic(message);
                return null;
            }

            switch (tipoU) {
                case 1:
                    return "MainAdministrador";
                case 2:
                    return "MainMedico";
                case 3:
                    return "MainPaciente";
                default:
                    FacesMessage message2 = new FacesMessage(FacesMessage.SEVERITY_INFO, "Revisar", "Constraseña o Usuario incorrecto");
                    PrimeFaces.current().dialog().showMessageDynamic(message2);
                    return null;
            }

        }

    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
