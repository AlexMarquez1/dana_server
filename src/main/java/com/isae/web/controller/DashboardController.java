package com.isae.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.isae.web.dao.IInventarioDAO;

@RestController
public class DashboardController {
	
	
	@Autowired
	private IInventarioDAO inventario;
	
	
	@CrossOrigin(origins = "*")
	@GetMapping("/obtener/total/registros/proyectos")
	public List<Map<String,Object>> obtenerTotalRegistrosPorProyecto() {
		List<Map<String,Object>> respuesta = new ArrayList<>();
		List<Object> consulta = new ArrayList<Object>();

		consulta = this.inventario.obtenerTotalRegistrosProyectos();
		
		for(Object item : consulta) {
			Object [] objeto  = (Object[]) item;
			Map<String, Object> aux = new HashMap<>();
			aux.put("domain", objeto[0]);
			aux.put("measure", objeto[1]);
			aux.put("idproyecto", objeto[2]);
			respuesta.add(aux);
		}

		return respuesta;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/obtener/total/estatus/proyecto/{idproyecto}")
	public List<Map<String,Object>> obtenerTotalEstatusProyecto(@PathVariable(value = "idproyecto") String idProyecto) {
		List<Map<String,Object>> respuesta = new ArrayList<>();
		List<Object> consulta = new ArrayList<Object>();

		consulta = this.inventario.obtenerTotalEstatusProyecto(Integer.parseInt(idProyecto));
		
		for(Object item : consulta) {
			Object [] objeto  = (Object[]) item;
			Map<String, Object> aux = new HashMap<>();
			aux.put("domain", objeto[0]);
			aux.put("measure", objeto[1]);
			respuesta.add(aux);
		}

		return respuesta;
	}

}
