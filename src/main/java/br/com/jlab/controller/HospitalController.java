/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jlab.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import br.com.jlab.model.Hospital;
import br.com.jlab.service.HospitalService;

/**
 *
 * @author Leonardo
 */
@ManagedBean(name = "hospital")
@ViewScoped
public class HospitalController {

	private Hospital hospital = new Hospital();
	private List<Hospital> listHospital;
	private Hospital selectedHospital = new Hospital();

	@ManagedProperty(value = "#{HospitalService}")
	private HospitalService hospitalService;

	public HospitalController() {

	}

	/**
	 * @return the hospital
	 */
	public Hospital getHospital() {
		return hospital;
	}

	/**
	 * @param hospital
	 *            the hospital to set
	 */
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	/**
	 * @return the listHospital
	 */
	public List<Hospital> getListHospital() {
		listHospital = new ArrayList<Hospital>();
		listHospital = getHospitalService().getHospital();
		return listHospital;
	}

	/**
	 * @param listHospital
	 *            the listHospital to set
	 */
	public void setListHospital(List<Hospital> listHospital) {
		this.listHospital = listHospital;
	}

	public String save() {
		try {
			getHospitalService().getHospitalDAO().saveHospital(hospital);

			hospital = new Hospital();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Sucesso!", "Hospital cadastrado"));
			return "listaHospital";
		} catch (Exception e) {
			e.printStackTrace();
			hospital = new Hospital();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Erro!", "Erro ao tentar cadastrar hospital: " +e));
			return "hospital";
		}
	}
	
	@PostConstruct
	public void editar(){
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("hospitalId");
		if(id != null){
			System.out.println("ID editar: " + id);
			hospital = getHospitalService().getHospitalById(Long.valueOf(id));
		}
	}
	
	public String delete() {

		try {
			getHospitalService().getHospitalDAO().deleteHospital(hospital);
			hospital = new Hospital();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Sucesso!", "Hospital deletado: " + selectedHospital.getHospital()));
			return "listahHospital";
		} catch (Exception e) {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Erro!", "Erro ao deletar hospital: " +e));
			return "listaHospital";
		}
	}
	
	public void onHospUnidade(SelectEvent event) {
		Hospital hosp = (Hospital) event.getObject();
        
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Car Selected", "Id:" + hosp.getCnpj());
        FacesContext.getCurrentInstance().addMessage(null, message);
        
        setHospital(getHospitalService().getHospitalDAO().getHospitalById(hosp.getHospital()));
        setSelectedHospital(getHospitalService().getHospitalDAO().getHospitalById(hosp.getHospital()));
    }
	
	public void selectHospFromDialog(Hospital hosp) {
		System.out.println("selectHospFromDialog: " + hosp);
		setHospital(getHospitalService().getHospitalDAO().getHospitalById(hosp.getHospital()));
        setSelectedHospital(getHospitalService().getHospitalDAO().getHospitalById(hosp.getHospital()));
    }
	
	public void selectHospital(SelectEvent event) {
		// listCorretores = new ClienteDAO().listaClientes();
		System.out.println(event.toString());
		if (event.getObject() != null) {
			Hospital hospital = (Hospital) event.getObject();
			setHospital(getHospitalService().getHospitalDAO().getHospitalById(hospital.getHospital()));

		}
	}

	/**
	 * @return the selectedHospital
	 */
	public Hospital getSelectedHospital() {
		return selectedHospital;
	}

	/**
	 * @param selectedHospital
	 *            the selectedHospital to set
	 */
	public void setSelectedHospital(Hospital selectedHospital) {
		this.selectedHospital = selectedHospital;
	}

	/**
	 * @return the hospitalService
	 */
	public HospitalService getHospitalService() {
		return hospitalService;
	}

	/**
	 * @param hospitalService
	 *            the hospitalService to set
	 */
	public void setHospitalService(HospitalService hospitalService) {
		this.hospitalService = hospitalService;
	}
}
