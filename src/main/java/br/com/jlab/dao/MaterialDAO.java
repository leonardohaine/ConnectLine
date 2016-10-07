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

import br.com.jlab.model.Material;


/**
 *
 * @author Leonardo
 */

@Repository
@Transactional
public class MaterialDAO extends GenericDAO<Material>{

	@Autowired
	private SessionFactory sessionFactory;

	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	private void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void saveMaterial(Material material) {
		System.out.println("Save: " + material.toString());
		getSessionFactory().getCurrentSession().merge(material);
	}

	public void deleteMaterial(Material material) {
		getSessionFactory().getCurrentSession().delete(material);
	}

	public void updateMaterial(Material material) {
		getSessionFactory().getCurrentSession().update(material);
	}

	public Material getMaterialById(Long id) {
		Material Material = (Material) getSessionFactory().getCurrentSession().get(Material.class, id);

		return Material;

	}

	public List<Material> getMaterial() {
		List list = getSessionFactory().getCurrentSession().createQuery("from Material").list();
		return list;
	}

	public Material getMaterial(String user, String senha) {

		Material material = null;
		boolean retorno = false;
		try {
			material = (Material) getSessionFactory().getCurrentSession().createCriteria(Material.class)
					.add(Restrictions.eq("login", user.toUpperCase())).add(Restrictions.eq("senha", senha))
					.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in login() --> " + e.getMessage());
		} finally {
			return material;
		}
	}

}
