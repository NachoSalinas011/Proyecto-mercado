package test;

import java.util.List;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import modelo.Articulo;
import modelo.Carrito;
import modelo.Cliente;
import modelo.Comercio;
import modelo.Contacto;
import modelo.DiaRetiro;
import modelo.Envio;
import modelo.ItemCarrito;
import modelo.RetiroLocal;
import modelo.Ubicacion;
import modelo.Turno;
public class TestFinal {

	public static void main(String[] args) {
		//Articulos en gondola
		Articulo art1 = new Articulo(1234, "Galletitas Oreo 16U", "0123456789012", 60);
		Articulo art2 = new Articulo(5678, "Fernet Branca 1L", "8414533043847", 450);
		Articulo art3 = new Articulo(9102, "Glade Sensations Lavanda", "7785684512126", 120);
		Articulo art4 = new Articulo(1112, "Servilletas Higienol 30M", "5901234123457", 90);
		Articulo art5 = new Articulo(4321, "Auriculares Logitech 504", "9780201379624", 1100);
		Articulo art6 = new Articulo(9876, "Pan lactal de salvado Bimbo", "4070071967072", 150);
		//Lista de articulos que vende el comercio
		List<Articulo>	articulosComercio = new ArrayList<Articulo>();
		articulosComercio.add(art1);
		articulosComercio.add(art2);
		articulosComercio.add(art3);
		articulosComercio.add(art4);
		articulosComercio.add(art5);
		articulosComercio.add(art6);
		//Productos cargados
		ItemCarrito producto1 = new ItemCarrito(art1, 4);
		ItemCarrito producto2 = new ItemCarrito(art2, 3);
		ItemCarrito producto3 = new ItemCarrito(art3, 5);
		ItemCarrito producto4 = new ItemCarrito(art4, 8);
		ItemCarrito producto5 = new ItemCarrito(art5, 1);
		ItemCarrito producto6 = new ItemCarrito(art6, 2);

		//Listas de compras
		List<ItemCarrito> comprasCarrito1 = new ArrayList<ItemCarrito>();
		comprasCarrito1.add(producto1);
		comprasCarrito1.add(producto2);
		comprasCarrito1.add(producto3);
		List<ItemCarrito> comprasCarrito2 = new ArrayList<ItemCarrito>();
		comprasCarrito2.add(producto4);
		comprasCarrito2.add(producto5);
		comprasCarrito2.add(producto6);
		List<ItemCarrito> comprasCarrito3 = new ArrayList<ItemCarrito>();
		comprasCarrito3.add(producto1);
		comprasCarrito3.add(producto3);
		comprasCarrito3.add(producto5);
		List<ItemCarrito> comprasCarrito4 = new ArrayList<ItemCarrito>();
		comprasCarrito4.add(producto2);
		comprasCarrito4.add(producto4);
		comprasCarrito4.add(producto6);
		List<ItemCarrito> comprasCarrito5 = new ArrayList<ItemCarrito>();
		comprasCarrito5.add(producto2);
		comprasCarrito5.add(producto5);
		comprasCarrito5.add(producto3);
		List<ItemCarrito> comprasCarrito6 = new ArrayList<ItemCarrito>();
		comprasCarrito6.add(producto1);
		comprasCarrito6.add(producto4);
		comprasCarrito6.add(producto2);

		//Dias en los que se puede retirar pedidos (Equivalen a una semana)
		DiaRetiro lunes = new DiaRetiro(1, 1, LocalTime.of(9, 00), LocalTime.of(13, 30), 10);
		DiaRetiro martes = new DiaRetiro(2, 2, LocalTime.of(10, 00), LocalTime.of(15, 00), 20);
		DiaRetiro miercoles = new DiaRetiro(3, 3, LocalTime.of(8, 0), LocalTime.of(15, 30), 15);
		DiaRetiro jueves = new DiaRetiro(4, 4, LocalTime.of(16, 00), LocalTime.of(22, 50), 50);
		DiaRetiro viernes = new DiaRetiro(5, 5, LocalTime.of(12, 30), LocalTime.of(23, 00), 25);
		DiaRetiro sabado = new DiaRetiro(6, 6, LocalTime.of(17, 00), LocalTime.of(21, 00), 30);
		DiaRetiro domingo = new DiaRetiro(7, 7, LocalTime.of(9, 30), LocalTime.of(13, 30), 60);
		List<DiaRetiro>	diasRetiro = new ArrayList<DiaRetiro>();
		diasRetiro.add(lunes);
		diasRetiro.add(martes);
		diasRetiro.add(miercoles);
		diasRetiro.add(jueves);
		diasRetiro.add(viernes);
		diasRetiro.add(sabado);
		diasRetiro.add(domingo);

		//Objetos instanciados necesarios para Cliente y Comercio
		Ubicacion capital = new Ubicacion(100, 200);
		Ubicacion zonaSur = new Ubicacion(50, 20);
		Ubicacion zonaNorte = new Ubicacion(80, 40);
		Ubicacion direccionComercio = new Ubicacion(200, 150);
		Contacto vendedorCapital = new Contacto("vendedor.ZSur@live.com.ar", "112345678", zonaSur);
		Contacto vendedorZonaS = new Contacto("vendedor.ZNorte@gmail.com", "1123654765", zonaNorte);
		Contacto vendedorZonaN = new Contacto("vendedor.ZCapital@outlook.es", "1121753214", capital);
		Contacto dueñoComercio = new Contacto("supermercado@hotmail.com.ar", "1132145687", direccionComercio);

		//Nosotros somos clientes
		Cliente clienteNacho = new Cliente(1234, vendedorZonaS, "Salinas", "Nicolas", 42284321, 'M');
		Cliente clienteRocio = new Cliente(5678, vendedorZonaN, "Torres", "Rocio",12345678 , 'F');
		Cliente clienteFabian = new Cliente(9101, vendedorCapital, "VillaLoboz", "Fabian", 43092082, 'M');
		Cliente clienteMatias = new Cliente(1112, vendedorZonaN, "Florencio", "Matias", 42353138, 'M');
		Cliente clienteMarlene = new Cliente(1314, vendedorZonaS, "Alessa", "Marlene", 39200863, 'F');
		Cliente clienteNaty = new Cliente(1516, vendedorCapital, "Lefay", "Natalia", 26212864, 'F');

		//Entrega de los carritos
		RetiroLocal retiroNacho = new RetiroLocal(1, LocalDate.of(2020, 10, 13), true, LocalTime.of(10, 00));
		RetiroLocal retiroRocio = new RetiroLocal(2, LocalDate.of(2020, 10, 13), false, LocalTime.of(10, 20));
		RetiroLocal retiroFabian = new RetiroLocal(3, LocalDate.of(2020, 10, 13), true, LocalTime.of(11, 00));
		RetiroLocal retiroMatias = new RetiroLocal(4, LocalDate.of(2020, 10, 13), false, LocalTime.of(11, 40));
		RetiroLocal retiroMarlene = new RetiroLocal(5, LocalDate.of(2020, 10, 13), true, LocalTime.of(12, 20));
		RetiroLocal retiroNaty = new RetiroLocal(6, LocalDate.of(2020, 10, 13), false, LocalTime.of(15, 00));
		Envio envioADomicilio = new Envio(7, LocalDate.of(2020, 10, 13), true, LocalTime.of(9, 00), LocalTime.of(12, 00), 150, zonaSur);

		//Carritos de los clientes
		Carrito carritoNacho = new Carrito(0001, LocalDate.now(), LocalTime.now(), false, 0, clienteNacho, comprasCarrito1, retiroNacho);
		Carrito carritoRocio = new Carrito(0010, LocalDate.now(), LocalTime.now(), false, 0, clienteRocio, comprasCarrito2, retiroRocio);
		Carrito carritoFabian = new Carrito(0011, LocalDate.now(), LocalTime.now(), true, 0, clienteFabian, comprasCarrito3, retiroFabian);
		Carrito carritoMatias = new Carrito(0100, LocalDate.now(), LocalTime.now(), true, 0, clienteMatias, comprasCarrito4, retiroMatias);
		Carrito carritoMarlene = new Carrito(0101, LocalDate.now(), LocalTime.now(), false, 0, clienteMarlene, comprasCarrito5, retiroMarlene);
		Carrito carritoNaty = new Carrito(0110, LocalDate.now(), LocalTime.now(), true, 0, clienteNaty, comprasCarrito6, retiroNaty);
		Carrito carritoElias = new Carrito(0111, LocalDate.of(2020, 10, 23), LocalTime.now(), true, 0, clienteRocio, comprasCarrito2, envioADomicilio);

		//Lista de carritos que tendra el comercio
		List<Carrito>	lstCarritos = new ArrayList<Carrito>();
		lstCarritos.add(carritoNacho);
		lstCarritos.add(carritoRocio);
		lstCarritos.add(carritoFabian);
		lstCarritos.add(carritoMatias);
		lstCarritos.add(carritoMarlene);
		lstCarritos.add(carritoNaty);

		//Instanciamos comercio y probamos los métodos
		
		Comercio supermercado = new Comercio(10, dueñoComercio, "Supermercado Objetos", 20422843214l, 50d, 30d, 5, 50, 15, diasRetiro, articulosComercio, lstCarritos);
		supermercado.mostrarComercio();
		System.out.println("\n---------------------------------------------------");
		System.out.println("\n\nHora Retiro de "+LocalDate.of(2020, 10, 13)+": "+supermercado.traerHoraRetiro(LocalDate.of(2020, 10, 13))+"\n\n");
		List<Turno> turnos = new ArrayList<Turno>();
		turnos = supermercado.generarAgenda(LocalDate.of(2020, 10, 13));
		System.out.println("---------------------------------------------------");
		System.out.println("Turnos para dia "+LocalDate.of(2020, 10, 13)+"\n");
		for(Turno turno : turnos)
		{
			System.out.println(turno.toString());
		}
		turnos = supermercado.traerTurnosOcupados(LocalDate.of(2020, 10, 13));
		System.out.println("---------------------------------------------------");
		System.out.println("Turnos ocupados para dia "+LocalDate.of(2020, 10, 13)+"\n");
		for(Turno turno : turnos)
		{
			System.out.println(turno.toString());
		}
		System.out.println("---------------------------------------------------");
		List<Turno> agenda = new ArrayList<Turno>();
		agenda = supermercado.generarAgenda(LocalDate.of(2020, 10, 13));
		System.out.println("Agenda generada para dia "+LocalDate.of(2020, 10, 13));
		for(Turno turno : agenda)
		{
			System.out.println(turno.toString());
		}
		System.out.println("---------------------------------------------------");
		System.out.println("Agregamos un dia retiro en la lista, será día 8 por la tarde\n\nTodos los dias retiro:\n");
		supermercado.agregarDiaRetiro(8, LocalTime.of(17, 00), LocalTime.of(22, 00), 25);
		for(DiaRetiro dia : supermercado.getLstDiaRetiro())
		{
			System.out.println(dia.toString());
		}
		System.out.println("---------------------------------------------------");
		System.out.println("Validemos los cod de barras de los articulos\n");
		System.out.println("Es válido el cod de barras de art1?: "+art1.validarCodBarras());
		System.out.println("Es válido el cod de barras de art2?: "+art2.validarCodBarras());
		System.out.println("Es válido el cod de barras de art3?: "+art3.validarCodBarras());
		System.out.println("Es válido el cod de barras de art4?: "+art4.validarCodBarras());
		System.out.println("Es válido el cod de barras de art5?: "+art5.validarCodBarras());
		System.out.println("Es válido el cod de barras de art6?: "+art6.validarCodBarras());
		System.out.println("---------------------------------------------------");
		for(ItemCarrito e : carritoNacho.getLstItemCarrito())
		{
			System.out.println(e.toString());
		}
		System.out.println("\nAgrego 1 item al primer elemento de la lista de compras y agrego un producto nuevo:\n");
		carritoNacho.agregarItem(art1, 1);
		carritoNacho.agregarItem(art6, 2);
		for(ItemCarrito e : carritoNacho.getLstItemCarrito())
		{
			System.out.println(e.toString());
		}
		System.out.println("\nAhora elimino el item que agregué al primer elemento y borro por completo el producto nuevo\n");
		carritoNacho.eliminarItem(art1, 1);
		carritoNacho.eliminarItem(art6, 10);
		for(ItemCarrito e : carritoNacho.getLstItemCarrito())
		{
			System.out.println(e.toString());
		}
		System.out.println("---------------------------------------------------");
		System.out.println("Calculemos los totales y descuentos del carrito 1\n");
		System.out.println("Subtotal item calculado del producto 1. Precio: "+producto1.getArticulo().getPrecio()+" Cantidad: "+producto1.getCantidad()+" Subtotal: "+producto1.calcularSubTotalItem());
		System.out.println("\nSubtotal carrito 1: "+carritoNacho.calcularTotalCarrito());
		System.out.println("\nLos viernes hay promoción al 50% de la segunda unidad! El carrito 1 obtiene un descuento de: "+carritoNacho.calcularDescuentoDia(5, 50));
		System.out.println("Pero como hoy es martes, solo hay descuento del 20% del total si se paga en efectivo. El carrito 1 obtiene un descuento de: "+carritoNacho.calcularDescuentoEfectivo(20));
		System.out.println("Los descuentos no son acumulables, solo se aplica el mayor");
		carritoNacho.calcularDescuentoCarrito(2, 50, 20);
		System.out.println("\nCarrito 1. Subtotal: "+carritoNacho.calcularTotalCarrito()+" Descuento: "+carritoNacho.getDescuento());
		System.out.println("Total a pagar carrito 1: "+carritoNacho.totalAPagarCarrito());
		System.out.println("---------------------------------------------------");
		System.out.println("Mostremos el costo del carrito 7 que eligió el modo envio a domicilio");
		Envio envioElias = (Envio)carritoElias.getEntrega();
		System.out.println("Ubicacion: "+envioElias.getUbicacion());
		System.out.println("Costo envio base: "+envioElias.getCosto());
		envioElias.setCosto(capital, 150, 2);
		DecimalFormat df = new DecimalFormat("#.00");
		System.out.println("Costo calculado: "+df.format(envioElias.getCosto()));
		
	}
}
