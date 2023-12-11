package com.isae.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.isae.web.entity.ClienteAplicacion;
import com.isae.web.entity.Localidad;

@Repository
public interface ILocalidadDAO extends JpaRepository<Localidad,Integer> {
	
	@Query("SELECT l FROM Localidad l WHERE clienteAplicacion =:cliente")
	List<Localidad> obtenerLocalidadPorCliente(@Param("cliente") ClienteAplicacion clienteAplicacion);

}
