package com.isae.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isae.web.dao.IAsignarRegistroDAO;
import com.isae.web.dao.IInventarioDAO;
import com.isae.web.entity.Asignacionregistro;
import com.isae.web.entity.Inventario;
import com.isae.web.entity.Proyecto;
import com.isae.web.entity.Usuario;


@RestController
//@RequestMapping("/asignacion/registro")
public class AsignacionRegistroRestController {
	
	@Autowired
	private IAsignarRegistroDAO asignarRegistro;
	
	@Autowired
	private IInventarioDAO inventario;
	
	@CrossOrigin(origins = "*")
	@PostMapping("/asignar/registro/{idUsuario}")
	public List<String> asignarRegistro(
			@PathVariable(value = "idUsuario") String idUsuario,
			@RequestBody List<String> idRegistros) {
		List<String> respuesta = new ArrayList<>();
		List<Asignacionregistro> listaAsignacionRegistro = new ArrayList<Asignacionregistro>();
		
		for(int i = 0; i< idRegistros.size(); i++) {
			listaAsignacionRegistro.add(new Asignacionregistro(0,new Usuario(Integer.parseInt(idUsuario)),new Inventario(Integer.parseInt(idRegistros.get(i)))));
			this.inventario.cambiarEstatus("ASIGNADO", Integer.parseInt(idRegistros.get(i)));
		}
		
		this.asignarRegistro.saveAll(listaAsignacionRegistro);
		respuesta.add("Correcto");

		return respuesta;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/eliminar/asignacion/registro/{idUsuario}/{idRegistro}")
	public List<String> eliminarAsignacionRegistro(
			@PathVariable(value = "idUsuario") String idUsuario,
			@PathVariable(value = "idRegistro") String idRegistro) {
		List<String> respuesta = new ArrayList<>();

		this.asignarRegistro.eliminarAsignacionRegistro(Integer.parseInt(idUsuario), Integer.parseInt(idRegistro));
		
		respuesta.add("Correcto");

		return respuesta;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/obtener/registros/proyecto/usuario/{idproyecto}/{idusuario}")
	public List<Inventario> obtenerRegistrosPorProyecto(
			@PathVariable(value = "idproyecto") String idProyecto,
			@PathVariable(value = "idusuario") String idUsuario) {
		List<Inventario> respuesta = new ArrayList<Inventario>();
		List<Asignacionregistro> lista = this.asignarRegistro.obtenerRegistrosAsignadosUsuarioProyecto(Integer.parseInt(idUsuario),Integer.parseInt(idProyecto));
		for(Asignacionregistro item : lista) {
			respuesta.add(item.getInventario());
		}

		return respuesta;
	}

}
