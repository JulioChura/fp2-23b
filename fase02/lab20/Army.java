import java.util.*;

public class Army {

    private ArrayList<ArrayList<Soldier>> army;
    private ArrayList<Soldier> armyU;
    private String name;

    private static final int COLUMN_BOARD = 10;
    private static final int ROW_BOARD = 10;

    public Army(String name) {
        ArrayList<ArrayList<Soldier>> army = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            army.add(new ArrayList<>(Collections.nCopies(10, null)));
        }
        this.army = army;
        this.name = name;
    }

    public Soldier getSoldier(int row, int column) {
        return army.get(row).get(column);
    }

    public void setSoldier(int row, int column, Army a, Soldier sol) {
        army.get(row).set(column, sol);

    }

    
}
