using System;
using System.Data;

namespace PArticuloGTK
{
	public partial class Nuevo : Gtk.Window
	{
	
		public Nuevo () :
			base(Gtk.WindowType.Toplevel)
		{
			this.Build ();

		}

		public class Nuevo{

		private static Nuevo instance = new Nuevo();
		public static Nuevo Instance {
			get { return instance;}
		}

		private Nuevo() {
		}

		private IDbConnection dbConnection;

		public IDbConnection DbConnection{
			get { return dbConnection;}
			set { dbConnection = value;}

		}

		}
	
}
}
