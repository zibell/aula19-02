package com.marcelo.aula;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.marcelo.aula.apicard.dao.CartaDAO;
import com.marcelo.aula.apicard.entity.CartaEntity;

@SpringBootApplication
public class MtgApplication implements CommandLineRunner {
	@Autowired
	CartaDAO cao;

	public static void main(String[] args) {
		SpringApplication.run(MtgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		CartaEntity ce = new CartaEntity();
		ce.setColecaoCard(null);
		ce.setCustoCard("3UB");
		ce.setCorCard("UB");
		ce.setCustoCMCCard("5");
		ce.setNomeCard("O Deus Escaravelho");
		ce.setTipoCard("Criatura Lendária");
		ce.toString();
		cao.save(ce);
	}
}
