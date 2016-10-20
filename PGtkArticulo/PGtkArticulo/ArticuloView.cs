using System;
using Gtk;
using System.Collections.Generic;
using System.Collections;
using System.Reflection;
using Org.InstitutoSerpis.Ad;

namespace PGtkArticulo
{
	public partial class ArticuloView : Gtk.Window
	{
		public ArticuloView () : base(Gtk.WindowType.Toplevel){
			this.Build ();
			spinButtonPrecio.Value = 0;

			saveAction.Sensitive = false;

			entryNombre.Changed += delegate {
				string value = entryNombre.Text.Trim();
				saveAction.Sensitive = !value.Equals("");
			};

			saveAction.Activated += delegate {
				Console.WriteLine ("saveAction.Activated");
			};

			List<Categoria> list = new List<Categoria> ();
			list.Add (new Categoria (1L, "categoria 1"));
			list.Add (new Categoria (2L, "categoria 2"));


		    ComboBoxHelper.Fill(comboBoxCategoria, list, "Nombre");


		}



	public class Categoria {
		public Categoria (long id, string nombre)
		{
			Id = id;
			Nombre = nombre;
		
		}
		public long Id { get; set;}
		public string Nombre { get; set;}
	}
}
}

