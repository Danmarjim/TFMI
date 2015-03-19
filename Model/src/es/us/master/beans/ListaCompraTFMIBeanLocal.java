package es.us.master.beans;

import es.us.master.entities.ListaCompraTFMI;

import java.util.List;

import javax.ejb.Local;

@Local
public interface ListaCompraTFMIBeanLocal {
    ListaCompraTFMI persistListaCompraTFMI(ListaCompraTFMI listaCompraTFMI);

    ListaCompraTFMI mergeListaCompraTFMI(ListaCompraTFMI listaCompraTFMI);

    void removeListaCompraTFMI(ListaCompraTFMI listaCompraTFMI);

    List<ListaCompraTFMI> getListaCompraTFMIFindAll();
}
