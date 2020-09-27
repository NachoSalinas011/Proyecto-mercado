package modelo;
import java.time.LocalTime;
import java.util.List;
import java.time.LocalDate;
public class Carrito {
	private int id;
	private LocalDate fecha;
	private LocalTime hora;
	private boolean cerrado;
	private double descuento;
	private Cliente cliente;
	private List<ItemCarrito> lstItemCarrito;
	private Entrega entrega;
	public Carrito(int id, LocalDate fecha, LocalTime hora, boolean cerrado, double descuento, Cliente cliente,
			List<ItemCarrito> lstItemCarrito, Entrega entrega) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
		this.cerrado = cerrado;
		this.descuento = descuento;
		this.cliente = cliente;
		this.lstItemCarrito = lstItemCarrito;
		this.entrega = entrega;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public LocalTime getHora() {
		return hora;
	}
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	public boolean isCerrado() {
		return cerrado;
	}
	public void setCerrado(boolean cerrado) {
		this.cerrado = cerrado;
	}
	public double getDescuento() {
		return descuento;
	}
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<ItemCarrito> getLstItemCarrito() {
		return lstItemCarrito;
	}
	public void setLstItemCarrito(List<ItemCarrito> lstItemCarrito) {
		this.lstItemCarrito = lstItemCarrito;
	}
	public Entrega getEntrega() {
		return entrega;
	}
	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}
	@Override
	public String toString() {
		return "Carrito [id=" + id + ", fecha=" + fecha + ", hora=" + hora + ", cerrado=" + cerrado + ", descuento="
				+ descuento + ", cliente=" + cliente + ", lstItemCarrito=" + lstItemCarrito + ", entrega=" + entrega
				+ "]";
	}
	
	public ItemCarrito traerItemCarrito(int idItem) { //Decidimos implementar esta funcion en caso de ser necesaria
		ItemCarrito result = null;
		for(ItemCarrito e : lstItemCarrito)
		{
			if(idItem == e.getArticulo().getId())
			{
				result = e;
			}
		}
		return result;
	}
	public boolean agregar(Articulo articulo, int cantidad) {
		boolean result = false;
		ItemCarrito item = new ItemCarrito(articulo, cantidad); //Instancio un objeto ItemCarrito con los valores del parametro
		for(ItemCarrito e: lstItemCarrito) //Para cada item de la lista
		{
			if(e.getArticulo().getId() == item.getArticulo().getId()) //Si el id del articulo que quiero EXISTE en la lista
			{
				e.setCantidad(e.getCantidad() + item.getCantidad()); //Aumento su cantidad
				result = true; //Avisaré que la operación se realizó con exito
			}
		}
		if(lstItemCarrito.contains(item) == false) //Si el articulo NO EXISTE en la lista
		{
			lstItemCarrito.add(item); //Lo agrego a la lista
			result = true;
		}
		return result; //Devuelvo el resultado de la operaciòn
	}
}
