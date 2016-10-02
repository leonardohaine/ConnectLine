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

import br.com.jlab.model.Hospital;


/**
 *
 * @author Leonardo
 */

@Repository
@Transactional
public class HospitalDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	private void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void saveHospital(Hospital hospital) {
		
		getSessionFactory().getCurrentSession().saveOrUpdate(hospital);
	}

	public void deleteHospital(Hospital hospital) {
		getSessionFactory().getCurrentSession().delete(hospital);
	}

	public void updateHospital(Hospital hospital) {
		getSessionFactory().getCurrentSession().update(hospital);
	}

	public Hospital getHospitalById(Long id) {
		Hospital hospital = (Hospital) getSessionFactory().getCurrentSession().get(Hospital.class, id);

		return hospital;

	}

	public List<Hospital> getHospital() {
		List list = getSessionFactory().getCurrentSession().createQuery("from Hospital").list();
		return list;
	}

	public Hospital getHospital(String user, String senha) {

		Hospital hospital = null;
		boolean retorno = false;
		try {
			hospital = (Hospital) getSessionFactory().getCurrentSession().createCriteria(Hospital.class)
					.add(Restrictions.eq("login", user.toUpperCase())).add(Restrictions.eq("senha", senha))
					.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in login() --> " + e.getMessage());
		} finally {
			return hospital;
		}
	}

}
