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
		
		//Listar categorias
		/*Categoria categoria = new Categoria();
		categoria.setNombre("nueva" + Calendar.getInstance().getTime());
		entityManager.persist(categoria);
		
		System.out.printf("%d %s\n", categoria.getId(), categoria.getNombre());
		
		List<Categoria> categorias = entityManager.createQuery("from Categoria", Categoria.class).getResultList();
		
		for(Categoria item : categorias){
			System.out.printf("%d %s\n", item.getId(), item.getNombre());
		}
		*/
		
		//Leer articulo concreto
		Articulo articulo = entityManager.getReference(Articulo.class, 2L);
		System.out.println(articulo);
		
		//Modificar un articulo
		articulo.setNombre("articulo modificado " +Calendar.getInstance().getTime());		
		entityManager.persist(articulo);

		//Modificar categoria del articulo
		Categoria categoria = entityManager.getReference(Categoria.class, 1L);
		articulo.setCategoria(categoria);
		entityManager.persist(articulo);
		
		//Eliminar articulo
		
		//Listar articulos
		//Articulo articulo = new Articulo();
		//articulo.setNombre("nueva" + Calendar.getInstance().getTime());
		 //entityManager.persist(articulo);
		
		//List<Articulo> articulos = entityManager.createQuery("from Articulo", Articulo.class).getResultList();
		
		//for(Articulo item : articulos){
			//System.out.printf("%d %s %s %s\n", item.getId(), item.getNombre(), item.getPrecio(), item.getId());
			
		//}
		
		//TABLAS
		//cliente --> id clave primaria auto incremento y bigint, nombre not null unique
		//pedido --> id clave primaria auto incremento y bigint, cliente bigint not null foreign del id de cliente, 
			//fecha datetime not null, importe decimal(10,2) dato calculado (pedido para un cliente especifico)
		//pedidolinea --> id clave primaria auto incremento y bigint, pedido bigint not null foreign a pedido on delete cascade,
			//articulo bigint foreign a articulo, precio decimal(10,2), unidades decimal(10,2), importe decimal(10,2)
		
		
		
		entityManager.getTransaction().commit();
		entityManager.close();
		
		entityManagerFactory.close();

	}
	

}
