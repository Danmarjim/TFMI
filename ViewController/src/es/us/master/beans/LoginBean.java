package es.us.master.beans;

import es.us.master.entities.UsuarioTFMI;

import javax.ejb.EJB;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class LoginBean {
    private FacesContext context;
    
    @EJB
    private UsuarioTFMIBeanLocal usuarioBean;
    private UsuarioTFMI usuario;
    
    public LoginBean() {
        usuario = new UsuarioTFMI();
        context = FacesContext.getCurrentInstance();
    }
    
    public UsuarioTFMI getUsuario(){
        return usuario;
    }
    
    public String login(){
        String res = "OK";
        UsuarioTFMI u = usuarioBean.getUsuarioTFMIUsernamePassword(usuario.getUsername(), usuario.getPassword());
        if(u == null){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "No existe un usuario con esa contrase�a"));
            
            res = "ERROR";
        } else {
            context.getExternalContext().getSessionMap().put("usuario", u);
        }
        return res;
    }
}
