/**
 * 
 */
package com.cursoJavaEx.project_jpa.dao.test;


import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.cursoJavaEx.project_jpa.beans.Disquera;
import com.cursoJavaEx.project_jpa.dao.DisqueraDao;
import com.cursoJavaEx.project_jpa.dao.impl.DisqueraDaoImpl;

/**
 * @author wilso
 *
 */
class DisqueraDaoImplTest {
	
	private DisqueraDao disqueraDao = new DisqueraDaoImpl();

	/**
	 * Test method for {@link com.cursoJavaEx.project_jpa.dao.impl.DisqueraDaoImpl#save(com.cursoJavaEx.project_jpa.beans.Disquera)}.
	 */
	@Test
	void testSave() {
		Disquera disquera = new Disquera("MegaForce",LocalDateTime.now(),true);
		this.disqueraDao.save(disquera);
	}

	/**
	 * Test method for {@link com.cursoJavaEx.project_jpa.dao.impl.DisqueraDaoImpl#update(com.cursoJavaEx.project_jpa.beans.Disquera)}.
	 */
	@Test
	void testUpdate() {
		Disquera disqueraConsultada = this.disqueraDao.findById(16L);
		
		disqueraConsultada.setDescripcion("Disquera IronMaiden");
		
		this.disqueraDao.update(disqueraConsultada);
	}

	/**
	 * Test method for {@link com.cursoJavaEx.project_jpa.dao.impl.DisqueraDaoImpl#delete(com.cursoJavaEx.project_jpa.beans.Disquera)}.
	 */
	@Test
	void testDelete() {	
		this.disqueraDao.delete(16L);
	}

	/**
	 * Test method for {@link com.cursoJavaEx.project_jpa.dao.impl.DisqueraDaoImpl#findById(java.lang.Long)}.
	 */
	@Test
	void testFindById() {
		Disquera disquera = this.disqueraDao.findById(16L);
		
		System.out.println("Disquera: " +disquera.getDescripcion());
	}
	
	@Test
	void testConsultar() {
		List<Disquera> disquerasConsultadas =  this.disqueraDao.consultar();
		
		assertTrue(disquerasConsultadas.size() > 0);
		
		disquerasConsultadas.forEach(disquera -> {
			System.out.println("Disquera: " + disquera.getDescripcion());
		});
		
		
	}
	

}
