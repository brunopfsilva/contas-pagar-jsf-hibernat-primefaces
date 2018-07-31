package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import VO.Fornecedor;

public class fornecedorDAO extends DAO{
	
	
	EntityManager em = getEntityManager().createEntityManager();
	
	public void save (Fornecedor fornecedor) {
		
		try {
			em.getTransaction().begin();
			em.persist(fornecedor);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		
		
	}

	public Fornecedor getOne(int id) {
		
		return em.find(Fornecedor.class, id);
	}
	
	public void update (Fornecedor fornecedor) {
		
		try {
			em.getTransaction().begin();
			Fornecedor f = em.find(Fornecedor.class, fornecedor.getId());
			f.setNome(fornecedor.getNome());
			f.setEndereco(fornecedor.getEndereco());
			f.setTelefone(fornecedor.getTelefone());
			f.setObs(fornecedor.getObs());
			//em.persist(f);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
			
	}
	
	public void delete (Fornecedor fornecedor) {
		
		try {
			em.getTransaction().begin();
			Fornecedor f = em.find(Fornecedor.class, fornecedor.getId());
			em.remove(f);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		
		
	}
	
	public List<Fornecedor>getAll(){
		
		List<Fornecedor>lista = null;
		
		try {
		Query q = em.createQuery("select object(f) from Fornecedor as f"); //nome da classe em maiusculo
		lista = q.getResultList();
		}catch (Exception e) {
			em.close();
		}
		return lista;
	}	
	
}
