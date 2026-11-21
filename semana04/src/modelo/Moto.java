package modelo;

public class Moto extends Vehiculo {
    private boolean tieneSidecar;

    public Moto(String marca, String modelo, double velocidadMax, boolean tieneSidecar) {
        super(marca, modelo, velocidadMax);
        this.tieneSidecar = tieneSidecar;
    }

    @Override
    public String describir() {
        String side = tieneSidecar ? "con sidecar" : "sin sidecar";
        return "moto " + marca + " " + modelo + " " + side + " max " + velocidadMax + " km/h";
    }
}
