package Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class GUI extends JFrame implements IVehiculo {
    private Concesionario concesionario;
    private JTable ventasTable;
    private DefaultTableModel ventasTableModel;

    public GUI() {
        // Inicialización del concesionario
        concesionario = new Concesionario("Concesionario ABC");

        // Configuración de la ventana principal
        setTitle("Concesionario ABC");
        setSize(800, 600);
        setLocationRelativeTo(null); // Centra la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Layout
        setLayout(new BorderLayout());

        // Panel de botones y acciones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, 1, 5, 5));

        JButton btnAgregarCliente = new JButton("Agregar Cliente");
        JButton btnMostrarVentas = new JButton("Ver Historial de Ventas");
        JButton btnBuscarCliente = new JButton("Buscar Cliente");
        JButton btnAgregarVenta = new JButton("Registrar Venta");

        buttonPanel.add(btnAgregarCliente);
        buttonPanel.add(btnMostrarVentas);
        buttonPanel.add(btnBuscarCliente);
        buttonPanel.add(btnAgregarVenta);

        add(buttonPanel, BorderLayout.WEST);

        // Tabla para mostrar ventas
        ventasTableModel = new DefaultTableModel(new Object[] { "Marca", "Modelo", "Cliente", "Fecha Venta", "Precio" }, 0);
        ventasTable = new JTable(ventasTableModel);
        JScrollPane scrollPane = new JScrollPane(ventasTable);
        add(scrollPane, BorderLayout.CENTER);

        // Acciones de los botones
        btnAgregarCliente.addActionListener(e -> mostrarFormularioCliente());
        btnMostrarVentas.addActionListener(e -> mostrarHistorialVentas());
        btnBuscarCliente.addActionListener(e -> buscarCliente());
        btnAgregarVenta.addActionListener(e -> registrarVenta());
    }

    private void mostrarFormularioCliente() {
        // Crear ventana para agregar cliente
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 5, 5));

        JTextField nombreField = new JTextField();
        JTextField direccionField = new JTextField();
        JTextField telefonoField = new JTextField();
        JTextField correoField = new JTextField();

        panel.add(new JLabel("Nombre:"));
        panel.add(nombreField);
        panel.add(new JLabel("Dirección:"));
        panel.add(direccionField);
        panel.add(new JLabel("Teléfono:"));
        panel.add(telefonoField);
        panel.add(new JLabel("Correo:"));
        panel.add(correoField);

        int option = JOptionPane.showConfirmDialog(this, panel, "Agregar Cliente", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (option == JOptionPane.OK_OPTION) {
            // Validación
            String nombre = nombreField.getText();
            String direccion = direccionField.getText();
            String telefono = telefonoField.getText();
            String correo = correoField.getText();

            if (nombre.isEmpty() || direccion.isEmpty() || telefono.isEmpty() || correo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.");
            } else {
                Cliente cliente = new Cliente(nombre, direccion, telefono, correo);
                if (concesionario.agregarCliente(cliente)) {
                    JOptionPane.showMessageDialog(this, "Cliente agregado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "El cliente ya existe.");
                }
            }
        }
    }

    private void mostrarHistorialVentas() {
        // Limpiar la tabla
        ventasTableModel.setRowCount(0);

        // Consultar historial de ventas
        List<Venta> ventas = concesionario.getHistorialVentas().consultarVentasPorCliente("Juan Pérez");

        // Mostrar en la tabla
        for (Venta venta : ventas) {
            ventasTableModel.addRow(new Object[] { venta.getVehiculo().getMarca(), venta.getVehiculo().getModelo(),
                venta.getCliente().getNombre(), venta.getFechaVenta(), venta.getPrecioVenta() });
        }
    }

    private void buscarCliente() {
        String telefono = JOptionPane.showInputDialog(this, "Ingrese el teléfono del cliente:");
        if (telefono != null && !telefono.isEmpty()) {
            Cliente cliente = concesionario.buscarCliente(telefono);
            if (cliente != null) {
                JOptionPane.showMessageDialog(this, "Cliente encontrado:\n" + cliente);
            } else {
                JOptionPane.showMessageDialog(this, "Cliente no encontrado.");
            }
        }
    }

    private void registrarVenta() {
        // Crear ventana para registrar venta
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 5, 5));

        JTextField marcaField = new JTextField();
        JTextField modeloField = new JTextField();
        JTextField precioField = new JTextField();

        panel.add(new JLabel("Marca:"));
        panel.add(marcaField);
        panel.add(new JLabel("Modelo:"));
        panel.add(modeloField);
        panel.add(new JLabel("Precio:"));
        panel.add(precioField);

        int option = JOptionPane.showConfirmDialog(this, panel, "Registrar Venta", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (option == JOptionPane.OK_OPTION) {
            // Validación
            String marca = marcaField.getText();
            String modelo = modeloField.getText();
            String precioText = precioField.getText();

            if (marca.isEmpty() || modelo.isEmpty() || precioText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.");
            } else {
                try {
                    double precio = Double.parseDouble(precioText);
                    IVehiculo vehiculo = new VehiculoConcreto(marca, modelo, "VID123", "Rojo", 10000, "2022");
                    Cliente cliente = new Cliente("Juan Pérez", "Calle Ficticia 123", "123456789", "juan@email.com");
                    Venta venta = new Venta(vehiculo, cliente, precio);
                    concesionario.getHistorialVentas().registrarVenta(venta);
                    JOptionPane.showMessageDialog(this, "Venta registrada exitosamente.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "El precio debe ser un número válido.");
                }
            }
        }
    }
}
