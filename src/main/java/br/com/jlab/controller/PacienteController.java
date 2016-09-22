package br.com.jlab.controller;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import br.com.jlab.model.Exame;

@ManagedBean(name = "paciente")
@ViewScoped
public class PacienteController implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2457514004956272802L;
	private Long idade;
	private char prontuario = 'P';
	private List<Exame> exames = new ArrayList<Exame>();
	
	public PacienteController(){
		
	}
	
	public void calcularIdade(){
		System.out.println("Calculando idade");
		idade = 30L;
		return;
	}
	
	public void salvarPaciente(){
		
		
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
	
	public void setProntuario(char prontuario){
		this.prontuario = prontuario;
	}
	
	public char getProntuario() {
		return prontuario;
	}

	public List<Exame> getExames() {
		return exames;
	}

	public void setExames(List<Exame> exames) {
		this.exames = exames;
	}
	
}
