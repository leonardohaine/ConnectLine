package br.com.jlab.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.jlab.dao.RequisicaoDAO;
import br.com.jlab.model.Requisicao;
import br.com.jlab.model.Requisicao;
import br.com.jlab.util.Util;

@Service("RequisicaoService")
@Transactional(readOnly = true)
public class RequisicaoService {

	@Autowired
	RequisicaoDAO pacienteDAO;

	/*@Transactional(readOnly = false)
	public void saveRequisicao(Requisicao paciente, Requisicao requisicao) {
		
		List<Requisicao> req = new ArrayList<Requisicao>();
		
		HttpSession session = Util.getSession();
		FacesContext.getCurrentInstance().getExternalContext().setResponseContentType("multipart/form-data");
		
		paciente.setEntrada(new Date());
		requisicao.setPosto(paciente.getPosto());
		requisicao.setProntuario(paciente);
		requisicao.setCnpjUnidade(Long.valueOf((String)session.getAttribute("cnpjUnidade").toString()));
		
		
		req.add(requisicao);
		paciente.setRequisicos(req);
		
		getRequisicaoDAO().saveRequisicao(paciente);
	}*/

	@Transactional(readOnly = false)
	public void deleteRequisicao(Requisicao paciente) {
		getRequisicaoDAO().deleteRequisicao(paciente);
	}

	@Transactional(readOnly = false)
	public void updateRequisicao(Requisicao paciente) {
		getRequisicaoDAO().updateRequisicao(paciente);
	}

	/*@Transactional(readOnly = false)
	public Requisicao getRequisicao(String id, char tipo) {
		List<Requisicao> paciente = new ArrayList<Requisicao>();
		System.out.println("Tipo consulta: " + tipo);
		if(tipo == 'P'){
			paciente = getRequisicaoDAO().getRequisicaoById(id);
		}	
		else if(tipo == 'S'){
			paciente = getRequisicaoDAO().getRequisicaoBySUS(id);
		}	
		else if(tipo == 'N'){
			paciente = getRequisicaoDAO().getRequisicaoByNome(id);
		}
		return paciente;
	}*/

	/**
	 * @return the pacienteDAO
	 */
	public RequisicaoDAO getRequisicaoDAO() {
		return pacienteDAO;
	}

	/**
	 * @param safx04DAO
	 *            the pacienteDAO to set
	 */
	public void setRequisicaoDAO(RequisicaoDAO pacienteDAO) {
		this.pacienteDAO = pacienteDAO;
	}

	public List<Requisicao> getRequisicoes() {
		List list = getRequisicaoDAO().getRequisicoes();
		System.out.println("SERVICE LISTA REQ: " + list);
		return list;
	}

}
