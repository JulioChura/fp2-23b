public class KnightMoro extends Soldier implements SpecialUnit {
    private int arrows = 10;
    private int levelEvolution = 1;

    
    
    public KnightMoro(int arrows, int levelEvolution) {
        this.arrows = arrows;
        this.levelEvolution = levelEvolution;
    }



    public KnightMoro(String name, int row, int column, int attackLevel, int defenseLevel, int actualLife, int speed,
            int arrows, int levelEvolution) {
        super(name, row, column, attackLevel, defenseLevel, actualLife, speed);
        this.arrows = arrows;
        this.levelEvolution = levelEvolution;
        actualLife = 13;
    }



    public KnightMoro(String name, int row, int column, int attackLevel, int defenseLevel, int actualLife, int speed,
            String attitude, boolean current, int arrows, int levelEvolution) {
        super(name, row, column, attackLevel, defenseLevel, actualLife, speed, attitude, current);
        this.arrows = arrows;
        this.levelEvolution = levelEvolution;
        actualLife = 13;
    }



    public void throwObjects() {
        if (arrows > 0) {
            attack();
            arrows--;
        } else {
            System.err.println("No se pudo atacar");
        }

    }

    public void evolve() {
        if (levelEvolution <= MAX_LEVEL) {
            levelEvolution++;
            arrows +=  10;
        }
    
    }

    public void charge() {

    }

}
