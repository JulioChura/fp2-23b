package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
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
    
    public void jugar() {
        boolean exitRequested = false;
        
        HomeGame home = new HomeGame();
        home.setVisible(true);
        do {

            

            Tablero tab = new Tablero(armyRed, armyRed, field);
            // juego(tab);
            PrincipalFrame juegazo = new PrincipalFrame(armyBlue, armyRed, field, tab);
            jugar(tab, juegazo);
            int option = JOptionPane.showConfirmDialog(null, "¿Desea jugar de nuevo?", "Reiniciar",
                    JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.NO_OPTION) {
                exitRequested = true;

            }
            juegazo.dispose();
        } while (!exitRequested);

        System.exit(0);
    }
    
    public static void main(String[] args) {
        boolean exitRequested = false;
        
        HomeGame home = new HomeGame();
        home.setVisible(true);
        do {

            String kingdom1 = showDialogToChooseKingdom();
            String kingdom2 = showDialogToChooseKingdom();
            String battleField1 = showDialogToChooseBattleField();
            String battleField2 = showDialogToChooseBattleField();
            String definitiveBattlefield = randomBattlefield(battleField1, battleField2);

            Army a = new Army(kingdom1);
            Army b = new Army(kingdom2);
            a.generateArmy(b);

            b.generateArmy(a);

            Tablero tab = new Tablero(a, b, definitiveBattlefield);
            // juego(tab);
            PrincipalFrame juegazo = new PrincipalFrame(a, b, definitiveBattlefield, tab);
            jugar(tab, juegazo);
            int option = JOptionPane.showConfirmDialog(null, "¿Desea jugar de nuevo?", "Reiniciar",
                    JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.NO_OPTION) {
                exitRequested = true;

            }
            juegazo.dispose();
        } while (!exitRequested);

        System.exit(0);
    }

    public static void jugar(Tablero tabla, PrincipalFrame pane) {
        Army e1 = tabla.getEjercito1();
        Army e2 = tabla.getEjercito2();
        int turno = 0;
        JOptionPane.showMessageDialog(null, "Bienvenidos a mi juego de guerra");
        //tabla.repintarTablero();
        do {
            if (turno % 2 == 0) {
                int x = 0, y = 0, Dx = 0, Dy = 0;

                do {
                    JOptionPane.showMessageDialog(null, "Turno del reino de " + e2.getName() + "(Azul)");
                    int arr[] = tabla.getCoordinates();
                    x = arr[0];
                    y = arr[1];
                    int toarr[] = tabla.getCoordinates();
                    Dx = toarr[0];
                    Dy = toarr[1];
                } while (Army.validatePosition(e2, x, y, Dx, y));
                Army.moveSoldier(e1, e2, x, y, Dx, Dy);
            } else {
                int x = 0, y = 0, Dx = 0, Dy = 0;
                do {

                    JOptionPane.showMessageDialog(null, "Turno del reino de " + e1.getName() + "(Rojo)");
                    int arr[] = tabla.getCoordinates();
                    x = arr[0];
                    y = arr[1];

                    int toarr[] = tabla.getCoordinates();
                    Dx = toarr[0];
                    Dy = toarr[1];
                } while (Army.validatePosition(e1, x, y, Dx, Dy));
                Army.moveSoldier(e2, e1, x, y, Dx, Dy);
            }
            // tabla.repaint();
            pane.repintarTablero();
            turno++;
        } while (Army.winnerDefinitive(e1, e2));
    }

    public static String showDialogToChooseKingdom() {
        String[] kingdoms = {"Francia", "Inglaterra", "Castilla-Aragon", "Sacro Imperio Romano", "Moros"};
        String seleccion = (String) JOptionPane.showInputDialog(
                null,
                "Seleccigona una opción:",
                "Elegir Opción",
                JOptionPane.QUESTION_MESSAGE,
                null,
                kingdoms,
                kingdoms[0]);

        // Verifica si el usuario seleccionó una opción
        if (seleccion != null) {
            JOptionPane.showMessageDialog(null, "Seleccionaste: " + seleccion);
        } else {
            JOptionPane.showMessageDialog(null, "No seleccionaste ninguna opción");
        }

        return seleccion;
    }

    public static String showDialogToChooseBattleField() {
        String[] fields = {"Bosque", "Campo", "Montaña", "Desierto", "Playas"};
        String seleccion = (String) JOptionPane.showInputDialog(
                null,
                "Seleccigona una opción:",
                "Elegir Opción",
                JOptionPane.QUESTION_MESSAGE,
                null,
                fields,
                fields[0]);

        // Verifica si el usuario seleccionó una opción
        if (seleccion != null) {
            JOptionPane.showMessageDialog(null, "Seleccionaste: " + seleccion);
        } else {
            JOptionPane.showMessageDialog(null, "No seleccionaste ninguna opción");
        }

        return seleccion;
    }

    public static String randomBattlefield(String battleField1, String battleField2) {
        Random random = new Random();
        int selection = random.nextInt(2);
        if (0 == selection) {
            return battleField1;
        } else {
            return battleField2;
        }
    }
}
