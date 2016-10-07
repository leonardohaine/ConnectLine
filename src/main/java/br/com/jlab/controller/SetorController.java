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
	
	
	
	public String save(){
		try{
			getSetorService().saveSetor(setor);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Sucesso!", "Setor cadastrado"));
		}catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Erro!", "Erro ao tentar cadastrar setor: " +e));
		}
		return "listaSetor";
	}
	
	public String delete(){
		System.out.println("DELETE SETOR: " + selectedSetor);
		try{
			getSetorService().deleteSetor(selectedSetor);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Sucesso!", "Setor deletado: " + selectedSetor.getDescricao().toUpperCase() ));
		}catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Erro!", "Erro ao tentar deletar setor: " +e));
		}
		
		return "listaSetor";
	}
	
	@PostConstruct
	public void editar(){
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("setorId");
		if(id != null){
			System.out.println("ID editar: " + id);
			setor = getSetorService().getSetorById(Long.valueOf(id));
		}
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
