public class Soldier {

    private String name;
    private int row;
    private int column;
    private int attackLevel;
    private int defenseLevel;
    private int lifePoints;
    private int actualLife;
    private int speed;
    private String attitude;
    private boolean current;

    public Soldier(String name, int row, int column, int attackLevel, int defenseLevel, int lifePoints) {
        this(name, row, column, attackLevel, defenseLevel, lifePoints, lifePoints, 0, "Reposo", true);
    }

    public Soldier(String name, int attackLevel, int defenseLevel, int lifePoints, int speed, String attitude,
            boolean current) {
        this(name, 0, 0, attackLevel, defenseLevel, lifePoints, lifePoints, speed, attitude, current);
    }

    public Soldier(String name, int row, int column, int attackLevel, int defenseLevel, int lifePoints, int actualLife,
            int speed, String attitude, boolean current) {
        this.name = name;
        this.row = row;
        this.column = column;
        this.attackLevel = attackLevel;
        this.defenseLevel = defenseLevel;
        this.lifePoints = lifePoints;
        this.actualLife = actualLife;
        this.speed = speed;
        this.attitude = attitude;
        this.current = current;
    }

    public void advance() {
        speed++;
    }

    public void attack() {
        attitude = "offensive";
        advance();
    }

    public void defend() {
        attitude = "defensive";
        speed = 0;
    }

    public void back() {
        if (speed > 0) {
            speed = 0;
            attitude = "defensive";
        } else if (speed == 0) {
            speed--;
        }
    }

    public void die() {
        if (actualLife < 0) {
            current = false;
        } else {
            current = true;
        }
    }

    public void beAttacked(int damage) {
        this.actualLife = this.actualLife - damage;
        die();
    }

    public String getName() {
        return name;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public String toString() {
        return "Soldier [name=" + name + ", row=" + row + ", column=" + column + ", attackLevel=" + attackLevel
                + ", defenseLevel=" + defenseLevel + ", lifePoints=" + lifePoints + ", actualLife=" + actualLife
                + ", speed=" + speed + ", attitude=" + attitude + ", current=" + current + "]";
    }

}
