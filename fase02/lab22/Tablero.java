import javax.swing.*;
import java.util.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Image;
import java.awt.*;
import java.awt.event.*;

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

        init();

        setVisible(true);
    }

    public void init() {
        casillas = new JButton[ROW][COLUMN];

        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                JButton boton;

                // 0:archer 1:Knight 2:Spearman 3:Swordsman 5:total
                // En la guia se nos pide contabilizar los objetos
                if (a.get(i).get(j) != null) {
                    Soldier sol = a.get(i).get(j);
                    boton = new JButton();
                    if (0 == Army.typeSoldier(sol)) {
                        boton.setIcon(typeSoldierIcon(0));
                    } else if (1 == Army.typeSoldier(sol)) {
                        boton.setIcon(typeSoldierIcon(1));
                    } else if (2 == Army.typeSoldier(sol)) {
                        boton.setIcon(typeSoldierIcon(2));
                    } else if (3 == Army.typeSoldier(sol)) {
                        boton.setIcon(typeSoldierIcon(3));
                    }
                    boton.setBorder(BorderFactory.createLineBorder(Color.RED));
                } else if (b.get(i).get(j) != null) {
                    Soldier sol = b.get(i).get(j);
                    boton = new JButton();
                    if (0 == Army.typeSoldier(sol)) {
                        boton.setIcon(typeSoldierIcon(0));
                    } else if (1 == Army.typeSoldier(sol)) {
                        boton.setIcon(typeSoldierIcon(1));
                    } else if (2 == Army.typeSoldier(sol)) {
                        boton.setIcon(typeSoldierIcon(2));
                    } else if (3 == Army.typeSoldier(sol)) {
                        boton.setIcon(typeSoldierIcon(3));
                    }
                    boton.setBorder(BorderFactory.createLineBorder(Color.BLUE));
                } else {
                    boton = new JButton();
                }

                MyButtonListener buttonListener = new MyButtonListener(i, j);
                boton.addActionListener(buttonListener);
                casillas[i][j] = boton;
                add(boton);
            }
        }
    }

    public class MyButtonListener implements ActionListener {
        private int row;
        private int column;

        private int turnos = 1;

        private int rowPast;
        private int columnPast;

        private boolean actualTurn = true;

        private boolean primerClick = true;

        private int lifeA;
        private int lifeB;

        private Soldier solA;
        private Soldier solB;

        public MyButtonListener(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public void actionPerformed(ActionEvent e) {
            if (turnos % 2 != 0) {
                if (primerClick && a.get(row).get(column) != null) {
                    JOptionPane.showMessageDialog(null, "Selecciono correctamente la pieza Roja!");

                    JOptionPane.showMessageDialog(null, "Ahora debe seleccionar una casilla");

                    solA = a.get(row).get(column);
                    lifeA = solA.getActualLife();
                    primerClick = false;
                    rowPast = row;
                    columnPast = column;
                    return;
                } else if (primerClick == false) {
                    JOptionPane.showMessageDialog(null, "Ahora debe seleccionar una casilla de destino");
                    if (a.get(row).get(column) != null) {
                        JOptionPane.showMessageDialog(null, "Seleccione otra casilla!");
                        return;
                    } else {
                        JOptionPane.showMessageDialog(null, "Fase de batalla!");
                        solB = b.get(row).get(column);
                        if (solB != null) {
                            lifeB = solB.getActualLife();
                            if (lifeA > lifeB) {
                                a.get(row).set(column, solA);
                                a.get(rowPast).set(columnPast, null);
                                b.get(row).set(column, null);
                                System.out.println("Movimiento exitoso: Soldado A derrota a Soldado B");
                            } else if (lifeB > lifeA) {
                                a.get(rowPast).set(columnPast, null);
                                System.out.println("Movimiento exitoso: Soldado A derrotado por Soldado B");
                            } else {
                                a.get(rowPast).set(columnPast, null);
                                b.get(row).set(column, null);
                                System.out.println("Movimiento exitoso: Ambos soldados eliminados");
                            }
                            turnos++;
                            primerClick = true;
                            repaint();
                            return;
                        } else {
                            a.get(row).set(column, solA);
                            a.get(rowPast).set(columnPast, null);
                            System.out.println("Movimiento exitoso: Soldado A se mueve a nueva posición");
                            turnos++;
                            primerClick = true;
                            repaint();
                            return;
                        }
                    }
                }

            } else {
                if (primerClick && isSoldierHereB(row, column) == 3) {
                    solB = b.get(row).get(column);
                    lifeB = solB.getActualLife();
                    primerClick = false;
                    rowPast = row;
                    columnPast = column;
                    return;
                } else if (primerClick == false) {

                    if (b.get(row).get(column) != null) {
                        JOptionPane.showMessageDialog(null, "Seleccione otra casilla!");
                        return;
                    } else {
                        solA = b.get(row).get(column);
                        if (solA != null) {
                            lifeA = solA.getActualLife();
                            if (lifeB > lifeA) {
                                b.get(row).set(column, solB);
                                b.get(rowPast).set(columnPast, null);
                                a.get(row).set(column, null);
                                System.out.println("Movimiento exitoso: Soldado A derrota a Soldado B");
                            } else if (lifeA > lifeB) {
                                b.get(rowPast).set(columnPast, null);
                                System.out.println("Movimiento exitoso: Soldado A derrotado por Soldado B");
                            } else {
                                b.get(rowPast).set(columnPast, null);
                                a.get(row).set(column, null);
                                System.out.println("Movimiento exitoso: Ambos soldados eliminados");
                            }
                            turnos--;
                            primerClick = true;
                            repaint();
                            return;
                        } else {
                            a.get(row).set(column, solA);
                            a.get(rowPast).set(columnPast, null);
                            System.out.println("Movimiento exitoso: Soldado A se mueve a nueva posición");
                            turnos--;
                            primerClick = true;
                            repaint();
                            return;
                        }
                    }
                }

            }
        }
    }

    public int isSoldierHereA(int row, int column) {
        // Turno rojo A es true
        Soldier sol = a.get(row).get(column);

        if (sol == null) {
            JOptionPane.showMessageDialog(null, "Seleccione bien su ficha!");
            return 1;
        } else {
            return 0;
        }
    }

    public int isSoldierHereB(int row, int column) {
        // Turno rojo A es true
        Soldier sol = b.get(row).get(column);

        if (sol == null) {
            JOptionPane.showMessageDialog(null, "Seleccione bien su ficha!");
            return 1;
        } else {
            return 3;
        }
    }

    public int getLife(Soldier sol) {
        return sol.getActualLife();
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

        tab.init();
        tab.init();
        tab.init();

    }

}
