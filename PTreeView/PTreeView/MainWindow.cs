using Org.InstitutoSerpis.Ad;
using System;
using Gtk;
using System.Collections.Generic;
using System.Collections;


public partial class MainWindow: Gtk.Window
{	
	public MainWindow (): base (Gtk.WindowType.Toplevel)
	{
		Build ();

		//IList list = new List<Articulo> ();


		//list.Add (new Articulo(1L, "articulo 1",1.5m));
		//list.Add (new Articulo(1L, "articulo 1",1.5m));
		//list.Add (new Articulo(1L, "articulo 1",1.5m));

		IList list = new List<Categoria> ();

		list.Add (new Categoria(1L, "categoria 1"));
		list.Add (new Categoria(2L, "categoria 2"));
		list.Add (new Categoria(3L, "categoria 3"));

		TreeViewHelper.Fill (treeView, list);

		//TreeViewHelper.AppendColumns (treeView, typeof(Articulo));
		//ListStore listStore = new ListStore (typeof(long), typeof(string));

		//listStore.AppendValues (1L, "categoria 1");
		//listStore.AppendValues (2L, "categoria 2");

		//treeView.Model = listStore;

	}

	protected void OnDeleteEvent (object sender, DeleteEventArgs a)
	{
		Application.Quit ();
		a.RetVal = true;
	}
}

	public class Categoria{
		public Categoria(long id, string nombre){
			Id = id;
			Nombre = nombre;
		}

		public long Id { get; set; }
		public String Nombre { get; set; }
	}

	public class Articulo{
		public Articulo(long id, string nombre, decimal precio){
			Id = id;
			Nombre = nombre;
			Precio = precio;
		}

		public long Id { get; set; }
		public String Nombre { get; set; }
		public decimal Precio { get; set;}

	}


