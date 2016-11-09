using System.Data;
using MySql.Data.MySqlClient;
using System;

namespace PArticuloGTK
{
	public partial class Editar : Gtk.Window
	{
		public Editar () : 
				base(Gtk.WindowType.Toplevel)
		{
			this.Build ();
		}


		protected void OnButton1Clicked (object sender, EventArgs e)
		{
			try{


			IDbConnection dbconnection = new MySqlConnection ("Database=dbprueba; User=root; Password=sistemas");

			dbconnection.Open ();

			IDbCommand dbcommand = dbconnection.CreateCommand ();
			dbcommand.CommandText = "update articulo set nombre='" + this.entry2.Text + "', precio='" +this.entry3.Text+ "', categoria='" +this.entry4.Text+ "' where id='" +this.entry1.Text+"';";

			dbcommand.ExecuteNonQuery ();
			dbconnection.Close ();

			}catch(MySqlException ex) {

				Console.WriteLine ("ID no existe");

			}
		
	}
}
}
