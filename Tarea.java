package actividad02.tda.enjava;

public class Tarea {
    private final String descripcion;
    private final boolean estaHecha;

    public Tarea(String descripcion) {
        this.descripcion = (descripcion != null && !descripcion.isEmpty()) ? descripcion : "Sin describir";
        this.estaHecha = false;
    }

    public boolean getEstaHecha() {
        return estaHecha;
    }

    public String obtenerEstado() {
        return estaHecha ? "TERMINADA" : "PENDIENTE";
    }

    public static String listarAlReves(Tarea[] lista, int indice) {
        if (indice < 0) return "";
        return lista[indice].descripcion + " - " + lista[indice].obtenerEstado() + "\n"
             + listarAlReves(lista, indice - 1);
    }

    public String mostrar() {
        return descripcion + " | " + obtenerEstado();
    }
}