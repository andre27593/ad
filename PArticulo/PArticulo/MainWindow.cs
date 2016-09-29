using System;
using Gtk;
using System.Data;
using MySql.Data.MySqlClient;
using PArticuloGTK;

public partial class MainWindow: Gtk.Window
{	
	public MainWindow (): base (Gtk.WindowType.Toplevel)
	{
		Build ();

		IDbConnection dbConnection = new MySqlConnection ("Database=dbprueba; User Id=root; Password=sistemas");

		IDbCommand dbcommand = dbConnection.CreateCommand();
		IDataReader query;

		dbConnection.Open ();




		//Para que lea y liste los datos de los campos
		ListStore listStore = new ListStore (typeof(long), typeof(string), typeof(string), typeof(long));
		treeview1.Model = listStore;


		//Poner la cabecera de los campos en el treeView 
		treeview1.AppendColumn ("id", new CellRendererText (), "text", 0);
		treeview1.AppendColumn ("nombre", new CellRendererText(), "text", 1);
		treeview1.AppendColumn ("precio", new CellRendererText(), "text", 2);
		treeview1.AppendColumn ("categoria", new CellRendererText(), "text", 3);


		dbcommand.CommandText = "select * from articulo";

		query = dbcommand.ExecuteReader ();

		while (query.Read()) {

					
			listStore.AppendValues (query ["id"], query ["nombre"], "" + query ["precio"], query ["categoria"]); //"" en precio es para que no de error si el precio es nulo
		
		}





		dbConnection.Close ();

	}

	protected void OnDeleteEvent (object sender, DeleteEventArgs a)
	{
		Application.Quit ();
		a.RetVal = true;
	}

	protected void OnNewActionActivated (object sender, EventArgs e)
	{


		Nuevo insertar = new Nuevo ();

		insertar.Show ();

	}

	protected void OnQuitActionActivated (object sender, EventArgs e)
	{
		Application.Quit ();
	}
	
	protected void OnDeleteActionActivated (object sender, EventArgs e)
	{
		Eliminar eliminar = new Eliminar ();

		eliminar.Show ();
	}
}
