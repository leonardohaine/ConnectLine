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
import javax.faces.event.ActionEvent;

import br.com.jlab.model.Posto;
import br.com.jlab.service.PostoService;

@ManagedBean(name = "posto")
@ViewScoped
public class PostoController implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2457514004956272802L;
	
	private Posto posto = new Posto();
	private List<Posto> postos = new ArrayList<Posto>();
	private Posto selectedPosto;
	
	@ManagedProperty(value = "#{PostoService}")
	private PostoService postoService;
	
	public PostoController(){

	}
	
	public String save(){
		try{
			System.out.println("Save Posto: " + posto);
			getPostoService().savePosto(posto);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Sucesso!", "Posto cadastrado"));
		}catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Erro!", "Erro ao tentar cadastrar posto: " +e));
		}
		
		return "listaPosto";
	}
	
	public String delete(){
		try{
			getPostoService().deletePosto(selectedPosto);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Sucesso!", "Posto deletado: " + selectedPosto.getDescricao()));
		}catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Erro!", "Erro ao deletar posto: " +e));
		}
		
		return "listaPosto";
	}
	
	@PostConstruct
	public void editar(){
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("postoId");
		if(id != null){
			System.out.println("ID editar: " + id);
			posto = getPostoService().getPostoById(Long.valueOf(id));
		}
	}
	
	public PostoService getPostoService() {
		return postoService;
	}

	public void setPostoService(PostoService postoService) {
		this.postoService = postoService;
	}



	public Posto getPosto() {
		return posto;
	}



	public void setPosto(Posto posto) {
		this.posto = posto;
	}



	public void setPostos(List<Posto> postos) {
		this.postos = postos;
	}



	public List<Posto> getPostos() {
		postos = getPostoService().getPosto();
		return postos;
	}



	public Posto getSelectedPosto() {
		return selectedPosto;
	}



	public void setSelectedPosto(Posto selectedPosto) {
		this.selectedPosto = selectedPosto;
	}

}
