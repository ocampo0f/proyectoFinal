package Service;

import java.util.ArrayList;
import java.time.LocalDate;

public class Mantenimiento {
	private Vehiculo vehiculoMantenimiento;
	private ArrayList<String> tipoMantenimiento;
	private ArrayList<Long> costoMantenimiento;
	private ArrayList<LocalDate> fechaMantenimiento;

	public Mantenimiento(Vehiculo vehiculoMantenimiento) {
		this.vehiculoMantenimiento = vehiculoMantenimiento;
		this.tipoMantenimiento = new ArrayList<>();
		this.costoMantenimiento = new ArrayList<>();
		this.fechaMantenimiento = new ArrayList<>();
	}

	public Vehiculo getVehiculoMantenimiento() {
		return vehiculoMantenimiento;
	}

	public void setVehiculoMantenimiento(Vehiculo vehiculoMantenimiento) {
		this.vehiculoMantenimiento = vehiculoMantenimiento;
	}

	public ArrayList<String> getTipoMantenimiento() {
		return tipoMantenimiento;
	}

	public void setTipoMantenimiento(String tipoMantenimiento) {
		this.tipoMantenimiento.add(tipoMantenimiento);
	}

	public ArrayList<Long> getCostoMantenimiento() {
		return costoMantenimiento;
	}

	public void setCostoMantenimiento(long costoMantenimiento) {
		this.costoMantenimiento.add(costoMantenimiento);
	}

	public ArrayList<LocalDate> getFechaMantenimiento() {
		return fechaMantenimiento;
	}

	public void setFechaMantenimiento(LocalDate fechaMantenimiento) {
		this.fechaMantenimiento.add(fechaMantenimiento);
	}
	public void agregarMantenimiento(String TipoMantenimiento,long costo) {
		this.tipoMantenimiento.add(TipoMantenimiento);
		this.costoMantenimiento.add(costo);
		this.fechaMantenimiento.add(LocalDate.now()); 
	}

	public String listarMantenimientos() {
		String mensaje = "";
		if (this.costoMantenimiento.size() > 0) {
			for (int p = 0; p < this.costoMantenimiento.size(); p++) {
				mensaje +="Mantenimiento " + " Costo:" + this.costoMantenimiento.get(p) + " Tipo mantenimiento:"
						+ this.tipoMantenimiento.get(p) + " Fecha Mantenimiento:" + this.fechaMantenimiento.get(p)
						+ ".\n";
			}
			return mensaje;
		}
		return mensaje="No hay matenimientos registrados";

	}

}
