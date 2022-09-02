package com.cursoJavaEx.project_jpa.dao;

import java.util.List;

import com.cursoJavaEx.project_jpa.beans.Disquera;

public interface DisqueraDao {

	void save(Disquera disquera);
	
	void update(Disquera disquera);
	
	void delete(Long idDisquera);
	
	Disquera findById(Long idDisquera);
	
	List<Disquera> consultar();
}
