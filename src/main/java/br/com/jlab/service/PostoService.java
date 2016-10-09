package br.com.jlab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.jlab.dao.PostoDAO;
import br.com.jlab.model.Posto;

@Service("PostoService")
@Transactional(readOnly = true)
public class PostoService {

	@Autowired
	PostoDAO postoDAO;

	@Transactional(readOnly = false)
	public void savePosto(Posto posto) {
		getPostoDAO().savePosto(posto);
	}

	@Transactional(readOnly = false)
	public void deletePosto(Posto posto) {
		getPostoDAO().deletePosto(posto);
	}

	@Transactional(readOnly = false)
	public void updatePosto(Posto posto) {
		getPostoDAO().updatePosto(posto);
	}

	public Posto getPostoById(Long id) {
		return getPostoDAO().getPostoById(id);
	}
	
	public List<Posto> getPostoByDescricao(String desc){
		return getPostoDAO().getPostoByDescricao(desc);
	}

	/**
	 * @return the postoDAO
	 */
	public PostoDAO getPostoDAO() {
		return postoDAO;
	}

	/**
	 * @param postoDAO
	 *            the postoDAO to set
	 */
	public void setPostoDAO(PostoDAO PostoDAO) {
		this.postoDAO = PostoDAO;
	}

	public List<Posto> getPostos() {
		return getPostoDAO().getPostos();
	}

}
