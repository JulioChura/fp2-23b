import java.util.*;

public class GameFast {
    private Board board;
    private Army army1;
    private Army army2;
    private boolean gameOver;

    public GameFast(Board board, Army army1, Army army2, boolean gameOver) {
        this.board = board;
        this.army1 = army1;
        this.army2 = army2;
        this.gameOver = gameOver;
    }

    public void winner() {
        String kingdom1 = army1.getName();
        String kingdom2 = army2.getName();

        Random random = new Random();
        int definitiveProbability = random.nextInt(100);

        int total1 = totalLife(army1);
        int total2 = totalLife(army2);

        double totalLife = total1 + total2;
        double probabilityAttack1 = 100 * total1 / totalLife;
        double probabilityAttack2 = 100 - probabilityAttack1;

        System.out.println("Estadísticas de batalla:\tReino " + kingdom1 + ": " + probabilityAttack1
                + "%\tReino " + kingdom2 + ": " + probabilityAttack2 + "%\tSalio como aleatorio: "
                + definitiveProbability + "%");

        if (definitiveProbability <= probabilityAttack1) {
            System.out.println("Gano el reino " + kingdom1);
        } else if (definitiveProbability <= probabilityAttack2) {
            System.out.println("Gano el reino " + kingdom2);
        } else {
            System.out.println("Empate");
        }
    }

    public int totalLife(Army army) {
        int sumLife = 0;
        for (Soldier sol : army.getArmyInArrayUni()) {
            sumLife = sumLife + sol.getActualLife();
        }
        return sumLife;
    }
}
