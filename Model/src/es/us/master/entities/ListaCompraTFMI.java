package es.us.master.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

/**
 * To create ID generator sequence "LISTACOMPRATFMI_ID_SEQ_GEN":
 * CREATE SEQUENCE "LISTACOMPRATFMI_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "ListaCompraTFMI.findAll", query = "select o from ListaCompraTFMI o") })
@SequenceGenerator(name = "ListaCompraTFMI_Id_Seq_Gen", sequenceName = "LISTACOMPRATFMI_ID_SEQ_GEN",
                   allocationSize = 50, initialValue = 50)
public class ListaCompraTFMI implements Serializable {
    private static final long serialVersionUID = 4754705628642496887L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ListaCompraTFMI_Id_Seq_Gen")
    private Integer id;
    @Version
    private Integer version;
    @Column(nullable = false)
    private int cantidad;
    @Column(nullable = false)
    private int id_producto;
    @Column(nullable = false)
    private Long subtotal;

    public ListaCompraTFMI() {
    }

    public Integer getId() {
        return id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public Long getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Long subtotal) {
        this.subtotal = subtotal;
    }
}
