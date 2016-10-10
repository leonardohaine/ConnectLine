package br.com.jlab.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "requisicao")
public class Requisicao implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_REQ")
	@SequenceGenerator(name = "SEQ_REQ", sequenceName = "seq_requisicao")
    @Basic(optional = false)
    @Column(name = "requisicao")
    private Long requisicao;
    @Basic(optional = false)
    @Column(name = "posto")
    private String posto;
    @Column(name = "cnpj_unidade")
    private Long cnpjUnidade;
    @Column(name = "entrada")
    @Temporal(TemporalType.DATE)
    private Date entrada;
    @Column(name = "especialidade")
    private Long especialidade;
    
    @Column(name = "responsavel")
    private String responsavel;
    
    @Column(name = "rg_responsavel")
    private Long rgResponsavel;
    @Column(name = "sequencia")
    private String sequencia;
    @Column(name = "controle")
    private String controle;
    @Column(name = "deve")
    private String deve;
    @Column(name = "quarto")
    private String quarto;
    @Column(name = "leito")
    private String leito;
    @Column(name = "motivo")
    private String motivo;
    @Lob
    @Column(name = "observacoes")
    private byte[] observacoes;
    @Lob
    @Column(name = "resultado")
    private byte[] resultado;
    @Column(name = "cid")
    private String cid;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Column(name = "coletado")
    private String coletado;
    @Column(name = "triado")
    private String triado;
    @Column(name = "pronto")
    private String pronto;
    @Column(name = "idamostrahc")
    private String idamostrahc;
    @Column(name = "entradahora")
    @Temporal(TemporalType.TIME)
    private Date entradahora;
    @Column(name = "origem")
    private String origem;
    @Type(type= "org.hibernate.type.NumericBooleanType")
    @Column(name = "gestante")
    private Boolean gestante;
    @Column(name = "observacao")
    private String observacao;
    @Column(name = "status")
    private String status;
    @Column(name = "req_impresso")
    private String reqImpresso;
    @Column(name = "dataentrega")
    @Temporal(TemporalType.DATE)
    private Date dataentrega;
    @Column(name = "medico")
    private String medico;
    @Column(name = "localentrega")
    private String localentrega;
    @Column(name = "req_in_status")
    private Integer reqInStatus;
    @Column(name = "req_ch_precadastro")
    private Character reqChPrecadastro;
    @Column(name = "colonia")
    private String colonia;
    @Column(name = "idamostraalt")
    private String idamostraalt;
    @Column(name = "req_in_amostras")
    private Integer reqInAmostras;
    @Column(name = "prontuariolab")
    private String prontuariolab;
    @Column(name = "image")
    private String image;
    @Column(name = "offlinne")
    private Integer offline;
    @Column(name = "req_st_etiquetaimpressa")
    private String reqStEtiquetaimpressa;
    @Column(name = "tipocadastro")
    private Character tipocadastro;
    @Column(name = "req_dt_geraetiqueta")
    @Temporal(TemporalType.DATE)
    private Date reqDtGeraetiqueta;
    @Column(name = "usu_st_reimpressao")
    private String usuStReimpressao;
    @Column(name = "req_dt_etiquetareimpressa")
    @Temporal(TemporalType.DATE)
    private Date reqDtEtiquetareimpressa;
    @Column(name = "req_st_origemunidade")
    private String reqStOrigemunidade;
    @Column(name = "req_st_etiquetareimpressa")
    private Character reqStEtiquetareimpressa;
    @JoinColumn(name = "prontuario", referencedColumnName = "prontuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Paciente prontuario;

    public Requisicao() {
    }

    public Requisicao(Long requisicao) {
        this.requisicao = requisicao;
    }

    public Requisicao(Long requisicao, String posto) {
        this.requisicao = requisicao;
        this.posto = posto;
    }

    public String getPosto() {
        return posto;
    }

    public void setPosto(String posto) {
    	
        this.posto = posto;
    }

    public Long getRequisicao() {
        return requisicao;
    }

    public void setRequisicao(Long requisicao) {
        this.requisicao = requisicao;
    }

    public Long getCnpjUnidade() {
		return cnpjUnidade;
	}

	public void setCnpjUnidade(Long cnpjUnidade) {
		this.cnpjUnidade = cnpjUnidade;
	}

	public Date getEntrada() {
		if(entrada == null){
    		entrada = new Date();
    	}
        return entrada;
    }

    public void setEntrada(Date entrada) {
    	
        this.entrada = entrada;
    }

    public String getSequencia() {
        return sequencia;
    }

    public void setSequencia(String sequencia) {
        this.sequencia = sequencia;
    }

    public String getControle() {
        return controle;
    }

    public void setControle(String controle) {
        this.controle = controle;
    }

    public String getDeve() {
        return deve;
    }

    public void setDeve(String deve) {
        this.deve = deve;
    }

    public String getQuarto() {
        return quarto;
    }

    public void setQuarto(String quarto) {
        this.quarto = quarto;
    }

    public String getLeito() {
        return leito;
    }

    public void setLeito(String leito) {
        this.leito = leito;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public byte[] getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(byte[] observacoes) {
        this.observacoes = observacoes;
    }

    public byte[] getResultado() {
        return resultado;
    }

    public void setResultado(byte[] resultado) {
        this.resultado = resultado;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getColetado() {
        return coletado;
    }

    public void setColetado(String coletado) {
        this.coletado = coletado;
    }

    public String getTriado() {
        return triado;
    }

    public void setTriado(String triado) {
        this.triado = triado;
    }

    public String getPronto() {
        return pronto;
    }

    public void setPronto(String pronto) {
        this.pronto = pronto;
    }

    public String getIdamostrahc() {
        return idamostrahc;
    }

    public void setIdamostrahc(String idamostrahc) {
        this.idamostrahc = idamostrahc;
    }

    public Date getEntradahora() {
        return entradahora;
    }

    public void setEntradahora(Date entradahora) {
        this.entradahora = entradahora;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public Boolean getGestante() {
        return gestante;
    }

    public void setGestante(Boolean gestante) {
        this.gestante = gestante;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReqImpresso() {
        return reqImpresso;
    }

    public void setReqImpresso(String reqImpresso) {
        this.reqImpresso = reqImpresso;
    }

    public Date getDataentrega() {
        return dataentrega;
    }

    public void setDataentrega(Date dataentrega) {
        this.dataentrega = dataentrega;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getLocalentrega() {
        return localentrega;
    }

    public void setLocalentrega(String localentrega) {
        this.localentrega = localentrega;
    }

    public Integer getReqInStatus() {
        return reqInStatus;
    }

    public void setReqInStatus(Integer reqInStatus) {
        this.reqInStatus = reqInStatus;
    }

    public Character getReqChPrecadastro() {
        return reqChPrecadastro;
    }

    public void setReqChPrecadastro(Character reqChPrecadastro) {
        this.reqChPrecadastro = reqChPrecadastro;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getIdamostraalt() {
        return idamostraalt;
    }

    public void setIdamostraalt(String idamostraalt) {
        this.idamostraalt = idamostraalt;
    }

    public Integer getReqInAmostras() {
        return reqInAmostras;
    }

    public void setReqInAmostras(Integer reqInAmostras) {
        this.reqInAmostras = reqInAmostras;
    }

    public String getProntuariolab() {
        return prontuariolab;
    }

    public void setProntuariolab(String prontuariolab) {
        this.prontuariolab = prontuariolab;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getOffline() {
        return offline;
    }

    public void setOffline(Integer offline) {
        this.offline = offline;
    }

    public String getReqStEtiquetaimpressa() {
        return reqStEtiquetaimpressa;
    }

    public void setReqStEtiquetaimpressa(String reqStEtiquetaimpressa) {
        this.reqStEtiquetaimpressa = reqStEtiquetaimpressa;
    }

    public Character getTipocadastro() {
        return tipocadastro;
    }

    public void setTipocadastro(Character tipocadastro) {
        this.tipocadastro = tipocadastro;
    }

    public Date getReqDtGeraetiqueta() {
        return reqDtGeraetiqueta;
    }

    public void setReqDtGeraetiqueta(Date reqDtGeraetiqueta) {
        this.reqDtGeraetiqueta = reqDtGeraetiqueta;
    }

    public String getUsuStReimpressao() {
        return usuStReimpressao;
    }

    public void setUsuStReimpressao(String usuStReimpressao) {
        this.usuStReimpressao = usuStReimpressao;
    }

    public Date getReqDtEtiquetareimpressa() {
        return reqDtEtiquetareimpressa;
    }

    public void setReqDtEtiquetareimpressa(Date reqDtEtiquetareimpressa) {
        this.reqDtEtiquetareimpressa = reqDtEtiquetareimpressa;
    }

    public String getReqStOrigemunidade() {
        return reqStOrigemunidade;
    }

    public void setReqStOrigemunidade(String reqStOrigemunidade) {
        this.reqStOrigemunidade = reqStOrigemunidade;
    }

    public Character getReqStEtiquetareimpressa() {
        return reqStEtiquetareimpressa;
    }

    public void setReqStEtiquetareimpressa(Character reqStEtiquetareimpressa) {
        this.reqStEtiquetareimpressa = reqStEtiquetareimpressa;
    }

    public Paciente getProntuario() {
        return prontuario;
    }

    public void setProntuario(Paciente prontuario) {
        this.prontuario = prontuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (requisicao != null ? requisicao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Requisicao)) {
            return false;
        }
        Requisicao other = (Requisicao) object;
        if ((this.requisicao == null && other.requisicao != null) || (this.requisicao != null && !this.requisicao.equals(other.requisicao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.entidades.Requisicoes[ requisicao=" + requisicao + " ]";
    }

	public Long getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Long especialidade) {
		this.especialidade = especialidade;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public Long getRgResponsavel() {
		return rgResponsavel;
	}

	public void setRgResponsavel(Long rgResponsavel) {
		this.rgResponsavel = rgResponsavel;
	}
    
}
