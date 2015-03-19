package es.us.master.beans;

import es.us.master.entities.UsuarioTFMI;

import javax.ejb.EJB;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class RegisterBean {
    private FacesContext context;

    @EJB
    private UsuarioTFMIBeanLocal usuarioBean;
    private UsuarioTFMI usuario;
    private String repassword;

    public RegisterBean() {
        usuario = new UsuarioTFMI();
        context = FacesContext.getCurrentInstance();
    }

    public UsuarioTFMI getUsuario() {
        return usuario;
    }
    
    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public String register() {
        String res = validate();
        if (res.equals("OK")) {
            UsuarioTFMI u = usuarioBean.persistUsuarioTFMI(usuario);
            if (u == null) {
                context.addMessage(null,
                                   new FacesMessage(FacesMessage.SEVERITY_INFO, "Error",
                                                    "No se ha podido crear el usuario."));

                res = "ERROR";
            } else {
                context.addMessage(null,
                                   new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "El usuario ha sido creado."));
            }
        }

        return res;
    }

    private String validate() {
        String res = "OK";

        if (!usuario.getPassword().equals(repassword)) {
            context.addMessage(null,
                               new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "Las contrase�as no son iguales"));

            res = "ERROR";
        }

        return res;
    }
}
