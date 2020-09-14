package modelo;

public class ItemCarrito extends Articulo{
	private Articulo articulo;
	private int cantidad;
	public ItemCarrito(int id, String nombre, String codBarras, double precio, Articulo articulo, int cantidad) {
		super(id, nombre, codBarras, precio);
		this.articulo = articulo;
		this.cantidad = cantidad;
	}
	public Articulo getArticulo() {
		return articulo;
	}
	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
}
