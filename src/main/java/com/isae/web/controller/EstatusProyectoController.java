package com.isae.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.isae.web.dao.IEstatusProyecto;
import com.isae.web.entity.EstatusProyecto;

@RestController
public class EstatusProyectoController {
	
	@Autowired
	private IEstatusProyecto estatusProyecto;
	
	@CrossOrigin(origins = "*")
	@GetMapping("/obtener/estatus/proyecto/{idproyecto}")
	public List<EstatusProyecto> obtenerEstatusPorProyecto(@PathVariable(value="idproyecto") String idProyecto){
		List<EstatusProyecto> listaEstatus = new ArrayList<EstatusProyecto>();
		
		listaEstatus = this.estatusProyecto.obtenerEstatusPorProyecto(Integer.parseInt(idProyecto));
		
		return listaEstatus;
	}

}
