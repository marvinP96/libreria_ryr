/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author marvin1
 */
@Entity
@Table(name = "CLIENTE")
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_CLIENTE")
    private BigDecimal idCliente;
    @Column(name = "NOMBRE_CLIE")
    private String nombreClie;
    @Column(name = "APELLIDO_CLIE")
    private String apellidoClie;
    @Column(name = "DIRECCION_CLIE")
    private String direccionClie;
    @Column(name = "NIT_CLIE")
    private String nitClie;
    @Column(name = "TELEFONO_CLIE")
    private String telefonoClie;
    @Column(name = "MUNICIPIO_CLIE")
    private String municipioClie;
    @Column(name = "DEPARTAMENTO_CLIE")
    private String departamentoClie;
    @Column(name = "N_REGISTRO_CLIE")
    private String nRegistroClie;

    public Cliente() {
    }

    public Cliente(BigDecimal idCliente) {
        this.idCliente = idCliente;
    }

    public BigDecimal getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(BigDecimal idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreClie() {
        return nombreClie;
    }

    public void setNombreClie(String nombreClie) {
        this.nombreClie = nombreClie;
    }

    public String getApellidoClie() {
        return apellidoClie;
    }

    public void setApellidoClie(String apellidoClie) {
        this.apellidoClie = apellidoClie;
    }

    public String getDireccionClie() {
        return direccionClie;
    }

    public void setDireccionClie(String direccionClie) {
        this.direccionClie = direccionClie;
    }

    public String getNitClie() {
        return nitClie;
    }

    public void setNitClie(String nitClie) {
        this.nitClie = nitClie;
    }

    public String getTelefonoClie() {
        return telefonoClie;
    }

    public void setTelefonoClie(String telefonoClie) {
        this.telefonoClie = telefonoClie;
    }

    public String getMunicipioClie() {
        return municipioClie;
    }

    public void setMunicipioClie(String municipioClie) {
        this.municipioClie = municipioClie;
    }

    public String getDepartamentoClie() {
        return departamentoClie;
    }

    public void setDepartamentoClie(String departamentoClie) {
        this.departamentoClie = departamentoClie;
    }

    public String getNRegistroClie() {
        return nRegistroClie;
    }

    public void setNRegistroClie(String nRegistroClie) {
        this.nRegistroClie = nRegistroClie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Cliente[ idCliente=" + idCliente + " ]";
    }
    
}
