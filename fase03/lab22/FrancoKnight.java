public class FrancoKnight extends Soldier implements SpecialUnit {

    private int spears = 10;
    private boolean defTor = false;

    public FrancoKnight(String name, int row, int column, int attackLevel, int defenseLevel, int actualLife, int speed,
            int spears, int levelEvolution, boolean defTor) {
        super(name, row, column, attackLevel, defenseLevel, actualLife, speed);
        this.spears = spears;
        this.levelEvolution = levelEvolution;
        this.defTor = defTor;
    }

    public void throwObjects() {
        if (spears > 0) {
            attack();
            spears--;
        } else {
            System.out.println("No se puede atacar");
        }
    }

    public void evolve() {
        if (levelEvolution <= MAX_LEVEL) {
            levelEvolution++;
            spears += levelEvolution * 10;

        } else {
            System.out.println("Maximo nivel");
        }
    }

    public String toString() {
        return "Caballero Franco "+ ", Lanzas: " + super.display();
    }
}
