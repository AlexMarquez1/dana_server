package com.isae.web.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.isae.web.entity.Asignacionregistro;


@Repository
public interface IAsignarRegistroDAO extends JpaRepository<Asignacionregistro,Integer>{

	@Modifying
    @Transactional
	@Query(value= "DELETE FROM asignacionregistro WHERE idusuario = :idUsuario AND idinventario = :idinventario", nativeQuery = true)
	void eliminarAsignacionRegistro(@Param("idUsuario") int idUsuario, @Param("idinventario") int idinventario);
	
	@Query(value= "SELECT * FROM asignacionregistro WHERE idusuario = :idusuario", nativeQuery = true)
	List<Asignacionregistro> obtenerRegistrosAsignadosUsuario(@Param("idusuario") int idusuario);
	
	@Query(value= "SELECT asignacionregistro.idasignacion, asignacionregistro.idusuario, asignacionregistro.idinventario FROM asignacionregistro INNER JOIN inventario ON inventario.idinventario = asignacionregistro.idinventario WHERE asignacionregistro.idusuario = :idusuario AND inventario.idproyecto = :idproyecto ORDER BY CAST(SUBSTRING_INDEX(folio, '-',1) AS UNSIGNED), CAST(SUBSTRING_INDEX(folio, '-',-1) AS UNSIGNED), inventario.folio, inventario.idinventario", nativeQuery = true)
	List<Asignacionregistro> obtenerRegistrosAsignadosUsuarioProyecto(@Param("idusuario") int idusuario, @Param("idproyecto") int idproyecto);
	
	@Query(value="SELECT COUNT(*) FROM asignacionregistro INNER JOIN inventario ON inventario.idinventario = asignacionregistro.idinventario WHERE asignacionregistro.idusuario = :idusuario AND inventario.idproyecto = :idproyecto", nativeQuery = true)
	int obtenerUltimoIngresadoPorUsuario(@Param("idusuario") int idUsuario, @Param("idproyecto") int idProyecto);
	
	
	@Modifying
    @Transactional
	@Query(value= "DELETE FROM asignacionregistro WHERE idinventario = :idinventario", nativeQuery = true)
	void eliminarPoridInventario(@Param("idinventario") int idinventario);
	
	@Modifying
    @Transactional
	@Query(value= "DELETE FROM asignacionregistro WHERE idusuario = :idusuario", nativeQuery = true)
	void eliminarPoridUsuario(@Param("idusuario") int idusuario);
	
}
