package com.isae.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isae.web.dao.IAsignacionProyectoDAO;
import com.isae.web.dao.IAsignarRegistroDAO;
import com.isae.web.dao.IInventarioDAO;
import com.isae.web.entity.Asignacionproyecto;
import com.isae.web.entity.Asignacionregistro;
import com.isae.web.entity.Inventario;
import com.isae.web.entity.Proyecto;
import com.isae.web.entity.Registro;
import com.isae.web.entity.Usuario;


@RestController
//@RequestMapping("/asignacion/proyecto")
public class AsignacionProyectoRestController {

	@Autowired
	private IAsignacionProyectoDAO asignacionProyecto;
	
	@Autowired
	private IAsignarRegistroDAO asignarRegistro;
	
	@Autowired
	private IInventarioDAO inventario;
	
	@CrossOrigin(origins = "*")
	@GetMapping("/eliminar/asignacion/proyecto/{idUsuario}/{idProyecto}")
	public List<String> eliminarAsignacionProyecto(
			@PathVariable(value = "idUsuario") String idUsuario,
			@PathVariable(value = "idProyecto") String idProyecto) {
		List<String> respuesta = new ArrayList<>();
		

		this.asignacionProyecto.eliminarAsignacion(Integer.parseInt(idUsuario), Integer.parseInt(idProyecto));
		respuesta.add("correcto");
		
		return respuesta;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/asignar/proyecto/{idUsuario}/{idProyecto}")
	public List<String> asignarProyecto(@PathVariable(value = "idUsuario") String idUsuario,
			@PathVariable(value = "idProyecto") String idProyecto) {
		List<String> respuesta = new ArrayList<>();
		Asignacionproyecto asignacionProyecto = 
				new Asignacionproyecto(0, new Usuario(Integer.parseInt(idUsuario)), new Proyecto(Integer.parseInt(idProyecto)));
		
		this.asignacionProyecto.save(asignacionProyecto);
		
		respuesta.add("correcto");
		
		return respuesta;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/obtener/proyectos/asignados/{idusuario}")
	public List<Proyecto> getProyectosAsignados(@PathVariable(value = "idusuario") String idusuario) {
		List<Proyecto> listaProyectos = new ArrayList<Proyecto>();
		List<Asignacionproyecto> lista = this.asignacionProyecto.obtenerProyectosAsignados(Integer.parseInt(idusuario));
		for(Asignacionproyecto item : lista) {
			listaProyectos.add(item.getProyecto());
		}
		return listaProyectos;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/obtener/registros/asignados/{idusuario}")
	public List<String> getRegistrosAsignados(@PathVariable(value = "idusuario") String idusuario) {
		return this.asignacionProyecto.obtenerRegistroAsignado(Integer.parseInt(idusuario));
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/obtener/registros/asignados/usuario/proyecto/{idusuario}/{idproyecto}")
	public List<Registro> getRegistrosAsignadosUsuarioProyecto(
			@PathVariable(value = "idusuario") String idUsuario,
			@PathVariable(value = "idproyecto") String idProyecto
			) {
		List<Asignacionregistro> listaAsignacionRegistros;
		List<Registro> listaRegistro = new ArrayList<Registro>();
		if(idProyecto.equalsIgnoreCase("0")) {
			listaAsignacionRegistros = this.asignarRegistro.obtenerRegistrosAsignadosUsuario(Integer.parseInt(idUsuario));
			
		}else {
			listaAsignacionRegistros = this.asignarRegistro.obtenerRegistrosAsignadosUsuarioProyecto(Integer.parseInt(idUsuario), Integer.parseInt(idProyecto));
		}
		
		if(listaAsignacionRegistros.isEmpty() && idUsuario.equalsIgnoreCase("0")) {
			List<Inventario> respuesta = this.inventario.findAll();
			
			for(Inventario item : respuesta) {
				listaRegistro.add(new Registro(item.getIdinventario(),item.getFolio(),item.getFechacreacion().toString(),item.getProyecto(),item.getEstatus()));
			}
			
		}else {
			for(Asignacionregistro item : listaAsignacionRegistros) {
				listaRegistro.add(new Registro(item.getInventario().getIdinventario(),item.getInventario().getFolio(),item.getInventario().getFechacreacion().toString(),item.getInventario().getProyecto(),item.getInventario().getEstatus()));
			}
		}
		
		
		
		return listaRegistro;
	}
}
