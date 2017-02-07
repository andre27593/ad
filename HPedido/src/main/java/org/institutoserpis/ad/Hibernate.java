package org.institutoserpis.ad;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.Persistence;

public class Hibernate {
	
	private static Scanner scanner;
	private static EntityManager entityManager; 
	private static EntityManagerFactory entityManagerFactory;
	
	public static void main(String[] args){
		
		entityManagerFactory = Persistence.createEntityManagerFactory("org.institutoserpis.ad.hpedido");
	
		scanner = new Scanner(System.in);
		int opc = 0;
		
		System.out.println("MENÚ");
		System.out.println("----------------------------");
		System.out.println("1. Insertar");
		System.out.println("2. Modificar");
		System.out.println("3. Eliminar");
		System.out.println("4. Consultar");
		System.out.println("5. Listar");
		System.out.println("0. Salir");
		
		System.out.println("-----------------------------");
		
		do{
			System.out.println("Escoge una opción: ");
			opc = scanner.nextInt();
		
			switch (opc) {
			case 1:
				System.out.println("Que quieres insertar? ");
				System.out.println();
				System.out.println("7. Cliente");
				System.out.println("8. Pedido");
				System.out.println("9. Salir");
				
				int opci=0;
				
				do {
					
					switch (opci) {
					case 9:
						System.out.println("Has salido de la opción insertar");
						break;
					case 7:
						System.out.println("Vas a insertar un cliente");
						nuevo_cliente();
					case 8:
						System.out.println("Vas a insertar un pedido");
						nuevo_pedido();

					default:
						break;
					}
					
					
				} while (opci!=9);
		
			case 2:
				System.out.println("Vas a modificar un articulo");
				System.out.println();
				//listar();
				//modificar();
				break;
			
			case 3:
				System.out.println("Vas a eliminar un artículo");
				System.out.println();
				//eliminar();
				break;
			
			case 4:
				System.out.println("Vas a consultar un artículo de tu base de datos");
				System.out.println();
				//consultar();
				break;
			
			case 5:
				System.out.println("Vas a listar los artículos de tu base de datos");
				System.out.println();
				//listar();
				break;
			
			case 0:
				System.out.println("Has salido del programa");
				break;

			default:
				System.out.println("Opción incorrecta");
				break;
			}
		}while(opc!=0);
		
}

	public static void nuevo_cliente(){
			
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		String nombre;
			
		System.out.println("Dime el nombre ");
		nombre=scanner.next();
			
		
		Cliente cliente = new Cliente();
		cliente.setNombre(nombre);
		entityManager.persist(cliente);
		
		entityManager.close();
			
	}
	
	public static void nuevo_pedido(){
		
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		String nombre;
			
		System.out.println("Dime el nombre ");
		nombre=scanner.next();
			
		
		Cliente cliente = new Cliente();
		cliente.setNombre(nombre);
		entityManager.persist(cliente);
		
		entityManager.close();
			
	}
	
		

	/*	//Insertar pedido
		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		java.util.Date dat = Calendar.getInstance().getTime();
		Date date = new Date(dat.getDate());
		pedido.setFecha(date);
		BigDecimal importe = new BigDecimal(50.40);
		pedido.setImporte(importe);
		entityManager.persist(pedido);
				

		entityManager.getTransaction().commit();
		entityManager.close();
		
		entityManagerFactory.close();
		
	}
*/
}
