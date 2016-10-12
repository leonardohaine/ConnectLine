/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jlab.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.Type;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "recipiente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recipiente.findAll", query = "SELECT r FROM Recipiente r"),
    @NamedQuery(name = "Recipiente.findByRecipiente", query = "SELECT r FROM Recipiente r WHERE r.recipiente = :recipiente"),
    @NamedQuery(name = "Recipiente.findByDescricao", query = "SELECT r FROM Recipiente r WHERE r.descricao = :descricao"),
    @NamedQuery(name = "Recipiente.findByRecStPreanalitico", query = "SELECT r FROM Recipiente r WHERE r.recStPreanalitico = :recStPreanalitico")})
public class Recipiente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SEQ_RECIP")
	@SequenceGenerator(name = "SEQ_RECIP", sequenceName = "seq_recipiente")
	@Basic(optional = false)
    @Column(name = "recipiente")
    private Long recipiente;
    @Column(name = "descricao")
    private String descricao;
    @Lob
    @Column(name = "figura")
    private byte[] figura;
    @Column(name = "rec_st_preanalitico")
    private String recStPreanalitico;
    @OneToMany(mappedBy = "recipiente")
    private List<Exame> examesList;
    @Type(type= "org.hibernate.type.NumericBooleanType")
    @Column(name = "ativo")
    private Boolean ativo;

    public Recipiente() {
    }

    public Recipiente(Long recipiente) {
        this.recipiente = recipiente;
    }

    public Long getRecipiente() {
        return recipiente;
    }

    public void setRecipiente(Long recipiente) {
        this.recipiente = recipiente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public byte[] getFigura() {
        return figura;
    }

    public void setFigura(byte[] figura) {
        this.figura = figura;
    }

    public String getRecStPreanalitico() {
        return recStPreanalitico;
    }

    public void setRecStPreanalitico(String recStPreanalitico) {
        this.recStPreanalitico = recStPreanalitico;
    }

    @XmlTransient
    public List<Exame> getExamesList() {
        return examesList;
    }

    public void setExamesList(List<Exame> examesList) {
        this.examesList = examesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recipiente != null ? recipiente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recipiente)) {
            return false;
        }
        Recipiente other = (Recipiente) object;
        if ((this.recipiente == null && other.recipiente != null) || (this.recipiente != null && !this.recipiente.equals(other.recipiente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.entidades.Recipientes[ recipiente=" + recipiente + " ]";
    }

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
    
}
