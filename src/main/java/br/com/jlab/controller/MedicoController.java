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

import br.com.jlab.model.Medico;
import br.com.jlab.service.MedicoService;
import br.com.jlab.util.BuscaCep;
import br.com.jlab.util.Endereco;

@ManagedBean(name = "medico")
@ViewScoped
public class MedicoController implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2457514004956272802L;
	
	private Medico medico = new Medico();
	private List<Medico> medicos = new ArrayList<Medico>();
	private Medico selectedMedico;
	
	@ManagedProperty(value = "#{MedicoService}")
	private MedicoService medicoService;
	
	public MedicoController(){
		
	}
	
	
	
	public String save(){
		try{
			getMedicoService().saveMedico(medico);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Sucesso!", "Medico cadastrado"));
		}catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Erro!", "Erro ao tentar cadastrar medico: " +e));
			return "medico";
		}
		return "listaMedico";
	}
	
	public String delete(){
		System.out.println("DELETE SETOR: " + selectedMedico);
		try{
			getMedicoService().deleteMedico(selectedMedico);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Sucesso!", "Medico deletado: " + selectedMedico.getNome().toUpperCase() ));
		}catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Erro!", "Erro ao tentar deletar medico: " +e));
			return "medico";
		}
		
		return "listaMedico";
	}
	
	public void endereco(){
		
		if(medico.getCep() != null && medico.getCep().length() == 8){
			Endereco end = BuscaCep.getEndereco(medico.getCep());
			if(end == null){
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
						"Aviso!", "CEP não encontrado: " + medico.getCep()));
				
				return;
			}
			medico.setEndereco(end.getLogradouro());
			medico.setBairro(end.getBairro());
			medico.setCidade(end.getLocalidade());
			medico.setUf(end.getUf());
			
			System.out.println("Cep encontrado: " + end.getCep());
		}
	}
	
	@PostConstruct
	public void editar(){
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("medicoId");
		if(id != null){
			System.out.println("ID editar: " + id);
			medico = getMedicoService().getMedicoById(Long.valueOf(id));
		}
	}
	
	public MedicoService getMedicoService() {
		return medicoService;
	}

	public void setMedicoService(MedicoService medicoService) {
		this.medicoService = medicoService;
	}



	public Medico getMedico() {
		return medico;
	}



	public void setMedico(Medico medico) {
		this.medico = medico;
	}



	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}



	public List<Medico> getMedicos() {
		medicos = getMedicoService().getMedico();
		return medicos;
	}



	public Medico getSelectedMedico() {
		return selectedMedico;
	}



	public void setSelectedMedico(Medico selectedMedico) {
		this.selectedMedico = selectedMedico;
	}
	
}
