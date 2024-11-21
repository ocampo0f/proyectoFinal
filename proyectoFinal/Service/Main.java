package Service;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Crear y mostrar la GUI
        SwingUtilities.invokeLater(() -> new GUI().setVisible(true));
    }
}
