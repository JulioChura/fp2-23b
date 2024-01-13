import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Panel;

public class Tablero extends JFrame {

    private static final int COLUMN = 10;
    private static final int ROW = 10;

    private JButton[][] casillas;

    public Tablero(int filas, int columnas) {
        casillas = new JButton[filas][columnas];
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Tablero de Juego");
        setLayout(new GridLayout(filas, columnas));

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                JButton boton = new JButton();
                casillas[i][j] = boton;
                add(boton);
            }
        }
        setVisible(true);
    }

    public static void main(String[] args) {
        Tablero tab = new Tablero(10,10);
    }
}
