// Laboratorio Nro 5
// Autor: Julio
// Tiempo: 20
// No hubo colaboradores

import java.util.*;

public class VideoJuego {
	public static void main(String[] args) {
		Soldier[][] army = generateArmy();
	}

	public static void printArray(Soldier[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i].toString());
		}
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

}
