package com.isae.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.isae.web.dao.IAsignacionClienteDAO;
import com.isae.web.dao.IAsignacionProyectoDAO;
import com.isae.web.dao.IProyectoDAO;
import com.isae.web.entity.AsignacionCliente;
import com.isae.web.entity.Cliente;
import com.isae.web.entity.Proyecto;
import com.isae.web.entity.Usuario;

@RestController
public class AsignacionClienteRestController {
	
	@Autowired
	private IAsignacionClienteDAO asignacionCliente;
	
	@Autowired
	private IAsignacionProyectoDAO asignacionProyecto;
	
	@CrossOrigin(origins = "*")
	@GetMapping("/obtener/asignaciones/cliente")
	public List<AsignacionCliente> obteneAsignacionCliente(){
		return this.asignacionCliente.findAll();
	}
	

}
