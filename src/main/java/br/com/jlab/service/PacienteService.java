package br.com.jlab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.jlab.dao.PacienteDAO;
import br.com.jlab.model.Paciente;

@Service("PacienteService")
@Transactional(readOnly = true)
public class PacienteService {

	@Autowired
	PacienteDAO pacienteDAO;

	@Transactional(readOnly = false)
	public void savePaciente(Paciente paciente) {
		getPacienteDAO().savePaciente(paciente);
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
