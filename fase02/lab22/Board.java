import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Panel;

public class Board extends JFrame {

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

    // 0:Bosque 1:Campo 2:Montania 3:Desierto 4: Playa
    public String chooseBattleField() {
        Random random = new Random();
        int option = random.nextInt(5);
        if (option == 0) {
            typeTerritory = "Bosque";
        } else if (option == 1) {
            typeTerritory = "Campo";
        } else if (option == 2) {
            typeTerritory = "Montania";
        } else if (option == 3) {
            typeTerritory = "Desierto";
        } else {
            typeTerritory = "Playa";
        }
        return typeTerritory;
    }

    public static String kingdom(String str) {
        if (str.equalsIgnoreCase("Castilla")) {
            return "C";
        } else if (str.equalsIgnoreCase("Francia")) {
            return "F";
        } else if (str.equalsIgnoreCase("Moros")) {
            return "M";
        } else if (str.equalsIgnoreCase("Inglaterra")) {
            return "I";
        } else {
            return "R";
        }
    }

    public String battlefield() {
        String charMap;
        if (typeTerritory.equalsIgnoreCase("playa")) {
            return "P";
        } else if (typeTerritory.equalsIgnoreCase("montañana")) {
            return "M";
        } else if (typeTerritory.equalsIgnoreCase("desierto")) {
            return "D";
        } else if (typeTerritory.equalsIgnoreCase("Campo")) {
            return "C";
        } else {
            return "B";
        }
    }

    public String typSoldier(Soldier sol) {
        if (sol instanceof Archer) {
            return "a";
        } else if (sol instanceof Knight) {
            return "r";
        } else if (sol instanceof Spearman) {
            return "l";
        } else {
            return "e";
        }
    }

    public String lifeInStringFormat(int row, int column, ArrayList<ArrayList<Soldier>> a) {
        int life = a.get(row).get(column).getActualLife();
        if (life < 10) {
            return "0" + String.valueOf(life);
        } else {
            return String.valueOf(life);
        }
    }

    public void generateMap() {

        ArrayList<ArrayList<Soldier>> a = army1.getArmyInArrayListBi();
        ArrayList<ArrayList<Soldier>> b = army2.getArmyInArrayListBi();

        String charMap = battlefield();
        map = new String[ROW][COLUMN];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = "|__________|";
            }
        }

        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(i).size(); j++) {
                if (a.get(i).get(j) != null) {
                    String strA = "|_" + charMap + "*" + Board.kingdom(kingdom1) + typSoldier(a.get(i).get(j))
                            + lifeInStringFormat(i, j, a) + "*" + charMap + "_|";
                    map[i][j] = strA;
                }
            }
        }
        for (int i = 0; i < b.size(); i++) {
            for (int j = 0; j < b.get(i).size(); j++) {
                if (b.get(i).get(j) != null && map[i][j] != "s") {
                    String strB = "|_" + charMap + "*" + Board.kingdom(kingdom2) + typSoldier(b.get(i).get(j))
                            + lifeInStringFormat(i, j, b) + "*" + charMap + "_|";
                    map[i][j] = strB;
                }
            }
        }
        System.out.print(
                "      A        B           C          D            E           F             G            H           I             J \n");
        for (int i = 0; i < map.length; i++) {
            System.out.printf("%2d", (i + 1));
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

}
