package org.institutoserpis.ad;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Hibernate {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.institutoserpis.ad.hmysql");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		Categoria categoria = new Categoria();
		categoria.setNombre("nueva" + Calendar.getInstance().getTime());
		entityManager.persist(categoria);
		
		List<Categoria> categorias = entityManager.createQuery("from Categoria", Categoria.class).getResultList();
		
		for(Categoria item : categorias){
			System.out.printf("%d %s\n", item.getId(), item.getNombre());
		}
		
		Articulo articulo = new Articulo();
		articulo.setNombre("nueva" + Calendar.getInstance().getTime());
		//entityManager.persist(articulo);
		
		List<Articulo> articulos = entityManager.createQuery("from Articulo", Articulo.class).getResultList();
		
		for(Articulo item : articulos){
			System.out.printf("%d %s %s %s\n", item.getId(), item.getNombre(), item.getPrecio(), item.getId());
			
		}
		
		
		
		entityManager.getTransaction().commit();
		entityManager.close();
		
		entityManagerFactory.close();

	}

}
