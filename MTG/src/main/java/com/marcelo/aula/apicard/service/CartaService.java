package com.marcelo.aula.apicard.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.marcelo.aula.apicard.dao.CartaDAO;
import com.marcelo.aula.apicard.entity.CartaEntity;
import com.marcelo.aula.apicard.exception.ObjNaoEncontradoException;

@Service
public class CartaService {

	 @Autowired
	 CartaDAO dao;
	
	public CartaEntity buscar(Integer id) {
		Optional<CartaEntity> Carta = dao.findById(id);
		return Carta.orElseThrow(()-> new ObjNaoEncontradoException("Objeto não encontrado"));
	}
	
	public List<CartaEntity> buscar(){
		 return dao.findAll();
	}

	public void salvar(CartaEntity ce) {
		try {	
			System.out.println(ce);
			dao.save(ce);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void apagar(Integer id) {
		dao.deleteById(id);
		
	}
	
	
	//public CartaEntity buscar(String nome) {
		//Optional<CardAPI> nameCard = dao.findById();
	//	//return name
	//}
}
