package test;

import modelo.Articulo;
import modelo.Carrito;
import modelo.ItemCarrito;
import modelo.Ubicacion;
import modelo.Cliente;
import modelo.Contacto;
import modelo.Entrega;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;
import java.io.CharArrayReader;
public class test {	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Articulos en gondola
		Articulo art1 = new Articulo(1234, "Galletitas Oreo 16U", "0123456789012", 60);
		Articulo art2 = new Articulo(5678, "Fernet Branca 1L", "8414533043847", 450);
		Articulo art3 = new Articulo(9102, "Glade Sensations Lavanda", "7785684512126", 120);
		Articulo art4 = new Articulo(1112, "Servilletas Higienol 30M", "5901234123457", 90);
		
		//Items de carrito
		ItemCarrito producto1 = new ItemCarrito(art1, 2);
		ItemCarrito producto2 = new ItemCarrito(art2, 5);
		ItemCarrito producto3 = new ItemCarrito(art3, 1);
		ItemCarrito producto4 = new ItemCarrito(art4, 4);
		
		//Listas de articulos
		List<ItemCarrito>	lista1 = new ArrayList<ItemCarrito>();
		lista1.add(producto1);
		lista1.add(producto2);

		List<ItemCarrito>	lista2 = new ArrayList<ItemCarrito>();
		lista2.add(producto3);
		lista2.add(producto4);
		
		//Variables necesarias para instanciar carrito
		Ubicacion capital = new Ubicacion(100, 50);
		Contacto zonaSur = new Contacto("yourname@example.com", "1173654837", capital);
		Cliente clienteNacho = new Cliente(1111, zonaSur, "Salinas", "Nicolas", 42284321, 'M');
		Cliente clienteRocio = new Cliente(1234, zonaSur, "Torres", "Rocio", 42522794, 'F');
		Entrega domicilio = new Entrega(1111, LocalDate.now(), true);
		Entrega correoArg = new Entrega(1234, LocalDate.of(2020, 10, 21), false);
		
		//Instanciamos dos carritos con distintos parametros
		Carrito comprasNacho = new Carrito(1111, LocalDate.of(2020, 11, 23), LocalTime.of(10, 00), true, 0, clienteNacho, lista1, domicilio);
		Carrito comprasRocio = new Carrito(1234, LocalDate.now(), LocalTime.now(), true, 0, clienteRocio, lista2, correoArg);
		
		System.out.println(comprasNacho.toString());
		System.out.println(comprasRocio.toString());
		System.out.println("Lista de compras 1");
		System.out.println(comprasNacho.getCliente().toString());
		for(ItemCarrito item : comprasNacho.getLstItemCarrito())
		{
			System.out.println(item.toString());
		}
		System.out.println("Descuento del dia: "+comprasNacho.calcularDescuentoDia(2, 50));
		System.out.println("Descuento en efectivo: "+comprasNacho.calcularDescuentoEfectivo(20));
		comprasNacho.calcularDescuentoCarrito(2, 50, 20);
		System.out.println("Total del carrito: "+comprasNacho.calcularTotalCarrito()+" Descuento del carrito: "+comprasNacho.getDescuento());
		System.out.println("Total a pagar del carrito: "+comprasNacho.totalAPagarCarrito());
		System.out.println("\n\n\nLista de compras 2");
		for(ItemCarrito item : comprasRocio.getLstItemCarrito())
		{
			System.out.println(item.toString());
		}
		System.out.println("Descuento del dia: "+comprasRocio.calcularDescuentoDia(5, 50));
		System.out.println("Descuento en efectivo: "+comprasRocio.calcularDescuentoEfectivo(20));
		comprasRocio.calcularDescuentoCarrito(5, 50, 0);
		System.out.println("Total del carrito: "+comprasRocio.calcularTotalCarrito()+" Descuento del carrito: "+comprasRocio.getDescuento());
		System.out.println("Total a pagar del carrito: "+comprasRocio.totalAPagarCarrito());
		
		
		System.out.println("\nCambiamos la lista de los clientes");
		comprasNacho.eliminarItem(art1, 1);
		comprasNacho.eliminarItem(art2, 5);
		comprasNacho.agregarItem(art3, 6);
		comprasNacho.agregarItem(art4, 3);
		comprasNacho.agregarItem(art1, 2);
		
		comprasRocio.eliminarItem(art4, 2);
		comprasRocio.eliminarItem(art3, 10);
		comprasRocio.agregarItem(art1, 5);
		comprasRocio.agregarItem(art2, 1);
		
		System.out.println("Mostramos las listas modificadas\n\n Cliente 1");
		for(ItemCarrito item : comprasNacho.getLstItemCarrito())
		{
			System.out.println(item.toString());
		}
		System.out.println("\n\n Cliente 2");
		for(ItemCarrito item : comprasRocio.getLstItemCarrito())
		{
			System.out.println(item.toString());
		}
		
		System.out.println("Es valido el cod Barras de art1?: "+art1.validarCodBarras());
		System.out.println("Es valido el cod Barras de art2?: "+art2.validarCodBarras());
		System.out.println("Es valido el cod Barras de art3?: "+art3.validarCodBarras());
		System.out.println("Es valido el cod Barras de art4?: "+art4.validarCodBarras());
	}
}
