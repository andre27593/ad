using System;
using System.Data;
using MySql.Data.MySqlClient;

namespace PArticuloGTK
{
	public partial class Eliminar : Gtk.Window
	{
		public Eliminar () : 
				base(Gtk.WindowType.Toplevel)
		{
			this.Build ();
		}


		protected void OnButton1Clicked (object sender, EventArgs e)
		{
			IDbConnection dbconnection = new MySqlConnection ("Database=dbprueba; User=root; Password=sistemas");

			dbconnection.Open ();

			IDbCommand dbcommand = dbconnection.CreateCommand ();
			dbcommand.CommandText = "delete from articulo where id=@id";

			string id = entry1.Text;


			IDbDataParameter parameter = dbcommand.CreateParameter ();


			parameter.ParameterName = "id";
			parameter.Value = id;
		
			dbcommand.Parameters.Add (parameter);

			dbcommand.ExecuteNonQuery ();
			dbconnection.Close ();
		
		}
	}
}

