
// This file has been generated by the GUI designer. Do not modify.
namespace PArticuloGTK
{
	public partial class Nuevo
	{
		private global::Gtk.VBox vbox2;

		protected virtual void Build ()
		{
			global::Stetic.Gui.Initialize (this);
			// Widget PArticuloGTK.Nuevo
			this.Name = "PArticuloGTK.Nuevo";
			this.Title = global::Mono.Unix.Catalog.GetString ("Nuevo");
			this.WindowPosition = ((global::Gtk.WindowPosition)(4));
			// Container child PArticuloGTK.Nuevo.Gtk.Container+ContainerChild
			this.vbox2 = new global::Gtk.VBox ();
			this.vbox2.Name = "vbox2";
			this.vbox2.Spacing = 6;
			this.Add (this.vbox2);
			if ((this.Child != null)) {
				this.Child.ShowAll ();
			}
			this.DefaultWidth = 400;
			this.DefaultHeight = 300;
			this.Show ();
		}
	}
}
