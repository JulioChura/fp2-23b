import java.util.*;

public class GameFast {
    private Board board;
    private Army army1;
    private Army army2;
    private boolean gameOver;

    public GameFast(Board board, Army army1, Army army2, boolean gameOver) {
        this.board = board;
        this.army1 = army1;
        this.army2 = army2;
        this.gameOver = gameOver;
    }
}
