package br.com.jlab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.jlab.dao.SetorDAO;
import br.com.jlab.dao.UsuarioDAO;
import br.com.jlab.model.Setor;
import br.com.jlab.model.Usuario;

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
	public void updateUsuario(Setor setor) {
		getSetorDAO().updateSetor(setor);
	}

	public Setor geSetorById(Integer id) {
		return getSetorDAO().getSetorById(id);
	}

	/**
	 * @return the usuarioDAO
	 */
	public SetorDAO getSetorDAO() {
		return setorDAO;
	}

	/**
	 * @param safx04DAO
	 *            the usuarioDAO to set
	 */
	public void setUsuarioDAO(SetorDAO setorDAO) {
		this.setorDAO = setorDAO;
	}

	public List<Setor> getSetor() {
		return getSetorDAO().getSetor();
	}

}
