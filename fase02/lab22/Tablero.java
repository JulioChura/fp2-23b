import javax.swing.*;
import java.util.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Panel;

public class Tablero extends JFrame {

    private static final int COLUMN = 10;
    private static final int ROW = 10;

    private JButton[][] casillas;

    public Tablero(Army army1, Army army2, String kingdom1, String kingdom2) {

        casillas = new JButton[ROW][COLUMN];
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Tablero de Juego");
        setLayout(new GridLayout(ROW, COLUMN));

        ArrayList<ArrayList<Soldier>> a = army1.getArmyInArrayListBi();
        ArrayList<ArrayList<Soldier>> b = army2.getArmyInArrayListBi();

        casillas = new JButton[ROW][COLUMN];

        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {

                JButton boton;
                if (a.get(i).get(j) != null) {
                    boton = new JButton("a");
                } else if (b.get(i).get(j) != null) {
                    boton = new JButton("b");
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
