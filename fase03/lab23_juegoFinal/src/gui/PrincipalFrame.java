package gui;


import javax.swing.*;
import java.awt.*;
import logica.Army;

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

    private JPanel panelData;

    /*
     * En el constructor se pudo solo obtener solo el tablero y desde el constructor
     * extraer
     * los ejercitos, pero se aprovechara los objetos que fueron creados en la clase
     * Aplicacion.java
     */

    public PrincipalFrame(Army armyBlue, Army armyRed, String field, Tablero tablero) {
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

    // Inicia los componentes del JFrame
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

        setVisible(true);
    }

    // Repinta el tablero en cada turno
    public void repintarTablero() {
        getContentPane().removeAll();
        initFrame();
        tablero.repintarTablero();
        revalidate();
        repaint();
    }
}
