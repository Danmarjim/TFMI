package es.us.master.entities;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 * To create ID generator sequence "CARROTFMI_ID_SEQ_GEN":
 * CREATE SEQUENCE "CARROTFMI_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "CarroTFMI.findAll", query = "select o from CarroTFMI o"), 
                @NamedQuery(name="CarroTFMI.findByUser", query = "select o from CarroTFMI o where o.id_usuario=:u")
            })
@SequenceGenerator(name = "CarroTFMI_Id_Seq_Gen", sequenceName = "CARROTFMI_ID_SEQ_GEN", allocationSize = 50,
                   initialValue = 50)
public class CarroTFMI implements Serializable {
    private static final long serialVersionUID = -5383645086083866650L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CarroTFMI_Id_Seq_Gen")
    private Integer id;
    @Version
    private Integer version;
    @Column(nullable = false)
    private Long total;
    @Column(nullable = false)
    private int id_usuario;
    @Temporal(TemporalType.DATE)
    private Date fechaCompra;
    @Column(nullable = false)
    private int id_listaCompra;

    public CarroTFMI() {
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

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public int getId_listaCompra() {
        return id_listaCompra;
    }

    public void setId_listaCompra(int id_listaCompra) {
        this.id_listaCompra = id_listaCompra;
    }
}
