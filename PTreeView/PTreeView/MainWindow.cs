using Org.InstitutoSerpis.Ad;
using System;
using Gtk;

public partial class MainWindow: Gtk.Window
{	
	public MainWindow (): base (Gtk.WindowType.Toplevel)
	{
		Build ();
		TreeViewHelper.AppendColumns (treeView, new string[] { "id", "nombre" });
		ListStore listStore = new ListStore (typeof(long), typeof(string));

		listStore.AppendValues (1L, "categoria 1");
		listStore.AppendValues (2L, "categoria 2");

		treeView.Model = listStore;

	}

	protected void OnDeleteEvent (object sender, DeleteEventArgs a)
	{
		Application.Quit ();
		a.RetVal = true;
	}
}
