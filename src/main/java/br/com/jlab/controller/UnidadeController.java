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
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.event.SelectEvent;

import br.com.jlab.model.Hospital;
import br.com.jlab.service.HospitalService;
import br.com.jlab.util.Util;

/**
 *
 * @author Leonardo
 */
@ManagedBean(name = "unidade")
@SessionScoped
public class UnidadeController {

	private Hospital hospital = new Hospital();
	private List<Hospital> listHospital;
	private Hospital selectedHospital = new Hospital();

	@ManagedProperty(value = "#{HospitalService}")
	private HospitalService hospitalService;

	public UnidadeController() {

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
					"Sucesso!", "Usuário cadastrado"));
			return "hospital";
		} catch (Exception e) {
			e.printStackTrace();
			hospital = new Hospital();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Erro!", "Erro ao tentar cadastrar usuário: " +e));
			return "hospital";
		}
	}
	
	@PostConstruct
	public String Edit(){
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("selectedHospital", selectedHospital);
		
		setHospital((Hospital)FacesContext.getCurrentInstance().getExternalContext().getFlash().get("selectedHospital"));
		System.out.println("selectedHospital: " + selectedHospital);
		System.out.println("hospital: " + hospital);
		
		return "hospital";
	}
	
	public String delete() {

		try {
			getHospitalService().getHospitalDAO().deleteHospital(hospital);
			hospital = new Hospital();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Sucesso!", "Usuário deletado: " + selectedHospital.getHospital()));
			return "hospitals";
		} catch (Exception e) {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Erro!", "Erro ao deletar usuário: " +e));
			return "hospital";
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
        
        HttpSession session = Util.getSession();
		FacesContext.getCurrentInstance().getExternalContext().setResponseContentType("multipart/form-data");
		session.setAttribute("cnpjUnidade", hosp.getCnpj());
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
