// Laboratorio Nro 5
// Autor: Julio
// Tiempo: 20
// No hubo colaboradores

import java.util.*;

public class VideoJuego {
	public static void main(String[] args) {

		Soldier[][] army = generateArmy();
		Soldier[] armyU = arrayUnidimensional(army);
		miTablero(army);
	}

	public static Soldier[] arrayUnidimensional(Soldier[][] s) {
		int contador = 0;
		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < s[i].length; j++) {
				if (s[i][j] != null) {
					contador++;
				}
			}
		}

		Soldier[] armyU = new Soldier[contador];
		int indice = 0;
		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < s[i].length; j++) {
				if (s[i][j] != null) {
					armyU[indice] = s[i][j];
					indice++;
				}
			}
		}
		return armyU;
	}

	public static Soldier[][] generateArmy() {
		Random random = new Random();
		int amount = random.nextInt(10) + 1;
		Soldier[][] myArmy = new Soldier[10][10];
		int i = 0;
		do {
			int row = random.nextInt(10);
			int column = random.nextInt(10);
			if (myArmy[row][column] == null) {
				String name = "Soldier" + (i + 1);
				int lifePoints = random.nextInt(5) + 1;

				myArmy[row][column] = new Soldier();

				myArmy[row][column].setLifePoints(lifePoints);
				myArmy[row][column].setName(name);
				myArmy[row][column].setColumn(column);
				myArmy[row][column].setRow(row);

				i++;
			}
		} while (i < amount);
		return myArmy;
	}

	public static void miTablero(Soldier[][] a) {
		String[][] tablero = new String[10][10];
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				tablero[i][j] = "|___|";
			}
		}

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (a[i][j] != null) {
					tablero[i][j] = "|_s_|";
				}
			}
		}

		System.out.print("    A    B    C    D    E   F    G    H    I    J \n");
		for (int i = 0; i < tablero.length; i++) {
			System.out.printf("%2d", (i + 1));
			for (int j = 0; j < tablero[i].length; j++) {
				System.out.print(tablero[i][j]);
			}
			System.out.println();
		}
	}

}
