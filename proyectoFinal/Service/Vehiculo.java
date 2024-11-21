package Service;

public abstract class Vehiculo implements IVehiculo{
	protected String marca;
	protected String modelo;
	protected String vid;
	protected String color;
	protected int kilometraje;
	protected String año;

	public Vehiculo(String marca, String modelo, String vid, String color, int kilometrage, String año) {
		this.marca = marca;
		this.modelo = modelo;
		this.vid = vid;
		this.color = color;
		this.kilometraje = kilometrage;
		this.año = año;
	}
	
	public abstract String toString();

	@Override
    public String getMarca() {
        return marca;
    }

    @Override
    public String getModelo() {
        return modelo;
    }

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getVid() {
		return vid;
	}

	public void setVid(String vid) {
		this.vid = vid;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getKilometraje() {
		return kilometraje;
	}

	public void setKilometraje(int kilometraje) {
		this.kilometraje = kilometraje;
	}

	public String getAño() {
		return año;
	}

	public void setAño(String año) {
		this.año = año;
	}

}
