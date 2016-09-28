package br.com.jlab.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "medicosol")
public class Medicosol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "medicosol")
    private String medicosol;
    @Column(name = "nome")
    private String nome;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "complemento")
    private String complemento;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "uf")
    private String uf;
    @Column(name = "cep")
    private String cep;
    @Column(name = "telefone1")
    private String telefone1;
    @Column(name = "telefone2")
    private String telefone2;
    @Column(name = "celular")
    private String celular;
    @Column(name = "email")
    private String email;
    @Column(name = "esp1")
    private String esp1;
    @Column(name = "esp2")
    private String esp2;
    @Column(name = "loguser")
    private String loguser;
    @Lob
    @Column(name = "logalteracoes")
    private byte[] logalteracoes;
    @Column(name = "logtime")
    private String logtime;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "fax")
    private String fax;
    @Column(name = "senha")
    private String senha;
    @Basic(optional = false)
    @Column(name = "estadocrm")
    private String estadocrm;
    @Column(name = "cbo")
    private String cbo;
    @Column(name = "medicosus")
    private String medicosus;

    public Medicosol() {
    }

    public Medicosol(String medicosol) {
        this.medicosol = medicosol;
    }

    public Medicosol(String medicosol, String estadocrm) {
        this.medicosol = medicosol;
        this.estadocrm = estadocrm;
    }

    public String getMedicosol() {
        return medicosol;
    }

    public void setMedicosol(String medicosol) {
        this.medicosol = medicosol;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEsp1() {
        return esp1;
    }

    public void setEsp1(String esp1) {
        this.esp1 = esp1;
    }

    public String getEsp2() {
        return esp2;
    }

    public void setEsp2(String esp2) {
        this.esp2 = esp2;
    }

    public String getLoguser() {
        return loguser;
    }

    public void setLoguser(String loguser) {
        this.loguser = loguser;
    }

    public byte[] getLogalteracoes() {
        return logalteracoes;
    }

    public void setLogalteracoes(byte[] logalteracoes) {
        this.logalteracoes = logalteracoes;
    }

    public String getLogtime() {
        return logtime;
    }

    public void setLogtime(String logtime) {
        this.logtime = logtime;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEstadocrm() {
        return estadocrm;
    }

    public void setEstadocrm(String estadocrm) {
        this.estadocrm = estadocrm;
    }

    public String getCbo() {
        return cbo;
    }

    public void setCbo(String cbo) {
        this.cbo = cbo;
    }

    public String getMedicosus() {
        return medicosus;
    }

    public void setMedicosus(String medicosus) {
        this.medicosus = medicosus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (medicosol != null ? medicosol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicosol)) {
            return false;
        }
        Medicosol other = (Medicosol) object;
        if ((this.medicosol == null && other.medicosol != null) || (this.medicosol != null && !this.medicosol.equals(other.medicosol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.entidades.Medicosol[ medicosol=" + medicosol + " ]";
    }
    
}
