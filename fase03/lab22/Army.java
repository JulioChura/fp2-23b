import java.util.*;
import javax.swing.JOptionPane;

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
                    name = "Arquero" + (row + 1) + "x" + (column + 1);
                    sol = new Archer(name, row, column, attack, defense, lifePoints, 0, 5);

                } else if (optionSoldier == 1) {
                    attack = 13;
                    defense = 7;
                    lifePoints = random.nextInt(3) + 10;
                    name = "Caballero" + (row + 1) + "x" + (column + 1);
                    sol = new Knight(name, row, column, attack, defense, lifePoints, 0, "sword", false);

                } else if (optionSoldier == 2) {
                    attack = 5;
                    defense = 10;
                    lifePoints = random.nextInt(4) + 5;
                    name = "Lancero" + (row + 1) + "x" + (column + 1);
                    sol = new Spearman(name, row, column, attack, defense, lifePoints, 0, 1);

                
                } else if (optionSoldier == 3) {
                    attack = 10;
                    defense = 8;
                    lifePoints = random.nextInt(3) + 8;
                    name = "Espad" + (row + 1) + "x" + (column + 1);
                    sol = new Swordsman(name, row, column, attack, defense, lifePoints, 0, 1, false);
                } else if (optionSoldier == 4) {
                    attack = 13;
                    defense = 7;
                    lifePoints = 15;
                    name = "C.Franco" + (row + 1) + "x" + (column + 1);
                    sol = new FrancoKnight(name, row, column, attack, defense, defense, lifePoints, optionSoldier, n,
                            false);
                } else if (optionSoldier == 5) {
                    attack = 10;
                    defense = 8;
                    lifePoints = 14;
                    name = "Esp.Conq" + (row + 1) + "x" + (column + 1);
                    sol = new ConquerorSwordsman(name, row, column, attack, defense, defense, lifePoints, n, false,
                            optionSoldier);
                } else if (optionSoldier == 6) {
                    attack = 10;
                    defense = 8;
                    lifePoints = 13;
                    name = "Esp.Teu" + (row + 1) + "x" + (column + 1);
                    sol = new GermanSwordsman(name, row, column, attack, defense, lifePoints, optionSoldier, n, false, n);
                } else if (optionSoldier == 7) {
                    attack = 13;
                    defense = 7;
                    lifePoints = 13;
                    name = "C.Moro" + (row + 1) + "x" + (column + 1);
                    sol = new Soldier(name, row, column, attack, defense, lifePoints, optionSoldier);
                } else  {
                    attack = 10;
                    defense = 8;
                    lifePoints = 13;
                    name = "R.Espad"+(row+1)+"x"+(column+1);
                    sol = new RoyalSwordsman(name, row, column, attack, defense, lifePoints, optionSoldier, n, false, n);
                }

                a.setSoldier(row, column, a, sol);
                n++;
            }
        } while (n < amount);
        return a;
    }

    // Para trabajar con ordenamientos, es necesario llevarlo a su forma
    // unidimensional
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

    public String showArmy() {
        String str = "";
        for (ArrayList<Soldier> row : army) {
            for (Soldier soldier : row) {
                if (soldier != null) {
                    System.out.println(soldier.display());
                    str = str + "\n" + soldier;

                }
            }
        }
        return str;
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
        int[] num = new int[10];
        int total = 0;
        for (Soldier sol : armyU) {
            int typeSol = typeSoldier(sol);

            num[typeSol]++;
        }
        for (int n : num) {
            total = total + n;
        }
        num[9] = total;
;
        return num;
    }

    // 0:archer 1:Knight 2:Spearman 3:Swordsman 5:total
    // En la guia se nos pide contabilizar los objetos
    public static int typeSoldier(Soldier sol) {
        if (sol instanceof Archer) {
            return 0;
        } else if (sol instanceof Knight) {
            return 1;
        } else if (sol instanceof Spearman) {
            return 2;
        } else if (sol instanceof Swordsman) {
            return 3;
        } else if (sol instanceof ConquerorSwordsman) {
            return 4;
        } else if (sol instanceof FrancoKnight) {
            return 5;
        } else if (sol instanceof GermanSwordsman) {
            return 6;
        } else if (sol instanceof KnightMoro) {
            return 7;
        } else {
            return 8;
        }


    }

    // ordena un arreglo unidimensional
    public void organize() {
        int n = armyU.size();
        for (int i = 1; i < n; i++) {
            Soldier key = armyU.get(i);
            int j = i - 1;
            while (j >= 0 && armyU.get(j).getActualLife() > key.getActualLife()) {
                armyU.set(j + 1, armyU.get(j));
                j--;
            }
            armyU.set(j + 1, key);
        }
    }

    // El soldado con mayor vida
    public void longerLife() {
        organize();
        System.out.println(armyU.get(armyU.size() - 1));
    }

    // imprime ranking de poder
    public void ranking() {
        organize();
        for (Soldier sol : armyU) {
            System.out.println(sol);
        }
    }

    public String getName() {
        return name;
    }

    public int totalLife() {
        int sumLife = 0;
        for (Soldier sol : getArmyInArrayUni()) {
            sumLife = sumLife + sol.getActualLife();
        }
        return sumLife;
    }

    public static Soldier searchSoldier(Army army, int row, int column) {
        Soldier sol = army.getArmyInArrayListBi().get(row).get(column);
        if (sol == null) {
            return null;
        } else {
            return sol;
        }
    }

    /*
     * Valida la posicion de un soldado de un ejercito. Verifica que estemos
     * seleccionando en la coordenada de
     * origen un soldado de nuestro bando, ademas en las coordenadas de destino se
     * verifica si hay presencia de
     * de soldados aliados, si es asi, nos muestra un mensaje que indica que de
     * nuevo debemos ingresar la posicion de destino
     */
    public static boolean validatePosition(Army ally, int rowOrigin, int columnOrigin,
            int rowDestination, int columnDestination) {

        if (searchSoldier(ally, rowOrigin, columnOrigin) != null
                && searchSoldier(ally, rowDestination, columnDestination) == null) {
            JOptionPane.showMessageDialog(null, "Coordenadas correctas!");
            return false;
        } else {
            JOptionPane.showMessageDialog(null, "Coordenadas no válidas!");
            return true;
        }
    }

    // Hace la simulacion de mover un soldado, pero en realidad actualiza la
    // posicion dentro del Array
    public static void moveSoldier(Army destination, Army origin, int rowOrigin, int columnOrigin,
            int rowDestination, int columnDestination) {
        Soldier destinationSoldier = searchSoldier(destination, rowDestination, columnDestination);
        Soldier originSoldier = searchSoldier(origin, rowOrigin, columnOrigin);

        if (destinationSoldier == null) {
            origin.getArmyInArrayListBi().get(rowOrigin).set(columnOrigin, null);
            origin.getArmyInArrayListBi().get(rowDestination).set(columnDestination, originSoldier);
            originSoldier.setRow(rowDestination);
            originSoldier.setColumn(columnDestination);
        } else if (destinationSoldier != null) {
            battle(destination, origin, rowOrigin, columnOrigin, rowDestination, columnDestination, destinationSoldier,
                    originSoldier);
        }

    }

    public static void battle(Army destination, Army origin, int rowOrigin, int columnOrigin,
            int rowDestination, int columnDestination, Soldier destinationSoldier, Soldier originSoldier) {
        int lifeDestination = destinationSoldier.getActualLife();
        int lifeOrigin = originSoldier.getActualLife();

        int result = winner(lifeOrigin, lifeDestination);
        if (1 == result) {
            origin.getArmyInArrayListBi().get(rowOrigin).set(columnOrigin, null);
            origin.getArmyInArrayListBi().get(rowDestination).set(columnDestination, originSoldier);
            destination.getArmyInArrayListBi().get(rowDestination).set(columnDestination, null);
            originSoldier.setRow(rowDestination);
            originSoldier.setColumn(columnDestination);
        } else if (2 == result) {
            origin.getArmyInArrayListBi().get(rowOrigin).set(columnOrigin, null);
        } else {
            origin.getArmyInArrayListBi().get(rowOrigin).set(columnOrigin, null);
            destination.getArmyInArrayListBi().get(rowDestination).set(columnDestination, null);
        }
    }

    public static int winner(int life1, int life2) {

        Random random = new Random();
        int definitiveProbability = random.nextInt(100);

        double totalLife = life1 + life2;
        double probabilityAttack1 = 100 * life1 / totalLife;
        double probabilityAttack2 = 100 - probabilityAttack1;

        JOptionPane.showMessageDialog(null, "Estadísticas de batalla:\tSoldado atacante: " + probabilityAttack1
                + "%\t Soldado en reposo: " + probabilityAttack2 + "%\t Salio como aleatorio: "
                + definitiveProbability + "%");

        System.out.println();

        if (definitiveProbability < probabilityAttack1) {
            JOptionPane.showMessageDialog(null, "Gano el soldado atacante");
            return 1;
        } else if (definitiveProbability > probabilityAttack1) {
            JOptionPane.showMessageDialog(null, "Gano el soldado en reposo");
            return 2;
        } else {
            JOptionPane.showMessageDialog(null, "Empate");
            return 3;
        }
    }

    public static boolean winnerDefinitive(Army e1, Army e2) {
        if (e2.converterToArrayUni().size() == 0) {
            JOptionPane.showMessageDialog(null, "Ganó " + e2.getName());
            return false;
        }
        if (e1.converterToArrayUni().size() == 0) {
            JOptionPane.showMessageDialog(null, "Ganó " + e1.getName());
            return false;
        }
        return true;
    }

    public void increaseLife() {
        for (ArrayList<Soldier> row : army) {
            for (Soldier sol : row) {
                sol.setActualLife(sol.getActualLife() + 1);
                ;
            }
        }
    }

    public void setName(String name) {
        this.name = name;
    }
}
