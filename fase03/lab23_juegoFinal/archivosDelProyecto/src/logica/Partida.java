package logica;

/**
 *
 * @author Julio Chura
 */
public class Partida {
    protected Player playerRed;
    protected Player playerBlue;
    protected String arena;

    public Partida(Player playerRed, Player playerBlue, String arena) {
        this.playerRed = playerRed;
        this.playerBlue = playerBlue;
        this.arena = arena;
    }

    public Player getPlayerRed() {
        return playerRed;
    }

    public void setPlayerRed(Player playerRed) {
        this.playerRed = playerRed;
    }

    public Player getPlayerBlue() {
        return playerBlue;
    }

    public void setPlayerBlue(Player playerBlue) {
        this.playerBlue = playerBlue;
    }

    public String getArena() {
        return arena;
    }

    public void setArena(String arena) {
        this.arena = arena;
    }
    
    
}
