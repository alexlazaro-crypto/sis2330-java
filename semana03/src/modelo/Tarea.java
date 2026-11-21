package modelo;

public class Tarea {
    private static int siguienteId = 1;
    private final int id;
    private String descripcion;
    private boolean completada;

    public Tarea(String descripcion) {
        this.id = siguienteId++;
        setDescripcion(descripcion);
        this.completada = false;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new IllegalArgumentException("la descripcion no puede estar vacia");
        }
        this.descripcion = descripcion.trim();
    }

    public boolean isCompletada() {
        return completada;
    }

    public void marcarCompletada() {
        this.completada = true;
    }

    @Override
    public String toString() {
        String marca = completada ? "[X]" : "[ ]";
        return marca + " (" + id + ") " + descripcion;
    }
}
