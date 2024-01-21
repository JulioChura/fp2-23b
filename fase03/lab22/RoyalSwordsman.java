//Este guerrero le pertenece al reino de Inglaterra
public class RoyalSwordsman extends Swordsman implements SpecialUnit {
    private int knives = 10;

    public RoyalSwordsman(String name, int row, int column, int attackLevel, int defenseLevel, int actualLife,
            int speed, String attitude, boolean current, double longSwords, int levelEvolution) {
        super(name, row, column, attackLevel, defenseLevel, actualLife, speed, attitude, current, longSwords);
        actualLife = 12;

    }

    public RoyalSwordsman(String name, int row, int column, int attackLevel, int defenseLevel, int actualLife,
            int speed, double longSwords, boolean shieldWalls, int levelEvolution) {
        super(name, row, column, attackLevel, defenseLevel, actualLife, speed, longSwords, shieldWalls);
        actualLife = 12;
    }

    public void throwObjects() {
        if (knives > 0) {
            attack();
            knives--;
        }
    }

    public void evolve() {
        if (levelEvolution <= 4) {
            levelEvolution++;
            knives += 10;
        } else {
            System.out.println("Alcanzo el maximo nivel");
        }
    }

    public String toString() {
        return "Caballero Real," + " Cuchillas: " + knives + super.display();
    }
}
