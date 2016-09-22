package br.com.jlab.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.jlab.model.Setor;
import br.com.jlab.service.SetorService;

@ManagedBean(name = "setor")
@ViewScoped
public class SetorController implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2457514004956272802L;
	
	private Setor setor = new Setor();
	private List<Setor> setores = new ArrayList<Setor>();
	private Setor selectedSetor;
	
	@ManagedProperty(value = "#{SetorService}")
	private SetorService setorService;
	
	public SetorController(){
		
	}
	
	
	
	public void salvarSetor(){
		try{
			getSetorService().saveSetor(setor);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Setor cadastrado com sucesso!", "Sucesso"));
		}catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Erro ao cadastrar usu�rio! ", "Erro" +e));
		}
	}
	
	@PostConstruct
	public String Edit(){
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("selectedSetor", selectedSetor);
		
		setSetor((Setor)FacesContext.getCurrentInstance().getExternalContext().getFlash().get("selectedSetor"));
		System.out.println("selectedSetor: " + selectedSetor);
		System.out.println("setor: " + setor);
		
		return "setor";
	}
	
	public SetorService getSetorService() {
		return setorService;
	}

	public void setSetorService(SetorService setorService) {
		this.setorService = setorService;
	}



	public Setor getSetor() {
		return setor;
	}



	public void setSetor(Setor setor) {
		this.setor = setor;
	}



	public void setSetores(List<Setor> setores) {
		this.setores = setores;
	}



	public List<Setor> getSetores() {
		setores = getSetorService().getSetor();
		return setores;
	}



	public Setor getSelectedSetor() {
		return selectedSetor;
	}



	public void setSelectedSetor(Setor selectedSetor) {
		this.selectedSetor = selectedSetor;
	}
	
}
