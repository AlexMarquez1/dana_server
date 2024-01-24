package com.isae.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.isae.web.entity.AsignacionCliente;
import com.isae.web.entity.Cliente;
import com.isae.web.entity.ClienteAplicacion;
import com.isae.web.entity.Proyecto;

@Repository
public interface IAsignacionClienteDAO extends JpaRepository<AsignacionCliente, Integer>{

	@Query(value="SELECT p FROM AsignacionCliente a INNER JOIN a.cliente c INNER JOIN a.proyecto p WHERE a.cliente =:cliente")
	List<Proyecto> obtenerProyectosPorCliente(@Param("cliente") Cliente cliente);
	
	@Query(value="SELECT p FROM AsignacionCliente a INNER JOIN a.cliente c INNER JOIN a.proyecto p INNER JOIN c.clienteAplicacion i WHERE c.clienteAplicacion =:clienteaplicacion")
	List<Proyecto> obtenerProyectosPorClienteAplicacion(@Param("clienteaplicacion") ClienteAplicacion clienteAplicacion);
	
	
}
