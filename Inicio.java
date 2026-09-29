package actividad02.tda.enjava;

import javax.swing.*;

public class Inicio {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaTareas().setVisible(true));
    }
}