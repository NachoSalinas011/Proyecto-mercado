package modelo;

public class Articulo {
	private int id;
	private String nombre;
	private String codBarras;
	private double precio;
	public Articulo(int id, String nombre, String codBarras, double precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.codBarras = codBarras;
		this.precio = precio;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodBarras() {
		return codBarras;
	}
	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Articulo [id=" + id + ", nombre=" + nombre + ", codBarras=" + codBarras + ", precio=" + precio + "]";
	}
	public double redondearMultiplo(double num, int multiplo) { //Metodo usado para realizar la validacion de codigo de barras
		double resultado= 0;
		if(num%10 == 0)//Si el numero ya es multiplo de 10
		{
			resultado = num;
		}else
		{
			resultado =Math.round((num + (double)multiplo/2)/multiplo)*multiplo;
		}
		return resultado;//Devuelve un numero redondeado a un multiplo, pasados por parametros
	}
	public boolean validarCodBarras () {
		boolean result = false;
		char[] arrayChar = this.codBarras.toCharArray(); //Lo pasamos a Array de char
		int digitoVerificador = Integer.parseInt(String.valueOf(arrayChar[arrayChar.length-1])); //El digito verificador obtenido por parametro
		int sumaPar =0, sumaImpar=0, sumaTotal= 0;// Variables a usar
		int digitoObtenido;
		for(int i =0; i<arrayChar.length-1; i++) //Para todos los valores del codigo de barras
		{
			if(i%2 == 0)
			{
				sumaPar+= Integer.parseInt(String.valueOf(arrayChar[i])); //Se suman posiciones pares
			}
			if(i%2 != 0)
			{
				sumaImpar += Integer.parseInt(String.valueOf(arrayChar[i]));//Se suman posiciones impares
			}
		}
		sumaImpar= sumaImpar *3; //La suma impar se multiplica por 3
		sumaTotal= sumaPar + sumaImpar; //La suma total es la suma de los pares + el resultado de la multiplicacion anterior
		double redondeo = redondearMultiplo(sumaTotal, 10); //Se redondea el total por el multiplo de 10 mas proximo
		digitoObtenido= (int)redondeo - sumaTotal; //El digito verificador obtenido será el redondeo - la suma del total
		if(digitoVerificador == digitoObtenido) //Si el digito verificador pasado por parametro corresponde con el calculado
		{
			result = true; //Devolvera true
		}
		if(codBarras.length() != 13)//De lo contrario, o si el codigo de barras es dinstinto a un largo de 13 digitos, devolvera falso
		{
			result = false;
		}
		return result;
	}
}
