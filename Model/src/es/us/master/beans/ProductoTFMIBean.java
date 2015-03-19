package es.us.master.beans;

import es.us.master.entities.ProductoTFMI;

import java.util.List;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(mappedName = "TFMI-Model-ProductoTFMIBean")
public class ProductoTFMIBean implements ProductoTFMIBeanLocal {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "TFMI")
    private EntityManager em;

    public ProductoTFMIBean() {
    }

    public ProductoTFMI persistProductoTFMI(ProductoTFMI productoTFMI) {
        em.persist(productoTFMI);
        return productoTFMI;
    }

    public ProductoTFMI mergeProductoTFMI(ProductoTFMI productoTFMI) {
        return em.merge(productoTFMI);
    }

    public void removeProductoTFMI(ProductoTFMI productoTFMI) {
        productoTFMI = em.find(ProductoTFMI.class, productoTFMI.getId());
        em.remove(productoTFMI);
    }

    /** <code>select o from ProductoTFMI o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<ProductoTFMI> getProductoTFMIFindAll() {
        return em.createNamedQuery("ProductoTFMI.findAll", ProductoTFMI.class).getResultList();
    }
}
