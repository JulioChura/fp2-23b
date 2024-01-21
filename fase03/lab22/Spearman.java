public class Spearman extends Soldier {
    private int lonLance;

    public Spearman(int lonLance) {
        this.lonLance = lonLance;
    }

    public Spearman(String name, int row, int column, int attackLevel, int defenseLevel, int actualLife, int speed,
            String attitude, boolean current, int lonLance) {
        super(name, row, column, attackLevel, defenseLevel, actualLife, speed, attitude, current);
        this.lonLance = lonLance;
    }

    
    
    public Spearman(String name, int row, int column, int attackLevel, int defenseLevel, int actualLife, int speed,
            int lonLance) {
        super(name, row, column, attackLevel, defenseLevel, actualLife, speed);
        this.lonLance = lonLance;
    }

    public void schiltrom() {
        int newDefense = getDefenseLevel() +1;
        setDefenseLevel(newDefense);  
    }

    @Override
    public String toString() {
        return "Lancero "+ super.display() +", Longitud de lanza: " + lonLance;
    }
    
}