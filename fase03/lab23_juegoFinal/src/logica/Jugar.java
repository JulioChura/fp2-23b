package logica;

import gui.HomeGame;
import gui.PrincipalFrame;
import gui.Tablero;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import persistencia.Conectar;

public class Jugar {

    protected Tablero tablero;
    protected Army red;
    protected Army blue;
    protected String arena;
    protected Player playerRed;
    protected Player playerBlue;

    public Jugar(Tablero tab, Army red, Army blue, String arena, Player playerRed, Player playerBlue) {
        this.tablero = tab;
        this.red = red;
        this.blue = blue;
        this.arena = arena;
        this.playerRed = playerRed;
        this.playerBlue = playerBlue;
    }

    public void game() {
        SwingWorker<Void, Void> gameWorker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                PrincipalFrame principal = new PrincipalFrame(blue, red, arena, tablero, playerBlue, playerRed);
                jugarTurnos(tablero, principal);

                if (playerRed == null || playerBlue == null) {
                    //
                } else {
                    Conectar conectar = Conectar.obtenerInstancia(); 
                    if (blue.converterToArrayUni() == null) {
                        conectar.registrarVictoria(playerRed.getNombre(), playerRed.getPassword());
                        JOptionPane.showMessageDialog(principal, "Se registró la victoria");
                    } else {
                        conectar.registrarVictoria(playerBlue.getNombre(), playerBlue.getPassword());
                        JOptionPane.showMessageDialog(principal, "Se registró la victoria");
                    }
                }
                
                principal.dispose();
                HomeGame home = new HomeGame();
                home.setVisible(true);
                return null;
            }
        };

        gameWorker.execute(); // Ejecuta el SwingWorker en un hilo separado
    }

    public static void jugarTurnos(Tablero tabla, PrincipalFrame pane) {
        Army e1 = tabla.getEjercito1();
        Army e2 = tabla.getEjercito2();
        int turno = 0;
        JOptionPane.showMessageDialog(null, "Bienvenidos a mi juego de guerra");
        do {
            if (turno % 2 == 0) {
                int x = 0, y = 0, Dx = 0, Dy = 0;

                do {
                    JOptionPane.showMessageDialog(null, "Turno del reino de " + e2.getName() + "(Azul)");
                    int[] arr = tabla.getCoordinates();
                    x = arr[0];
                    y = arr[1];
                    int[] toarr = tabla.getCoordinates();
                    Dx = toarr[0];
                    Dy = toarr[1];
                } while (Army.validatePosition(e2, x, y, Dx, y));
                Army.moveSoldier(e1, e2, x, y, Dx, Dy);
            } else {
                int x = 0, y = 0, Dx = 0, Dy = 0;
                do {
                    JOptionPane.showMessageDialog(null, "Turno del reino de " + e1.getName() + "(Rojo)");
                    int[] arr = tabla.getCoordinates();
                    x = arr[0];
                    y = arr[1];
                    int[] toarr = tabla.getCoordinates();
                    Dx = toarr[0];
                    Dy = toarr[1];
                } while (Army.validatePosition(e1, x, y, Dx, Dy));
                Army.moveSoldier(e2, e1, x, y, Dx, Dy);
            }
            SwingUtilities.invokeLater(() -> pane.repintarTablero()); // Actualiza el GUI en el EDT
            turno++;
        } while (Army.winnerDefinitive(e1, e2));

    }
}
