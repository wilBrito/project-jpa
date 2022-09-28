package com.cursoJavaEx.project_jpa.dao.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.cursoJavaEx.project_jpa.beans.Genero;
import com.cursoJavaEx.project_jpa.beans.SubGenero;
import com.cursoJavaEx.project_jpa.dao.SubGeneroDao;
import com.cursoJavaEx.project_jpa.dao.impl.SubGeneroDaoImpl;

class SubGeneroDaoImplTest {
	
	private SubGeneroDao subGeneroDao = new SubGeneroDaoImpl();

	@Test
	void testSave() {
		Genero genero = new Genero("Metal2", LocalDateTime.now(),true);
		SubGenero subGenero = new SubGenero("Hard Core2",genero,LocalDateTime.now(),true);
		
		this.subGeneroDao.save(subGenero);
	}

	@Test
	void testUpdate() {
		SubGenero subGeneroConsultado = this.subGeneroDao.findById(7L);
		
		subGeneroConsultado.setDescripcion("Trash Metal");
		subGeneroConsultado.getGenero().setDescripcion("Metal Trash");
		
		this.subGeneroDao.update(subGeneroConsultado);
	}

	@Test
	void testDelete() {
		this.subGeneroDao.delete(8L);
	}

	@Test
	void testConsultar() {
		List<SubGenero> subGeneroConsultados = this.subGeneroDao.consultar();
		
		assertTrue(subGeneroConsultados.size() > 0);
		
		for(SubGenero subGenero : subGeneroConsultados) {
			System.out.println("Subgenero: " + subGenero.getDescripcion());
			System.out.println("Genero: " + subGenero.getGenero().getDescripcion());
		}
		
	}

	@Test
	void testFindById() {
		fail("Not yet implemented");
	}

}
