package test;

import modelo.Articulo;
import modelo.Carrito;
import modelo.ItemCarrito;
import modelo.RetiroLocal;
import modelo.Ubicacion;
import modelo.Cliente;
import modelo.Comercio;
import modelo.Contacto;
import modelo.Entrega;
import modelo.Envio;
import modelo.Turno;
import modelo.DiaRetiro;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.WeekFields;
import java.io.CharArrayReader;
public class test {	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Articulos en gondola
		Articulo art1 = new Articulo(1234, "Galletitas Oreo 16U", "0123456789012", 60);
		Articulo art2 = new Articulo(5678, "Fernet Branca 1L", "8414533043847", 450);
		Articulo art3 = new Articulo(9102, "Glade Sensations Lavanda", "7785684512126", 120);
		Articulo art4 = new Articulo(1112, "Servilletas Higienol 30M", "5901234123457", 90);
		
		List<Articulo> articulos = new ArrayList<Articulo>();
		articulos.add(art1);
		articulos.add(art2);
		articulos.add(art3);
		articulos.add(art4);
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
		RetiroLocal local = new RetiroLocal(1234, LocalDate.of(2020, 11, 23), true, LocalTime.of(9, 30));
		RetiroLocal correoArg = new RetiroLocal(5678, LocalDate.of(2020, 11, 26), false, LocalTime.of(16, 00));
		
		//Instanciamos dos carritos con distintos parametros
		Carrito comprasNacho = new Carrito(1111, LocalDate.of(2020, 11, 23), LocalTime.of(10, 00), true, 0, clienteNacho, lista1,local);
		Carrito comprasRocio = new Carrito(1234, LocalDate.of(2020, 11, 26), LocalTime.now(), true, 0, clienteRocio, lista2, correoArg);
		
		List<Carrito> carritos = new ArrayList<Carrito>();
		carritos.add(comprasNacho);
		carritos.add(comprasRocio);
		
		List<DiaRetiro> listaRetiros = new ArrayList<DiaRetiro>();
		List<Turno> listaTurnos = new ArrayList<Turno>();
		
		DiaRetiro retiro1 = new DiaRetiro(1, 1, LocalTime.of(9, 00), LocalTime.of(13, 30), 10);
		DiaRetiro retiro2 = new DiaRetiro(2, 2, LocalTime.of(10, 00), LocalTime.of(15, 00), 20);
		DiaRetiro retiro3 = new DiaRetiro(3, 3, LocalTime.of(8, 0), LocalTime.of(15, 30), 15);
		DiaRetiro retiro4 = new DiaRetiro(4, 4, LocalTime.of(16, 00), LocalTime.of(22, 50), 50);
		DiaRetiro retiro5 = new DiaRetiro(5, 5, LocalTime.of(12, 30), LocalTime.of(23, 00), 25);
		DiaRetiro retiro6 = new DiaRetiro(6, 6, LocalTime.of(17, 00), LocalTime.of(21, 00), 30);
		DiaRetiro retiro7 = new DiaRetiro(7, 7, LocalTime.of(9, 30), LocalTime.of(13, 30), 60);
		
		listaRetiros.add(retiro1);
		listaRetiros.add(retiro2);
		listaRetiros.add(retiro3);
		listaRetiros.add(retiro4);
		listaRetiros.add(retiro5);
		listaRetiros.add(retiro6);
		listaRetiros.add(retiro7);
		
		Comercio chino = new Comercio(1234, zonaSur, "Supermercado Chinoxd", 42284321l, 10, 15, 5, 20, 15, listaRetiros, articulos, carritos);
		/*Turno turno = new Turno(LocalDate.now(), LocalTime.now(), false);
		 int index = 0;
		while(index < listaRetiros.size())//Para cada item de la lista de retiros
		{
			LocalDate fecha = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), listaRetiros.get(index).getDiaSemana());
			LocalTime hora = listaRetiros.get(index).getHoraDesde();//Creo variables fecha y hora
			turno.setDia(fecha);//Asigno la fecha correspondiente a los turnos de hoy
			while(hora.equals(listaRetiros.get(index).getHoraDesde()) || hora.equals(listaRetiros.get(index).getHoraHasta()) || hora.isAfter(listaRetiros.get(index).getHoraDesde()) && hora.isBefore(listaRetiros.get(index).getHoraHasta()))//Si la hora esta en el rango establecido
			{
				turno.setHora(hora);//Asigno la hora del turno
				hora = hora.plusMinutes(listaRetiros.get(index).getIntervalo());//Sumo el intervalo
				System.out.println("Fecha: "+turno.getDia()+ " Hora: "+turno.getHora());
			}
			index++;//Aumento el indice
		}
		System.out.println(listaTurnos.toString());
		
		List<Turno> turnos = new ArrayList<Turno>();
		turnos = chino.traerTurnosOcupados(LocalDate.of(2020, 11, 23));
		System.out.println(turnos.toString());
		*/
		List<Turno> agenda = new ArrayList<Turno>();
		//agenda = chino.generarAgenda(LocalDate.of(2020, 11, 23));
		//System.out.println(agenda.toString());
		List<Turno> turnosOcupados = new ArrayList<Turno>();
		turnosOcupados = chino.traerTurnosOcupados(LocalDate.of(2020, 11, 23));
		System.out.println(turnosOcupados.toString());
	}
}
