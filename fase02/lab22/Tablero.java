import javax.swing.*;
import java.util.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Image;

public class Tablero extends JFrame {

    private static final int COLUMN = 10;
    private static final int ROW = 10;

    private JButton[][] casillas;

    private static ArrayList<ArrayList<Soldier>> a;
    private static ArrayList<ArrayList<Soldier>> b;

    public Tablero(Army army1, Army army2, String kingdom1, String kingdom2) {

        a = army1.getArmyInArrayListBi();
        b = army2.getArmyInArrayListBi();

        casillas = new JButton[ROW][COLUMN];
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Tablero de Juego");
        setLayout(new GridLayout(ROW, COLUMN));

        casillas = new JButton[ROW][COLUMN];

        // Iconos para diferentes tipos de soldados
        ImageIcon arqueroIcon = new ImageIcon("img/arquero.png");
        Image arqueroImage = arqueroIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon resizedArqueroIcon = new ImageIcon(arqueroImage);

        ImageIcon caballeroIcon = new ImageIcon("img/caballero.png");
        Image caballeroImage = caballeroIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon resizedCaballeroIcon = new ImageIcon(caballeroImage);

        ImageIcon lanceroIcon = new ImageIcon("img/lancero.png");
        Image lanceroImage = lanceroIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon resizedLanceroIcon = new ImageIcon(lanceroImage);

        ImageIcon espadachinIcon = new ImageIcon("img/espadachin.png");
        Image espadachinImage = espadachinIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon resizedEspadachinIcon = new ImageIcon(espadachinImage);

        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                JButton boton;

                // 0:archer 1:Knight 2:Spearman 3:Swordsman 5:total
                // En la guia se nos pide contabilizar los objetos
                if (a.get(i).get(j) != null) {
                    Soldier sol = a.get(i).get(j);  
                    boton = new JButton();
                    if (0 == Army.typeSoldier(sol)) {
                        boton.setIcon(resizedArqueroIcon);
                    } else if (1 == Army.typeSoldier(sol)) {
                        boton.setIcon(resizedCaballeroIcon);
                    } else if ( 2 == Army.typeSoldier(sol)) {
                        boton.setIcon(resizedLanceroIcon);
                    } else if (3 == Army.typeSoldier(sol)) {
                        boton.setIcon(resizedEspadachinIcon);
                    }
                    boton.setBorder(BorderFactory.createLineBorder(Color.RED));
                } else if (b.get(i).get(j) != null) {
                    Soldier sol = b.get(i).get(j);  
                    boton = new JButton();
                    if (0 == Army.typeSoldier(sol)) {
                        boton.setIcon(resizedArqueroIcon);
                    } else if (1 == Army.typeSoldier(sol)) {
                        boton.setIcon(resizedCaballeroIcon);
                    } else if ( 2 == Army.typeSoldier(sol)) {
                        boton.setIcon(resizedLanceroIcon);
                    } else if (3 == Army.typeSoldier(sol)) {
                        boton.setIcon(resizedEspadachinIcon);
                    }
                    boton.setBorder(BorderFactory.createLineBorder(Color.BLUE));
                } else {
                    boton = new JButton();
                }

                casillas[i][j] = boton;
                add(boton);
            }
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        String kingdom1;
        String kingdom2;
        Scanner sc = new Scanner(System.in);
        System.out.println("Elija su reino (Francia, Inglaterra, Moros, Roma, Castilla)");
        kingdom1 = sc.next();

        System.out.println("Elija su reino (Francia, Inglaterra, Moros, Roma, Castilla)");
        kingdom2 = sc.next();

        Army a = new Army(kingdom1);
        Army b = new Army(kingdom2);
        a.generateArmy(b);
        b.generateArmy(a);

        Tablero tab = new Tablero(a, b, kingdom1, kingdom2);

        a.showArmy();
        System.out.println();
        b.showArmy();
        System.out.println();

    }

}
