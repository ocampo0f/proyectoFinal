package Service;

import java.util.ArrayList;

public class Inventario {
	private String nombre;
	private ArrayList<Vehiculo> vehiculos;
	
	public Inventario(String nombre) {
		this.nombre = nombre;
		this.vehiculos = new ArrayList<>();
	}
	
	public Vehiculo buscarVehiculos(String vid){
		for (Vehiculo vehiculo : this.vehiculos) {
			if (vehiculo.getVid().equalsIgnoreCase(vid)) {
				return vehiculo;
			}
		}
		return null;	
	}
	public String infoVehiculos(Vehiculo vehiculo ) {
		String mensaje = "";
		if( vehiculo instanceof Automovil) {
			Automovil a = (Automovil) vehiculo;
			mensaje = a.toString();
		}else if (vehiculo instanceof Motocicleta) {
			Motocicleta m = (Motocicleta) vehiculo;
			mensaje = m.toString();
		}else if(vehiculo instanceof Motocicleta){
			Camion c = (Camion) vehiculo;
			mensaje = c.toString();
		}
		return mensaje;
    }
	
	//metodos automovil
	public boolean crearAutomovil(Automovil automovil) {
		if (isAutomovilExistente(automovil) == false) {
			vehiculos.add(automovil);
			return true;
		}
		return false;
	}
	public boolean isAutomovilExistente(Automovil automovil) {
		for (Vehiculo v : vehiculos) {
			String vid = automovil.getVid();
			if (v.getVid().equalsIgnoreCase(vid)) {
				return true;
			}
		}
		return false;
	}
	public boolean eliminarAuntomovil(String vid) {
		for (Vehiculo v : vehiculos) {
			if (v.getVid().equalsIgnoreCase(vid)) {
				vehiculos.remove(v);
			return true;
			}
		}
		return false;
	}
	public void actualizarAuntomovil(String marca, String modelo, String vid, String color, int kilometrage, String año, int numPuertas,
			String tipoCombustible, String tipoTransmicion, String tipoTraccion, Automovil a) {
		a.setAño(año);
		a.setColor(color);
		a.setKilometraje(kilometrage);
		a.setMarca(marca);
		a.setModelo(modelo);
		a.setVid(vid);
		a.setNumPuertas(numPuertas);
		a.setTipoCombustible(tipoCombustible);
		a.setTipoTraccion(tipoTraccion);
		a.setTipoTransmicion(tipoTransmicion);
	}
	
	//metodos motocicleta
	public boolean crearMotocicleta(Motocicleta motocicleta) {
		if (isMotocicletaExistente(motocicleta) == false) {
			vehiculos.add(motocicleta);
			return true;
		}
		return false;
	}
	public boolean isMotocicletaExistente(Motocicleta motocicleta) {
		for (Vehiculo v : vehiculos) {
			String vid = motocicleta.getVid();
			if (v.getVid().equalsIgnoreCase(vid)) {
				return true;
			}
		}
		return false;
	}
	public boolean eliminalMOtocicleta(String vid) {
		for (Vehiculo v : vehiculos) {
			if (v.getVid().equalsIgnoreCase(vid)) {
			vehiculos.remove(v);
			return true;
			}
		}
		return false;
	}
	public void actualizarMotocicleta(String marca, String modelo, String vid, String color, int kilometrage, String año,
			String tipoManillar, int numRuedas, String tipoFreno, String cilindrada, Motocicleta m) {
		m.setAño(año);
		m.setColor(color);
		m.setKilometraje(kilometrage);
		m.setMarca(marca);
		m.setModelo(modelo);
		m.setVid(vid);
		m.setTipoManillar(tipoManillar);
		m.setCilindrada(cilindrada);
		m.setNumRuedas(numRuedas);
		m.setTipoFreno(tipoFreno);
	}

	//metodos camion
	public boolean crearCamion(Camion camion) {
		if (isCamionExistente(camion) == false) {
			vehiculos.add(camion);
			return true;
		}
		return false;
	}
	public boolean isCamionExistente(Camion camion) {
		for (Vehiculo v : vehiculos) {
			String vid = camion.getVid();
			if (v.getVid().equalsIgnoreCase(vid)) {
			return true;
			}
		}
		return false;
	}
	public boolean eliminarCamion(String vid) {
		for (Vehiculo v : vehiculos) {
			if (v.getVid().equalsIgnoreCase(vid)) {
			vehiculos.remove(v);
			return true;
			}
		}
		return false;
	}
	public void actualizarCamion(String marca, String modelo, String vid, String color, int kilometrage, String año,
			String capacidadCarga, String tipoCamion, int longitud, int numEjes, Camion c) {
		c.setAño(año);
		c.setCapacidadCarga(capacidadCarga);
		c.setColor(color);
		c.setKilometraje(kilometrage);
		c.setLongitud(longitud);
		c.setMarca(marca);
		c.setModelo(modelo);
		c.setNumEjes(numEjes);
		c.setTipoCamion(tipoCamion);
		c.setVid(vid);
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
