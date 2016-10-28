using System;
using System.Data;

namespace Org.InstitutoSerpis.Ad
{
	public class App
	{
		private App ()
		{
		}

		private static App instance = new App();
		public static App Instance{
			get{return instance;}
		}

		private IDbConnection dbconnection;
		public IDbConnection Dbconnection{
			get{return dbconnection;}
			set{dbconnection=value;}
		}
	}
}

