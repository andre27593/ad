using System;
using MySql.Data.MySqlClient;
using System.Windows.Forms;
using System.Data;
using System.Data.Common;



namespace PDbPrueba
{
	class MainClass
	{
		public static void Main (string[] args)
		{
			//Conectar con la base de datos
			Console.WriteLine ("Probando acceso a dbprueba");
			Console.WriteLine ("");
			IDbConnection dbConnection = new MySqlConnection ("Database=dbprueba;User Id=root;Password=sistemas");

			//Creación de un comando para poder insertar, eliminar, modificar...
			IDbCommand dbcommand = dbConnection.CreateCommand ();

			//Añadir a la base de datos
			IDbDataParameter dbDataParameter = dbcommand.CreateParameter ();
			IDbDataParameter dbDataParameter2 = dbcommand.CreateParameter (); //Creamos otro parámetro, sino coge el mismo objeto

			IDataReader query;
			int opc=0;

			dbConnection.Open ();

		
			//Menú con las opciones de salir, insertar, editar, eliminar, listar todos

			Console.Write ("MENÚ");
			Console.WriteLine ("");
			Console.Write ("0.SALIR" + "\n" + "1.NUEVO" + "\n" + "2.EDITAR" + "\n" + "3.ELIMINAR" + "\n" + "4.LISTAR TODOS" + "\n");


		

			do {

				Console.WriteLine("");
				Console.Write ("Seleccione una opción: ");

				switch (Console.Read ()) {

				case '0':

					Console.WriteLine ("");
					Console.Write ("ADI0000S!! :)");
					Console.WriteLine ("");
					Environment.Exit (0);
					break;

				case '1':

					Console.WriteLine ("");
					Console.Write ("NUEVO");
					Console.WriteLine ("");
					Console.WriteLine ("Introduce el nombre: ");
					String nombre = Console.ReadLine ();		
					dbcommand.CommandText = "insert into categoria (id, nombre) values (id, @nombre)";


					dbDataParameter.ParameterName = "nombre";

					dbDataParameter.Value = nombre;
					dbcommand.Parameters.Add (dbDataParameter);


					dbcommand.ExecuteNonQuery ();

					break;

				case '2':

					Console.WriteLine ("");
					Console.Write ("EDITAR");
					Console.WriteLine ("");
					dbcommand.CommandText = "select  id, nombre from categoria";

					query = dbcommand.ExecuteReader ();

					while (query.Read()) {

						int id = query.GetInt32 (0);
						String nom = query.GetString (1);

						Console.WriteLine ("El id es " + id + " y el nombre es " + nom);
				

					}


					query.Close ();

					Console.Write ("Dime el nombre nuevo");
					String nombrenuevo = Console.ReadLine ();
					Console.Write ("Dime el id del nombre que quieres modificar");
					String idmod = Console.ReadLine ();
					int idori = int.Parse (idmod); //Convertir el id de String a int


					dbcommand.CommandText = "update categoria set nombre = @nombrenuevo where id = @id";

					dbDataParameter.ParameterName = "nombrenuevo";

					dbDataParameter.Value = nombrenuevo;


					dbDataParameter2.ParameterName = "id";

					dbDataParameter2.Value = idori;
					dbcommand.Parameters.Add (dbDataParameter);
					dbcommand.Parameters.Add (dbDataParameter2);



					dbcommand.ExecuteNonQuery ();


					break;


				case '3':

					Console.WriteLine ("");
					Console.Write ("ELIMINAR");
					Console.WriteLine ("");

					Console.Write ("Dime el nombre que quieres eliminar");
					String nombreeli = Console.ReadLine ();

					dbcommand.CommandText = "delete from categoria where nombre=@nombreeli";

					dbDataParameter.ParameterName = "nombreeli";
					dbDataParameter.Value = nombreeli;

					dbcommand.Parameters.Add (dbDataParameter);

					dbcommand.ExecuteNonQuery ();

					break;

				case '4':

					Console.WriteLine ("");
					Console.Write ("LISTAR TODOS");
					Console.WriteLine ("");

					dbcommand.CommandText = "select  id, nombre from categoria";

					query = dbcommand.ExecuteReader ();

					while (query.Read()) {

						int id = query.GetInt32 (0);
						String nom = query.GetString (1);

						Console.WriteLine ("El id es " + id + " y el nombre es " + nom);


					}


					query.Close ();

					break;

				}


			} while(opc!=0);

			dbConnection.Close ();
		}
	}
}
