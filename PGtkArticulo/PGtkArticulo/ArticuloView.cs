using System;
using Gtk;
using System.Collections.Generic;

namespace PGtkArticulo
{
	public partial class ArticuloView : Gtk.Window
	{
		public ArticuloView () : base(Gtk.WindowType.Toplevel){
			this.Build ();
			spinButtonPrecio.Value = 0;

			saveAction.Sensitive = false;

			List<Categoria> list = new List<Categoria> ();
			list.Add (new Categoria (1L, "categoria 1"));
			list.Add (new Categoria (2L, "categoria 2"));

			ListStore listStore = new ListStore (typeof(object));
			foreach (object item in list)
				listStore.AppendValues (item);

			CellRendererText cellRendererText = new CellRendererText();

			comboBoxCategoria.PackStart (cellRendererText, false);

			comboBoxCategoria.SetCellDataFunc (cellRendererText, delegate(CellLayout cell_layout, CellRenderer cell, TreeModel tree_model, TreeIter iter) {

			});

			comboBoxCategoria.Model = listStore;

			entryNombre.Changed += delegate {
				string value = entryNombre.Text.Trim();
				saveAction.Sensitive = !value.Equals("");
			};

			saveAction.Activated += delegate {
				Console.WriteLine ("saveAction.Activated");
			};
		}
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

