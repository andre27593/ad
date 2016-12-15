package org.institutoserpis.ad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Scanner;

import com.mysql.jdbc.RowDataCursor;

public class GArticulo {
	
	private static Connection connection;
	private static Scanner scanner;
	
	public static void main(String[] args) throws SQLException {
		
		connection = DriverManager.getConnection("jdbc:mysql://localhost/dbprueba","root","sistemas");
				
		scanner = new Scanner(System.in);
		int opc = 0;
		
		System.out.println("MENÚ");
		System.out.println("----------------------------");
		System.out.println("1. Nuevo");
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
				System.out.println("Vas a introducir un nuevo artículo");
				System.out.println();
				nuevo();
				break;
		
			case 2:
				System.out.println("Vas a modificar un articulo");
				System.out.println();
				listar();
				modificar();
				break;
			
			case 3:
				System.out.println("Vas a eliminar un artículo");
				System.out.println();
				eliminar();
				break;
			
			case 4:
				System.out.println("Vas a consultar un artículo de tu base de datos");
				System.out.println();
				consultar();
				break;
			
			case 5:
				System.out.println("Vas a listar los artículos de tu base de datos");
				System.out.println();
				listar();
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
		
		System.out.println();
		
		preparedStatement.executeUpdate();
		preparedStatement.close();
		
		
	}
	
	public static void modificar() throws SQLException{
		
		String nomnuevo;
		double prenuevo;
		int catenuevo;		
		int id;
		
		System.out.println("Dime el id del artículo que quieres modificar ");
		id = scanner.nextInt();
		
		System.out.println("Dime el nombre  ");
		nomnuevo=scanner.next();
		
		System.out.println("Dime el precio ");
		prenuevo = scanner.nextDouble();
		
		System.out.println("Dime el id de la categoria ");
		catenuevo = scanner.nextInt();
		
		String sql = "update articulo set nombre=?, precio=?, categoria=? where id='"+id+"'";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setString(1, nomnuevo);
		preparedStatement.setDouble(2, prenuevo);
		preparedStatement.setInt(3, catenuevo);
		
		System.out.println();
		
		preparedStatement.executeUpdate();
		preparedStatement.close();
		
	}
	

	public static void eliminar() throws SQLException{	
		int id;
		
		System.out.println("Dime el id del artículo que quieres eliminar ");
		id = scanner.nextInt();
				
		String sql = "delete from articulo where id='"+id+"'";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		System.out.println();
		
		preparedStatement.executeUpdate();
		preparedStatement.close();
		
	}
	
	public static void consultar() throws SQLException{
		
		int id;
		
		System.out.println("Dime el id del artículo que quieres consultar ");
		id = scanner.nextInt();
				
		String sql = "select * from articulo where id='"+id+"'";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		System.out.printf("%5s %30s %10s %5s\n", "id", "nombre", "precio", "categoria");
		while (resultSet.next()){
			
			System.out.printf("%5d %30s %10s %5d\n",resultSet.getInt("id"),resultSet.getString("nombre"),resultSet.getDouble("precio"),resultSet.getInt("categoria"));
			System.out.println();
		}
				
		resultSet.close();
		preparedStatement.close();
		
	}
	
	public static void listar() throws SQLException{
				
		String sql = "select * from articulo";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		System.out.printf("%5s %30s %10s %5s\n", "id", "nombre", "precio", "categoria");
		while (resultSet.next()){
			
			System.out.printf("%5d %30s %10s %5d\n",resultSet.getInt("id"),resultSet.getString("nombre"),resultSet.getDouble("precio"),resultSet.getInt("categoria"));
			System.out.println();
			
		}
				
		resultSet.close();
		preparedStatement.close();
		
		
	}

}
