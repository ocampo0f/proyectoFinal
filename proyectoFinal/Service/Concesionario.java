package Service;

import java.util.ArrayList;

public class Concesionario {
	private String nombre;
	private Inventario i;
	private ArrayList<Venta> ventas;
	private ArrayList<Mantenimiento> mantenimientos;
	private ArrayList<Cliente> clientes;
	

	public Concesionario(String nombre) {
		this.nombre = nombre;
		this.i = new Inventario("inventario");
		this.ventas = new ArrayList<>();
		this.mantenimientos = new ArrayList<>();
		
		this.clientes = new ArrayList<>();
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}
	
	// metodos cliente 
	public boolean ExisteCliente(Cliente cliente) {
		for (Cliente c : this.clientes) {
			String telefono = c.getNumeroTelefono();
			if (telefono.equalsIgnoreCase(cliente.getNumeroTelefono())) {
				return true;
			}
		}
		return false;
	}
	public boolean agregarCliente(Cliente cliente) {
		if (ExisteCliente(cliente) != true) {
			this.clientes.add(cliente);
			return true;
		}
		return false;
	}
	public Cliente buscarCliente(String numero) {
		for (Cliente c : this.clientes) {
			if (numero.equalsIgnoreCase(c.getNumeroTelefono())) {
				return c;
			}
		}
		return null;
	}
	public boolean eliminarCliente(String numero) {
		for (Cliente c : this.clientes) {
			if (numero.equalsIgnoreCase(c.getNumeroTelefono())) {
				clientes.remove(c);
				return true;
			}
		}
		return false;
	}
	public void actualizarCliente(String nombre, String direccion, String numerotelefono, String correo, Cliente c) {
		this.clientes.remove(c);
		c.setNombre(nombre);
		c.setDireccion(direccion);
		c.setNumeroTelefono(numerotelefono);
		c.setCorreo(correo);
		this.clientes.add(c);
		
	}

	public String infoCliente(Cliente c) {
		String mensaje = c.toString();
		return mensaje;
	} 
// METODOS DE MANTENIMIENTO  :)
	public void agregarMantenimiento(Mantenimiento m) {
		this.mantenimientos.add(m);
	}
			
	public boolean isVehiculoExisteMantenimiento(String vid) {
		for(Mantenimiento man:this.mantenimientos) {
			if(man.getVehiculoMantenimiento().getVid().equals(vid)) {
				return true;
			}
			
		} 
		return false;
	}
	public Mantenimiento buscaMantenimiento(String vid) {
		for(Mantenimiento man:this.mantenimientos) {
			if(man.getVehiculoMantenimiento().getVid().equals(vid)) {
				return man;
			}
			
		} 
		return null;
	}
	public String opcionesMantenimiento(int opc) {
	    switch (opc) {
	        case 1:
	            return "Preventivo";
	        case 2:
	            return "Correctivo";
            default:
	            return "Predictivo";
	        
	        	
	    }
	}
	public String listarMantenimientoVehiculo(String vid) {
		Mantenimiento m=buscaMantenimiento(vid);
		String mensaje="";
		if(m!= null) {
			return mensaje=m.listarMantenimientos();
			
		}
		return mensaje="El vehiculo ingresado no posee mantenimientos";
	}
}
