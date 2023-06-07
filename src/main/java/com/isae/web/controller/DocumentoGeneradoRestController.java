package com.isae.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.isae.web.dao.IDocumentoGenerado;
import com.isae.web.entity.Documentogenerado;

@RestController
//@RequestMapping("/documento")
public class DocumentoGeneradoRestController {
	
	@Autowired
	private IDocumentoGenerado documentoGenerado;
	
	@CrossOrigin(origins = "*")
	@PostMapping("/guardar/documento")
	public Documentogenerado guardarDocumento(
			@RequestBody Documentogenerado documento
			) {
		
		List<Documentogenerado> lista = this.documentoGenerado.obtenerDocumento(documento.getInventario().getIdinventario());
		if(lista.isEmpty()) {
			this.documentoGenerado.save(documento);
		}else {
			documento.setIddocumento(lista.get(0).getIddocumento());
			this.documentoGenerado.save(documento);
		}
		
		return documento;
		
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/obtener/documento/inventario/{idinventario}")
	public String obtenerDocumento(
			@PathVariable(value = "idinventario") String idinventario
			) {
		String respuesta = this.documentoGenerado.obtenerUrlPorIdInventario(Integer.parseInt(idinventario));
		return respuesta;
		
	}

}
