package com.isae.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.isae.web.entity.Tipoproyecto;

@Repository
public interface ITipoProyectoDAO extends JpaRepository<Tipoproyecto, Integer>{

	@Query(value="SELECT descripcion FROM tipoproyecto WHERE descripcion = :dato", nativeQuery = true )
	Tipoproyecto findByDescripcion(@Param("dato") String descripcion);
}
