package es.us.master.beans;

import es.us.master.entities.ProductoTFMI;

import java.util.List;

import javax.ejb.Local;

@Local
public interface ProductoTFMIBeanLocal {
    ProductoTFMI persistProductoTFMI(ProductoTFMI productoTFMI);

    ProductoTFMI mergeProductoTFMI(ProductoTFMI productoTFMI);

    void removeProductoTFMI(ProductoTFMI productoTFMI);

    List<ProductoTFMI> getProductoTFMIFindAll();
}
