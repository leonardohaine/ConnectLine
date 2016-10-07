/*
	 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jlab.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.jlab.model.Recipiente;
import br.com.jlab.model.Setor;


/**
 *
 * @author Leonardo
 */

@Repository
@Transactional
public class RecipienteDAO extends GenericDAO<Setor>{

	@Autowired
	private SessionFactory sessionFactory;

	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	private void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void saveRecipiente(Recipiente recipiente) {
		System.out.println("Save: " + recipiente.toString());
		getSessionFactory().getCurrentSession().merge(recipiente);
	}

	public void deleteRecipiente(Recipiente recipiente) {
		getSessionFactory().getCurrentSession().delete(recipiente);
	}

	public void updateRecipiente(Recipiente recipiente) {
		getSessionFactory().getCurrentSession().update(recipiente);
	}

	public Recipiente getRecipienteById(Long id) {
		Recipiente recipiente = (Recipiente) getSessionFactory().getCurrentSession().get(Recipiente.class, id);

		return recipiente;

	}

	public List<Recipiente> getRecipientes() {
		List list = getSessionFactory().getCurrentSession().createQuery("from Recipiente").list();
		return list;
	}

}
