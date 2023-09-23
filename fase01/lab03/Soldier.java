public class Soldier {
    private String name;
    private int lifePoints;
    
    public String getName() {
        return name;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    @Override
    public String toString() {
        return "Soldier{" + "name=" + name + ", lifePoints=" + lifePoints + '}';
    }  
   	
}

