package com.isae.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.isae.web.dao.IAsignacionClienteDAO;
import com.isae.web.dao.IClienteDAO;
import com.isae.web.entity.Cliente;
import com.isae.web.entity.Proyecto;

@RestController
public class ClienteRestController {

	@Autowired
	private IClienteDAO cliente;
	
	@Autowired
	private IAsignacionClienteDAO asignacionCliente;
	
	@CrossOrigin(origins="*")
	@GetMapping("/obtener/clientes")
	public List<Cliente> obtenerClientes() {
		return this.cliente.findAll();
	}
	
	@CrossOrigin(origins="*")
	@GetMapping("/obtener/clientes/usuario/{idclienteaplicacion}")
	public List<Cliente> obtenerClientesPoUsuario(@PathVariable("idclienteaplicacion") String idClienteAplicacion) {
		
		return this.cliente.obtenerClientesPorUsuario(Integer.parseInt(idClienteAplicacion));
	}
	
	@CrossOrigin(origins="*")
	@PostMapping("/obtener/proyectos/cliente")
	public List<Proyecto> obtenerProyectosPorCliente(@RequestBody Cliente cliente) {
		
		return this.asignacionCliente.obtenerProyectosPorCliente(cliente);
	}
}
