package es.us.master.entities;

import java.io.Serializable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;

import java.util.GregorianCalendar;

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
 * To create ID generator sequence "USUARIOTFMI_ID_SEQ_GEN":
 * CREATE SEQUENCE "USUARIOTFMI_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "UsuarioTFMI.findAll", query = "select o from UsuarioTFMI o"),
                @NamedQuery(name = "UsuarioTFMI.findByUserPass", query = "select o from UsuarioTFMI o where o.username=:u and o.password=:p")
            })
@SequenceGenerator(name = "UsuarioTFMI_Id_Seq_Gen", sequenceName = "USUARIOTFMI_ID_SEQ_GEN", allocationSize = 50,
                   initialValue = 50)
public class UsuarioTFMI implements Serializable {
    private static final long serialVersionUID = 8129037805097008113L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UsuarioTFMI_Id_Seq_Gen")
    private Integer id;
    @Version
    private Integer version;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String username;
    @Temporal(TemporalType.DATE)
    @Column(nullable = true)
    private Date fechaAct;
    @Temporal(TemporalType.DATE)
    @Column(nullable = true)
    private Date fechaNac;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String apellidos;
    @Temporal(TemporalType.DATE)
    @Column(nullable = true)
    private Date fechaAlt;
    @Column(nullable = false)
    private int rol = 2;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private int activo = 1;

    public UsuarioTFMI() {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getFechaAct() {        
        return fechaAct;
    }

    public void setFechaAct(Date fechaAct) {
        
        DateFormat dataFormat = new SimpleDateFormat("dd/mm/yy");
        fechaAct = new Date();
        
        this.fechaAct = fechaAct;
    }
    
    public Date getFechaAlta() {
        
        /*Calendar fecha = new GregorianCalendar();
        
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        
        return fechaAlt = + dia + "-" + (mes+1) + "-" + año;*/
        return fechaAlt;
    }

    public void setFechaAlta(Date fechaAlt) {
        
        /*Calendar fecha = new GregorianCalendar();
        
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        
        fechaAlt = + dia + "/" + (mes+1) + "/" + año;*/
        
        this.fechaAlt = fechaAlt;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }


    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        if (!(object instanceof UsuarioTFMI)) {
            return false;
        }
        final UsuarioTFMI other = (UsuarioTFMI) object;
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
