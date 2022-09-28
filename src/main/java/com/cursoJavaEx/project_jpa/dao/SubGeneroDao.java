package com.cursoJavaEx.project_jpa.dao;

import java.util.List;
import com.cursoJavaEx.project_jpa.beans.SubGenero;

public interface SubGeneroDao {

	void save(SubGenero subGenero);
	
	void update(SubGenero subGenero);
	
	void delete(Long idSubGenero);
	
	List<SubGenero> consultar();
	
	SubGenero findById(Long idSubGenero);
}
