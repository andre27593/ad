package org.institutoserpis.ad;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Hibernate {
	
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.institutoserpis.ad.hpedido");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		//Insertar cliente
		
		Cliente cliente = new Cliente();
		cliente.setId(1);
		cliente.setNombre("Pepito");
		//entityManager
		//clase Session?
				
		
		//Insertar pedido
		
		

		entityManager.getTransaction().commit();
		entityManager.close();
		
		entityManagerFactory.close();
		
	}

}
