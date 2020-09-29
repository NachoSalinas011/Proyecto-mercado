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
		//Caso de uso de una lista de ItemCarrito lista para ser usada a modo de ejemplo
		Articulo a1 = new Articulo(1234, "Galleitas Oreo", "1234567891234", 60);
		Articulo a2 = new Articulo(5678, "Papas Lays original", "9876543219876", 120);
		Articulo a3 = new Articulo(9101, "Fernet Branca", "1011121314151", 450);
		Articulo a4 = new Articulo(1112, "Servilletas Higienol", "2021222324252", 90);
		Articulo a5 = new Articulo(1314, "Jabon en polvo Ace", "9991234567890", 150);
		
		ItemCarrito producto1 = new ItemCarrito(a1, 2);
		ItemCarrito producto2 = new ItemCarrito(a2, 1);
		ItemCarrito producto3 = new ItemCarrito(a3, 4);
		ItemCarrito producto4 = new ItemCarrito(a4, 3);
		ItemCarrito producto5 = new ItemCarrito(a5, 9);
		
		List<ItemCarrito> listaSuper = new ArrayList<ItemCarrito>();
		listaSuper.add(producto1);
		listaSuper.add(producto2);
		
		Ubicacion Casa = new Ubicacion (100,100);
		Contacto contacto1 = new Contacto ("rociobtorres2000@gmail.com","1158208781",Casa);
		Cliente Persona = new Cliente (14,contacto1,"Torres","Rocio",42522794,'F');
		Entrega entrega1= new Entrega(14,LocalDate.now(),false);
		
		Carrito Changuito = new Carrito (14,LocalDate.now(),LocalTime.now(),true,50,Persona,listaSuper,entrega1);
		
		System.out.println("Total Carrito: " +Changuito.calcularTotalCarrito());
		System.out.println("Total a pagar Carrito: " +Changuito.totalAPagarCarrito());		
		System.out.println("Descuento por dia:" +Changuito.calcularDescuentoDia(5,50));
		Changuito.calcularDescuentoCarrito(5, 20, 50);
		
	}
}
