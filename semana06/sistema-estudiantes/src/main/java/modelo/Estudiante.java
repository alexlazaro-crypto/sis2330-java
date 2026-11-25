package modelo;

import java.util.Objects;

public class Estudiante implements Comparable<Estudiante> {
    private String codigo;
    private String nombre;
    private double promedio;

    public Estudiante(String codigo, String nombre, double promedio) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("codigo vacio");
        }
        if (promedio < 0.0 || promedio > 100.0) {
            throw new IllegalArgumentException("promedio fuera de rango 0 a 100");
        }
        this.codigo = codigo.trim();
        this.nombre = nombre;
        this.promedio = promedio;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        if (promedio < 0.0 || promedio > 100.0) {
            throw new IllegalArgumentException("promedio fuera de rango 0 a 100");
        }
        this.promedio = promedio;
    }

    @Override
    public int compareTo(Estudiante otro) {
        int porProm = Double.compare(otro.promedio, this.promedio);
        if (porProm != 0) {
            return porProm;
        }
        return this.codigo.compareTo(otro.codigo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Estudiante)) {
            return false;
        }
        Estudiante otro = (Estudiante) o;
        return codigo.equals(otro.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public String toString() {
        return codigo + " " + nombre + " (" + promedio + ")";
    }
}
