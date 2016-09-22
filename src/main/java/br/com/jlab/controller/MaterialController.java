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

import br.com.jlab.model.Material;
import br.com.jlab.service.MaterialService;

@ManagedBean(name = "material")
@ViewScoped
public class MaterialController implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2457514004956272802L;
	
	private Material material = new Material();
	private List<Material> materiais = new ArrayList<Material>();
	private Material selectedMaterial;
	
	@ManagedProperty(value = "#{MaterialService}")
	private MaterialService materialService;
	
	public MaterialController(){
		
	}
	
	
	
	public void salvarMaterial(){
		try{
			getMaterialService().saveMaterial(material);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Material cadastrado com sucesso!", "Sucesso"));
		}catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Erro ao cadastrar Material! ", "Erro" +e));
		}
	}
	
	@PostConstruct
	public String Edit(){
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("selectedMaterial", selectedMaterial);
		
		setMaterial((Material)FacesContext.getCurrentInstance().getExternalContext().getFlash().get("selectedMaterial"));
		System.out.println("selectedMaterial: " + selectedMaterial);
		System.out.println("material: " + material);
		
		return "material";
	}
	
	public MaterialService getMaterialService() {
		return materialService;
	}

	public void setMaterialService(MaterialService materialService) {
		this.materialService = materialService;
	}



	public Material getMaterial() {
		return material;
	}



	public void setMaterial(Material material) {
		this.material = material;
	}



	public void setMateriais(List<Material> materiais) {
		this.materiais = materiais;
	}



	public List<Material> getMateriais() {
		materiais = getMaterialService().getMaterial();
		return materiais;
	}



	public Material getSelectedMaterial() {
		return selectedMaterial;
	}



	public void setSelectedMaterial(Material selectedMaterial) {
		this.selectedMaterial = selectedMaterial;
	}
	
}
