package principal;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidade.Espirito;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Espirito e1 = new Espirito(null, "Pazuzu"); //Por ser auto increment, tem que ser id "null"
		Espirito e2 = new Espirito(null, "Abadon");	
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("exemplo-jpa"); //Puxa o arquivo do persist e mantem ativo.
		
		EntityManager manager = factory.createEntityManager(); //Faz as opera�oes do banco
		
		manager.getTransaction().begin();
		manager.persist(e1);
		manager.persist(e2);
		manager.getTransaction().commit();
	
		
		
		
	}
	
}