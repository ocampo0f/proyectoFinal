package Service;

public class Cliente {
	private String nombre;
	private String direccion;
	private String numeroTelefono;
	private String correo;

	public Cliente(String nombre, String direccion, String numeroTelefono, String correo) {
		if(nombre == null||direccion==null||numeroTelefono==null||correo ==null) {
            throw new IllegalArgumentException("El cliente no puede tener atibutos vacíos.");
		}
		this.nombre = nombre;
		this.direccion = direccion;
		this.numeroTelefono = numeroTelefono;
		this.correo = correo;
	}
	public Cliente(String string, String string2) {
		// TODO Auto-generated constructor stub
	}
	public String toString() {
		return "Cliente [nombre=" + nombre + ", direccion=" + direccion + ", numeroTelefono=" + numeroTelefono
				+ ", correo=" + correo + "]";
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getNumeroTelefono() {
		return numeroTelefono;
	}
	
	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}
}
