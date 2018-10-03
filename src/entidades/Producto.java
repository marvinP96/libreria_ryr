/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Miguel Benavides
 */
@Entity
@Table(name = "PRODUCTO")
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PRODUCTO")
    private BigDecimal idProducto;
    @Column(name = "NOMBRE_PROD")
    private String nombreProd;
    @Column(name = "FECHA_INGRESO_PROD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngresoProd;
    @Column(name = "PRECIO_PROD")
    private BigInteger precioProd;
    @Column(name = "EXISTENCIA_PROD")
    private BigInteger existenciaProd;
    @JoinColumn(name = "ID_CAT_PRODUCTO", referencedColumnName = "ID_CAT_PRODUCTO")
    @ManyToOne
    private CatProducto idCatProducto;
    @JoinColumn(name = "ID_PROVEEDOR", referencedColumnName = "ID_PROVEEDOR")
    @ManyToOne
    private Proveedor idProveedor;

    public Producto() {
    }

    public Producto(BigDecimal idProducto) {
        this.idProducto = idProducto;
    }

    public BigDecimal getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(BigDecimal idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProd() {
        return nombreProd;
    }

    public void setNombreProd(String nombreProd) {
        this.nombreProd = nombreProd;
    }

    public Date getFechaIngresoProd() {
        return fechaIngresoProd;
    }

    public void setFechaIngresoProd(Date fechaIngresoProd) {
        this.fechaIngresoProd = fechaIngresoProd;
    }

    public BigInteger getPrecioProd() {
        return precioProd;
    }

    public void setPrecioProd(BigInteger precioProd) {
        this.precioProd = precioProd;
    }

    public BigInteger getExistenciaProd() {
        return existenciaProd;
    }

    public void setExistenciaProd(BigInteger existenciaProd) {
        this.existenciaProd = existenciaProd;
    }

    public CatProducto getIdCatProducto() {
        return idCatProducto;
    }

    public void setIdCatProducto(CatProducto idCatProducto) {
        this.idCatProducto = idCatProducto;
    }

    public Proveedor getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Proveedor idProveedor) {
        this.idProveedor = idProveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Producto[ idProducto=" + idProducto + " ]";
    }
    
}
