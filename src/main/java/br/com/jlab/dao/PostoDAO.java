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

import br.com.jlab.model.Posto;


/**
 *
 * @author Leonardo
 */

@Repository
@Transactional
public class PostoDAO extends GenericDAO<Posto>{

	@Autowired
	private SessionFactory sessionFactory;

	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	private void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void savePosto(Posto posto) {
		System.out.println("Save: " + posto.toString());
		getSessionFactory().getCurrentSession().merge(posto);
	}

	public void deletePosto(Posto posto) {
		getSessionFactory().getCurrentSession().delete(posto);
	}

	public void updatePosto(Posto posto) {
		getSessionFactory().getCurrentSession().update(posto);
	}

	public Posto getPostoById(Long id) {
		Posto Posto = (Posto) getSessionFactory().getCurrentSession().get(Posto.class, id);

		return Posto;

	}

	public List<Posto> getPosto() {
		List list = getSessionFactory().getCurrentSession().createQuery("from Posto").list();
		return list;
	}
	
	public List<Posto> getPostoByDescricao(String desc) {
		List list = getSessionFactory().getCurrentSession().createCriteria(Posto.class)
				.add(Restrictions.like("descricao", desc, MatchMode.ANYWHERE))
				.add(Restrictions.eq("ativo", true)).list();
		return list;
	}

}
