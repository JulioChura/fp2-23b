import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.util.concurrent.CountDownLatch;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tablero extends JPanel{

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

    public void init() {
        casillas = new JButton[ROW][COLUMN];

        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                JButton boton;
                String label;
                // 0:archer 1:Knight 2:Spearman 3:Swordsman 5:total
                // En la guia se nos pide contabilizar los objetos
                if (a.get(i).get(j) != null) {
                    Soldier sol = a.get(i).get(j);

                    label = sol.getLabelLife();

                    boton = new JButton(label);
                    boton.setVerticalTextPosition(SwingConstants.CENTER);
                    boton.setHorizontalTextPosition(SwingConstants.CENTER);

                    if (0 == Army.typeSoldier(sol)) {
                        boton.setIcon(typeSoldierIcon(0));
                    } else if (1 == Army.typeSoldier(sol)) {
                        boton.setIcon(typeSoldierIcon(1));
                    } else if (2 == Army.typeSoldier(sol)) {
                        boton.setIcon(typeSoldierIcon(2));
                    } else if (3 == Army.typeSoldier(sol)) {
                        boton.setIcon(typeSoldierIcon(3));
                    }
                    boton.setBackground(Color.red);
                } else if (b.get(i).get(j) != null) {

                    Soldier sol = b.get(i).get(j);

                    label = sol.getLabelLife();

                    boton = new JButton(label);
                    boton.setVerticalTextPosition(SwingConstants.CENTER);
                    boton.setHorizontalTextPosition(SwingConstants.CENTER);
                    if (0 == Army.typeSoldier(sol)) {
                        boton.setIcon(typeSoldierIcon(0));
                    } else if (1 == Army.typeSoldier(sol)) {
                        boton.setIcon(typeSoldierIcon(1));
                    } else if (2 == Army.typeSoldier(sol)) {
                        boton.setIcon(typeSoldierIcon(2));
                    } else if (3 == Army.typeSoldier(sol)) {
                        boton.setIcon(typeSoldierIcon(3));
                    }
                    boton.setBackground(Color.blue);
                } else {
                    boton = new JButton();
                }

                boton.setForeground(Color.WHITE);
                Font font = new Font("Arial", Font.BOLD, 32);
                boton.setFont(font);

                MyButtonListener buttonListener = new MyButtonListener(i, j);
                boton.addActionListener(buttonListener);
                add(boton);
            }
        }
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

    public ImageIcon typeSoldierIcon(int option) {
        // Iconos para diferentes tipos de soldados
        if (option == 0) {
            ImageIcon arqueroIcon = new ImageIcon("img/arquero.png");
            Image arqueroImage = arqueroIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            ImageIcon resizedArqueroIcon = new ImageIcon(arqueroImage);
            return resizedArqueroIcon;
        } else if (option == 1) {
            ImageIcon caballeroIcon = new ImageIcon("img/caballero.png");
            Image caballeroImage = caballeroIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            ImageIcon resizedCaballeroIcon = new ImageIcon(caballeroImage);
            return resizedCaballeroIcon;
        } else if (option == 2) {
            ImageIcon lanceroIcon = new ImageIcon("img/lancero.png");
            Image lanceroImage = lanceroIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            ImageIcon resizedLanceroIcon = new ImageIcon(lanceroImage);
            return resizedLanceroIcon;
        } else {
            ImageIcon espadachinIcon = new ImageIcon("img/espadachin.png");
            Image espadachinImage = espadachinIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            ImageIcon resizedEspadachinIcon = new ImageIcon(espadachinImage);
            return resizedEspadachinIcon;
        }
    }

    public void repintarTablero() {
        getContentPane().removeAll();
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
        } else if (battleField.equalsIgnoreCase("Campo Abierto") || name1.equalsIgnoreCase("Francia")) {
            army1.increaseLife();
        } else if (battleField.equalsIgnoreCase("Campo Abierto") || name2.equalsIgnoreCase("Francia")) {
            army2.increaseLife();
        } else if (battleField.equalsIgnoreCase("Montaña") || name1.equalsIgnoreCase("Castilla-Aragón")) {
            army1.increaseLife();
        } else if (battleField.equalsIgnoreCase("Montaña") || name2.equalsIgnoreCase("Castilla-Aragón")) {
            army2.increaseLife();
        } else if (battleField.equalsIgnoreCase("desierto") || name1.equalsIgnoreCase("Moros")) {
            army1.increaseLife();
        } else if (battleField.equalsIgnoreCase("desierto") || name2.equalsIgnoreCase("Moros")) {
            army2.increaseLife();
        } else if (battleField.equalsIgnoreCase("bosque") && battleField.equalsIgnoreCase("campo abierto")
                && battleField.equalsIgnoreCase("playa") || name1.equalsIgnoreCase("Sacro Imperio Romano")) {
            army1.increaseLife();
        } else if (battleField.equalsIgnoreCase("bosque") && battleField.equalsIgnoreCase("campo abierto")
                && battleField.equalsIgnoreCase("playa") || name2.equalsIgnoreCase("Sacro Imperio Romano")) {
            army2.increaseLife();
        } 
    }

}
