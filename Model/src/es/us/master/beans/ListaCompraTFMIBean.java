package es.us.master.beans;

import es.us.master.entities.ListaCompraTFMI;

import java.util.List;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(mappedName = "TFMI-Model-ListaCompraTFMIBean")
public class ListaCompraTFMIBean implements ListaCompraTFMIBeanLocal {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "TFMI")
    private EntityManager em;

    public ListaCompraTFMIBean() {
    }

    public ListaCompraTFMI persistListaCompraTFMI(ListaCompraTFMI listaCompraTFMI) {
        em.persist(listaCompraTFMI);
        return listaCompraTFMI;
    }

    public ListaCompraTFMI mergeListaCompraTFMI(ListaCompraTFMI listaCompraTFMI) {
        return em.merge(listaCompraTFMI);
    }

    public void removeListaCompraTFMI(ListaCompraTFMI listaCompraTFMI) {
        listaCompraTFMI = em.find(ListaCompraTFMI.class, listaCompraTFMI.getId());
        em.remove(listaCompraTFMI);
    }

    /** <code>select o from ListaCompraTFMI o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<ListaCompraTFMI> getListaCompraTFMIFindAll() {
        return em.createNamedQuery("ListaCompraTFMI.findAll", ListaCompraTFMI.class).getResultList();
    }
}
