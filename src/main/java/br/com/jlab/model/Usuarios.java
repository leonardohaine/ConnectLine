/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jlab.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findByCodusuario", query = "SELECT u FROM Usuarios u WHERE u.codusuario = :codusuario"),
    @NamedQuery(name = "Usuarios.findByCheckconfig", query = "SELECT u FROM Usuarios u WHERE u.checkconfig = :checkconfig"),
    @NamedQuery(name = "Usuarios.findByChecksafx04", query = "SELECT u FROM Usuarios u WHERE u.checksafx04 = :checksafx04"),
    @NamedQuery(name = "Usuarios.findByChecksafx0708", query = "SELECT u FROM Usuarios u WHERE u.checksafx0708 = :checksafx0708"),
    @NamedQuery(name = "Usuarios.findByChecksafx2013", query = "SELECT u FROM Usuarios u WHERE u.checksafx2013 = :checksafx2013"),
    @NamedQuery(name = "Usuarios.findByCheckusuarios", query = "SELECT u FROM Usuarios u WHERE u.checkusuarios = :checkusuarios"),
    @NamedQuery(name = "Usuarios.findByEmail", query = "SELECT u FROM Usuarios u WHERE u.email = :email"),
    @NamedQuery(name = "Usuarios.findByIsadmin", query = "SELECT u FROM Usuarios u WHERE u.isadmin = :isadmin"),
    @NamedQuery(name = "Usuarios.findByIsativo", query = "SELECT u FROM Usuarios u WHERE u.isativo = :isativo"),
    @NamedQuery(name = "Usuarios.findByLogin", query = "SELECT u FROM Usuarios u WHERE u.login = :login"),
    @NamedQuery(name = "Usuarios.findByNome", query = "SELECT u FROM Usuarios u WHERE u.nome = :nome"),
    @NamedQuery(name = "Usuarios.findBySenha", query = "SELECT u FROM Usuarios u WHERE u.senha = :senha")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codusuario")
    private Integer codusuario;
    @Column(name = "checkconfig")
    private Boolean checkconfig;
    @Column(name = "checksafx04")
    private Boolean checksafx04;
    @Column(name = "checksafx0708")
    private Boolean checksafx0708;
    @Column(name = "checksafx2013")
    private Boolean checksafx2013;
    @Column(name = "checkusuarios")
    private Boolean checkusuarios;
    @Column(name = "email")
    private String email;
    @Column(name = "isadmin")
    private Boolean isadmin;
    @Column(name = "isativo")
    private Boolean isativo;
    @Column(name = "login")
    private String login;
    @Column(name = "nome")
    private String nome;
    @Column(name = "senha")
    private String senha;

    public Usuarios() {
    }

    public Usuarios(Integer codusuario) {
        this.codusuario = codusuario;
    }

    public Integer getCodusuario() {
        return codusuario;
    }

    public void setCodusuario(Integer codusuario) {
        this.codusuario = codusuario;
    }

    public Boolean getCheckconfig() {
        return checkconfig;
    }

    public void setCheckconfig(Boolean checkconfig) {
        this.checkconfig = checkconfig;
    }

    public Boolean getChecksafx04() {
        return checksafx04;
    }

    public void setChecksafx04(Boolean checksafx04) {
        this.checksafx04 = checksafx04;
    }

    public Boolean getChecksafx0708() {
        return checksafx0708;
    }

    public void setChecksafx0708(Boolean checksafx0708) {
        this.checksafx0708 = checksafx0708;
    }

    public Boolean getChecksafx2013() {
        return checksafx2013;
    }

    public void setChecksafx2013(Boolean checksafx2013) {
        this.checksafx2013 = checksafx2013;
    }

    public Boolean getCheckusuarios() {
        return checkusuarios;
    }

    public void setCheckusuarios(Boolean checkusuarios) {
        this.checkusuarios = checkusuarios;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(Boolean isadmin) {
        this.isadmin = isadmin;
    }

    public Boolean getIsativo() {
        return isativo;
    }

    public void setIsativo(Boolean isativo) {
        this.isativo = isativo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codusuario != null ? codusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.codusuario == null && other.codusuario != null) || (this.codusuario != null && !this.codusuario.equals(other.codusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.entidades.Usuarios[ codusuario=" + codusuario + " ]";
    }
    
}
