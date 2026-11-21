package app;

import modelo.Auto;
import modelo.AutoElectrico;
import modelo.Camion;
import modelo.Electrico;
import modelo.Moto;
import modelo.Vehiculo;
import java.util.ArrayList;

public class GestionVehiculos {
    public static void main(String[] args) {
        ArrayList<Vehiculo> flota = new ArrayList<Vehiculo>();
        flota.add(new Auto("Toyota", "Corolla", 180, 4));
        flota.add(new Moto("Honda", "CB500", 200, false));
        flota.add(new Camion("Volvo", "FH16", 130, 25.0));
        flota.add(new AutoElectrico("Tesla", "Model 3", 225, 4));

        for (Vehiculo v : flota) {
            System.out.println(v.describir());
            if (v instanceof Electrico) {
                Electrico e = (Electrico) v;
                e.cargarBateria();
                System.out.println("bateria cargada -> " + v.describir());
            }
        }
    }
}
