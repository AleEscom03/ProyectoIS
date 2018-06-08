package Beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@RequestScoped
public class AdministradorBean implements Serializable {

    private final FacesContext fc;
    private final HttpServletRequest request;
    private String idcurp;
    private String nombre;
    private String correo;

    public AdministradorBean() {
        fc = FacesContext.getCurrentInstance();
        request = (HttpServletRequest) fc.getExternalContext().getRequest();
        if (request.getSession().getAttribute("idcurp") != null) {
            idcurp = (String) request.getSession().getAttribute("idcurp");
            nombre = (String) request.getSession().getAttribute("nombre");
            correo = (String) request.getSession().getAttribute("correo");
            System.out.println(nombre);
        }
    }

    public String cerrarSession(){
        request.getSession().removeAttribute("idcurp");
        request.getSession().removeAttribute("nombre");
        request.getSession().removeAttribute("correo");
        return "index";
    }
    
    
    public String getIdcurp() {
        return idcurp;
    }

    public void setIdcurp(String idcurp) {
        this.idcurp = idcurp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    
    
    
}
