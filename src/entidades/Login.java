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
@Table(name = "LOGIN")
@NamedQueries({
    @NamedQuery(name = "Login.findAll", query = "SELECT l FROM Login l")})
public class Login implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_USER")
    private BigDecimal idUser;
    @Column(name = "NOM_USER")
    private String nomUser;
    @Column(name = "CONTRASE\u00d1A_USER")
    private String contraseñaUser;

    public Login() {
    }

    public Login(BigDecimal idUser) {
        this.idUser = idUser;
    }

    public BigDecimal getIdUser() {
        return idUser;
    }

    public void setIdUser(BigDecimal idUser) {
        this.idUser = idUser;
    }

    public String getNomUser() {
        return nomUser;
    }

    public void setNomUser(String nomUser) {
        this.nomUser = nomUser;
    }

    public String getContraseñaUser() {
        return contraseñaUser;
    }

    public void setContraseñaUser(String contraseñaUser) {
        this.contraseñaUser = contraseñaUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Login)) {
            return false;
        }
        Login other = (Login) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Login[ idUser=" + idUser + " ]";
    }
    
}
