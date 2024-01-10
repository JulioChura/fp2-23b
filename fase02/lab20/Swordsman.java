public class Swordsman extends Soldier {
    private double longSnow;
    private boolean shieldWalls = false;

    public Swordsman(double longSnow) {
        this.longSnow = longSnow;
    }

    public Swordsman(String name, int row, int column, int attackLevel, int defenseLevel, int actualLife, int speed,
            String attitude, boolean current, double longSnow) {
        super(name, row, column, attackLevel, defenseLevel, actualLife, speed, attitude, current);
        this.longSnow = longSnow;
    }

    public Swordsman(String name, int row, int column, int attackLevel, int defenseLevel, int actualLife, int speed,
            double longSnow, boolean shieldWalls) {
        super(name, row, column, attackLevel, defenseLevel, actualLife, speed);
        this.longSnow = longSnow;
        this.shieldWalls = shieldWalls;
    }
	
	
}