package modelo;

public class Cliente extends Actor{
	private String apellido;
	private String nombre;
	private int dni;
	private char sexo;

	public Cliente(int id, Contacto contacto, String apellido, String nombre, int dni, char sexo) {
		super(id, contacto);
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni = dni;
		this.sexo = sexo;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return "Cliente [apellido=" + apellido + ", nombre=" + nombre + ", dni=" + dni + ", sexo=" + sexo + "]";
	}

	@Override
	protected boolean validarIdentificadorUnico(int dni) {
		String validar =  String.valueOf(dni);
		boolean result = false;
		if(validar.matches("[0-9]*"))//Si contiene valores de 0 a 9
		{
			result = true;
		}
		if(validar.length() != 8) //Si la longitud no es valida
		{
			result = false;
		}
		return result;
	}
}
