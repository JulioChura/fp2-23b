package logica;

public class Knight extends Soldier {
    private String currentWeapon;
    private boolean horseRiding;

    public Knight(String name, int row, int column, int attackLevel, int defenseLevel, int actualLife, int speed,
            String attitude, boolean current, int arroes, String weapon, boolean riding) {
        super(name, row, column, attackLevel, defenseLevel, actualLife, speed, attitude, current);
        currentWeapon = weapon;
        horseRiding = riding;
    }

    

    public Knight(String currentWeapon, boolean horseRiding) {
        this.currentWeapon = currentWeapon;
        this.horseRiding = horseRiding;
    }



    public Knight(String name, int row, int column, int attackLevel, int defenseLevel, int actualLife, int speed,
            String currentWeapon, boolean horseRiding) {
        super(name, row, column, attackLevel, defenseLevel, actualLife, speed);
        this.currentWeapon = currentWeapon;
        this.horseRiding = horseRiding;
    }



    public void envestir() {
        if (horseRiding == true)
            for (int i = 0; i <= 2; i++)
                super.attack();
        else
            super.attack();
			super.attack();
    }

    public void desmontar() {
        if (horseRiding == true) {
            horseRiding = false;
            super.defend();
            cambiaArma();
        }
    }

    public void cambiaArma() {
        if (currentWeapon == "Lanza")
            currentWeapon = "Espada";
        else
            currentWeapon = "Lanza";
    }

    public void montar() {
        if (horseRiding == false) {
            horseRiding = true;
            super.attack();
            cambiaArma();
        }
    }


    @Override
    public String toString() {
        return " # Caballero -> Arma actual: " + currentWeapon + super.display();
    }
}
