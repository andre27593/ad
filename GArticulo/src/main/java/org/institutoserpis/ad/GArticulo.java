package org.institutoserpis.ad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class GArticulo {
	
	private static Connection connection;
	private static Scanner scanner;
	
	public static void main(String[] args) throws SQLException {
		
		connection = DriverManager.getConnection("jdbc:mysql://localhost/dbprueba","root","sistemas");
				
		scanner = new Scanner(System.in);
		int opc = 0;
		
		System.out.println("Menú");
		System.out.println("1. Nuevo");
		System.out.println("2. Modificar");
		System.out.println("3. Eliminar");
		System.out.println("4. Consultar");
		System.out.println("5. Listar");
		System.out.println("0. Salir");
		
		System.out.println("Escoge una opción ");
		opc = scanner.nextInt();
		
		switch (opc) {
		case 1:
			System.out.println("Introducir nuevo articulo");
			nuevo();
			break;
		
		case 2:
			
			break;
			
		case 3:
			
			break;
			
		case 4:
			
			break;
			
		case 5:
			
			break;
			
		case 0:
			
			break;

		default:
			System.out.println("Opción incorrecta");
			break;
		}
		
		
	}
	
	public static void nuevo() throws SQLException{
		
		String nombre;
		double precio;
		int categoria;
		
		System.out.println("Dime el nombre ");
		nombre=scanner.next();
		
		System.out.println("Dime el precio ");
		precio = scanner.nextDouble();
		
		System.out.println("Dime el id de la categoria ");
		categoria = scanner.nextInt();
		
		String sql = "insert into articulo (id,nombre,precio,categoria) values (id,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setString(1, nombre);
		preparedStatement.setDouble(2, precio);
		preparedStatement.setInt(3, categoria);
		
		preparedStatement.executeUpdate();
		preparedStatement.close();
		
		
	}
	
	public static void modificar(){
		
	}

}
