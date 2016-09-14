package br.com.jlab.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.jlab.util.HibernateUtil;

public class GenericDAO<Entidade> {
	
	
public void salvar(Entidade entidade){
		
		Session sessao = HibernateUtil.getFabricaDeSessao().openSession();
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction();
			sessao.save(entidade);
			transacao.commit();
		}catch(RuntimeException ex){
			if(transacao != null){
				transacao.rollback();
			}
			throw ex;
			
		}finally {

			sessao.close();
		
		}	
	


}
}
