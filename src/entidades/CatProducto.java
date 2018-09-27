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
@Table(name = "CAT_PRODUCTO")
@NamedQueries({
    @NamedQuery(name = "CatProducto.findAll", query = "SELECT c FROM CatProducto c")})
public class CatProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_CAT_PRODUCTO")
    private BigDecimal idCatProducto;
    @Column(name = "NOMBRE_CAT_PROD")
    private String nombreCatProd;

    public CatProducto() {
    }

    public CatProducto(BigDecimal idCatProducto) {
        this.idCatProducto = idCatProducto;
    }

    public BigDecimal getIdCatProducto() {
        return idCatProducto;
    }

    public void setIdCatProducto(BigDecimal idCatProducto) {
        this.idCatProducto = idCatProducto;
    }

    public String getNombreCatProd() {
        return nombreCatProd;
    }

    public void setNombreCatProd(String nombreCatProd) {
        this.nombreCatProd = nombreCatProd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCatProducto != null ? idCatProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatProducto)) {
            return false;
        }
        CatProducto other = (CatProducto) object;
        if ((this.idCatProducto == null && other.idCatProducto != null) || (this.idCatProducto != null && !this.idCatProducto.equals(other.idCatProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CatProducto[ idCatProducto=" + idCatProducto + " ]";
    }
    
}
