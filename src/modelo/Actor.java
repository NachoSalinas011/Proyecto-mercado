package modelo;
public class Actor {
	private int id;
	protected Contacto contacto;
	public Actor(int id, Contacto contacto) {
		super();
		this.id = id;
		this.contacto = contacto;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Contacto getContacto() {
		return contacto;
	}
	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}
	
	@Override
	public String toString() {
		return "Actor [id=" + id + ", contacto=" + contacto + "]";
	}
	protected boolean validarIdentificadorUnico(int id) { //Valida que el id ingresado sea puramente numerico
		String validar =  String.valueOf(id);
		boolean result = false;
		if(validar.matches("[0-9]*"))
		{
			result = true;
		}
		return result;
	}
}
