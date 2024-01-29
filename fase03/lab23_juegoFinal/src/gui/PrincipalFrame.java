package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import logica.Army;
import logica.Player;

public class PrincipalFrame extends JFrame {
    private static int HEIGHT = 1500;
    private static int WIDTH = 900;

    private InformationFrame panelBlue;
    private InformationFrame panelRed;
    private Tablero panelGame;

    private JPanel panel;

    private ImagePanel panelImg;

    private Army armyBlue;
    private Army armyRed;
    private String field;
    private Tablero tablero;
    
    private Player playerBlue;
    private Player playerRed;

    private JPanel panelData;

    public PrincipalFrame(Army armyBlue, Army armyRed, String field, Tablero tablero, Player playerBlue, Player playerRed) {
        this.armyBlue = armyBlue;
        this.armyRed = armyRed;
        this.field = field;
        this.tablero = tablero;
        String name1 = armyBlue.getName();
        String name2 = armyRed.getName();

        setSize(HEIGHT, WIDTH);
        setTitle(name2 + " (Azul) vs " + name1 + " (Rojo)" + ": Combate en: " + field);
        initFrame();
    }

    public void initFrame() {
        setLayout(new GridLayout(1, 3, -43, 4));

        panelBlue = new InformationFrame(armyBlue);
        panelRed = new InformationFrame(armyRed);

        panel = new JPanel();

        panelData = new JPanel();
        panelData.setLayout(new GridLayout(1, 2));
        panelImg = new ImagePanel(field);
        panelData.add(panelBlue);
        panelData.add(panelRed);

        panel.add(panelData);
        panel.add(panelImg);

        add(tablero);
        add(panel);

        // Crear barra de menú
        JMenuBar menuBar = new JMenuBar();

        // Crear menú "Archivo"
        JMenu archivoMenu = new JMenu("Archivo");

        // Agregar opción "Guardar"
        JMenuItem guardarItem = new JMenuItem("Guardar");
        guardarItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para guardar
                if (playerBlue==null || playerRed==null) {
                    JOptionPane.showMessageDialog(rootPane, "No puede guardar porque está en modo partida"
                            + " rápida, regístrese primero!");
                } else {
                    //Deberia implementarse la funcion de poder guardar el estado actual, pero por falta de tiempo se omite                    
                }
                System.out.println("Guardar");
            }
        });
        archivoMenu.add(guardarItem);

        // Agregar opción "Salir"
        JMenuItem salirItem = new JMenuItem("Salir");
        salirItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para salir
                System.exit(0);
            }
        });
        archivoMenu.add(salirItem);

        // Agregar menú "Archivo" a la barra de menú
        menuBar.add(archivoMenu);

        // Establecer la barra de menú en el JFrame
        setJMenuBar(menuBar);

        setVisible(true);
    }

    public void repintarTablero() {
        getContentPane().removeAll();
        initFrame();
        tablero.repintarTablero();
        revalidate();
        repaint();
    }
    
}
