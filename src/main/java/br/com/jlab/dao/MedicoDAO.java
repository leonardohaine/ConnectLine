/*
	 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jlab.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.jlab.model.Medico;
import br.com.jlab.model.Medico;


/**
 *
 * @author Leonardo
 */

@Repository
@Transactional
public class MedicoDAO extends GenericDAO<Medico>{

	@Autowired
	private SessionFactory sessionFactory;

	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	private void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void saveMedico(Medico medicosol) {
		System.out.println("Save: " + medicosol.toString());
		getSessionFactory().getCurrentSession().merge(medicosol);
	}

	public void deleteMedico(Medico medicosol) {
		getSessionFactory().getCurrentSession().delete(medicosol);
	}

	public void updateMedico(Medico medicosol) {
		getSessionFactory().getCurrentSession().update(medicosol);
	}

	public Medico getMedicoById(Long id) {
		Medico medicosol = (Medico) getSessionFactory().getCurrentSession().get(Medico.class, id);

		return medicosol;

	}

	public List<Medico> getMedico() {
		List list = getSessionFactory().getCurrentSession().createQuery("from Medico").list();
		return list;
	}

}
