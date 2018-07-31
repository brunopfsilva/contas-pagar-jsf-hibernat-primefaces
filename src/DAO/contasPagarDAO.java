package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import VO.ContasPagar;

public class contasPagarDAO extends DAO{
	
	
	
	public void salvarConta(ContasPagar contasPagar) {
		
		EntityManager em = getEntityManager().createEntityManager();
		
						
		try {
			em.getTransaction().begin(); //inicia a transacao
			em.persist(contasPagar); //salva
			em.getTransaction().commit(); //comita
			em.close();
		} catch (Exception e) {
			em.getTransaction().rollback(); //volta se der erro
		}finally {
			em.close();
		}
		
	}
	
	public List<ContasPagar>getAll(){
		List <ContasPagar>lista = null;
		EntityManager em = getEntityManager().createEntityManager();

		try {
			
			
			Query q = em.createQuery("select object(c) from ContasPagar as c"); //nome da classe em maiusculo
			lista = q.getResultList();
		
			
		} catch (Exception e) {
			
				
		
		}finally {
				em.close();
		}
		
		return lista;
	}
}
