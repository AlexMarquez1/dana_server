package com.isae.web.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.isae.web.entity.Asignacionproyecto;


@Repository
public interface IAsignacionProyectoDAO extends JpaRepository<Asignacionproyecto, Integer>{

	@Modifying
    @Transactional
	@Query(value= "DELETE FROM asignacionproyecto WHERE idusuario = :idUsuario AND idproyecto = :idProyecto", nativeQuery = true)
	void eliminarAsignacion(@Param("idUsuario") int idUsuario, @Param("idProyecto") int idProyecto);
	
	@Query(value= "SELECT * FROM asignacionproyecto WHERE idusuario = :idUsuario", nativeQuery = true)
	List<Asignacionproyecto> obtenerProyectosAsignados(@Param("idUsuario") int idUsuario);
	
	@Query(value= "SELECT inventario.folio FROM asignacionregistro INNER JOIN inventario ON asignacionregistro.idinventario = inventario.idinventario WHERE idusuario = :idUsuario", nativeQuery = true)
	List<String> obtenerRegistroAsignado(@Param("idUsuario") int idUsuario);
	
	@Modifying
    @Transactional
	@Query(value= "DELETE FROM asignacionproyecto WHERE idproyecto = :idproyecto", nativeQuery = true)
	void eliminarPoridProyecto(@Param("idproyecto") int idproyecto);
	@Modifying
    @Transactional
	@Query(value= "DELETE FROM asignacionproyecto WHERE idusuario = :idusuario", nativeQuery = true)
	void eliminarPoridUsuario(@Param("idusuario") int idusuario);

}
