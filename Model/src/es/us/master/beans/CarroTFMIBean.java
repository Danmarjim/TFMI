package es.us.master.beans;

import es.us.master.entities.CarroTFMI;

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

@Stateless(mappedName = "TFMI-Model-CarroTFMIBean")
public class CarroTFMIBean implements CarroTFMIBeanLocal {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "TFMI")
    private EntityManager em;

    public CarroTFMIBean() {
    }

    public CarroTFMI persistCarroTFMI(CarroTFMI carroTFMI) {
        em.persist(carroTFMI);
        return carroTFMI;
    }

    public CarroTFMI mergeCarroTFMI(CarroTFMI carroTFMI) {
        return em.merge(carroTFMI);
    }

    public void removeCarroTFMI(CarroTFMI carroTFMI) {
        carroTFMI = em.find(CarroTFMI.class, carroTFMI.getId());
        em.remove(carroTFMI);
    }

    /** <code>select o from CarroTFMI o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<CarroTFMI> getCarroTFMIFindAll() {
        return em.createNamedQuery("CarroTFMI.findAll", CarroTFMI.class).getResultList();
    }
    
    @Override
    public List<CarroTFMI> getCarroByUser(UsuarioTFMI user){
      
        Query query = em.createNamedQuery("CarroTFMI.findByUser", CarroTFMI.class);
        query.setParameter("u", user);
        return query.getResultList();
        
    }    
}
