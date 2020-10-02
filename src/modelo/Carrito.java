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
	protected void setDescuento(double descuento) {
		if (descuento>0)
		{
			this.descuento=descuento; //Solo se aplicará el descuento si el valor por parametro es mayor que 0
		}	
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
		ItemCarrito itemEncontrado = null;
		ItemCarrito itemBuscado = null;
		int index = 0;
		while(itemEncontrado == null && index < lstItemCarrito.size())
		{
			itemBuscado = lstItemCarrito.get(index);
			if(itemBuscado.getArticulo().getId() == idItem)
			{
				itemEncontrado = itemBuscado;
			}
			index++;
		}
		return itemEncontrado;
	}
	public ItemCarrito traerItemCarrito(Articulo articulo) { //Sobrecarga del método traerItemCarrito
		ItemCarrito itemEncontrado = null;
		ItemCarrito itemBuscado = null;
		int index = 0;
		while(itemEncontrado == null && index < lstItemCarrito.size()) //Mientras el resultado sea null y el iterador sea menor al tamaño de la lista
		{
			itemBuscado = lstItemCarrito.get(index); //Obtengo un elemento de la lista
			if(itemBuscado.getArticulo().equals(articulo))//Los comparo
			{
				itemEncontrado = itemBuscado;
			}
			index++;
		}
		return itemEncontrado;//Devuelvo un resultado
	}
	public boolean agregarItem(Articulo articulo, int cantidad) {
		boolean result = false;
		ItemCarrito itemBuscado = new ItemCarrito(articulo, cantidad);
		ItemCarrito itemEncontrado = traerItemCarrito(itemBuscado.getArticulo()); //Traigo el item que quiero agregar
		if(lstItemCarrito.contains(itemEncontrado)) //Si el item existe en la lista
		{
			itemEncontrado.setCantidad(itemEncontrado.getCantidad() + cantidad);//Cambio su cantidad
			result = true;
		}else
		{
			lstItemCarrito.add(itemBuscado);//Sino, lo agrego
			result = true;
		}
		return result;//Devuelve true si la operación se realizò con exito
	}
	public boolean eliminarItem(Articulo articulo, int cantidad) { //Eliminar un articulo de la lista
		boolean result = false;
		int cant = 0;
		ItemCarrito itemBuscado = new ItemCarrito(articulo, cantidad);
		ItemCarrito itemEncontrado = traerItemCarrito(itemBuscado.getArticulo());
		if(lstItemCarrito.contains(itemEncontrado))
		{
			cant = itemEncontrado.getCantidad();
		}
		if(cant > cantidad)
		{
			itemEncontrado.setCantidad(itemEncontrado.getCantidad() - cantidad);
			result = true;
		}
		else
		{
			lstItemCarrito.remove(itemEncontrado);
			result = true;
		}
		return result;
	}
	public double calcularTotalCarrito()
	{
		int tamanio= lstItemCarrito.size(); // Se inicializo el entero con el tamaño de la lista
		double total=0; // Se inicializo el doble 
		for (int i=0;i<tamanio;i++)
		{
			ItemCarrito item = lstItemCarrito.get(i); // Saca item i y lo guarda en un nuevo item 
			int cantidad= item.getCantidad(); // Se guarda la cantidad del item i de la lista
			Articulo itemArticulo = item.getArticulo(); // Se saca el Articulo del item i y se guarda en un nuevo articulo
			double precio = itemArticulo.getPrecio(); //Se guarda el precio unitario del Articulo
			total=total+(cantidad*precio); // Se calcula el precio total de cada item segun la cantidad del mismo
			// mientras dure el bucle el total se acumula item a item
		} // fin del bucle
		return total;  //Se retorna el total calculado
	}
	public double totalAPagarCarrito () 
	 {
		double total=calcularTotalCarrito();//Se obtiene el total de carrito del metodo ya realizado
		if(total > this.descuento)
		{
		total= total- this.descuento;//se calcula el total descontandose el descuento 
		}
		return total; //retorna lo calculado
	 }
	
	public double calcularDescuentoDia(int diaDescuento, double porcentajeDescuento) { //Devuelve un descuento calculado si es viernes
		double descuento= 0, precioArticulo= 0;
		int cant = 0, artDescuento = 0;
		if(diaDescuento == 5)
		{
			for(ItemCarrito item : lstItemCarrito) //Para cada item del carrito
			{
				cant= item.getCantidad(); //Obtengo su cantidad
				artDescuento= (int)Math.floor((cant)/2); //Calculo la cantidad de elementos que obtienen descuento de ese articulo
				precioArticulo= item.getArticulo().getPrecio(); //Obtengo su precio
				if(cant>1) //Si hay mas de 1 item del mismo articulo
				{
					descuento+= artDescuento * precioArticulo * porcentajeDescuento /100;//Calculo y sumo 
				}
			}
		}
		return descuento;//Devuelvo la suma de todos los descuentos por articulo
	}
	
	public double calcularDescuentoEfectivo(double porcentajeDescuentoEfectivo) {
		double descuento = 0;
		if(entrega.efectivo==true) {
			double total = calcularTotalCarrito();
			descuento = total*porcentajeDescuentoEfectivo /100;
		}
		return descuento;
	}
	
	public void calcularDescuentoCarrito(int diaDescuento, double porcentajeDescuento, double porcentajeDescuentoEfectivo) { //Determina cual sera el descuento mayor a aplicar
		double descuentoDia =0, descuentoEfectivo =0, total=0;
		descuentoDia = calcularDescuentoDia(diaDescuento, porcentajeDescuento);
		descuentoEfectivo = calcularDescuentoEfectivo(porcentajeDescuentoEfectivo); //Calculamos los descuentos
		if(descuentoDia > descuentoEfectivo)
		{
			total= descuentoDia;
		}
		if(descuentoEfectivo > descuentoDia)
		{
			total= descuentoEfectivo; //Se aplicará el mayor
		}
		if(descuentoDia == descuentoEfectivo)
		{
			total= descuentoEfectivo; //Si ambos son iguales se aplica el descuento por efectivo
		}
		setDescuento(total);//Actualizo el descuento
	}
}
