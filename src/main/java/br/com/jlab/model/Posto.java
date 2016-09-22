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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "postos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Postos.findAll", query = "SELECT p FROM Postos p"),
    @NamedQuery(name = "Postos.findByPosto", query = "SELECT p FROM Postos p WHERE p.posto = :posto"),
    @NamedQuery(name = "Postos.findByDescricao", query = "SELECT p FROM Postos p WHERE p.descricao = :descricao"),
    @NamedQuery(name = "Postos.findByNumerorequisicao", query = "SELECT p FROM Postos p WHERE p.numerorequisicao = :numerorequisicao"),
    @NamedQuery(name = "Postos.findByRequisicao", query = "SELECT p FROM Postos p WHERE p.requisicao = :requisicao"),
    @NamedQuery(name = "Postos.findByCabectam", query = "SELECT p FROM Postos p WHERE p.cabectam = :cabectam"),
    @NamedQuery(name = "Postos.findByRodapetam", query = "SELECT p FROM Postos p WHERE p.rodapetam = :rodapetam"),
    @NamedQuery(name = "Postos.findByCmes", query = "SELECT p FROM Postos p WHERE p.cmes = :cmes"),
    @NamedQuery(name = "Postos.findByCnes", query = "SELECT p FROM Postos p WHERE p.cnes = :cnes")})
public class Posto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "posto")
    private String posto;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "numerorequisicao")
    private String numerorequisicao;
    @Column(name = "requisicao")
    private Integer requisicao;
    @Lob
    @Column(name = "cabec")
    private byte[] cabec;
    @Lob
    @Column(name = "rodape")
    private byte[] rodape;
    @Column(name = "cabectam")
    private Integer cabectam;
    @Column(name = "rodapetam")
    private Integer rodapetam;
    @Column(name = "cmes")
    private String cmes;
    @Column(name = "cnes")
    private String cnes;
    @Lob
    @Column(name = "cabecexporta")
    private byte[] cabecexporta;
    @Lob
    @Column(name = "rodapeexporta")
    private byte[] rodapeexporta;

    public Posto() {
    }

    public Posto(String posto) {
        this.posto = posto;
    }

    public String getPosto() {
        return posto;
    }

    public void setPosto(String posto) {
        this.posto = posto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNumerorequisicao() {
        return numerorequisicao;
    }

    public void setNumerorequisicao(String numerorequisicao) {
        this.numerorequisicao = numerorequisicao;
    }

    public Integer getRequisicao() {
        return requisicao;
    }

    public void setRequisicao(Integer requisicao) {
        this.requisicao = requisicao;
    }

    public byte[] getCabec() {
        return cabec;
    }

    public void setCabec(byte[] cabec) {
        this.cabec = cabec;
    }

    public byte[] getRodape() {
        return rodape;
    }

    public void setRodape(byte[] rodape) {
        this.rodape = rodape;
    }

    public Integer getCabectam() {
        return cabectam;
    }

    public void setCabectam(Integer cabectam) {
        this.cabectam = cabectam;
    }

    public Integer getRodapetam() {
        return rodapetam;
    }

    public void setRodapetam(Integer rodapetam) {
        this.rodapetam = rodapetam;
    }

    public String getCmes() {
        return cmes;
    }

    public void setCmes(String cmes) {
        this.cmes = cmes;
    }

    public String getCnes() {
        return cnes;
    }

    public void setCnes(String cnes) {
        this.cnes = cnes;
    }

    public byte[] getCabecexporta() {
        return cabecexporta;
    }

    public void setCabecexporta(byte[] cabecexporta) {
        this.cabecexporta = cabecexporta;
    }

    public byte[] getRodapeexporta() {
        return rodapeexporta;
    }

    public void setRodapeexporta(byte[] rodapeexporta) {
        this.rodapeexporta = rodapeexporta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (posto != null ? posto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Posto)) {
            return false;
        }
        Posto other = (Posto) object;
        if ((this.posto == null && other.posto != null) || (this.posto != null && !this.posto.equals(other.posto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.entidades.Postos[ posto=" + posto + " ]";
    }
    
}
