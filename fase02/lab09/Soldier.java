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

    public void setName(String name) {
        this.name = name;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public void setRow(int row) {
        this.row = row + 1;
    }

    public void setColumn(int column) {
        this.column = column + 1;
    }
}
