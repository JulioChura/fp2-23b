package logica;

//Espadachin romano
public class GermanSwordsman extends Swordsman implements SpecialUnit {

    private int javelin = 10;

    public GermanSwordsman(double longSwords, int javelin) {
        super(longSwords);
        this.javelin = javelin;
    }

    public GermanSwordsman(String name, int row, int column, int attackLevel, int defenseLevel, int actualLife,
            int speed, String attitude, boolean current, double longSwords, int javelin) {
        super(name, row, column, attackLevel, defenseLevel, actualLife, speed, attitude, current, longSwords);
        this.javelin = javelin;
        actualLife = 13;
    }

    public GermanSwordsman(String name, int row, int column, int attackLevel, int defenseLevel, int actualLife,
            int speed, double longSwords, boolean shieldWalls, int javelin) {
        super(name, row, column, attackLevel, defenseLevel, actualLife, speed, longSwords, shieldWalls);
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
            javelin = +10;
        } else {
            System.err.println("Se alcanzo el maximo nivel");
        }
    }

    public String toString() {
        return " # Esp. Germano ->" + " Javalinas: " + javelin + super.display();
    }

}