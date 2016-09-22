package br.com.jlab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.jlab.dao.RecipienteDAO;
import br.com.jlab.model.Recipiente;

@Service("RecipienteService")
@Transactional(readOnly = true)
public class RecipienteService {

	@Autowired
	RecipienteDAO recipienteDAO;

	@Transactional(readOnly = false)
	public void saveRecipiente(Recipiente recipiente) {
		getRecipienteDAO().saveRecipiente(recipiente);
	}

	@Transactional(readOnly = false)
	public void deleteRecipiente(Recipiente recipiente) {
		getRecipienteDAO().deleteRecipiente(recipiente);
	}

	@Transactional(readOnly = false)
	public void updateRecipiente(Recipiente recipiente) {
		getRecipienteDAO().updateRecipiente(recipiente);
	}

	public Recipiente geRecipienteById(Integer id) {
		return getRecipienteDAO().getRecipienteById(id);
	}
	
	public List<Recipiente> getRecipientes(){
		return getRecipienteDAO().getRecipientes();
	}

	/**
	 * @return the recipienteDAO
	 */
	public RecipienteDAO getRecipienteDAO() {
		return recipienteDAO;
	}

	/**
	 * @param recipienteDAO
	 *            the recipienteDAO to set
	 */
	public void setRecipienteDAO(RecipienteDAO recipienteDAO) {
		this.recipienteDAO = recipienteDAO;
	}

}
