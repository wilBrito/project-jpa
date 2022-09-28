package com.cursoJavaEx.project_jpa.dao.impl;

import java.util.List;

import com.cursoJavaEx.project_jpa.beans.SubGenero;
import com.cursoJavaEx.project_jpa.dao.SubGeneroDao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class SubGeneroDaoImpl implements SubGeneroDao {
	
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("persistenceProject");

	@Override
	public void save(SubGenero subGenero) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		try {
			et.begin();		
			em.persist(subGenero);
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
	public void update(SubGenero subGenero) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		try {		
			em.merge(subGenero);
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
	public void delete(Long idSubGenero) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		SubGenero subGeneroConsutado =   em.find(SubGenero.class, idSubGenero);
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		try {		
			em.remove(subGeneroConsutado);
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
	public List<SubGenero> consultar() {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		TypedQuery<SubGenero> queryTyped = (TypedQuery<SubGenero>) em.createQuery("FROM SubGenero ORDER BY descripcion");
		
		return queryTyped.getResultList();
	}

	@Override
	public SubGenero findById(Long idSubGenero) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		SubGenero subGeneroConsultado = em.find(SubGenero.class, idSubGenero);
		
		if(subGeneroConsultado == null) 
			throw new EntityNotFoundException("El subGenero con id "+ idSubGenero +" no se encontro");
		
		return subGeneroConsultado;
		
	}

}
