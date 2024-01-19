public class RoyalSwordsman extends Swordsman implements SpecialUnit {
    private int knives = 10;
    private int levelEvolution = 1;

    public RoyalSwordsman(double longSnow, int levelEvolution) {
        super(longSnow);
        this.levelEvolution = levelEvolution;
    }

    public RoyalSwordsman(String name, int row, int column, int attackLevel, int defenseLevel, int actualLife,
            int speed, String attitude, boolean current, double longSnow, int levelEvolution) {
        super(name, row, column, attackLevel, defenseLevel, actualLife, speed, attitude, current, longSnow);
        this.levelEvolution = levelEvolution;
    }

    public RoyalSwordsman(String name, int row, int column, int attackLevel, int defenseLevel, int actualLife,
            int speed, double longSnow, boolean shieldWalls, int levelEvolution) {
        super(name, row, column, attackLevel, defenseLevel, actualLife, speed, longSnow, shieldWalls);
        this.levelEvolution = levelEvolution;
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
}
