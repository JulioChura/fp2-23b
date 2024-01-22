import javax.swing.*;
import javax.swing.border.Border;

import java.util.*;
import java.awt.*;
import java.util.concurrent.CountDownLatch;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tablero extends JPanel {

    private static final int COLUMN = 10;
    private static final int ROW = 10;

    private JButton[][] casillas;

    private ArrayList<ArrayList<Soldier>> a;
    private ArrayList<ArrayList<Soldier>> b;

    private Army army1;
    private Army army2;

    private String battleField;

    public Tablero(Army army1, Army army2, String battlefield) {

        army1.getName();
        army2.getName();

        this.army1 = army1;
        this.army2 = army2;
        this.battleField = battlefield;

        a = army1.getArmyInArrayListBi();
        b = army2.getArmyInArrayListBi();

        setLayout(new GridLayout(ROW, COLUMN));

        initButtons();
        initColors();
        init();

        setVisible(true);
    }

    // Para crear una matriz de botones sin diseños
    public void initButtons() {
        casillas = new JButton[ROW][COLUMN];
        JButton boton;
        setLayout(new GridLayout(10, 10));

        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                boton = new JButton();
                MyButtonListener buttonListener = new MyButtonListener(i, j);
                boton.addActionListener(buttonListener);
                add(boton);
                casillas[i][j] = boton;

            }
        }
    }

    // Para pintar el tablero al estilo ajedrez y quitar adornos a las casillas
    public void initColors() {
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                casillas[i][j].setIcon(null);
                casillas[i][j].setText("");
                if ((i + j) % 2 == 0) {
                    casillas[i][j].setBackground(new Color(139, 69, 19));
                } else {
                    casillas[i][j].setBackground(new Color(255, 253, 208));
                }

            }
        }
    }

    // Pone encima los iconos
    public void setIconsSoldier(Soldier sol, JButton[][] arreglo, int i, int j) {
        if (0 == Army.typeSoldier(sol)) {
            arreglo[i][j].setIcon(typeSoldierIcon(0));
        } else if (1 == Army.typeSoldier(sol)) {
            arreglo[i][j].setIcon(typeSoldierIcon(1));
        } else if (2 == Army.typeSoldier(sol)) {
            arreglo[i][j].setIcon(typeSoldierIcon(2));
        } else if (3 == Army.typeSoldier(sol)) {
            arreglo[i][j].setIcon(typeSoldierIcon(3));
        } else if (4 == Army.typeSoldier(sol)) {
            arreglo[i][j].setIcon(typeSoldierIcon(3));
        } else if (5 == Army.typeSoldier(sol)) {
            arreglo[i][j].setIcon(typeSoldierIcon(1));
        } else if (6 == Army.typeSoldier(sol)) {
            arreglo[i][j].setIcon(typeSoldierIcon(3));
        } else if (7 == Army.typeSoldier(sol)) {
            arreglo[i][j].setIcon(typeSoldierIcon(1));
        } else if (8 == Army.typeSoldier(sol)) {
            arreglo[i][j].setIcon(typeSoldierIcon(3));
        }
    }

    //Le da el fondo, pone iconos y letra al boton
    public void init() {
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                String label;
                if (a.get(i).get(j) != null) {
                    Soldier sol = a.get(i).get(j);
                    label = sol.getLabelLife();
                    casillas[i][j].setText(label);
                    casillas[i][j].setVerticalTextPosition(SwingConstants.CENTER);
                    casillas[i][j].setHorizontalTextPosition(SwingConstants.CENTER);
                    casillas[i][j].setBackground(Color.red);
                    setIconsSoldier(sol, casillas, i, j);
                } else if (b.get(i).get(j) != null) {
                    Soldier sol = b.get(i).get(j);
                    label = sol.getLabelLife();
                    casillas[i][j].setText(label);
                    casillas[i][j].setVerticalTextPosition(SwingConstants.CENTER);
                    casillas[i][j].setHorizontalTextPosition(SwingConstants.CENTER);
                    casillas[i][j].setBackground(Color.blue);
                    setIconsSoldier(sol, casillas, i, j);
                }

                casillas[i][j].setForeground(Color.WHITE);
                Font font = new Font("Arial", Font.BOLD, 32);
                casillas[i][j].setFont(font);
            }
        }
    }

    public ImageIcon typeSoldierIcon(int option) {
        // Iconos para diferentes tipos de soldados
        String solIcon;
        ImageIcon icon;
        if (option == 0) {
            solIcon = "arquero";
        } else if (option == 1) {
            solIcon = "caballero"; 
        } else if (option == 2) {
            solIcon = "lancero";
        } else {
            solIcon = "espadachin";
        }
        
        icon  = new ImageIcon("img/"+solIcon+".png");
        Image editedIcon = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon resizedEspadachinIcon = new ImageIcon(editedIcon);
        return resizedEspadachinIcon;
    }

    private int fila = 0;
    private int columna = 0;
    // Hace que debe esperar 1 evento
    private CountDownLatch latch = new CountDownLatch(1);

    public class MyButtonListener implements ActionListener {
        private int row;
        private int column;

        public MyButtonListener(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public void actionPerformed(ActionEvent e) {
            fila = row;
            columna = column;
            latch.countDown();

        }
    }

    public int[] getCoordinates() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int[] array = new int[2];
        array[0] = fila;
        array[1] = columna;
        fila = 0;
        columna = 0;

        latch = new CountDownLatch(1);

        return array;

    }

    public void repintarTablero() {
        initColors();
        init();
        revalidate();
        repaint();
    }

    public Army getEjercito1() {
        return army1;
    }

    public Army getEjercito2() {
        return army2;
    }

    public void increaseLife() {
        String name1 = army1.getName();
        String name2 = army2.getName();
        if (battleField.equalsIgnoreCase("bosque") || name1.equals("Inglaterra")) {
            army1.increaseLife();
        } else if (battleField.equalsIgnoreCase("bosque") || name2.equals("Inglaterra")) {
            army2.increaseLife();
        } else if (battleField.equalsIgnoreCase("Campo") || name1.equalsIgnoreCase("Francia")) {
            army1.increaseLife();
        } else if (battleField.equalsIgnoreCase("Campo") || name2.equalsIgnoreCase("Francia")) {
            army2.increaseLife();
        } else if (battleField.equalsIgnoreCase("Montaña") || name1.equalsIgnoreCase("Castilla-Aragon")) {
            army1.increaseLife();
        } else if (battleField.equalsIgnoreCase("Montaña") || name2.equalsIgnoreCase("Castilla-Aragon")) {
            army2.increaseLife();
        } else if (battleField.equalsIgnoreCase("desierto") || name1.equalsIgnoreCase("Moros")) {
            army1.increaseLife();
        } else if (battleField.equalsIgnoreCase("desierto") || name2.equalsIgnoreCase("Moros")) {
            army2.increaseLife();
        } else if (battleField.equalsIgnoreCase("bosque") && battleField.equalsIgnoreCase("campo")
                && battleField.equalsIgnoreCase("playa") || name1.equalsIgnoreCase("Sacro Imperio Romano")) {
            army1.increaseLife();
        } else if (battleField.equalsIgnoreCase("bosque") && battleField.equalsIgnoreCase("campo")
                && battleField.equalsIgnoreCase("playa") || name2.equalsIgnoreCase("Sacro Imperio Romano")) {
            army2.increaseLife();
        }
    }

}
