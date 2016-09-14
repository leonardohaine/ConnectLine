/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jlab.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "equipamentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipamentos.findAll", query = "SELECT e FROM Equipamentos e"),
    @NamedQuery(name = "Equipamentos.findByEquipamento", query = "SELECT e FROM Equipamentos e WHERE e.equipamento = :equipamento"),
    @NamedQuery(name = "Equipamentos.findByDescricao", query = "SELECT e FROM Equipamentos e WHERE e.descricao = :descricao"),
    @NamedQuery(name = "Equipamentos.findByBoundrate", query = "SELECT e FROM Equipamentos e WHERE e.boundrate = :boundrate"),
    @NamedQuery(name = "Equipamentos.findByNbits", query = "SELECT e FROM Equipamentos e WHERE e.nbits = :nbits"),
    @NamedQuery(name = "Equipamentos.findByStopbits", query = "SELECT e FROM Equipamentos e WHERE e.stopbits = :stopbits"),
    @NamedQuery(name = "Equipamentos.findByParidade", query = "SELECT e FROM Equipamentos e WHERE e.paridade = :paridade"),
    @NamedQuery(name = "Equipamentos.findByFlowcontrol", query = "SELECT e FROM Equipamentos e WHERE e.flowcontrol = :flowcontrol"),
    @NamedQuery(name = "Equipamentos.findByPosicaohorizontal", query = "SELECT e FROM Equipamentos e WHERE e.posicaohorizontal = :posicaohorizontal"),
    @NamedQuery(name = "Equipamentos.findByPosicaovertical", query = "SELECT e FROM Equipamentos e WHERE e.posicaovertical = :posicaovertical"),
    @NamedQuery(name = "Equipamentos.findByDescricaotecnica", query = "SELECT e FROM Equipamentos e WHERE e.descricaotecnica = :descricaotecnica"),
    @NamedQuery(name = "Equipamentos.findBySetor", query = "SELECT e FROM Equipamentos e WHERE e.setor = :setor"),
    @NamedQuery(name = "Equipamentos.findByPorta", query = "SELECT e FROM Equipamentos e WHERE e.porta = :porta"),
    @NamedQuery(name = "Equipamentos.findByComputador", query = "SELECT e FROM Equipamentos e WHERE e.computador = :computador"),
    @NamedQuery(name = "Equipamentos.findByIp", query = "SELECT e FROM Equipamentos e WHERE e.ip = :ip"),
    @NamedQuery(name = "Equipamentos.findByPort", query = "SELECT e FROM Equipamentos e WHERE e.port = :port"),
    @NamedQuery(name = "Equipamentos.findByDllname", query = "SELECT e FROM Equipamentos e WHERE e.dllname = :dllname"),
    @NamedQuery(name = "Equipamentos.findByImgdir", query = "SELECT e FROM Equipamentos e WHERE e.imgdir = :imgdir"),
    @NamedQuery(name = "Equipamentos.findByImpressora", query = "SELECT e FROM Equipamentos e WHERE e.impressora = :impressora"),
    @NamedQuery(name = "Equipamentos.findByAtivo", query = "SELECT e FROM Equipamentos e WHERE e.ativo = :ativo"),
    @NamedQuery(name = "Equipamentos.findByComputadorbackup", query = "SELECT e FROM Equipamentos e WHERE e.computadorbackup = :computadorbackup"),
    @NamedQuery(name = "Equipamentos.findBySerialbackup", query = "SELECT e FROM Equipamentos e WHERE e.serialbackup = :serialbackup"),
    @NamedQuery(name = "Equipamentos.findByBackupautomatico", query = "SELECT e FROM Equipamentos e WHERE e.backupautomatico = :backupautomatico"),
    @NamedQuery(name = "Equipamentos.findByTipocomunicacao", query = "SELECT e FROM Equipamentos e WHERE e.tipocomunicacao = :tipocomunicacao"),
    @NamedQuery(name = "Equipamentos.findByThread", query = "SELECT e FROM Equipamentos e WHERE e.thread = :thread"),
    @NamedQuery(name = "Equipamentos.findByNovo", query = "SELECT e FROM Equipamentos e WHERE e.novo = :novo"),
    @NamedQuery(name = "Equipamentos.findByTimer", query = "SELECT e FROM Equipamentos e WHERE e.timer = :timer"),
    @NamedQuery(name = "Equipamentos.findByLista", query = "SELECT e FROM Equipamentos e WHERE e.lista = :lista"),
    @NamedQuery(name = "Equipamentos.findByNumeroserie", query = "SELECT e FROM Equipamentos e WHERE e.numeroserie = :numeroserie"),
    @NamedQuery(name = "Equipamentos.findByDataativo", query = "SELECT e FROM Equipamentos e WHERE e.dataativo = :dataativo"),
    @NamedQuery(name = "Equipamentos.findByDatadesativo", query = "SELECT e FROM Equipamentos e WHERE e.datadesativo = :datadesativo"),
    @NamedQuery(name = "Equipamentos.findByTeste", query = "SELECT e FROM Equipamentos e WHERE e.teste = :teste"),
    @NamedQuery(name = "Equipamentos.findByTeste2", query = "SELECT e FROM Equipamentos e WHERE e.teste2 = :teste2"),
    @NamedQuery(name = "Equipamentos.findByChecked", query = "SELECT e FROM Equipamentos e WHERE e.checked = :checked"),
    @NamedQuery(name = "Equipamentos.findByTipoEquipamento", query = "SELECT e FROM Equipamentos e WHERE e.tipoEquipamento = :tipoEquipamento"),
    @NamedQuery(name = "Equipamentos.findByEmpresa", query = "SELECT e FROM Equipamentos e WHERE e.empresa = :empresa"),
    @NamedQuery(name = "Equipamentos.findByImgdirgrava", query = "SELECT e FROM Equipamentos e WHERE e.imgdirgrava = :imgdirgrava")})
public class Equipamentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "equipamento")
    private String equipamento;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "boundrate")
    private String boundrate;
    @Column(name = "nbits")
    private String nbits;
    @Column(name = "stopbits")
    private String stopbits;
    @Column(name = "paridade")
    private String paridade;
    @Column(name = "flowcontrol")
    private String flowcontrol;
    @Column(name = "posicaohorizontal")
    private Integer posicaohorizontal;
    @Column(name = "posicaovertical")
    private Integer posicaovertical;
    @Lob
    @Column(name = "roteiro")
    private byte[] roteiro;
    @Lob
    @Column(name = "pinagem")
    private byte[] pinagem;
    @Column(name = "descricaotecnica")
    private String descricaotecnica;
    @Column(name = "setor")
    private String setor;
    @Column(name = "porta")
    private Short porta;
    @Column(name = "computador")
    private String computador;
    @Column(name = "ip")
    private String ip;
    @Column(name = "port")
    private Integer port;
    @Column(name = "dllname")
    private String dllname;
    @Column(name = "imgdir")
    private String imgdir;
    @Column(name = "impressora")
    private String impressora;
    @Column(name = "ativo")
    private String ativo;
    @Column(name = "computadorbackup")
    private String computadorbackup;
    @Column(name = "serialbackup")
    private Short serialbackup;
    @Column(name = "backupautomatico")
    private String backupautomatico;
    @Column(name = "tipocomunicacao")
    private Character tipocomunicacao;
    @Basic(optional = false)
    @Column(name = "thread")
    private String thread;
    @Column(name = "novo")
    private Character novo;
    @Column(name = "timer")
    private Integer timer;
    @Column(name = "lista")
    private Integer lista;
    @Column(name = "numeroserie")
    private String numeroserie;
    @Column(name = "dataativo")
    @Temporal(TemporalType.DATE)
    private Date dataativo;
    @Column(name = "datadesativo")
    @Temporal(TemporalType.DATE)
    private Date datadesativo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "teste")
    private BigDecimal teste;
    @Column(name = "teste2")
    private BigDecimal teste2;
    @Column(name = "checked")
    private String checked;
    @Column(name = "tipo_equipamento")
    private String tipoEquipamento;
    @Column(name = "empresa")
    private String empresa;
    @Column(name = "imgdirgrava")
    private String imgdirgrava;
    @OneToMany(mappedBy = "equipamento")
    private Collection<Exames> examesCollection;

    public Equipamentos() {
    }

    public Equipamentos(String equipamento) {
        this.equipamento = equipamento;
    }

    public Equipamentos(String equipamento, String thread) {
        this.equipamento = equipamento;
        this.thread = thread;
    }

    public String getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getBoundrate() {
        return boundrate;
    }

    public void setBoundrate(String boundrate) {
        this.boundrate = boundrate;
    }

    public String getNbits() {
        return nbits;
    }

    public void setNbits(String nbits) {
        this.nbits = nbits;
    }

    public String getStopbits() {
        return stopbits;
    }

    public void setStopbits(String stopbits) {
        this.stopbits = stopbits;
    }

    public String getParidade() {
        return paridade;
    }

    public void setParidade(String paridade) {
        this.paridade = paridade;
    }

    public String getFlowcontrol() {
        return flowcontrol;
    }

    public void setFlowcontrol(String flowcontrol) {
        this.flowcontrol = flowcontrol;
    }

    public Integer getPosicaohorizontal() {
        return posicaohorizontal;
    }

    public void setPosicaohorizontal(Integer posicaohorizontal) {
        this.posicaohorizontal = posicaohorizontal;
    }

    public Integer getPosicaovertical() {
        return posicaovertical;
    }

    public void setPosicaovertical(Integer posicaovertical) {
        this.posicaovertical = posicaovertical;
    }

    public byte[] getRoteiro() {
        return roteiro;
    }

    public void setRoteiro(byte[] roteiro) {
        this.roteiro = roteiro;
    }

    public byte[] getPinagem() {
        return pinagem;
    }

    public void setPinagem(byte[] pinagem) {
        this.pinagem = pinagem;
    }

    public String getDescricaotecnica() {
        return descricaotecnica;
    }

    public void setDescricaotecnica(String descricaotecnica) {
        this.descricaotecnica = descricaotecnica;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public Short getPorta() {
        return porta;
    }

    public void setPorta(Short porta) {
        this.porta = porta;
    }

    public String getComputador() {
        return computador;
    }

    public void setComputador(String computador) {
        this.computador = computador;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getDllname() {
        return dllname;
    }

    public void setDllname(String dllname) {
        this.dllname = dllname;
    }

    public String getImgdir() {
        return imgdir;
    }

    public void setImgdir(String imgdir) {
        this.imgdir = imgdir;
    }

    public String getImpressora() {
        return impressora;
    }

    public void setImpressora(String impressora) {
        this.impressora = impressora;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public String getComputadorbackup() {
        return computadorbackup;
    }

    public void setComputadorbackup(String computadorbackup) {
        this.computadorbackup = computadorbackup;
    }

    public Short getSerialbackup() {
        return serialbackup;
    }

    public void setSerialbackup(Short serialbackup) {
        this.serialbackup = serialbackup;
    }

    public String getBackupautomatico() {
        return backupautomatico;
    }

    public void setBackupautomatico(String backupautomatico) {
        this.backupautomatico = backupautomatico;
    }

    public Character getTipocomunicacao() {
        return tipocomunicacao;
    }

    public void setTipocomunicacao(Character tipocomunicacao) {
        this.tipocomunicacao = tipocomunicacao;
    }

    public String getThread() {
        return thread;
    }

    public void setThread(String thread) {
        this.thread = thread;
    }

    public Character getNovo() {
        return novo;
    }

    public void setNovo(Character novo) {
        this.novo = novo;
    }

    public Integer getTimer() {
        return timer;
    }

    public void setTimer(Integer timer) {
        this.timer = timer;
    }

    public Integer getLista() {
        return lista;
    }

    public void setLista(Integer lista) {
        this.lista = lista;
    }

    public String getNumeroserie() {
        return numeroserie;
    }

    public void setNumeroserie(String numeroserie) {
        this.numeroserie = numeroserie;
    }

    public Date getDataativo() {
        return dataativo;
    }

    public void setDataativo(Date dataativo) {
        this.dataativo = dataativo;
    }

    public Date getDatadesativo() {
        return datadesativo;
    }

    public void setDatadesativo(Date datadesativo) {
        this.datadesativo = datadesativo;
    }

    public BigDecimal getTeste() {
        return teste;
    }

    public void setTeste(BigDecimal teste) {
        this.teste = teste;
    }

    public BigDecimal getTeste2() {
        return teste2;
    }

    public void setTeste2(BigDecimal teste2) {
        this.teste2 = teste2;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }

    public String getTipoEquipamento() {
        return tipoEquipamento;
    }

    public void setTipoEquipamento(String tipoEquipamento) {
        this.tipoEquipamento = tipoEquipamento;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getImgdirgrava() {
        return imgdirgrava;
    }

    public void setImgdirgrava(String imgdirgrava) {
        this.imgdirgrava = imgdirgrava;
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
        hash += (equipamento != null ? equipamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipamentos)) {
            return false;
        }
        Equipamentos other = (Equipamentos) object;
        if ((this.equipamento == null && other.equipamento != null) || (this.equipamento != null && !this.equipamento.equals(other.equipamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.entidades.Equipamentos[ equipamento=" + equipamento + " ]";
    }
    
}
