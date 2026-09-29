/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad02.tda.enjava;

/**
 *
 * @author Pablo
 */
public class TareaImportante extends Tarea {
    // Atributo extra
    private int nivelPrioridad;

    // Constructor
    public TareaImportante(String descripcion, int prioridad) {
        super(descripcion); // Llama al constructor de la clase padre
        if (prioridad >= 1 && prioridad <= 5) {
            this.nivelPrioridad = prioridad;
        } else {
            this.nivelPrioridad = 3;
        }
    }

    // Getter y Setter
    public int getNivelPrioridad() {
        return nivelPrioridad;
    }

    public void setNivelPrioridad(int p) {
        if (p >= 1 && p <= 5) {
            nivelPrioridad = p;
        }
    }

    // Método de lógica extra
    public boolean esUrgente() {
        return nivelPrioridad >= 4;
    }

    @Override
    public String mostrar() {
        return "[PRIORIDAD " + nivelPrioridad + "] " + super.mostrar();
    }
}
