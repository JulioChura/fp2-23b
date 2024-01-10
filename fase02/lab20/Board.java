import java.util.ArrayList;
import java.util.Random;

public class Board {
    private static final int COLUMN = 10;
    private static final int ROW = 10;

    private Army army1;
    private Army army2;

    private String typeTerritory;

    private String kingdom1;
    private String kingdom2;

    private String[][] map;

    public Board(Army a, Army b, String kingdom1, String kingdom2) {
        army1 = a;
        army2 = b;
        chooseBattleField();
        this.kingdom1 = kingdom1;
        this.kingdom2 = kingdom2;
    }


    
}
