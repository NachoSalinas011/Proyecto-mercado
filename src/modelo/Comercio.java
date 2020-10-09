package modelo;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
/**
 * @author usuario1
 *
 */
public class Comercio extends Actor {
	private String nombreComercio;
	private long cuit;
	private double CostoFijo;
	private double costoPorKm;
	private int diaDescuento;
	private int porcentajeDescuentoDia;
	private int porcentajeDescuentoEfectivo;
	private List<DiaRetiro> lstDiaRetiro;
	private List<Articulo> lstArticulo;
	private List<Carrito> lstCarrito;
	public Comercio(int id, Contacto contacto, String nombreComercio, long cuit, double costoFijo, double costoPorKm,
			int diaDescuento, int porcentajeDescuentoDia, int porcentajeDescuentoEfectivo, List<DiaRetiro> lstDiaRetiro,
			List<Articulo> lstArticulo, List<Carrito> lstCarrito) {
		super(id, contacto);
		this.nombreComercio = nombreComercio;
		this.cuit = cuit;
		CostoFijo = costoFijo;
		this.costoPorKm = costoPorKm;
		this.diaDescuento = diaDescuento;
		this.porcentajeDescuentoDia = porcentajeDescuentoDia;
		this.porcentajeDescuentoEfectivo = porcentajeDescuentoEfectivo;
		this.lstDiaRetiro = lstDiaRetiro;
		this.lstArticulo = lstArticulo;
		this.lstCarrito = lstCarrito;
	}
	public String getNombreComercio() {
		return nombreComercio;
	}
	public void setNombreComercio(String nombreComercio) {
		this.nombreComercio = nombreComercio;
	}
	public long getCuit() {
		return cuit;
	}
	public void setCuit(long cuit) {
		this.cuit = cuit;
	}
	public double getCostoFijo() {
		return CostoFijo;
	}
	public void setCostoFijo(double costoFijo) {
		CostoFijo = costoFijo;
	}
	public double getCostoPorKm() {
		return costoPorKm;
	}
	public void setCostoPorKm(double costoPorKm) {
		this.costoPorKm = costoPorKm;
	}
	public int getDiaDescuento() {
		return diaDescuento;
	}
	public void setDiaDescuento(int diaDescuento) {
		this.diaDescuento = diaDescuento;
	}
	public int getPorcentajeDescuentoDia() {
		return porcentajeDescuentoDia;
	}
	public void setPorcentajeDescuentoDia(int porcentajeDescuentoDia) {
		this.porcentajeDescuentoDia = porcentajeDescuentoDia;
	}
	public int getPorcentajeDescuentoEfectivo() {
		return porcentajeDescuentoEfectivo;
	}
	public void setPorcentajeDescuentoEfectivo(int porcentajeDescuentoEfectivo) {
		this.porcentajeDescuentoEfectivo = porcentajeDescuentoEfectivo;
	}
	public List<DiaRetiro> getLstDiaRetiro() {
		return lstDiaRetiro;
	}
	public void setLstDiaRetiro(List<DiaRetiro> lstDiaRetiro) {
		this.lstDiaRetiro = lstDiaRetiro;
	}
	public List<Articulo> getLstArticulo() {
		return lstArticulo;
	}
	public void setLstArticulo(List<Articulo> lstArticulo) {
		this.lstArticulo = lstArticulo;
	}
	public List<Carrito> getLstCarrito() {
		return lstCarrito;
	}
	public void setLstCarrito(List<Carrito> lstCarrito) {
		this.lstCarrito = lstCarrito;
	}
	@Override
	public String toString() {
		return "Comercio [nombreComercio=" + nombreComercio + ", cuit=" + cuit + ", CostoFijo=" + CostoFijo
				+ ", costoPorKm=" + costoPorKm + ", diaDescuento=" + diaDescuento + ", porcentajeDescuentoDia="
				+ porcentajeDescuentoDia + ", porcentajeDescuentoEfectivo=" + porcentajeDescuentoEfectivo
				+ ", lstDiaRetiro=" + lstDiaRetiro + ", lstArticulo=" + lstArticulo + ", lstCarrito=" + lstCarrito
				+ "]";
	}
	protected boolean validarIdentidicadorUnico(long cuit) {
		boolean result = false; 
		int suma=0, z=0, r=0, cont = 5; //Variables a usar
		String cadenaCuit = String.valueOf(cuit); //Paso a String
		char[] caracteres = cadenaCuit.toCharArray(); //Paso el String a un array de char
		int[] arrayDni = new int[11]; //Creo un array para el CUIT
		for(int i=0; i<11; i++) //Desde 2 hasta 9
		{
			arrayDni[i] = Integer.parseInt(String.valueOf(caracteres[i])); //arrayDni (=0 hasta 8) = caracteres(=2 hasta 10)
		}
		for(int e=0; e<arrayDni.length -1; e++) //Desde 0 hasta 10
		{
			suma +=(arrayDni[e] * cont); //Suma = arrayInt[e]*cont
			cont-=1; //Resto 1 al contador
			if((cont==1) && (e==3)) //Si el contador es 1 y es la 3era vuelta
			{
				cont = 7;
			}
		}
		int digitoVerificador = arrayDni[arrayDni.length-1];
		r=suma%11; //Obtengo el resto de la suma/11
		if(r == 0)
		{
			z = 0; // Si el resto es 0 entones Z = 0
		}
		else
		{
			if(r == 1) //Si el resto es 1
			{
				if((arrayDni[0] == 2) && (arrayDni[1] == 0)) //Y es hombre
				{
					z = 9; 
					arrayDni[1] = 3; //Z = 9 y cambia el segundo valor del cuit
				}
				if((arrayDni[0] == 2) && (arrayDni[1] == 7))// Y es mujer
				{
					z = 4;
					arrayDni[1] = 3; //Z = 4 y cambia el segundo valor del cuit
				}
			}
			else //Si no cumple con ninguna de las condiciones anteriores
			{
				z = 11 - r; 
			}
		}
		if(z == digitoVerificador) // Devolverá true si el digito obtenido por calculo es igual al pasado por parametro
		{
			result = true;
		}
		if(cadenaCuit.length() != 11) //Si el largo del cuit obtenido por parametro es distinto de 11, devolverá falso y una excepcion
		{
			result = false;
		}
		return result;
	}
	public DiaRetiro traerDiaRetiro(int dia) {//Trae un diaRetiro por fecha
		int index = 0;
		DiaRetiro obtenido = null;
		while(index < lstDiaRetiro.size() && obtenido == null)
		{
			if(lstDiaRetiro.get(index).getDiaSemana() == dia)
			{
				obtenido = lstDiaRetiro.get(index);
			}
			index++;
		}
		return obtenido;
	}
	public Carrito traerCarrito(LocalDate fecha) {//Trae un carrito por fecha
		int index = 0;
		Carrito obtenido = null;
		while(index < lstCarrito.size() && obtenido == null)
		{
			if(lstCarrito.get(index).getFecha().equals(fecha))
			{
				obtenido = lstCarrito.get(index);
			}
			index++;
		}
		return obtenido;
	}
	public List<Turno> generarTurnosLibres(LocalDate fecha){
		List<Turno> lstTurno = new ArrayList<Turno>(); //Lista de turnos a retornar
		int dia = fecha.getDayOfWeek().getValue(); //Paso la fecha a int
		DiaRetiro diaRetiro = traerDiaRetiro(dia);//Uso traerDiaReiro
		LocalTime hora = diaRetiro.getHoraDesde();//Creo variables fecha y hora
		if(lstDiaRetiro.contains(diaRetiro)) //Si existe DiaRetiro en la lista
		{
			while(hora.equals(diaRetiro.getHoraDesde()) || hora.equals(diaRetiro.getHoraHasta()) || hora.isAfter(diaRetiro.getHoraDesde()) && hora.isBefore(diaRetiro.getHoraHasta()))//Si la hora esta en el rango establecido
			{
				Turno turno = new Turno(fecha, hora, false);//Asigno a turnos sus correspondientes valores
				lstTurno.add(turno);//Si no hago esto no funciona xd
				hora = hora.plusMinutes(diaRetiro.getIntervalo());//Sumo el intervalo
			}
		}
		return lstTurno;//Retorno la lista
	}
	public List<Turno> traerTurnosOcupados(LocalDate fecha){ //Falta desarrollar, devuelve solo un turno ocupado
		List<Turno> lstTurno = new ArrayList<Turno>();
		List<Turno> lstTurnosOcupados = new ArrayList<Turno>();
		lstTurno = generarTurnosLibres(fecha); //Tengo los turnos libres de la fecha indicada
		int index = 0;
		while(index < lstTurno.size())
		{
			int cont = 0;
			while(cont < lstCarrito.size())
			{
				LocalTime horaRetiro = traerHoraRetiro(lstCarrito.get(cont).getFecha());
				if(lstTurno.get(index).getHora().equals(horaRetiro))
				{
					System.out.println("Entre al if");
					lstTurno.get(index).setOcupado(true);
					lstTurnosOcupados.add(lstTurno.get(index));
				}
				cont++;
			}
			index++;
		}
		return lstTurnosOcupados;
	}
	public LocalTime traerHoraRetiro(LocalDate fecha) { //Trae la hora del retiro de un carrito en determinada fecha
		int index = 0;
		RetiroLocal retiro = new RetiroLocal(1, LocalDate.now(), false, LocalTime.now());
		LocalTime horaEntrega = LocalTime.now();
		Carrito carrito = traerCarrito(fecha);
		if(carrito.getFecha().equals(fecha) && carrito.getEntrega() instanceof RetiroLocal)
			{
				retiro = (RetiroLocal)lstCarrito.get(index).getEntrega();
				horaEntrega = retiro.getHoraEntrega();
		}
		return horaEntrega;
	}
}