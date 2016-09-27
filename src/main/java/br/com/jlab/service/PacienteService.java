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

	public Paciente gePacienteById(Integer id) {
		return getPacienteDAO().getPacienteById(id);
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

	public List<Paciente> getPaciente() {
		return getPacienteDAO().getPaciente();
	}

}
