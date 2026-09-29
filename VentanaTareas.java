package actividad02.tda.enjava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class VentanaTareas extends JFrame {
    private JTextField cajaTarea;
    private JTextArea areaResultados;
    private ArrayList<Tarea> listaTareas;

    public VentanaTareas() {
        listaTareas = new ArrayList<>();

        setTitle("Gestor de Tareas");
        setSize(500, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Título centrado
        JLabel lblTitulo = new JLabel("Gestor de Tareas", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Dialog", Font.BOLD, 16));
        lblTitulo.setBounds(150, 10, 200, 30);
        add(lblTitulo);

        // Nueva tarea + caja
        JLabel lblTarea = new JLabel("Nueva tarea:");
        lblTarea.setBounds(50, 60, 100, 25);
        add(lblTarea);

        cajaTarea = new JTextField();
        cajaTarea.setBounds(150, 60, 300, 25);
        add(cajaTarea);

        // Fila 1 de botones
        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(50, 100, 120, 35);
        add(btnAgregar);

        JButton btnVer = new JButton("Ver Todas");
        btnVer.setBounds(190, 100, 120, 35);
        add(btnVer);

        JButton btnReves = new JButton("Ver al revés");
        btnReves.setBounds(330, 100, 130, 35);
        add(btnReves);

        // Fila 2 de botones
        JButton btnContar = new JButton("Contar");
        btnContar.setBounds(50, 150, 120, 35);
        add(btnContar);

        JButton btnBorrar = new JButton("Borrar Todo");
        btnBorrar.setBounds(190, 150, 120, 35);
        add(btnBorrar);

        // Etiqueta Resultados
        JLabel lblResultados = new JLabel("Resultados:");
        lblResultados.setBounds(50, 200, 100, 25);
        add(lblResultados);

        // Recuadro grande de resultados
        areaResultados = new JTextArea();
        areaResultados.setBounds(50, 225, 400, 120);
        areaResultados.setEditable(false);
        areaResultados.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(areaResultados);

        // Nombre abajo
        JLabel lblNombre = new JLabel("Desarrollado por: CARLOS DANIEL ALONSO HERNANDEZ", SwingConstants.CENTER);
        lblNombre.setBounds(50, 360, 400, 25);
        add(lblNombre);

        // === FUNCIONES ===

        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String texto = cajaTarea.getText().trim();
                if (texto.isEmpty()) {
                    areaResultados.setText("Escribe algo primero");
                    return;
                }
                listaTareas.add(new Tarea(texto));
                areaResultados.setText("Agregado: " + texto);
                cajaTarea.setText("");
            }
        });

        btnVer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (listaTareas.isEmpty()) {
                    areaResultados.setText("No hay tareas guardadas");
                    return;
                }
                StringBuilder sb = new StringBuilder("=== LISTA DE TAREAS ===\n");
                for (int i = 0; i < listaTareas.size(); i++) {
                    sb.append((i+1) + ". " + listaTareas.get(i).mostrar() + "\n");
                }
                areaResultados.setText(sb.toString());
            }
        });

        btnReves.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (listaTareas.isEmpty()) {
                    areaResultados.setText("No hay tareas guardadas");
                    return;
                }
                Tarea[] arr = new Tarea[listaTareas.size()];
                listaTareas.toArray(arr);
                areaResultados.setText("=== EN ORDEN INVERSO ===\n" + Tarea.listarAlReves(arr, arr.length - 1));
            }
        });

        btnContar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int total = listaTareas.size();
                int hechas = 0;
                for (Tarea t : listaTareas) {
                    if (t.getEstaHecha()) hechas++;
                }
                areaResultados.setText(
                    "Total: " + total + "\n" +
                    "Terminadas: " + hechas + "\n" +
                    "Pendientes: " + (total - hechas)
                );
            }
        });

        btnBorrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listaTareas.clear();
                areaResultados.setText("Lista vacía");
                cajaTarea.setText("");
            }
        });
    }
}