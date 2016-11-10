using System;
using MySql.Data.MySqlClient;
using Gtk;
using PGtkArticulo;
using System.Collections.Generic;
using System.Collections;
using Org.InstitutoSerpis.Ad;
using System.Data;

//La librería me da problemas

public partial class MainWindow: Gtk.Window
{	

	public MainWindow (): base (Gtk.WindowType.Toplevel)
	{
		Build ();
		App.Instance.Dbconnection = new MySqlConnection (
			"Database=dbprueba;User Id=root;Password=sistemas");
		App.Instance.Dbconnection.Open ();

		fill ();

		treeView.Selection.Changed += delegate {
			bool selected = treeView.Selection.CountSelectedRows() > 0;
			editAction.Sensitive = selected;
			deleteAction.Sensitive = selected;
		};

		newAction.Activated += delegate {
			new ArticuloView();
		};

		deleteAction.Activated += delegate {
			MessageDialog messagedialog = new MessageDialog(this,DialogFlags.Modal,MessageType.Question,ButtonsType.YesNo,"¿Quieres eliminar el registro?");
			ResponseType response = (ResponseType) messagedialog.Run();
			messagedialog.Destroy();
			if(response!=ResponseType.Yes){
				return;
			}
		};

		refreshAction.Activated += delegate {
			fill();
		};

		new ArticuloView ();
	}

	private void fill() {

		editAction.Sensitive = false;
		deleteAction.Sensitive = false;
		IList list = ArticuloDao.GetList ();
		TreeViewHelper.Fill (treeView, list);
	}

	protected void OnDeleteEvent (object sender, DeleteEventArgs a)
	{
		App.Instance.Dbconnection.Close ();
		Application.Quit ();
		a.RetVal = true;
	}



}
