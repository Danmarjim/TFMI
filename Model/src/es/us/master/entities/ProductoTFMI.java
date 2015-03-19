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
 * To create ID generator sequence "PRODUCTOTFMI_ID_SEQ_GEN":
 * CREATE SEQUENCE "PRODUCTOTFMI_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "ProductoTFMI.findAll", query = "select o from ProductoTFMI o") })
@SequenceGenerator(name = "ProductoTFMI_Id_Seq_Gen", sequenceName = "PRODUCTOTFMI_ID_SEQ_GEN", allocationSize = 50,
                   initialValue = 50)
public class ProductoTFMI implements Serializable {
    private static final long serialVersionUID = 6043559239331729563L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ProductoTFMI_Id_Seq_Gen")
    private Integer id;
    @Version
    private Integer version;
    @Column(nullable = false)
    private String nombre;
    private Integer codigo;
    @Column(nullable = false)
    private int categoria;
    @Temporal(TemporalType.DATE)
    private Date fechaAct;
    @Column(nullable = false)
    private Long precio;
    @Temporal(TemporalType.DATE)
    private Date fechaAlt;
    @Column(nullable = false)
    private String descripcion;
    @Column(nullable = false)
    private int activo = 1;

    public ProductoTFMI() {
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public Date getFechaAct() {
        return fechaAct;
    }

    public void setFechaAct(Date fechaAct) {
        this.fechaAct = fechaAct;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public Date getFechaAlt() {
        return fechaAlt;
    }

    public void setFechaAlt(Date fechaAlt) {
        this.fechaAlt = fechaAlt;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
    
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof ProductoTFMI)) {
            return false;
        }
        final ProductoTFMI other = (ProductoTFMI) object;
        if (!(id == null ? other.id == null : id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 37;
        int result = 1;
        result = PRIME * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
}
