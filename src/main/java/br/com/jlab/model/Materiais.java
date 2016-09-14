/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jlab.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "materiais")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materiais.findAll", query = "SELECT m FROM Materiais m"),
    @NamedQuery(name = "Materiais.findByMaterial", query = "SELECT m FROM Materiais m WHERE m.material = :material"),
    @NamedQuery(name = "Materiais.findByDescricao", query = "SELECT m FROM Materiais m WHERE m.descricao = :descricao")})
public class Materiais implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "material")
    private String material;
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(mappedBy = "material")
    private Collection<Exames> examesCollection;

    public Materiais() {
    }

    public Materiais(String material) {
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public Collection<Exames> getExamesCollection() {
        return examesCollection;
    }

    public void setExamesCollection(Collection<Exames> examesCollection) {
        this.examesCollection = examesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (material != null ? material.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materiais)) {
            return false;
        }
        Materiais other = (Materiais) object;
        if ((this.material == null && other.material != null) || (this.material != null && !this.material.equals(other.material))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.entidades.Materiais[ material=" + material + " ]";
    }
    
}
