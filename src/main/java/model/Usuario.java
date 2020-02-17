/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jr
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario")
    , @NamedQuery(name = "Usuario.findByNmUsuario", query = "SELECT u FROM Usuario u WHERE u.nmUsuario = :nmUsuario")
    , @NamedQuery(name = "Usuario.findByEmailUsuario", query = "SELECT u FROM Usuario u WHERE u.emailUsuario = :emailUsuario")
    , @NamedQuery(name = "Usuario.findBySenhaUsuario", query = "SELECT u FROM Usuario u WHERE u.senhaUsuario = :senhaUsuario")
    , @NamedQuery(name = "Usuario.findByTelUsuario", query = "SELECT u FROM Usuario u WHERE u.telUsuario = :telUsuario")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nm_usuario")
    private String nmUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email_usuario")
    private String emailUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "senha_usuario")
    private String senhaUsuario;
    @Transient
    private String senhaUsuarioNaoCriptografada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tel_usuario")
    private String telUsuario;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Integer idUsuario, String nmUsuario, String emailUsuario, String senhaUsuario, String telUsuario) {
        this.idUsuario = idUsuario;
        this.nmUsuario = nmUsuario;
        this.emailUsuario = emailUsuario;
        this.senhaUsuario = senhaUsuario;
        this.telUsuario = telUsuario;
    }
    
    public Usuario(Integer idUsuario, String nmUsuario, String emailUsuario, String senhaUsuario, String senhaUsuarioNaoCriptografada, String telUsuario) {
        this.idUsuario = idUsuario;
        this.nmUsuario = nmUsuario;
        this.emailUsuario = emailUsuario;
        this.senhaUsuario = senhaUsuario;
        this.senhaUsuarioNaoCriptografada = senhaUsuarioNaoCriptografada;
        this.telUsuario = telUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNmUsuario() {
        return nmUsuario;
    }

    public void setNmUsuario(String nmUsuario) {
        this.nmUsuario = nmUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public String getSenhaUsuarioNaoCriptografada() {
        return senhaUsuarioNaoCriptografada;
    }

    public void setSenhaUsuarioNaoCriptografada(String senhaUsuarioNaoCriptografada) {
        this.senhaUsuarioNaoCriptografada = senhaUsuarioNaoCriptografada;
    }
    
    public String getTelUsuario() {
        return telUsuario;
    }

    public void setTelUsuario(String telUsuario) {
        this.telUsuario = telUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "wellington.desafio_sefaz.Usuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
