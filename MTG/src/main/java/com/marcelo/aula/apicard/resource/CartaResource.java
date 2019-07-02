package com.marcelo.aula.apicard.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marcelo.aula.apicard.entity.CartaEntity;
import com.marcelo.aula.apicard.service.CartaService;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/colecao")
public class CartaResource {

	@Autowired
	CartaService cs;

	@RequestMapping(method = RequestMethod.GET)
	public List<CartaEntity> listarColecao() {
		List<CartaEntity> colecao = cs.buscar();
		return colecao;
	}
	
	@RequestMapping(method = RequestMethod.GET, value="{id}")
	public ResponseEntity<CartaEntity> buscar(@PathVariable Integer id){
		CartaEntity ce = cs.buscar(id);
		return ResponseEntity.ok(ce);
	}
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<Void> delete (@PathVariable Integer id){
		cs.apagar(id);
		return ResponseEntity.noContent().build();
	}

}
