package test;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import modelo.Articulo;
import modelo.Carrito;
import modelo.Cliente;
import modelo.Comercio;
import modelo.Contacto;
import modelo.DiaRetiro;
import modelo.ItemCarrito;
import modelo.RetiroLocal;
import modelo.Ubicacion;
import modelo.Turno;
public class AlternTest {

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

		//Carritos de los clientes
		Carrito carritoNacho = new Carrito(0001, LocalDate.now(), LocalTime.now(), false, 0, clienteNacho, comprasCarrito1, retiroNacho);
		Carrito carritoRocio = new Carrito(0010, LocalDate.now(), LocalTime.now(), false, 0, clienteRocio, comprasCarrito2, retiroRocio);
		Carrito carritoFabian = new Carrito(0011, LocalDate.now(), LocalTime.now(), true, 0, clienteFabian, comprasCarrito3, retiroFabian);
		Carrito carritoMatias = new Carrito(0100, LocalDate.now(), LocalTime.now(), true, 0, clienteMatias, comprasCarrito4, retiroMatias);
		Carrito carritoMarlene = new Carrito(0101, LocalDate.now(), LocalTime.now(), false, 0, clienteMarlene, comprasCarrito5, retiroMarlene);
		Carrito carritoNaty = new Carrito(0110, LocalDate.now(), LocalTime.now(), true, 0, clienteNaty, comprasCarrito6, retiroNaty);

		//Lista de carritos que tendra el comercio
		List<Carrito>	lstCarritos = new ArrayList<Carrito>();
		lstCarritos.add(carritoNacho);
		lstCarritos.add(carritoRocio);
		lstCarritos.add(carritoFabian);
		lstCarritos.add(carritoMatias);
		lstCarritos.add(carritoMarlene);
		lstCarritos.add(carritoNaty);

		//Instanciamos comercio
		Comercio supermercado = new Comercio(10, dueñoComercio, "Supermercado Objetos", 20422843214l, 50d, 30d, 5, 50, 15, diasRetiro, articulosComercio, lstCarritos);
		/*//supermercado.mostrarComercio();
		List<Turno> agenda = new ArrayList<Turno>();
		agenda = supermercado.traerTurnosOcupados(LocalDate.of(2020, 10, 13));
		System.out.println("Lista de turnos ocupados: ");
		for(Turno e : agenda)
		{
			System.out.println(e.toString());
		}*/
		
		System.out.println("Es valido el cuit del comercio?: "+supermercado.validarIdentidicadorUnico(supermercado.getCuit()));
		System.out.println("Es valido el codigo de barras del articulo 1?: "+art1.validarCodBarras()+"\n\n");
		//Muestro la lista inicial
		/*for(ItemCarrito item : carritoNacho.getLstItemCarrito())
		{
			System.out.println(item.toString());
		}
		//La modifico
		System.out.println("\n\n");
		carritoNacho.agregarItem(art1, 1);
		carritoNacho.agregarItem(art6, 3);
		//La muestro modificada
				for(ItemCarrito item : carritoNacho.getLstItemCarrito())
				{
					System.out.println(item.toString());
				}
		carritoNacho.eliminarItem(art6, 3);
		carritoNacho.eliminarItem(art1, 1);
		
		//La muestro otra vez, quedando como el principio
		System.out.println("\n\n");
		for(ItemCarrito item : carritoNacho.getLstItemCarrito())
		{
			System.out.println(item.toString());
		}
		+/
		
		/*List<Turno>	turnos = new ArrayList<Turno>();
		turnos = supermercado.generarTurnosLibres(LocalDate.of(2020, 10, 13));
		System.out.println(turnos.toString()+"\n\n");
		turnos = supermercado.traerTurnosOcupados(LocalDate.of(2020, 10, 13));
		System.out.println(turnos.toString());
		*/
		
		//Hola
	}

}
