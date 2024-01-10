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

    // 0:Archer; 1:Knight; 2:Spearman; 3:Swordsman
    public Army generateArmy(Army a) {
        Random random = new Random();
        int amount = random.nextInt(10) + 1;
        int n = 0;
        int row, column, attack, defense, lifePoints;
        String name;
        int optionSoldier;
        Soldier sol;
        do {
            row = random.nextInt(ROW_BOARD);
            column = random.nextInt(COLUMN_BOARD);
            if (a.getSoldier(row, column) == null && army.get(row).get(column) == null) {

                optionSoldier = random.nextInt(4);
                if (optionSoldier == 0) {
                    attack = 7;
                    defense = 3;
                    lifePoints = random.nextInt(5) + 3;
                    name = "Archer" + (row + 1) + "x" + (column + 1);
                    sol = new Archer(name, row + 1, column + 1, attack, defense, lifePoints, 0, 5);

                } else if (optionSoldier == 1) {
                    attack = 13;
                    defense = 7;
                    lifePoints = random.nextInt(3) + 10;
                    name = "Knight" + (row + 1) + "x" + (column + 1);
                    sol = new Knight(name, row + 1, column + 1, attack, defense, lifePoints, 0, "sword", false);

                } else if (optionSoldier == 2) {
                    attack = 5;
                    defense = 10;
                    lifePoints = random.nextInt(4) + 5;
                    name = "Spearman" + (row + 1) + "x" + (column + 1);
                    sol = new Spearman(name, row + 1, column + 1, attack, defense, lifePoints, 0, 1);

                } else {
                    attack = 10;
                    defense = 8;
                    lifePoints = random.nextInt(3) + 8;
                    name = "Swordsman" + (row + 1) + "x" + (column + 1);
                    sol = new Swordsman(name, row + 1, column + 1, attack, defense, lifePoints, 0, 1, false);
                }
                a.setSoldier(row, column, a, sol);
                n++;
            }
        } while (n < amount);
        return a;
    }

    // Para trabajar con ordenamientos, es necesario llevarlo a su forma
    // bidimensioanl
    public ArrayList<Soldier> converterToArrayUni() {
        ArrayList<Soldier> armyUni = new ArrayList<Soldier>();
        for (int i = 0; i < army.size(); i++) {
            for (int j = 0; j < army.get(i).size(); j++) {
                if (army.get(i).get(j) != null) {
                    armyUni.add(army.get(i).get(j));
                }
            }
        }
        armyU = armyUni;
        return armyUni;
    }

    public void showArmy() {
        for (ArrayList<Soldier> row : army) {
            for (Soldier soldier : row) {
                if (soldier != null) {
                    System.out.println(soldier);
                }
            }
        }
    }

    public ArrayList<ArrayList<Soldier>> getArmyInArrayListBi() {
        return army;
    }

    public ArrayList<Soldier> getArmyInArrayUni() {
        return armyU;
    }

    // 0:archer 1:Knight 2:Spearman 3:Swordsman 5:total
    // En la guia se nos pide contabilizar los objetos
    public int[] count() {
        converterToArrayUni();
        int[] num = new int[5];
        int total = 0;
        for (Soldier sol : armyU) {
            if (sol instanceof Archer) {
                num[0]++;
            } else if (sol instanceof Knight) {
                num[1]++;
            } else if (sol instanceof Spearman) {
                num[2]++;
            } else {
                num[3]++;
            }
        }
        for (int n : num) {
            total = total + n;
        }
    }

}
