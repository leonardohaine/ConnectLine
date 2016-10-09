package br.com.jlab.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import br.com.jlab.model.Material;
import br.com.jlab.model.Posto;
import br.com.jlab.service.PostoService;
	

@ViewScoped
@ManagedBean(name = "selecaoPosto")
public class SelecaoPostoController implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{PostoService}")
	private PostoService postoService;
	
	private String nome;
	
	private List<Posto> postosFiltrados = new ArrayList<Posto>();
	private Posto selectedPosto;
	public SelecaoPostoController(){
		
	}
	
	public void pesquisar() {
		postosFiltrados = getPostoService().getPostoByDescricao(nome);
	}
	
	public void abrirDialogo() {
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 300);
		opcoes.put("appendToBody", true);
		System.out.println("abrindo dialogo postos");
		RequestContext.getCurrentInstance().openDialog("selecaoPosto", opcoes, null);
	}
	
	
	public void selecionar(Posto posto) {
		
		RequestContext.getCurrentInstance().closeDialog(posto);
		System.out.println("fechando dialogo postos: " + posto);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public PostoService getPostoService() {
		return postoService;
	}

	public void setPostoService(PostoService postoService) {
		this.postoService = postoService;
	}

	public Posto getSelectedPosto() {
		System.out.println("getSelectedPosto; " + selectedPosto);
		return selectedPosto;
	}

	public void setSelectedPosto(Posto selectedPosto) {
		System.out.println("setSelectedPosto; " + selectedPosto);
		this.selectedPosto = selectedPosto;
	}

	public List<Posto> getPostosFiltrados() {
		return postosFiltrados;
	}

	public void setPostosFiltrados(List<Posto> postosFiltrados) {
		this.postosFiltrados = postosFiltrados;
	}

}