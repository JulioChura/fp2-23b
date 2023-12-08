public class Soldier {

    private String name;
    private int row;
    private int column;
    private int attackLevel;
    private int defenseLevel;
    private int actualLife;
    private int speed;
    private String attitude;
    private boolean current;

    public Soldier() {
        this("NotFound", 0, 0, 0, 0,
                0, 0, "repose", true);
    }

    public Soldier(String name, int row, int column, int attackLevel, int defenseLevel, int actualLife, int speed) {
        this(name, row, column, attackLevel, defenseLevel, actualLife, 0,
                "Repose", true);
    }

    public Soldier(String name, int row, int column, int attackLevel, int defenseLevel, int actualLife,
            int speed, String attitude, boolean current) {
        this.name = name;
        this.row = row;
        this.column = column;
        this.attackLevel = attackLevel;
        this.defenseLevel = defenseLevel;
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

    public void scape() {
        this.speed = this.speed + 2;
    }

    public int getActualLife() {
        return actualLife;
    }

    public void setActualLife(int actualLife) {
        this.actualLife = actualLife;
    }

    public String getName() {
        return name;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getAttackLevel() {
        return attackLevel;
    }

    public void setAttackLevel(int attackLevel) {
        this.attackLevel = attackLevel;
    }

    public int getDefenseLevel() {
        return defenseLevel;
    }

    public void setDefenseLevel(int defenseLevel) {
        this.defenseLevel = defenseLevel;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean getCurrent() {
        return current;
    }

    
    public String toString() {
        return "Soldier [name=" + name + ", lifePoints=" + lifePoints + ", row=" + row + ", column=" + column + "]";
    }

}
