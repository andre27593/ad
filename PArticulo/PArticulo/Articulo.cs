using System;

namespace PArticulo
{
	public class Articulo
	{
		public Articulo() {
		}
		public Articulo (object id, string nombre, decimal? precio, long? categoria) {
			Id = id;
			Nombre = nombre;
			Precio = precio;
			Categoria = categoria;
		}

		public object Id { get; set; }
		public string Nombre { get; set; }
		public decimal? Precio { get; set; }
		public long? Categoria { get; set; }
	}
}

