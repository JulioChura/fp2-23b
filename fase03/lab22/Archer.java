public class Archer extends Soldier {
    private int arrows;

    public Archer(int arrows) {
        this.arrows = arrows;
    }

    public Archer(String name, int row, int column, int attackLevel, int defenseLevel, int actualLife, int speed,
            String attitude, boolean current, int arroes) {
        super(name, row, column, attackLevel, defenseLevel, actualLife, speed, attitude, current);
        this.arrows = arroes;
    }

    public Archer(String name, int row, int column, int attackLevel, int defenseLevel, int actualLife, int speed,
            int arrows) {
        super(name, row, column, attackLevel, defenseLevel, actualLife, speed);
        this.arrows = arrows;
    }

    public void shoot() {
        if (arrows > 0) {
            arrows--;
        } 
    }

    @Override
    public String toString() {
        return "Arquero "+  super.display()  +", Flechas: " + arrows;
    }
    
}
