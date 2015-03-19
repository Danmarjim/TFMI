package es.us.master.beans;

import es.us.master.entities.UsuarioTFMI;

import java.util.List;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(mappedName = "TFMI-Model-UsuarioTFMIBean")
public class UsuarioTFMIBean implements UsuarioTFMIBeanLocal {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "TFMI")
    private EntityManager em;

    public UsuarioTFMIBean() {
    }

    public UsuarioTFMI persistUsuarioTFMI(UsuarioTFMI usuarioTFMI) {
        em.persist(usuarioTFMI);
        return usuarioTFMI;
    }

    public UsuarioTFMI mergeUsuarioTFMI(UsuarioTFMI usuarioTFMI) {
        return em.merge(usuarioTFMI);
    }

    public void removeUsuarioTFMI(UsuarioTFMI usuarioTFMI) {
        usuarioTFMI = em.find(UsuarioTFMI.class, usuarioTFMI.getId());
        em.remove(usuarioTFMI);
    }

    /** <code>select o from UsuarioTFMI o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<UsuarioTFMI> getUsuarioTFMIFindAll() {
        return em.createNamedQuery("UsuarioTFMI.findAll", UsuarioTFMI.class).getResultList();
    }
    
    @Override 
    public UsuarioTFMI getUsuarioTFMIUsernamePassword(String username, String password){
        
        try{            
            Query query = em.createNamedQuery("UsuarioTFMI.findByUserPass", UsuarioTFMI.class);
            query.setParameter("u", username);
            query.setParameter("p", password); 
            return (UsuarioTFMI) query.getSingleResult();
            
        } catch (NoResultException e){
            return null;
        }        
        
    }
}
