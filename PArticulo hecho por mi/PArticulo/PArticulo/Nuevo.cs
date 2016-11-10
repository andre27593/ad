using System;
using System.Data;
using MySql.Data.MySqlClient;

namespace PArticuloGTK
{
	public partial class Nuevo : Gtk.Window
	{
	
		public Nuevo () :
			base(Gtk.WindowType.Toplevel)
		{
			this.Build ();



		}	
	
		protected void OnButton1Clicked (object sender, EventArgs e)
		{
			try {

				IDbConnection dbconnection = new MySqlConnection ("Database=dbprueba; User=root; Password=sistemas");

				dbconnection.Open ();

				IDbCommand dbcommand = dbconnection.CreateCommand ();
				dbcommand.CommandText = "insert into articulo (id,nombre, precio, categoria) values (id,@nombre, @precio, @categoria)";
				string nombre = entry1.Text;
				string precio = entry2.Text;
				string categoria = entry3.Text;

				IDbDataParameter parameter1 = dbcommand.CreateParameter ();
				IDbDataParameter parameter2 = dbcommand.CreateParameter ();
				IDbDataParameter parameter3 = dbcommand.CreateParameter ();

				parameter1.ParameterName = "nombre";
				parameter1.Value = nombre;
				dbcommand.Parameters.Add (parameter1);

				parameter2.ParameterName = "precio";
				parameter2.Value = precio;
				dbcommand.Parameters.Add (parameter2);

				parameter3.ParameterName = "categoria";
				parameter3.Value = categoria;
				dbcommand.Parameters.Add (parameter3);


				dbcommand.ExecuteNonQuery ();
				dbconnection.Close ();	

			} catch (MySqlException ex) {

				Console.WriteLine ("ID no existe");
		
			}


		}
}
}
