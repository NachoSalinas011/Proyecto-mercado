package test;

import modelo.Articulo;
import modelo.Carrito;
import modelo.ItemCarrito;
import modelo.RetiroLocal;
import modelo.Ubicacion;
import modelo.Cliente;
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
		RetiroLocal local = new RetiroLocal(1234, LocalDate.now(), true, LocalTime.now());
		Envio correoArg = new Envio(5678, LocalDate.now(), false, LocalTime.of(13, 0), LocalTime.of(9, 0), 50, capital);
		
		//Instanciamos dos carritos con distintos parametros
		Carrito comprasNacho = new Carrito(1111, LocalDate.of(2020, 11, 23), LocalTime.of(10, 00), true, 0, clienteNacho, lista1,local);
		Carrito comprasRocio = new Carrito(1234, LocalDate.now(), LocalTime.now(), true, 0, clienteRocio, lista2, correoArg);
	
		
		List<DiaRetiro> listaRetiros = new ArrayList<DiaRetiro>();
		List<Turno> listaTurnos = new ArrayList<Turno>();
		
		DiaRetiro retiro1 = new DiaRetiro(1, 1, LocalTime.of(9, 9), LocalTime.of(13, 30), 10);
		DiaRetiro retiro2 = new DiaRetiro(2, 2, LocalTime.of(10, 0), LocalTime.of(15, 0), 20);
		DiaRetiro retiro3 = new DiaRetiro(6, 6, LocalTime.of(17, 0), LocalTime.of(21, 0), 30);
		listaRetiros.add(retiro1);
		listaRetiros.add(retiro2);
		listaRetiros.add(retiro3);
		
		int index =0;
		while(index < listaRetiros.size())
		{
			LocalDate fecha = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), listaRetiros.get(index).getDiaSemana());
			LocalTime hora = listaRetiros.get(index).getHoraDesde();
			Turno turno = new Turno(LocalDate.now(), LocalTime.now(), false);
			turno.setDia(fecha);
			while(((hora.isAfter(listaRetiros.get(index).getHoraDesde())) || (hora.equals(listaRetiros.get(index).getHoraDesde()))) && (hora.isBefore(listaRetiros.get(index).getHoraHasta())))
			{
				System.out.println("Entre al while :D");
				if(hora.equals(listaRetiros.get(index).getHoraDesde()))
					{
						turno.setHora(hora);
					}else
					{
						hora.plusMinutes(listaRetiros.get(index).getIntervalo());
						turno.setHora(hora);
					}
			listaTurnos.add(turno);
			}
			index++;
		}
		System.out.println(listaTurnos.toString());
		
		
	}
}
