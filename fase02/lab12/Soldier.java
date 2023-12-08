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

    public Soldier clone() {
        Soldier clon = new Soldier();
        clon.name = this.name;
        clon.attackLevel = this.attackLevel;
        clon.defenseLevel = this.defenseLevel;
        clon.actualLife = this.actualLife;
        clon.speed = this.speed;
        clon.attitude = this.attitude;
        clon.current = this.current;
        clon.row = this.row;
        clon.column = this.column;
        return clon;
    }
    public void compareTo(Soldier s) {
        if (this.attackLevel == s.getAttackLevel()) {
            System.out.println("Tienen igual nivel de ataque");
        } else {
            System.out.println("Tienen distintos niveles de ataque");
        }
        if (this.defenseLevel == s.getDefenseLevel()) {
            System.out.println("Tiene igual nivel de defensa");
        } else {
            System.out.println("Tienen diferente nivel de defensa");
        }
        if (this.actualLife == s.getActualLife()) {
            System.out.println("Su vida actual de vida es actual");
        } else {
            System.out.println("Su vida actual son diferentes");
        }
        if (this.current && s.getCurrent()) {
            System.out.println("Ambos viven");
        } else {
            System.out.println("El estado de si vive o no es distinto");
        }
        if (this.speed == s.getSpeed()) {
            System.out.println("Tienen igual velocidad");
        } else {
            System.out.println("Tienen diferentes velocidades");
        } 
    }
    
    public Soldier mightySoldier(Soldier s) {
        Soldier sol = new Soldier();
        this.actualLife = this.actualLife + s.getActualLife();
        this.attackLevel = this.attackLevel + s.getAttackLevel();
        this.defenseLevel = this.defenseLevel + s.getDefenseLevel();
        this.speed = this.speed + s.getSpeed();

        sol.setActualLife(this.actualLife);
        sol.setAttackLevel(this.attackLevel);
        sol.setDefenseLevel(this.defenseLevel);
        sol.setSpeed(this.speed);
        return sol;
    }
    public String toString() {
        return "Soldier [name=" + name + ", lifePoints=" + lifePoints + ", row=" + row + ", column=" + column + "]";
    }

}
