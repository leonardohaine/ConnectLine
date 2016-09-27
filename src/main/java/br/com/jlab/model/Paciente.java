package br.com.jlab.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "paciente")
public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "prontuario")
    private String prontuario;
    @Basic(optional = false)
    @Column(name = "posto")
    private String posto;
    @Column(name = "convenio")
    private String convenio;
    @Column(name = "regra")
    private Integer regra;
    @Column(name = "matricula")
    private String matricula;
    @Column(name = "validadecarteira")
    @Temporal(TemporalType.DATE)
    private Date validadecarteira;
    @Column(name = "nome")
    private String nome;
    @Column(name = "nascimento")
    @Temporal(TemporalType.DATE)
    private Date nascimento;
    @Column(name = "sexo")
    private Boolean sexo;
    @Column(name = "cor")
    private String cor;
    @Column(name = "estadocivil")
    private String estadocivil;
    @Column(name = "rg")
    private String rg;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "profissao")
    private String profissao;
    @Column(name = "email")
    private String email;
    @Column(name = "cep")
    private String cep;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "uf")
    private String uf;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "celular")
    private String celular;
    @Column(name = "origem")
    private String origem;
    @Column(name = "destino")
    private String destino;
    @Lob
    @Column(name = "observacoes")
    private byte[] observacoes;
    @Lob
    @Column(name = "foto")
    private byte[] foto;
    @Column(name = "medico")
    private String medico;
    @Column(name = "entrada")
    @Temporal(TemporalType.DATE)
    private Date entrada;
    @Column(name = "dum")
    @Temporal(TemporalType.DATE)
    private Date dum;
    @Column(name = "numero")
    private String numero;
    @Column(name = "complemento")
    private String complemento;
    @Column(name = "entradahora")
    @Temporal(TemporalType.TIME)
    private Date entradahora;
    @Column(name = "idade")
    private Integer idade;
    @Column(name = "alterado")
    private String alterado;
    @Column(name = "pac_st_sus")
    private String pacStSus;
    @Column(name = "num_same")
    private String numSame;
    @Column(name = "mae")
    private String mae;
    @Column(name = "prontuariounidade")
    private String prontuariounidade;
    @Column(name = "peso")
    private String peso;
    @Column(name = "altura")
    private String altura;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prontuario")
    private List<Requisicao> requisicoes;

    public Paciente() {
    }

    public Paciente(String prontuario) {
        this.prontuario = prontuario;
    }

    public Paciente(String prontuario, String posto) {
        this.prontuario = prontuario;
        this.posto = posto;
    }

    public String getProntuario() {
        return prontuario;
    }

    public void setProntuario(String prontuario) {
        this.prontuario = prontuario;
    }

    public String getPosto() {
        return posto;
    }

    public void setPosto(String posto) {
        this.posto = posto;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public Integer getRegra() {
        return regra;
    }

    public void setRegra(Integer regra) {
        this.regra = regra;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Date getValidadecarteira() {
        return validadecarteira;
    }

    public void setValidadecarteira(Date validadecarteira) {
        this.validadecarteira = validadecarteira;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public Boolean getSexo() {
        return sexo;
    }

    public void setSexo(Boolean sexo) {
        this.sexo = sexo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(String estadocivil) {
        this.estadocivil = estadocivil;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public byte[] getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(byte[] observacoes) {
        this.observacoes = observacoes;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public Date getEntrada() {
        return entrada;
    }

    public void setEntrada(Date entrada) {
        this.entrada = entrada;
    }

    public Date getDum() {
        return dum;
    }

    public void setDum(Date dum) {
        this.dum = dum;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Date getEntradahora() {
        return entradahora;
    }

    public void setEntradahora(Date entradahora) {
        this.entradahora = entradahora;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getAlterado() {
        return alterado;
    }

    public void setAlterado(String alterado) {
        this.alterado = alterado;
    }

    public String getPacStSus() {
        return pacStSus;
    }

    public void setPacStSus(String pacStSus) {
        this.pacStSus = pacStSus;
    }

    public String getNumSame() {
        return numSame;
    }

    public void setNumSame(String numSame) {
        this.numSame = numSame;
    }

    public String getMae() {
        return mae;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }

    public String getProntuariounidade() {
        return prontuariounidade;
    }

    public void setProntuariounidade(String prontuariounidade) {
        this.prontuariounidade = prontuariounidade;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }
    
    public List<Requisicao> getRequisicoes() {
		return requisicoes;
	}
    
    public void setRequisicoes(List<Requisicao> requisicoes) {
		this.requisicoes = requisicoes;
	}


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prontuario != null ? prontuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.prontuario == null && other.prontuario != null) || (this.prontuario != null && !this.prontuario.equals(other.prontuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.entidades.Pacientes[ prontuario=" + prontuario + " ]";
    }
    
}
