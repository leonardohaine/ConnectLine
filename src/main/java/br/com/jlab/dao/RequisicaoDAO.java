/*
	 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jlab.dao;

import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.jlab.model.Requisicao;


/**
 *
 * @author Leonardo
 */

@Repository
@Transactional
public class RequisicaoDAO extends GenericDAO<Requisicao>{

	@Autowired
	private SessionFactory sessionFactory;

	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	private void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void saveRequisicao(Requisicao requisicao) {
		
		System.out.println("Save: " + requisicao.toString());
		getSessionFactory().getCurrentSession().merge(requisicao);
	}

	public void deleteRequisicao(Requisicao requisicao) {
		getSessionFactory().getCurrentSession().delete(requisicao);
	}

	public void updateRequisicao(Requisicao requisicao) {
		getSessionFactory().getCurrentSession().update(requisicao);
	}

	public List<Requisicao> getRequisicaoByProntuario(String prontuario) {
		List requisicao = getSessionFactory().getCurrentSession().createCriteria(Requisicao.class)
				.add(Restrictions.eq("prontuario", prontuario)).list();
		return requisicao;

	}
	
	public Requisicao getRequisicaoBySUS(String sus) {
		Requisicao requisicao = (Requisicao) getSessionFactory().getCurrentSession().createCriteria(Requisicao.class)
				.add(Restrictions.eq("pacStSus", sus)).uniqueResult();

		return requisicao;

	}
	
	public Requisicao getRequisicaoByNome(String nome) {
		System.out.println("Nome: " + nome);
		Requisicao requisicao = (Requisicao) getSessionFactory().getCurrentSession().createCriteria(Requisicao.class)
				.setFetchMode("prontuario", FetchMode.SELECT)
				.add(Restrictions.like("nome", nome, MatchMode.START)).uniqueResult();

		return requisicao;

	}
	
	public List<Requisicao> getRequisicaoById(String req) {
		List requisicao = getSessionFactory().getCurrentSession().createCriteria(Requisicao.class)
				.setFetchMode("requisicao", FetchMode.JOIN)
				.add(Restrictions.eq("requisicao", req)).list();
			System.out.println("requisicao: " + requisicao);
		return requisicao;

	}

	public List<Requisicao> getRequisicoes() {
		List<Requisicao> list = getSessionFactory().getCurrentSession().createQuery("from Requisicao").list();
		System.out.println("DAO LISTA REQ: " + list);
		return list;
	}

	
}
