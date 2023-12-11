package com.isae.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isae.web.dao.IAccesoDAO;


@RestController
public class AccesoRestController {
	
	@Autowired
	private IAccesoDAO acceso; 
	
	@CrossOrigin(origins = "*")
	@GetMapping("/obtener/pass")
	public String obtenerPass() {
		return this.acceso.findById(1).get().getPass();
	}

}
