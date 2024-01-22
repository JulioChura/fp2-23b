//Pertenece al reino Aragon-Castilla
public class ConquerorSwordsman extends Swordsman implements SpecialUnit {
    private int axes = 10;

    public ConquerorSwordsman(double longSwords, int axes) {
        super(longSwords);
        this.axes = axes;
    }

    public ConquerorSwordsman(String name, int row, int column, int attackLevel, int defenseLevel, int actualLife,
            int speed, String attitude, boolean current, double longSwords, int axes) {
        super(name, row, column, attackLevel, defenseLevel, actualLife, speed, attitude, current, longSwords);
        this.axes = axes;
        actualLife = 14;
    }

    public ConquerorSwordsman(String name, int row, int column, int attackLevel, int defenseLevel, int actualLife,
            int speed, double longSwords, boolean shieldWalls, int axes) {
        super(name, row, column, attackLevel, defenseLevel, actualLife, speed, longSwords, shieldWalls);
        this.axes = axes;
        actualLife = 14;
    }

    public void throwObjects() {
        if (0 < axes) {
            attack();
            axes--;
        } else {
            System.out.println("No se pudo atacar");
        }
    }

    public void evolve() {
        if (levelEvolution < MAX_LEVEL) {
            levelEvolution++;
            axes = +10;
        } else {
            System.out.println("Se alcanzo el maximo nivel");
        }
    }

    public String toString() {
        return " # Esp. Conquist -> Hachas: " + axes +  super.display();
    }
    
}
