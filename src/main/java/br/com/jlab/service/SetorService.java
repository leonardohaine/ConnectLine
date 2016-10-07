package br.com.jlab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.jlab.dao.SetorDAO;
import br.com.jlab.model.Setor;

@Service("SetorService")
@Transactional(readOnly = true)
public class SetorService {

	@Autowired
	SetorDAO setorDAO;

	@Transactional(readOnly = false)
	public void saveSetor(Setor setor) {
		getSetorDAO().saveSetor(setor);
	}

	@Transactional(readOnly = false)
	public void deleteSetor(Setor setor) {
		getSetorDAO().deleteSetor(setor);
	}

	@Transactional(readOnly = false)
	public void updateSetor(Setor setor) {
		getSetorDAO().updateSetor(setor);
	}

	public Setor getSetorById(Long id) {
		return getSetorDAO().getSetorById(id);
	}

	/**
	 * @return the setorDAO
	 */
	public SetorDAO getSetorDAO() {
		return setorDAO;
	}

	/**
	 * @param setorDAO
	 *            the setorDAO to set
	 */
	public void setSetorDAO(SetorDAO setorDAO) {
		this.setorDAO = setorDAO;
	}

	public List<Setor> getSetor() {
		return getSetorDAO().getSetor();
	}

}
