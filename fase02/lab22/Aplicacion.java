// Laboratorio Nro 20
// Autor: Julio
// Tiempo: 6 horas
// No hubo colaboradores

import java.util.*;

public class Aplicacion {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String kingdom1;
        String kingdom2;

        while (validation()) {

            System.out.println("Elija su reino (Francia, Inglaterra, Moros, Roma, Castilla)");
            kingdom1 = sc.next();

            System.out.println("Elija su reino (Francia, Inglaterra, Moros, Roma, Castilla)");
            kingdom2 = sc.next();

            Army a = new Army(kingdom1);
            Army b = new Army(kingdom2);

            a.generateArmy(b);
            b.generateArmy(a);

            a.showArmy();
            System.out.println();
            b.showArmy();
            System.out.println();

            Board tablero = new Board(a, b, "Castilla", "Francia");
            tablero.generateMap();

            System.out.println("Contando los soldados");
            System.out.println("Ejercito 1:" + a.count());
            System.out.println("Ejercito 2:" + b.count());
            System.out.println();

            System.out.println("Datos de los soldados con mayor vida");
            a.longerLife();
            b.longerLife();

            System.out.println();
            GameFast gameFast = new GameFast(tablero, a, b, false);
            gameFast.winner();
        }
    }

    public static boolean validation() {
        do {
            System.out.println("Desea jugar una ronda?(si/no)");
            String answer = sc.next();
            if (answer.equalsIgnoreCase("Si")) {
                return true;
            } else if (answer.equalsIgnoreCase("No")) {
                return false;
            } else {
                System.out.println("Respuesta no admsible");
            }
        } while (true);

    }

}
