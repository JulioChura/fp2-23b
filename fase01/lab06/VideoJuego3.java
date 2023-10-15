// Laboratorio Nro 5
// Autor: Julio
// Tiempo: 3 horas
// No hubo colaboradores

import java.util.*;

public class VideoJuego3 {
	public static void main(String[] args) {

		ArrayList<ArrayList<Soldier>> armyA = generateArmy();
		ArrayList<ArrayList<Soldier>> armyB = generateArmy();
		ArrayList<Soldier> armyAU = arrayListUnidimensional(armyA);
		ArrayList<Soldier> armyBU = arrayListUnidimensional(armyB);

		System.out.println("oooooooooooooooo  FASE 1 DE LA CONTIENDA  oooooooooooooooo");
		System.out.println("Mostrando estadisticas de cada ejercito" + "\n");

		System.out.println("oooooooooooooooo  FASE 2 DE LA CONTIENDA  oooooooooooooooo");
		System.out.println("Mostrando el tablero de juego");
		miTablero(armyA, armyB);
		/*
		 * Soldier[] armyU = arrayUnidimensional(army);
		 * miTablero(army);
		 * System.out.println("Mostrando soldados por orden de creacion");
		 * mostrarPorCreacion(armyU);
		 * mayorVida(armyU);
		 * System.out.println("El soldado con mayor vida: " + armyU[armyU.length - 1]);
		 * totalLifeAndAverage(armyU);
		 * System.out.println("Mostrando soldados por ranking de poder");
		 * orderByPower(armyU);
		 */
	}

	public static ArrayList<Soldier> arrayListUnidimensional(ArrayList<ArrayList<Soldier>> s) {
		ArrayList<Soldier> armyUni = new ArrayList<Soldier>();
		for (int i = 0; i < s.size(); i++) {
			for (int j = 0; j < s.get(i).size(); j++) {
				if (s.get(i).get(j) != null) {
					armyUni.add(s.get(i).get(j));
				}
			}
		}
		return armyUni;
	}

	public static ArrayList<ArrayList<Soldier>> generateArmy() {
		ArrayList<ArrayList<Soldier>> army = new ArrayList<ArrayList<Soldier>>(10);
		Random random = new Random();
		int amount = random.nextInt(10) + 1;
		int n = 0;
		for (int i = 0; i < 10; i++) {
			army.add(new ArrayList<>(Collections.nCopies(10, null)));
		}
		do {
			int row = random.nextInt(10);
			int column = random.nextInt(10);
			if (army.get(row).get(column) == null) {
				String name = "Soldier" + row + "x" + column;
				int lifePoints = random.nextInt(5) + 1;
				Soldier sol = new Soldier();
				sol.setLifePoints(lifePoints);
				sol.setName(name);
				sol.setColumn(column);
				sol.setRow(row);
				army.get(row).set(column, sol);
				n++;
			}
		} while (n < amount);
		return army;
	}

	public static void miTablero(ArrayList<ArrayList<Soldier>> a, ArrayList<ArrayList<Soldier>> b) {
		String[][] tablero = new String[10][10];
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				tablero[i][j] = "|___|";
			}
		}

		for (int i = 0; i < a.size(); i++) {
			for (int j = 0; j < a.get(i).size(); j++) {
				if (a.get(i).get(j) != null) {
					tablero[i][j] = "|_a_|";
				}
			}
		}

		for (int i = 0; i < b.size(); i++) {
			for (int j = 0; j < b.get(i).size(); j++) {
				if (b.get(i).get(j) != null && tablero[i][j] != "s") {
					tablero[i][j] = "|_b_|";
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

	public static void mostrarPorCreacion(ArrayList<Soldier> sol) {
		for (Soldier n : sol) {
			System.out.println(n);
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
