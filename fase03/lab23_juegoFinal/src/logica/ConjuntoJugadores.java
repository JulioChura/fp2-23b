package logica;

/**
 *
 * @author USUARIO
 */
public class ConjuntoJugadores {
    protected Player jugador1;
    protected Player jugador2;

    public ConjuntoJugadores(Player jugador1, Player jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    public Player getJugador1() {
        return jugador1;
    }

    public Player getJugador2() {
        return jugador2;
    }
    
    
}