package com.isae.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isae.web.entity.Dia;

@Repository
public interface IDiaDAO extends JpaRepository<Dia ,Integer>{
	@Query(value= "SELECT dia FROM dias", nativeQuery = true)
	List<String> obtenerDias();
	
}
