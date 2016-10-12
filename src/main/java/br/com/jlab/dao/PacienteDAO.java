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

import br.com.jlab.model.Paciente;


/**
 *
 * @author Leonardo
 */

@Repository
@Transactional
public class PacienteDAO extends GenericDAO<Paciente>{

	@Autowired
	private SessionFactory sessionFactory;

	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	private void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void savePaciente(Paciente paciente) {
		
		System.out.println("Save: " + paciente.toString());
		getSessionFactory().getCurrentSession().merge(paciente);
	}

	public void deletePaciente(Paciente paciente) {
		getSessionFactory().getCurrentSession().delete(paciente);
	}

	public void updatePaciente(Paciente paciente) {
		getSessionFactory().getCurrentSession().update(paciente);
	}

	public Paciente getPacienteByProntuario(String id) {
		Paciente paciente = (Paciente) getSessionFactory().getCurrentSession().get(Paciente.class, id);

		return paciente;

	}
	
	public Paciente getPacienteBySUS(String sus) {
		Paciente paciente = (Paciente) getSessionFactory().getCurrentSession().createCriteria(Paciente.class)
				.add(Restrictions.eq("pacStSus", sus)).uniqueResult();

		return paciente;

	}
	
	public Paciente getPacienteByNome(String nome) {
		System.out.println("Nome: " + nome);
		Paciente paciente = (Paciente) getSessionFactory().getCurrentSession().createCriteria(Paciente.class)
				.setFetchMode("prontuario", FetchMode.SELECT)
				.add(Restrictions.like("nome", nome, MatchMode.START)).uniqueResult();

		return paciente;

	}
	
	public Paciente getPacienteById(String id) {
		Paciente paciente = (Paciente) getSessionFactory().getCurrentSession().get(Paciente.class, id);

		return paciente;

	}

	public List<Paciente> getPacientes() {
		List list = getSessionFactory().getCurrentSession().createQuery("from Paciente").list();
		
		return list;
	}

}
