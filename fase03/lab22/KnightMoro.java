public class KnightMoro extends Knight implements SpecialUnit {
    private int arrows = 10;

    public KnightMoro(String name, int row, int column, int attackLevel, int defenseLevel, int actualLife, int speed,
            String attitude, boolean current, int arroes, String weapon, boolean riding, int arrows,
            int levelEvolution) {
        super(name, row, column, attackLevel, defenseLevel, actualLife, speed, attitude, current, arroes, weapon,
                riding);
        this.arrows = arrows;
        this.levelEvolution = levelEvolution;
        actualLife = 13;
    }

    public KnightMoro(String currentWeapon, boolean horseRiding, int arrows, int levelEvolution) {
        super(currentWeapon, horseRiding);
        this.arrows = arrows;
        this.levelEvolution = levelEvolution;
    }

    public KnightMoro(String name, int row, int column, int attackLevel, int defenseLevel, int actualLife, int speed,
            String currentWeapon, boolean horseRiding, int arrows, int levelEvolution) {
        super(name, row, column, attackLevel, defenseLevel, actualLife, speed, currentWeapon, horseRiding);
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
            arrows += 10;
        }

    }

    public String toString() {
        return "C. Moro ->  Flechas: "+ arrows + super.display();
    }

}
