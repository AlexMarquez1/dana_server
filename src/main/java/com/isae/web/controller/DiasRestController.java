package com.isae.web.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isae.web.dao.IDiaDAO;
import com.isae.web.entity.Dia;

@RestController
public class DiasRestController {

	@Autowired
	private IDiaDAO dias;
	
	@CrossOrigin(origins = "*")
	@GetMapping("/dias")
	public List<Dia> dias(){
		return this.dias.findAll();
	}
}
