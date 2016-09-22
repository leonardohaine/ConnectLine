package br.com.jlab.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "exame")
public class Exame implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "exame")
    private Long exame;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "fantasia")
    private String fantasia;
    @Column(name = "metodo")
    private String metodo;
    @Column(name = "volume_ml")
    private BigInteger volumeMl;
    @Column(name = "amb")
    private String amb;
    @Lob
    @Column(name = "obs")
    private byte[] obs;
    @Column(name = "custo")
    private BigInteger custo;
    @Column(name = "usuario")
    private String usuario;
    @Lob
    @Column(name = "conserva")
    private byte[] conserva;
    @Lob
    @Column(name = "preparo")
    private byte[] preparo;
    @Lob
    @Column(name = "interfere")
    private byte[] interfere;
    @Lob
    @Column(name = "referencia")
    private byte[] referencia;
    @Lob
    @Column(name = "interpreta")
    private byte[] interpreta;
    @Lob
    @Column(name = "relaciona")
    private byte[] relaciona;
    @Column(name = "triagem")
    private String triagem;
    @Lob
    @Column(name = "gabinete0")
    private byte[] gabinete0;
    @Lob
    @Column(name = "gabinete1")
    private byte[] gabinete1;
    @Lob
    @Column(name = "gabinete2")
    private byte[] gabinete2;
    @Column(name = "bloq")
    private String bloq;
    @Lob
    @Column(name = "motivo")
    private byte[] motivo;
    @Lob
    @Column(name = "urgencia")
    private byte[] urgencia;
    @Column(name = "interface")
    private String interface1;
    @Column(name = "temmedico")
    private String temmedico;
    @Column(name = "imagem")
    private String imagem;
    @Lob
    @Column(name = "cuidados")
    private byte[] cuidados;
    @Column(name = "apoio")
    private String apoio;
    @Column(name = "folha")
    private String folha;
    @Column(name = "ordem")
    private String ordem;
    @Column(name = "agenda")
    private String agenda;
    @Lob
    @Column(name = "txtrefere")
    private byte[] txtrefere;
    @Column(name = "labapoio")
    private String labapoio;
    @Column(name = "usamat")
    private String usamat;
    @Column(name = "sofatura")
    private String sofatura;
    @Column(name = "exmtria")
    private String exmtria;
    @Column(name = "partecorpo")
    private String partecorpo;
    @Column(name = "medicor")
    private String medicor;
    @Column(name = "naogab")
    private String naogab;
    @Column(name = "matmed")
    private String matmed;
    @Column(name = "enviainternet")
    private String enviainternet;
    @Column(name = "taxa")
    private BigInteger taxa;
    @Lob
    @Column(name = "laudo")
    private byte[] laudo;
    @Column(name = "especialidade")
    private String especialidade;
    @Column(name = "prazo")
    private String prazo;
    @Column(name = "recipientetriagem")
    private String recipientetriagem;
    @Column(name = "tubonovacoleta")
    private String tubonovacoleta;
    @Column(name = "interfaceado")
    private String interfaceado;
    @Lob
    @Column(name = "caracteristicasexame")
    private byte[] caracteristicasexame;
    @Lob
    @Column(name = "examesrelacionados")
    private byte[] examesrelacionados;
    @Lob
    @Column(name = "remediosinterferentes")
    private byte[] remediosinterferentes;
    @Lob
    @Column(name = "cudadosparacoleta")
    private byte[] cudadosparacoleta;
    @Lob
    @Column(name = "comentarios")
    private byte[] comentarios;
    @Lob
    @Column(name = "mapa")
    private byte[] mapa;
    @Column(name = "etiquetarecipiente")
    private Integer etiquetarecipiente;
    @Column(name = "etiquetatriagem")
    private Integer etiquetatriagem;
    @Column(name = "somentefaturamento")
    private String somentefaturamento;
    @Column(name = "necessitamedrealizante")
    private String necessitamedrealizante;
    @Column(name = "exameimagem")
    private String exameimagem;
    @Lob
    @Column(name = "referencias")
    private byte[] referencias;
    @Column(name = "examesozinho")
    private String examesozinho;
    @Column(name = "descricaolis")
    private String descricaolis;
    @Column(name = "examelis")
    private String examelis;
    @Column(name = "dataalteracao")
    @Temporal(TemporalType.DATE)
    private Date dataalteracao;
    @Column(name = "horaalteracao")
    @Temporal(TemporalType.TIME)
    private Date horaalteracao;
    @Column(name = "periodo")
    private String periodo;
    @Column(name = "liberacaoautomatica")
    private String liberacaoautomatica;
    @Column(name = "automatico")
    private String automatico;
    @Column(name = "grupo")
    private Integer grupo;
    @Column(name = "diluicao")
    private Integer diluicao;
    @Column(name = "tamanho")
    private Integer tamanho;
    @Basic(optional = false)
    @Column(name = "coletaseparado")
    private String coletaseparado;
    @Column(name = "materialtriagem")
    private String materialtriagem;
    @Column(name = "pex_st_codigo")
    private String pexStCodigo;
    @Column(name = "exa_in_sequenciaperfil")
    private Integer exaInSequenciaperfil;
    @Column(name = "aliquota")
    private String aliquota;
    @Column(name = "consultalaudo")
    private String consultalaudo;
    @Column(name = "relatorio")
    private String relatorio;
    @Column(name = "exa_dt_subsetor")
    @Temporal(TemporalType.DATE)
    private Date exaDtSubsetor;
    @Column(name = "exa_in_subsetor")
    private Integer exaInSubsetor;
    @Column(name = "exa_st_gerasubsetor")
    private String exaStGerasubsetor;
    @Column(name = "sequencialaudo")
    private Integer sequencialaudo;
    @Column(name = "ativo")
    private Character ativo;
    @Column(name = "exa_st_enviolis")
    private String exaStEnviolis;
    @Column(name = "exa_st_tubompa")
    private String exaStTubompa;
    @Column(name = "exa_in_prioridade")
    private Short exaInPrioridade;
    @JoinColumn(name = "equipamento", referencedColumnName = "equipamento")
    @ManyToOne
    private Equipamento equipamento;
    @JoinColumn(name = "material", referencedColumnName = "material")
    @ManyToOne
    private Material material;
    @JoinColumn(name = "recipiente", referencedColumnName = "recipiente")
    @ManyToOne
    private Recipiente recipiente;
    @JoinColumn(name = "setor", referencedColumnName = "setor")
    @ManyToOne
    private Setor setor;

    public Exame() {
    }

    public Exame(Long exame) {
        this.exame = exame;
    }

    public Exame(Long exame, String coletaseparado) {
        this.exame = exame;
        this.coletaseparado = coletaseparado;
    }

    public Long getExame() {
        return exame;
    }

    public void setExame(Long exame) {
        this.exame = exame;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public BigInteger getVolumeMl() {
        return volumeMl;
    }

    public void setVolumeMl(BigInteger volumeMl) {
        this.volumeMl = volumeMl;
    }

    public String getAmb() {
        return amb;
    }

    public void setAmb(String amb) {
        this.amb = amb;
    }

    public byte[] getObs() {
        return obs;
    }

    public void setObs(byte[] obs) {
        this.obs = obs;
    }

    public BigInteger getCusto() {
        return custo;
    }

    public void setCusto(BigInteger custo) {
        this.custo = custo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public byte[] getConserva() {
        return conserva;
    }

    public void setConserva(byte[] conserva) {
        this.conserva = conserva;
    }

    public byte[] getPreparo() {
        return preparo;
    }

    public void setPreparo(byte[] preparo) {
        this.preparo = preparo;
    }

    public byte[] getInterfere() {
        return interfere;
    }

    public void setInterfere(byte[] interfere) {
        this.interfere = interfere;
    }

    public byte[] getReferencia() {
        return referencia;
    }

    public void setReferencia(byte[] referencia) {
        this.referencia = referencia;
    }

    public byte[] getInterpreta() {
        return interpreta;
    }

    public void setInterpreta(byte[] interpreta) {
        this.interpreta = interpreta;
    }

    public byte[] getRelaciona() {
        return relaciona;
    }

    public void setRelaciona(byte[] relaciona) {
        this.relaciona = relaciona;
    }

    public String getTriagem() {
        return triagem;
    }

    public void setTriagem(String triagem) {
        this.triagem = triagem;
    }

    public byte[] getGabinete0() {
        return gabinete0;
    }

    public void setGabinete0(byte[] gabinete0) {
        this.gabinete0 = gabinete0;
    }

    public byte[] getGabinete1() {
        return gabinete1;
    }

    public void setGabinete1(byte[] gabinete1) {
        this.gabinete1 = gabinete1;
    }

    public byte[] getGabinete2() {
        return gabinete2;
    }

    public void setGabinete2(byte[] gabinete2) {
        this.gabinete2 = gabinete2;
    }

    public String getBloq() {
        return bloq;
    }

    public void setBloq(String bloq) {
        this.bloq = bloq;
    }

    public byte[] getMotivo() {
        return motivo;
    }

    public void setMotivo(byte[] motivo) {
        this.motivo = motivo;
    }

    public byte[] getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(byte[] urgencia) {
        this.urgencia = urgencia;
    }

    public String getInterface1() {
        return interface1;
    }

    public void setInterface1(String interface1) {
        this.interface1 = interface1;
    }

    public String getTemmedico() {
        return temmedico;
    }

    public void setTemmedico(String temmedico) {
        this.temmedico = temmedico;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public byte[] getCuidados() {
        return cuidados;
    }

    public void setCuidados(byte[] cuidados) {
        this.cuidados = cuidados;
    }

    public String getApoio() {
        return apoio;
    }

    public void setApoio(String apoio) {
        this.apoio = apoio;
    }

    public String getFolha() {
        return folha;
    }

    public void setFolha(String folha) {
        this.folha = folha;
    }

    public String getOrdem() {
        return ordem;
    }

    public void setOrdem(String ordem) {
        this.ordem = ordem;
    }

    public String getAgenda() {
        return agenda;
    }

    public void setAgenda(String agenda) {
        this.agenda = agenda;
    }

    public byte[] getTxtrefere() {
        return txtrefere;
    }

    public void setTxtrefere(byte[] txtrefere) {
        this.txtrefere = txtrefere;
    }

    public String getLabapoio() {
        return labapoio;
    }

    public void setLabapoio(String labapoio) {
        this.labapoio = labapoio;
    }

    public String getUsamat() {
        return usamat;
    }

    public void setUsamat(String usamat) {
        this.usamat = usamat;
    }

    public String getSofatura() {
        return sofatura;
    }

    public void setSofatura(String sofatura) {
        this.sofatura = sofatura;
    }

    public String getExmtria() {
        return exmtria;
    }

    public void setExmtria(String exmtria) {
        this.exmtria = exmtria;
    }

    public String getPartecorpo() {
        return partecorpo;
    }

    public void setPartecorpo(String partecorpo) {
        this.partecorpo = partecorpo;
    }

    public String getMedicor() {
        return medicor;
    }

    public void setMedicor(String medicor) {
        this.medicor = medicor;
    }

    public String getNaogab() {
        return naogab;
    }

    public void setNaogab(String naogab) {
        this.naogab = naogab;
    }

    public String getMatmed() {
        return matmed;
    }

    public void setMatmed(String matmed) {
        this.matmed = matmed;
    }

    public String getEnviainternet() {
        return enviainternet;
    }

    public void setEnviainternet(String enviainternet) {
        this.enviainternet = enviainternet;
    }

    public BigInteger getTaxa() {
        return taxa;
    }

    public void setTaxa(BigInteger taxa) {
        this.taxa = taxa;
    }

    public byte[] getLaudo() {
        return laudo;
    }

    public void setLaudo(byte[] laudo) {
        this.laudo = laudo;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getPrazo() {
        return prazo;
    }

    public void setPrazo(String prazo) {
        this.prazo = prazo;
    }

    public String getRecipientetriagem() {
        return recipientetriagem;
    }

    public void setRecipientetriagem(String recipientetriagem) {
        this.recipientetriagem = recipientetriagem;
    }

    public String getTubonovacoleta() {
        return tubonovacoleta;
    }

    public void setTubonovacoleta(String tubonovacoleta) {
        this.tubonovacoleta = tubonovacoleta;
    }

    public String getInterfaceado() {
        return interfaceado;
    }

    public void setInterfaceado(String interfaceado) {
        this.interfaceado = interfaceado;
    }

    public byte[] getCaracteristicasexame() {
        return caracteristicasexame;
    }

    public void setCaracteristicasexame(byte[] caracteristicasexame) {
        this.caracteristicasexame = caracteristicasexame;
    }

    public byte[] getExamesrelacionados() {
        return examesrelacionados;
    }

    public void setExamesrelacionados(byte[] examesrelacionados) {
        this.examesrelacionados = examesrelacionados;
    }

    public byte[] getRemediosinterferentes() {
        return remediosinterferentes;
    }

    public void setRemediosinterferentes(byte[] remediosinterferentes) {
        this.remediosinterferentes = remediosinterferentes;
    }

    public byte[] getCudadosparacoleta() {
        return cudadosparacoleta;
    }

    public void setCudadosparacoleta(byte[] cudadosparacoleta) {
        this.cudadosparacoleta = cudadosparacoleta;
    }

    public byte[] getComentarios() {
        return comentarios;
    }

    public void setComentarios(byte[] comentarios) {
        this.comentarios = comentarios;
    }

    public byte[] getMapa() {
        return mapa;
    }

    public void setMapa(byte[] mapa) {
        this.mapa = mapa;
    }

    public Integer getEtiquetarecipiente() {
        return etiquetarecipiente;
    }

    public void setEtiquetarecipiente(Integer etiquetarecipiente) {
        this.etiquetarecipiente = etiquetarecipiente;
    }

    public Integer getEtiquetatriagem() {
        return etiquetatriagem;
    }

    public void setEtiquetatriagem(Integer etiquetatriagem) {
        this.etiquetatriagem = etiquetatriagem;
    }

    public String getSomentefaturamento() {
        return somentefaturamento;
    }

    public void setSomentefaturamento(String somentefaturamento) {
        this.somentefaturamento = somentefaturamento;
    }

    public String getNecessitamedrealizante() {
        return necessitamedrealizante;
    }

    public void setNecessitamedrealizante(String necessitamedrealizante) {
        this.necessitamedrealizante = necessitamedrealizante;
    }

    public String getExameimagem() {
        return exameimagem;
    }

    public void setExameimagem(String exameimagem) {
        this.exameimagem = exameimagem;
    }

    public byte[] getReferencias() {
        return referencias;
    }

    public void setReferencias(byte[] referencias) {
        this.referencias = referencias;
    }

    public String getExamesozinho() {
        return examesozinho;
    }

    public void setExamesozinho(String examesozinho) {
        this.examesozinho = examesozinho;
    }

    public String getDescricaolis() {
        return descricaolis;
    }

    public void setDescricaolis(String descricaolis) {
        this.descricaolis = descricaolis;
    }

    public String getExamelis() {
        return examelis;
    }

    public void setExamelis(String examelis) {
        this.examelis = examelis;
    }

    public Date getDataalteracao() {
        return dataalteracao;
    }

    public void setDataalteracao(Date dataalteracao) {
        this.dataalteracao = dataalteracao;
    }

    public Date getHoraalteracao() {
        return horaalteracao;
    }

    public void setHoraalteracao(Date horaalteracao) {
        this.horaalteracao = horaalteracao;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getLiberacaoautomatica() {
        return liberacaoautomatica;
    }

    public void setLiberacaoautomatica(String liberacaoautomatica) {
        this.liberacaoautomatica = liberacaoautomatica;
    }

    public String getAutomatico() {
        return automatico;
    }

    public void setAutomatico(String automatico) {
        this.automatico = automatico;
    }

    public Integer getGrupo() {
        return grupo;
    }

    public void setGrupo(Integer grupo) {
        this.grupo = grupo;
    }

    public Integer getDiluicao() {
        return diluicao;
    }

    public void setDiluicao(Integer diluicao) {
        this.diluicao = diluicao;
    }

    public Integer getTamanho() {
        return tamanho;
    }

    public void setTamanho(Integer tamanho) {
        this.tamanho = tamanho;
    }

    public String getColetaseparado() {
        return coletaseparado;
    }

    public void setColetaseparado(String coletaseparado) {
        this.coletaseparado = coletaseparado;
    }

    public String getMaterialtriagem() {
        return materialtriagem;
    }

    public void setMaterialtriagem(String materialtriagem) {
        this.materialtriagem = materialtriagem;
    }

    public String getPexStCodigo() {
        return pexStCodigo;
    }

    public void setPexStCodigo(String pexStCodigo) {
        this.pexStCodigo = pexStCodigo;
    }

    public Integer getExaInSequenciaperfil() {
        return exaInSequenciaperfil;
    }

    public void setExaInSequenciaperfil(Integer exaInSequenciaperfil) {
        this.exaInSequenciaperfil = exaInSequenciaperfil;
    }

    public String getAliquota() {
        return aliquota;
    }

    public void setAliquota(String aliquota) {
        this.aliquota = aliquota;
    }

    public String getConsultalaudo() {
        return consultalaudo;
    }

    public void setConsultalaudo(String consultalaudo) {
        this.consultalaudo = consultalaudo;
    }

    public String getRelatorio() {
        return relatorio;
    }

    public void setRelatorio(String relatorio) {
        this.relatorio = relatorio;
    }

    public Date getExaDtSubsetor() {
        return exaDtSubsetor;
    }

    public void setExaDtSubsetor(Date exaDtSubsetor) {
        this.exaDtSubsetor = exaDtSubsetor;
    }

    public Integer getExaInSubsetor() {
        return exaInSubsetor;
    }

    public void setExaInSubsetor(Integer exaInSubsetor) {
        this.exaInSubsetor = exaInSubsetor;
    }

    public String getExaStGerasubsetor() {
        return exaStGerasubsetor;
    }

    public void setExaStGerasubsetor(String exaStGerasubsetor) {
        this.exaStGerasubsetor = exaStGerasubsetor;
    }

    public Integer getSequencialaudo() {
        return sequencialaudo;
    }

    public void setSequencialaudo(Integer sequencialaudo) {
        this.sequencialaudo = sequencialaudo;
    }

    public Character getAtivo() {
        return ativo;
    }

    public void setAtivo(Character ativo) {
        this.ativo = ativo;
    }

    public String getExaStEnviolis() {
        return exaStEnviolis;
    }

    public void setExaStEnviolis(String exaStEnviolis) {
        this.exaStEnviolis = exaStEnviolis;
    }

    public String getExaStTubompa() {
        return exaStTubompa;
    }

    public void setExaStTubompa(String exaStTubompa) {
        this.exaStTubompa = exaStTubompa;
    }

    public Short getExaInPrioridade() {
        return exaInPrioridade;
    }

    public void setExaInPrioridade(Short exaInPrioridade) {
        this.exaInPrioridade = exaInPrioridade;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Recipiente getRecipiente() {
        return recipiente;
    }

    public void setRecipiente(Recipiente recipiente) {
        this.recipiente = recipiente;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (exame != null ? exame.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Exame)) {
            return false;
        }
        Exame other = (Exame) object;
        if ((this.exame == null && other.exame != null) || (this.exame != null && !this.exame.equals(other.exame))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.entidades.Exames[ exame=" + exame + " ]";
    }
    
}
