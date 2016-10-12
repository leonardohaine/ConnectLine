package br.com.jlab.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;


/**
 *
 * @author diego
 */
@Entity
@Table(name = "setor")
public class Setor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SEQ_SET")
	@SequenceGenerator(name = "SEQ_SET", sequenceName = "seq_setores")
	@Basic(optional = false)
    @Column(name = "setor")
    private Long setor;
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
    /*@Lob
    @Column(name = "laudoresp")
    private byte[] laudoresp;*/
    @Column(name = "laudotam")
    private Integer laudotam;
    @Type(type= "org.hibernate.type.NumericBooleanType")
    @Column(name = "ativo")
    private Boolean ativo;
    @Column(name = "loinc")
    private String loinc;
   

    public Setor() {
    }

    public Setor(Long setor) {
        this.setor = setor;
    }

    public Long getSetor() {
    	//StringUtils.leftPad(setor == null ? null : setor, 3, "3");
    	System.out.println("Setor: " + setor);
        return setor;
    }

    public void setSetor(Long setor) {
    	//StringUtils.leftPad(setor, 3, "3");
    	System.out.println("Setor: " + setor);
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

    /*public byte[] getLaudoresp() {
        return laudoresp;
    }

    public void setLaudoresp(byte[] laudoresp) {
        this.laudoresp = laudoresp;
    }*/

    public Integer getLaudotam() {
        return laudotam;
    }

    public void setLaudotam(Integer laudotam) {
        this.laudotam = laudotam;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getLoinc() {
        return loinc;
    }

    public void setLoinc(String loinc) {
        this.loinc = loinc;
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
        if (!(object instanceof Setor)) {
            return false;
        }
        Setor other = (Setor) object;
        if ((this.setor == null && other.setor != null) || (this.setor != null && !this.setor.equals(other.setor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.entidades.Setores[ setor=" + setor + ", descricao="+ descricao + "]";
    }
    
}
