package modelo;

public class ItemCarrito {
	private Articulo articulo;
	private int cantidad;
	public ItemCarrito(Articulo articulo, int cantidad) {
		super();
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
	@Override
	public String toString() {
		return "ItemCarrito [articulo=" + articulo + ", cantidad=" + cantidad + "]";
	}
	
	public double calcularSubTotalItem()
	{
		int cantidad = getCantidad();  // Se guarda la cantidad del item en el entero
		double precio = articulo.getPrecio(); //Se guarda el precio unitario del Articulo en el double
		double subTotal= cantidad*precio; //Se calcula el subTotal del item multiplicando cantidad por precio
		return subTotal; //Se retorna lo calculado 
	}
}
