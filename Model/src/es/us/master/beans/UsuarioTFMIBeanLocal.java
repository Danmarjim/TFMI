package es.us.master.beans;

import es.us.master.entities.UsuarioTFMI;

import java.util.List;

import javax.ejb.Local;

@Local
public interface UsuarioTFMIBeanLocal {
    UsuarioTFMI persistUsuarioTFMI(UsuarioTFMI usuarioTFMI);

    UsuarioTFMI mergeUsuarioTFMI(UsuarioTFMI usuarioTFMI);

    void removeUsuarioTFMI(UsuarioTFMI usuarioTFMI);

    List<UsuarioTFMI> getUsuarioTFMIFindAll();
    
    UsuarioTFMI getUsuarioTFMIUsernamePassword(String username, String password);
}
