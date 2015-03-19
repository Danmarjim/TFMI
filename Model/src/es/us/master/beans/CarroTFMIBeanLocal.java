package es.us.master.beans;

import es.us.master.entities.CarroTFMI;

import es.us.master.entities.UsuarioTFMI;

import java.util.List;

import javax.ejb.Local;

@Local
public interface CarroTFMIBeanLocal {
    CarroTFMI persistCarroTFMI(CarroTFMI carroTFMI);

    CarroTFMI mergeCarroTFMI(CarroTFMI carroTFMI);

    void removeCarroTFMI(CarroTFMI carroTFMI);

    List<CarroTFMI> getCarroTFMIFindAll();
    
    List<CarroTFMI> getCarroByUser(UsuarioTFMI user);
}
