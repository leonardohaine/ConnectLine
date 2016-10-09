package br.com.jlab.controller;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import br.com.jlab.model.Exame;
import br.com.jlab.model.Paciente;
import br.com.jlab.model.Posto;
import br.com.jlab.model.Requisicao;
import br.com.jlab.model.Setor;
import br.com.jlab.service.PacienteService;
import br.com.jlab.util.BuscaCep;
import br.com.jlab.util.Endereco;
import br.com.jlab.util.Util;

@ManagedBean(name = "paciente")
@ViewScoped
public class PacienteController implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2457514004956272802L;
	
	private Paciente paciente = new Paciente();
	private Requisicao requisicao = new Requisicao();
	private List<Paciente> pacientes = new ArrayList<Paciente>();
	private Setor selectedPaciente;
	private String pesquisa;
	private Long idade;
	private char tipoPesquisa = 'P';
	
	private List<Exame> exames = new ArrayList<Exame>();
	
	@ManagedProperty(value = "#{unidade.hospital.cnpj}")
	private String cnpj;
	
	@ManagedProperty(value = "#{PacienteService}")
	private PacienteService pacienteService;
	
	public PacienteController(){
		
	}
	
	public void calcularIdade(){
		System.out.println("Calculando idade");
		
		if(paciente.getNascimento() != null){
			int anoAtual = Calendar.getInstance().getTime().getYear();
			int anoPaciente = paciente.getNascimento().getYear();
			idade = (long) (anoAtual - anoPaciente);
			paciente.setIdade(idade.intValue());
			System.out.println("Idade: " + idade);
		}
		
	}
	
	public void pesquisaPaciente(){
		
		paciente = getPacienteService().getPaciente(pesquisa, tipoPesquisa);
		if(paciente == null){
			System.out.println("Paciente não encontrado");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Paciente não encontrado", "Paciente não encontrado"));
			return;
		}
		
		System.out.println("Paciente encontrado: " + paciente);
	}
	
	public void postoSelecionado(SelectEvent event) {
		System.out.println("Event selecionado; " + event);
		Posto posto = (Posto) event.getObject();
		paciente.setPosto(posto.getPosto().toString());
		System.out.println("Posto selecionado; " + posto);
	}
	
	public void endereco(){
		
		if(paciente.getCep() != null && paciente.getCep().length() == 8){
			Endereco end = BuscaCep.getEndereco(paciente.getCep());
			
			paciente.setEndereco(end.getLogradouro());
			paciente.setBairro(end.getBairro());
			paciente.setCidade(end.getLocalidade());
			paciente.setUf(end.getUf());
			
			System.out.println("Cep encontrado: " + end.getCep());
		}	
	}
	
	public String save(){
		try{
			
			System.out.println("CNPJ HOSP: " + cnpj);
			List<Requisicao> req = new ArrayList<Requisicao>();
			
			HttpSession session = Util.getSession();
			FacesContext.getCurrentInstance().getExternalContext().setResponseContentType("multipart/form-data");
			
			requisicao.setPosto(paciente.getPosto());
			requisicao.setProntuario(paciente);
			requisicao.setCnpjUnidade(Integer.valueOf((String)session.getAttribute("cnpjUnidade").toString()));
			session.getAttribute("");
			
			req.add(requisicao);
			paciente.setRequisicoes(req);
			getPacienteService().savePaciente(paciente);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Sucesso!", "Paciente cadastrado"));
		}catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Erro!", "Erro ao tentar cadastrar paciente: " +e));
		}
		return "paciente";
	}
	
	public void addExame(){
		Exame col = new Exame();
		Exame tri = new Exame();
		
		
		col.setExame(1L);
		col.setDescricao("Colesterol");
		
		tri.setExame(2L);
		tri.setDescricao("Trigricerides");
		
		exames.add(col);
		exames.add(tri);
		
		System.out.println("Adicionando exames a lista.");
	}

	public void onDateSelect(SelectEvent event) {
		System.out.println("Calculando idade - onDateSelect");
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", event.getObject().toString()));
    }

	public Long getIdade() {
		return idade;
	}


	public void setIdade(Long idade) {
		
		this.idade = idade;
	}
	
	public void setTipoPesquisa(char tipoPesquisa){
		this.tipoPesquisa = tipoPesquisa;
	}
	
	public char getTipoPesquisa() {
		return tipoPesquisa;
	}

	public List<Exame> getExames() {
		return exames;
	}

	public void setExames(List<Exame> exames) {
		this.exames = exames;
	}

	public PacienteService getPacienteService() {
		return pacienteService;
	}

	public void setPacienteService(PacienteService pacienteService) {
		this.pacienteService = pacienteService;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public Setor getSelectedPaciente() {
		return selectedPaciente;
	}

	public void setSelectedPaciente(Setor selectedPaciente) {
		this.selectedPaciente = selectedPaciente;
	}

	public Requisicao getRequisicao() {
		return requisicao;
	}

	public void setRequisicao(Requisicao requisicao) {
		this.requisicao = requisicao;
	}

	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
}
