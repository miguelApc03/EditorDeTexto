package Tema7;

public class Empleado extends Trabajador{
    private double antiguedad;

    public  Empleado (double antiguedad){
        super("nombre", "apellios", 0, "departamento", 0, 0);
        this.antiguedad=antiguedad;
    }
}
