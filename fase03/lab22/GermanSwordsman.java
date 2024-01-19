//Espadachin romano
public class GermanSwordsman extends Swordsman implements SpecialUnit {

    private int javelin = 10;

    public GermanSwordsman(double longSnow, int javelin) {
        super(longSnow);
        this.javelin = javelin;
    }

    public GermanSwordsman(String name, int row, int column, int attackLevel, int defenseLevel, int actualLife,
            int speed, String attitude, boolean current, double longSnow, int javelin) {
        super(name, row, column, attackLevel, defenseLevel, actualLife, speed, attitude, current, longSnow);
        this.javelin = javelin;
        actualLife = 13;
    }

    public GermanSwordsman(String name, int row, int column, int attackLevel, int defenseLevel, int actualLife,
            int speed, double longSnow, boolean shieldWalls, int javelin) {
        super(name, row, column, attackLevel, defenseLevel, actualLife, speed, longSnow, shieldWalls);
        this.javelin = javelin;
        actualLife = 13;
    }

    public void throwObjects() {
        if (0 < javelin) {
            attack();
            javelin--;
        } else {
            System.err.println("No hay javalinas");
        }
    }

    public void evolve() {
        if (levelEvolution <= MAX_LEVEL) {
            levelEvolution++;
            javelin =+ 10;
        } else {
            System.err.println("Se alcanzo el maximo nivel");
        }
    }

}