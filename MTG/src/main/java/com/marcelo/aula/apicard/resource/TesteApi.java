package com.marcelo.aula.apicard.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marcelo.aula.apicard.api.CardAPI;
import com.marcelo.aula.apicard.dao.CartaDAO;
import com.marcelo.aula.apicard.entity.CartaEntity;
import com.marcelo.aula.apicard.service.CartaService;

@RestController
@RequestMapping (value="/cartas")
public class TesteApi {
	
	
	@Autowired 
	CartaService cs;
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Card> buscar(@RequestParam(value="nomecarta", defaultValue="") String nomeCard){
		Card cartaProcurada = new Card();
		try {
			cartaProcurada = CardAPI.getCardByName(nomeCard);
			String nome = cartaProcurada.getName();
			String custo = cartaProcurada.getManaCost();
			Double custocmc = cartaProcurada.getCmc();
			String custocmcS = custocmc.toString(); 
			String[] cor = cartaProcurada.getColors();
			String corS = Arrays.toString(cor);
			String tipo = cartaProcurada.getType();
			
			
			CartaEntity ce = new CartaEntity();
			ce.setColecaoCard(null);
			ce.setNomeCard(nome);
			ce.setCustoCard(custo);
			ce.setCustoCMCCard(custocmcS);
			ce.setCorCard(corS);
			ce.setTipoCard(tipo);
			
			cs.salvar(ce);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			return ResponseEntity.ok(cartaProcurada);
		}
	}	
}
