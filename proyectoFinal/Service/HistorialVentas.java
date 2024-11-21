package Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HistorialVentas {
    private List<Venta> ventas;

    public HistorialVentas() {
        this.ventas = new ArrayList<>();
    }

    public void registrarVenta(Venta venta) {
        ventas.add(venta);
    }

    public List<Venta> consultarVentasPorCliente(String nombreCliente) {
        List<Venta> ventasPorCliente = new ArrayList<>();
        for (Venta venta : ventas) {
            if (venta.getCliente().getNombre().equalsIgnoreCase(nombreCliente)) {
                ventasPorCliente.add(venta);
            }
        }
        return ventasPorCliente;
    }

    public List<Venta> consultarVentasPorVehiculo(String marca, String modelo) {
        List<Venta> ventasPorVehiculo = new ArrayList<>();
        for (Venta venta : ventas) {
            if (venta.getVehiculo().getMarca().equalsIgnoreCase(marca) &&
                venta.getVehiculo().getModelo().equalsIgnoreCase(modelo)) {
                ventasPorVehiculo.add(venta);
            }
        }
        return ventasPorVehiculo;
    }

    public List<Venta> consultarVentasPorFecha(Date inicio, Date fin) {
        List<Venta> ventasPorFecha = new ArrayList<>();
        for (Venta venta : ventas) {
            if (venta.getFechaVenta().after(inicio) && venta.getFechaVenta().before(fin)) {
                ventasPorFecha.add(venta);
            }
        }
        return ventasPorFecha;
    }

    public void mostrarVentas() {
        if (ventas.isEmpty()) {
            System.out.println("No hay ventas registradas.");
        } else {
            for (Venta venta : ventas) {
                System.out.println(venta);
            }
        }
    }
}
