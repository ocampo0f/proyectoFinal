package Service;

import java.util.Date;

public class Venta {
    private IVehiculo vehiculo; // Cambiar 'Vehiculo' a 'IVehiculo'
    private Cliente cliente;
    private Date fechaVenta;
    private double precioVenta;

    // Constructor
    public Venta(IVehiculo vehiculo, Cliente cliente, double precioVenta) {
        this.vehiculo = vehiculo;
        this.cliente = cliente;
        this.precioVenta = precioVenta;
        this.fechaVenta = new Date(); // Fecha actual de la venta
    }

    // Métodos Getters
    public IVehiculo getVehiculo() {
        return vehiculo; // Esto ahora devuelve un IVehiculo
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    @Override
    public String toString() {
        return "Venta [vehiculo=" + vehiculo.getMarca() + " " + vehiculo.getModelo() +
               ", cliente=" + cliente.getNombre() +
               ", fechaVenta=" + fechaVenta +
               ", precioVenta=" + precioVenta + "]";
    }
}

