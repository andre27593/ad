
// This file has been generated by the GUI designer. Do not modify.
namespace PArticuloGTK
{
	public partial class Eliminar
	{
		private global::Gtk.HBox hbox1;
		private global::Gtk.Label label1;
		private global::Gtk.Entry entry1;
		private global::Gtk.Button button1;

		protected virtual void Build ()
		{
			global::Stetic.Gui.Initialize (this);
			// Widget PArticuloGTK.Eliminar
			this.Name = "PArticuloGTK.Eliminar";
			this.Title = global::Mono.Unix.Catalog.GetString ("Eliminar");
			this.WindowPosition = ((global::Gtk.WindowPosition)(4));
			// Container child PArticuloGTK.Eliminar.Gtk.Container+ContainerChild
			this.hbox1 = new global::Gtk.HBox ();
			this.hbox1.Name = "hbox1";
			this.hbox1.Spacing = 6;
			// Container child hbox1.Gtk.Box+BoxChild
			this.label1 = new global::Gtk.Label ();
			this.label1.Name = "label1";
			this.label1.LabelProp = global::Mono.Unix.Catalog.GetString ("ID");
			this.hbox1.Add (this.label1);
			global::Gtk.Box.BoxChild w1 = ((global::Gtk.Box.BoxChild)(this.hbox1 [this.label1]));
			w1.Position = 0;
			w1.Expand = false;
			w1.Fill = false;
			// Container child hbox1.Gtk.Box+BoxChild
			this.entry1 = new global::Gtk.Entry ();
			this.entry1.CanFocus = true;
			this.entry1.Name = "entry1";
			this.entry1.IsEditable = true;
			this.entry1.InvisibleChar = '•';
			this.hbox1.Add (this.entry1);
			global::Gtk.Box.BoxChild w2 = ((global::Gtk.Box.BoxChild)(this.hbox1 [this.entry1]));
			w2.Position = 1;
			// Container child hbox1.Gtk.Box+BoxChild
			this.button1 = new global::Gtk.Button ();
			this.button1.CanFocus = true;
			this.button1.Name = "button1";
			this.button1.UseUnderline = true;
			this.button1.Label = global::Mono.Unix.Catalog.GetString ("Eliminar");
			this.hbox1.Add (this.button1);
			global::Gtk.Box.BoxChild w3 = ((global::Gtk.Box.BoxChild)(this.hbox1 [this.button1]));
			w3.Position = 2;
			w3.Expand = false;
			w3.Fill = false;
			this.Add (this.hbox1);
			if ((this.Child != null)) {
				this.Child.ShowAll ();
			}
			this.DefaultWidth = 334;
			this.DefaultHeight = 76;
			this.Show ();
			this.button1.Clicked += new global::System.EventHandler (this.OnButton1Clicked);
		}
	}
}
