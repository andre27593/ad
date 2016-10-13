using System;
using MySql.Data.MySqlClient;
using Gtk;
using PGtkArticulo;
using System.Collections.Generic;
using Org.InstitutoSerpis.Ad;
using System.Data;

public partial class MainWindow: Gtk.Window
{	
	private IDbConnection dbConnection;
	public MainWindow (): base (Gtk.WindowType.Toplevel)
	{
		Build ();

		dbConnection = new MySqlConnection ("Database = dbprueba; User Id=root; Password=sistemas");

		dbConnection.Open ();

		List <Articulo> list = new List<Articulo>();

		//Se puede porque es tipo referencia, decimal no porque es un tipo valor
		//pero si pones ? al lado del tipo de la variable si que se puede

		string selectSql = "select * from articulo";
		IDbCommand dbCommand = dbConnection.CreateCommand ();
		dbCommand.CommandText = selectSql;

		IDataReader datareader = dbCommand.ExecuteReader ();
		while (datareader.Read()) {
			long id = (long)datareader ["id"];
			string nombre = (string)datareader ["nombre"];
			decimal? precio = datareader ["precio"] is DBNull ? null : (decimal?)datareader ["precio"];
			long? categoria = datareader ["categoria"] is DBNull ? null : (long?)datareader ["categoria"];
			Articulo articulo = new Articulo (id, nombre, precio, categoria);
			list.Add (articulo);


		}

		datareader.Close ();

		TreeViewHelper.Fill (treeView, list);


	}

	protected void OnDeleteEvent (object sender, DeleteEventArgs a)
	{
		dbConnection.Close ();
		Application.Quit ();
		a.RetVal = true;
	}
}
