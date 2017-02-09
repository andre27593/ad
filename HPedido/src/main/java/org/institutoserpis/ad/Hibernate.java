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
				int opci=0;
				System.out.println("Que quieres insertar? ");
				System.out.println();
				System.out.println("7. Cliente");
				System.out.println("8. Pedido");
				System.out.println("9. Salir");
				opci = scanner.nextInt();
				
				if(opci == 7){
						System.out.println("Vas a insertar un cliente");
						String nombre;
						System.out.println("Dime el nombre ");
						nombre=scanner.next();
						nuevo_cliente(nombre);
				}
				
				if(opci == 8){
					
						System.out.println("Vas a insertar un pedido");
						BigDecimal importe;
						System.out.println("Dime el importe del pedido ");
						importe = scanner.nextBigDecimal();
						//nuevo_pedido(id,importe);
						
				}
				
				if(opci == 9){
					
						System.out.println("Has salido de la opción insertar");
						break;
				}
				
			case 0:
				System.out.println("Has salido del menú");
				break;			
			default:
				break;
			}
		}while(opc!=0);
		
}

	public static void nuevo_cliente(String nombre){
			
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
			
		Cliente cliente = new Cliente();
		cliente.setNombre(nombre);
		entityManager.persist(cliente);
		
		entityManager.getTransaction().commit();
		entityManager.close();
			
	}
	
	public static void nuevo_pedido(String idcliente, BigDecimal importe){
		
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Cliente cliente = entityManager.getReference(Cliente.class, Long.parseLong(idcliente));
		
		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		
		java.util.Date dat = Calendar.getInstance().getTime();
		Date date = new Date(dat.getDate());
		pedido.setFecha(date);
		pedido.setImporte(importe);
		entityManager.persist(pedido);
			
		entityManager.getTransaction().commit();		
		entityManager.close();
			
	}
	
		


}
