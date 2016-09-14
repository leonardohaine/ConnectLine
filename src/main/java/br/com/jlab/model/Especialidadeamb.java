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
@Table(name = "especialidadeamb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Especialidadeamb.findAll", query = "SELECT e FROM Especialidadeamb e"),
    @NamedQuery(name = "Especialidadeamb.findByEspecialidade", query = "SELECT e FROM Especialidadeamb e WHERE e.especialidade = :especialidade"),
    @NamedQuery(name = "Especialidadeamb.findByDescricao", query = "SELECT e FROM Especialidadeamb e WHERE e.descricao = :descricao")})
public class Especialidadeamb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "especialidade")
    private String especialidade;
    @Column(name = "descricao")
    private String descricao;

    public Especialidadeamb() {
    }

    public Especialidadeamb(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (especialidade != null ? especialidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Especialidadeamb)) {
            return false;
        }
        Especialidadeamb other = (Especialidadeamb) object;
        if ((this.especialidade == null && other.especialidade != null) || (this.especialidade != null && !this.especialidade.equals(other.especialidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.entidades.Especialidadeamb[ especialidade=" + especialidade + " ]";
    }
    
}
