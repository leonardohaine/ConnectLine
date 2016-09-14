package br.com.jlab.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "setores")
public class Setores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "setor")
    private String setor;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "rack")
    private Integer rack;
    @Column(name = "diasretencao")
    private Short diasretencao;
    @Column(name = "datagerenciamento")
    private Character datagerenciamento;
    @Column(name = "liberaparcial")
    private Character liberaparcial;
    @Lob
    @Column(name = "laudoresp")
    private byte[] laudoresp;
    @Column(name = "laudotam")
    private Integer laudotam;
    @Column(name = "ativo")
    private Character ativo;
    @Column(name = "loinc")
    private String loinc;
    @OneToMany(mappedBy = "setor")
    private Collection<Exames> examesCollection;

    public Setores() {
    }

    public Setores(String setor) {
        this.setor = setor;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Integer getRack() {
        return rack;
    }

    public void setRack(Integer rack) {
        this.rack = rack;
    }

    public Short getDiasretencao() {
        return diasretencao;
    }

    public void setDiasretencao(Short diasretencao) {
        this.diasretencao = diasretencao;
    }

    public Character getDatagerenciamento() {
        return datagerenciamento;
    }

    public void setDatagerenciamento(Character datagerenciamento) {
        this.datagerenciamento = datagerenciamento;
    }

    public Character getLiberaparcial() {
        return liberaparcial;
    }

    public void setLiberaparcial(Character liberaparcial) {
        this.liberaparcial = liberaparcial;
    }

    public byte[] getLaudoresp() {
        return laudoresp;
    }

    public void setLaudoresp(byte[] laudoresp) {
        this.laudoresp = laudoresp;
    }

    public Integer getLaudotam() {
        return laudotam;
    }

    public void setLaudotam(Integer laudotam) {
        this.laudotam = laudotam;
    }

    public Character getAtivo() {
        return ativo;
    }

    public void setAtivo(Character ativo) {
        this.ativo = ativo;
    }

    public String getLoinc() {
        return loinc;
    }

    public void setLoinc(String loinc) {
        this.loinc = loinc;
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
        hash += (setor != null ? setor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Setores)) {
            return false;
        }
        Setores other = (Setores) object;
        if ((this.setor == null && other.setor != null) || (this.setor != null && !this.setor.equals(other.setor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.entidades.Setores[ setor=" + setor + " ]";
    }
    
}
