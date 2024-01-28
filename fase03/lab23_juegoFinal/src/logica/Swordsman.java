package logica;

public class Swordsman extends Soldier {
    private double longSwords;
    private boolean shieldWalls = false;

    public Swordsman(double longSwords) {
        this.longSwords = longSwords;
    }

    public Swordsman(String name, int row, int column, int attackLevel, int defenseLevel, int actualLife, int speed,
            String attitude, boolean current, double longSwords) {
        super(name, row, column, attackLevel, defenseLevel, actualLife, speed, attitude, current);
        this.longSwords = longSwords;
    }

    public Swordsman(String name, int row, int column, int attackLevel, int defenseLevel, int actualLife, int speed,
            double longSwords, boolean shieldWalls) {
        super(name, row, column, attackLevel, defenseLevel, actualLife, speed);
        this.longSwords = longSwords;
        this.shieldWalls = shieldWalls;
    }

    public void muroEscudos() {
        if (shieldWalls == true) {
            shieldWalls = false;
        } else {
            shieldWalls = true;
        }
    }

    @Override
    public String toString() {
        return " # Espadachin -> Long. espada" + longSwords + super.display();
    }

}