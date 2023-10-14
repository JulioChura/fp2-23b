// Laboratorio Nro 5
// Autor: Julio
// Tiempo: 3 horas
// No hubo colaboradores

import java.util.*;

public class VideoJuego {
	public static void main(String[] args) {

		Soldier[][] army = generateArmy();
		Soldier[] armyU = arrayUnidimensional(army);
		miTablero(army);
		System.out.println("Mostrando soldados por orden de creacion");
		mostrarPorCreacion(armyU);
		mayorVida(armyU);	
		System.out.println("El soldado con mayor vida: " + armyU[armyU.length - 1]);
		totalLifeAndAverage(armyU);
		System.out.println("Mostrando soldados por ranking de poder");
		orderByPower(armyU);
		
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

	// Se hará uso del ordenamiento por inserción
	public static void mayorVida(Soldier[] s) {
		int n = s.length;
		for (int i = 1; i < n; i++) {
			Soldier key = s[i];
			int j = i - 1;
			while (j >= 0 && s[j].getLifePoints() > key.getLifePoints()) {
				s[j + 1] = s[j];
				j--;
			}
			s[j + 1] = key;
		}
	}

	public static void mostrarPorCreacion(Soldier[] sol) {
		for (int i = 0; i < sol.length; i++) {
			System.out.println(sol[i]);
		}
	}

	public static void totalLifeAndAverage(Soldier[] sol) {
		int addition = 0;
		for (int i = 0; i < sol.length; i++) {
			addition = addition + sol[i].getLifePoints();
		}
		System.out.println("El promedio de vida del ejercito es: " + (double) addition / sol.length);
		System.out.println("El total de vida del ejercito es: " + addition);
	}

	// Por condiciones del problema se solicitan dos metodos de ordenamiento, por lo
	// que este seria el segundo. Se usara el burbuja
	public static void orderByPower(Soldier[] ar) {
		boolean swapped;
		Soldier temp;
		for (int i = 0; i < ar.length - 1; i++) {
			swapped = false;
			for (int j = 0; j < ar.length - 1 - i; j++) {
				temp = ar[j];
				ar[j] = ar[j + 1];
				ar[j + 1] = temp;
				swapped = true;

			}
			if (swapped == false) {
				break;
			}
		}
		for (int i = 0; i < ar.length; i++) {
			System.out.println(ar[i]);
		}

	}

}
