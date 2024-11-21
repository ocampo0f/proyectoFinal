package Service;

public class VehiculoConcreto extends Vehiculo {
    public VehiculoConcreto(String marca, String modelo, String vid, String color, int kilometraje, String año) {
        super(marca, modelo, vid, color, kilometraje, año);
    }

    @Override
    public String toString() {
        return "VehiculoConcreto [marca=" + marca + ", modelo=" + modelo + ", año=" + año + "]";
    }
}
