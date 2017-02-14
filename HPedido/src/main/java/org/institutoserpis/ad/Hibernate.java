package org.institutoserpis.ad;

import java.awt.event.ItemEvent;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.Persistence;

import org.hibernate.engine.internal.StatefulPersistenceContext;
import org.hibernate.query.criteria.internal.expression.function.SubstringFunction;



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
				
				else if(opci == 8){
					
						System.out.println("Lista de clientes");
						listar_clientes();
						System.out.println();
						System.out.println("Vas a insertar un pedido");
						BigDecimal importe;
						String idcliente;
						System.out.println("Dime el id del cliente ");
						idcliente = scanner.next();
						System.out.println("Dime el importe del pedido ");
						importe = scanner.nextBigDecimal();
						nuevo_pedido(idcliente,importe);
						
				}
				
				else if(opci == 9){
					
						System.out.println("Has salido de la opción insertar");
						break;
				}
				
			case 0:
				System.out.println("Has salido del menú");
				break;	
			
			case 2:
				int opcion=0;
				System.out.println("Que quieres modificar? ");
				System.out.println();
				System.out.println("7. Cliente");
				System.out.println("8. Pedido");
				System.out.println("9. Salir");
				opcion = scanner.nextInt();
				
				if(opcion == 7){
						
					System.out.println("Vas a modificar un cliente");
					System.out.println();
					System.out.println("Lista de clientes");
					listar_clientes();
					System.out.println();
					String idcliente;
					String nombrenuevo;
					System.out.println("Dime el id del cliente que quieres modificar ");
					idcliente =scanner.next();
					System.out.println("Dime el nombre nuevo del cliente ");
					nombrenuevo = scanner.next();
					modificar_cliente(idcliente,nombrenuevo);
						
				}
				
				else if(opcion == 8){
					System.out.println("Vas a modificar un pedido");
					System.out.println();
					System.out.println("Lista de pedidos");
					listar_pedidos();
					System.out.println();
					String idpedido;
					String idcliente;
					BigDecimal importe;
					System.out.println("Dime el id del pedido que quieres modificar ");
					idpedido =scanner.next();
					System.out.println("Dime el id del cliente ");
					idcliente = scanner.next();
					System.out.println("Dime el importe del pedido que quieres modificar ");
					importe =scanner.nextBigDecimal();
					modificar_pedido(idcliente,idpedido,importe);					
					
						
				}
				
				else if(opcion == 9){
					
						System.out.println("Has salido de la opción modificar");
						break;
				}
				
			case 3:
				int opcio=0;
				System.out.println("Que quieres eliminar? ");
				System.out.println();
				System.out.println("7. Cliente");
				System.out.println("8. Pedido");
				System.out.println("9. Salir");
				opcio = scanner.nextInt();
				
				if(opcio == 7){
						System.out.println("Vas a eliminar un cliente");
						System.out.println();
						System.out.println("Lista de clientes");
						listar_clientes();
						System.out.println();
						String idcliente;
						System.out.println("Dime el id del cliente que quieres eliminar ");
						idcliente=scanner.next();
						eliminar_cliente(idcliente);
						
				}
				
				else if(opcio == 8){
					
						System.out.println("Vas a eliminar un pedido");
						System.out.println();
						System.out.println("Lista de pedidos");
						listar_pedidos();
						String idpedido;
						System.out.println("Dime el id del cliente ");
						idpedido = scanner.next();
						eliminar_pedido(idpedido);
						
				}
				
				else if(opcio == 9){
					
						System.out.println("Has salido de la opción eliminar");
						break;
				}
				
			case 4:
				int opn=0;
				System.out.println("Que quieres consultar? ");
				System.out.println();
				System.out.println("7. Cliente");
				System.out.println("8. Pedido");
				System.out.println("9. Salir");
				opn = scanner.nextInt();
				
				if(opn == 7){
					System.out.println("Vas a consultar un cliente");
					System.out.println();
					String idcliente;
					System.out.println("Dime el id del cliente ");
					idcliente = scanner.next();
					consultar_cliente(idcliente);
						
				}
				
				else if(opn == 8){
					System.out.println("Vas a consultar un pedido");
					System.out.println();
					String idpedido;
					System.out.println("Dime el id del pedido ");
					idpedido = scanner.next();
					consultar_pedido(idpedido);						
						
						
				}
				
				else if(opn == 9){
					
						System.out.println("Has salido de la opción consultar");
						break;
				}
				
			case 5:
				int o=0;
				System.out.println("Que quieres listar? ");
				System.out.println();
				System.out.println("7. Cliente");
				System.out.println("8. Pedido");
				System.out.println("9. Salir");
				o = scanner.nextInt();
				
				if(o == 7){
						System.out.println("Clientes");
						listar_clientes();
						
				}
				
				else if(o == 8){
					
						System.out.println("Pedidos");
						listar_pedidos();
						
				}
				
				else if(o == 9){
					
						System.out.println("Has salido de la opción listar");
						break;
				}
				
				
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
	
	public static void listar_clientes(){
		
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		Cliente cliente = new Cliente();
		
		System.out.printf("%d %s\n", cliente.getId(), cliente.getNombre());
		
		List<Cliente> clientes = entityManager.createQuery("from Cliente", Cliente.class).getResultList();
		
		for(Cliente item : clientes){
			System.out.printf("%d %s\n", item.getId(), item.getNombre());
		}
		
			
		entityManager.getTransaction().commit();		
		entityManager.close();
		
		
		
	}
	
	public static void listar_pedidos(){
		
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		Pedido pedido = new Pedido();
		
		System.out.printf("%d %s %s %s\n", pedido.getId(), pedido.getCliente(), pedido.getFecha(), pedido.getImporte());
		
		List<Pedido> pedidos = entityManager.createQuery("from Pedido", Pedido.class).getResultList();
		for(Pedido item : pedidos){
			System.out.printf("%d %s %s %s\n", item.getId(), item.getCliente() , item.getFecha(), item.getImporte());
		}
		
			
		entityManager.getTransaction().commit();		
		entityManager.close();
		
		
	}
	
	public static void eliminar_cliente(String idcliente){
		
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		Cliente cliente = entityManager.getReference(Cliente.class, Long.parseLong(idcliente));
		
		entityManager.remove(cliente);
		
		entityManager.getTransaction().commit();		
		entityManager.close();
		
		
	}
	
	public static void eliminar_pedido(String idpedido){
		
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		Pedido pedido = entityManager.getReference(Pedido.class, Long.parseLong(idpedido));
		
		entityManager.remove(pedido);
		
		entityManager.getTransaction().commit();		
		entityManager.close();
		
		
	}
	
	public static void consultar_pedido(String idpedido){
		
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
				
		Pedido pedido = entityManager.getReference(Pedido.class, Long.parseLong(idpedido));
		System.out.printf("%d %s %s %s\n", pedido.getId(), pedido.getCliente(), pedido.getFecha(), pedido.getImporte());
			
		entityManager.getTransaction().commit();		
		entityManager.close();
		
		
	}
	
	public static void consultar_cliente(String idcliente){
		
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
				
		Cliente cliente = entityManager.getReference(Cliente.class, Long.parseLong(idcliente));
		System.out.printf("%d %s\n", cliente.getId(), cliente.getNombre());
			
		entityManager.getTransaction().commit();		
		entityManager.close();
		
		
	}
	
	public static void modificar_cliente(String idcliente, String nombrenuevo){
		
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
				
		Cliente cliente = entityManager.getReference(Cliente.class, Long.parseLong(idcliente));
		cliente.setNombre(nombrenuevo);
		entityManager.flush();
			
		entityManager.getTransaction().commit();		
		entityManager.close();
		
	}
	
	public static void modificar_pedido(String idcliente, String idpedido, BigDecimal importe){
		
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		Cliente cliente = entityManager.getReference(Cliente.class, Long.parseLong(idcliente));
				
		Pedido pedido = entityManager.getReference(Pedido.class, Long.parseLong(idpedido));
		pedido.setCliente(cliente);
		pedido.setImporte(importe);
		entityManager.flush();
			
		entityManager.getTransaction().commit();		
		entityManager.close();
		
		
	}
		


}
