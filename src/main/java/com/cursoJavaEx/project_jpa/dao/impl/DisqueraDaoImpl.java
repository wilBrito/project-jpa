/**
 * 
 */
package com.cursoJavaEx.project_jpa.dao.impl;

import java.util.List;

import com.cursoJavaEx.project_jpa.beans.Disquera;
import com.cursoJavaEx.project_jpa.dao.DisqueraDao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

/**
 * @author wilson
 *
 */
public class DisqueraDaoImpl implements DisqueraDao {

	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("persistenceProject");

	@Override
	public void save(Disquera disquera) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		try {
			em.persist(disquera);
			et.commit();
		} catch (Exception e) {
			if(et != null)
				et.rollback();
			
			e.printStackTrace();
		}finally {
			em.close();
		}

	}

	@Override
	public void update(Disquera disquera) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		try {
			em.merge(disquera);
			et.commit();
		} catch (Exception e) {
			if(et != null)
				et.rollback();
			
			e.printStackTrace();
		}finally {
			em.close();
		}

	}

	@Override
	public void delete(Long idDisquera) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		Disquera disqueraConsultado = em.find(Disquera.class, idDisquera);
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		try {
			em.remove(disqueraConsultado);
			et.commit();
		} catch (Exception e) {
			if(et != null)
				et.rollback();
			
			e.printStackTrace();
		}finally {
			em.close();
		}

	}

	@Override
	public Disquera findById(Long idDisquera) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		Disquera disqueraConsultado = em.find(Disquera.class, idDisquera);
		
		if(disqueraConsultado == null)
			throw new EntityNotFoundException("La disquera con id "+ idDisquera +" no se encontro");
		
		return disqueraConsultado;
	}

	@Override
	public List<Disquera> consultar() {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		TypedQuery<Disquera> queryDisquera = (TypedQuery<Disquera>) em.createQuery("FROM Disquera ORDER BY descripcion");
		
		return queryDisquera.getResultList();
		
	}

}
