package br.com.jlab.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.jlab.dao.PacienteDAO;
import br.com.jlab.model.Paciente;
import br.com.jlab.model.Requisicao;
import br.com.jlab.util.Util;

@Service("PacienteService")
@Transactional(readOnly = true)
public class PacienteService {

	@Autowired
	PacienteDAO pacienteDAO;

	@Transactional(readOnly = false)
	public Boolean savePaciente(Paciente paciente, Requisicao requisicao) {
		
		List<Requisicao> req = new ArrayList<Requisicao>();
		
		HttpSession session = Util.getSession();
		FacesContext.getCurrentInstance().getExternalContext().setResponseContentType("multipart/form-data");
		
		String cnpjUnidade = (String)session.getAttribute("cnpjUnidade");
		if(cnpjUnidade == null){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Aviso!", "Selecione uma unidade no topo da página."));
			return false;
		}
		
		paciente.setEntrada(new Date());
		requisicao.setEntrada(new Date());
		requisicao.setPosto(paciente.getPosto());
		requisicao.setProntuario(paciente);
		requisicao.setCnpjUnidade(Long.valueOf(cnpjUnidade));
		
		
		req.add(requisicao);
		paciente.setRequisicoes(req);
		
		getPacienteDAO().savePaciente(paciente);
		return true;
	}

	@Transactional(readOnly = false)
	public void deletePaciente(Paciente paciente) {
		getPacienteDAO().deletePaciente(paciente);
	}

	@Transactional(readOnly = false)
	public void updatePaciente(Paciente paciente) {
		getPacienteDAO().updatePaciente(paciente);
	}

	@Transactional(readOnly = false)
	public Paciente getPaciente(String id, char tipo) {
		Paciente paciente = new Paciente();
		System.out.println("Tipo consulta: " + tipo);
		if(tipo == 'P'){
			paciente = getPacienteDAO().getPacienteByProntuario(id);
		}	
		else if(tipo == 'S'){
			paciente = getPacienteDAO().getPacienteBySUS(id);
		}	
		else if(tipo == 'N'){
			paciente = getPacienteDAO().getPacienteByNome(id);
		}
		return paciente;
	}

	/**
	 * @return the pacienteDAO
	 */
	public PacienteDAO getPacienteDAO() {
		return pacienteDAO;
	}

	/**
	 * @param safx04DAO
	 *            the pacienteDAO to set
	 */
	public void setPacienteDAO(PacienteDAO pacienteDAO) {
		this.pacienteDAO = pacienteDAO;
	}

	public List<Paciente> getPacientes() {
		return getPacienteDAO().getPacientes();
	}

}
