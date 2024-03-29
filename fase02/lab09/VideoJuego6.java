// Laboratorio Nro 9
// Autor: Julio
// Fecha de Inicio: 02-11-2023	     Tiempo: 
// No hubo colaboradores

import java.util.*;

public class VideoJuego6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (validation()) {
			ArrayList<ArrayList<Soldier>> armyA = generateArmy();
			ArrayList<ArrayList<Soldier>> armyB = generateArmyB(armyA);
			ArrayList<Soldier> armyAU = arrayListUnidimensional(armyA);
			ArrayList<Soldier> armyBU = arrayListUnidimensional(armyB);
			int a = totalLife(armyAU);
			int b = totalLife(armyBU);

			System.out.println("oooooooooooooooo  FASE 1 DE LA CONTIENDA  oooooooooooooooo");
			System.out.println("Mostrando estadisticas de cada ejercito" + "\n");
			System.out.println("Mostrando soldados por orden de creacion");
			System.out.println("DATOS DEL DEL EJERCITO A");
			showByCreation(armyAU);
			System.out.println("Mayor vida en A: " + longerLife(armyAU));
			System.out.println("El total de vida del ejercito A es: " + totalLife(armyAU));
			System.out.println("El promedio de vida del ejercito A es: " + (double) a / armyAU.size());
			System.out.println("Mostrando soldados por ranking de poder de A");
			orderByPower(armyAU);
			System.out.println("Ingrese el nombre del Soldier que desea buscar");
			String nameA = sc.next();
			binarySearchByName(armyAU, nameA);
			System.out.println();
			System.out.println("DATOS DEL EJRCITO B");
			showByCreation(armyBU);
			System.out.println("Mayor vida en B: " + longerLife(armyBU));
			System.out.println("El total de vida del ejercito B es: " + totalLife(armyBU));
			System.out.println("El promedio de vida del ejercito B es: " + (double) b / armyBU.size());
			System.out.println("Mostrando soldados por ranking de poder de B");
			orderByPower(armyBU);
			System.out.println("Ingrese el nombre del Soldier que desea buscar");
			String nameB = sc.next();
			sequenceSearchByName(armyBU, nameB);
			System.out.println();

			System.out.println("oooooooooooooooo  FASE 2 DE LA CONTIENDA  oooooooooooooooo");
			System.out.println("Mostrando el tablero de juego");
			myBoard(armyA, armyB);
			System.out.println();

			System.out.println("+++++++++++++++++   FASE 3 DE LA CONTIENDA  +++++++++++++++++");
			System.out.println("El ganador se determina en base a los puntos de vida total");
			System.out.println("Enfrentamiento");
			theWinner(a, b);
		}

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

	public static ArrayList<ArrayList<Soldier>> generateArmyB(ArrayList<ArrayList<Soldier>> a) {
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
			if (army.get(row).get(column) == null && a.get(row).get(column) == null) {
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

	public static void myBoard(ArrayList<ArrayList<Soldier>> a, ArrayList<ArrayList<Soldier>> b) {
		String[][] tablero = new String[10][10];
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				tablero[i][j] = "|____|";
			}
		}
		for (int i = 0; i < a.size(); i++) {
			for (int j = 0; j < a.get(i).size(); j++) {
				if (a.get(i).get(j) != null) {
					String strA = "|_" + "a" + a.get(i).get(j).getLifePoints() + "_|";
					tablero[i][j] = strA;
				}
			}
		}
		for (int i = 0; i < b.size(); i++) {
			for (int j = 0; j < b.get(i).size(); j++) {
				if (b.get(i).get(j) != null && tablero[i][j] != "s") {
					String strB = "|_" + "b" + b.get(i).get(j).getLifePoints() + "_|";
					tablero[i][j] = strB;
				}
			}
		}
		System.out.print("   A     B     C     D     E    F     G     H     I     J \n");
		for (int i = 0; i < tablero.length; i++) {
			System.out.printf("%2d", (i + 1));
			for (int j = 0; j < tablero[i].length; j++) {
				System.out.print(tablero[i][j]);
			}
			System.out.println();
		}
	}

	// Se hará uso del ordenamiento por inserción
	public static Soldier longerLife(ArrayList<Soldier> s) {
		int n = s.size();
		for (int i = 1; i < n; i++) {
			Soldier key = s.get(i);
			int j = i - 1;
			while (j >= 0 && s.get(j).getLifePoints() > key.getLifePoints()) {
				s.set(j + 1, s.get(j));
				j--;
			}
			s.set(j + 1, key);
		}
		return s.get(s.size() - 1);
	}

	public static void showByCreation(ArrayList<Soldier> sol) {
		for (Soldier n : sol) {
			System.out.println(n);
		}
	}

	public static int totalLife(ArrayList<Soldier> sol) {
		int addition = 0;
		for (Soldier n : sol) {
			addition = addition + n.getLifePoints();
		}
		return addition;
	}

	// Por condiciones del problema se solicitan dos metodos de ordenamiento, por lo
	// que este seria el segundo. Se usara el burbuja.
	public static void orderByPower(ArrayList<Soldier> sol) {
		boolean swapped;
		Soldier temp;
		for (int i = 0; i < sol.size() - 1; i++) {
			swapped = false;
			for (int j = 0; j < sol.size() - 1 - i; j++) {
				temp = sol.get(j);
				sol.set(j, sol.get(j + 1));
				sol.set(j + 1, temp);
				swapped = true;
			}
			if (swapped == false) {
				break;
			}
		}
		for (Soldier n : sol) {
			System.out.println(n);
		}
	}

	public static void theWinner(int a, int b) {
		if (a < b) {
			System.out.println("El ganador es el equipo B");
			System.out.println("Ventaja de " + (b - a) + " puntos de vida");
		} else if (a > b) {
			System.out.println("El ganador es el equipo A");
			System.out.println("Ventaja de " + (a - b) + " puntos de vida");
		} else {
			System.out.println("Fue un empate");
		}
	}

	public static boolean validation() {
		Scanner sc = new Scanner(System.in);
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

	public static void binarySearchByName(ArrayList<Soldier> armyA, String name) {
		Collections.sort(armyA, new Comparator<Soldier>() {
			public int compare(Soldier soldier1, Soldier soldier2) {
				return soldier1.getName().compareTo(soldier2.getName());
			}
		});
		int high = armyA.size() - 1;
		int low = 0;
		while (low <= high) {
			int mid = (high + low) / 2;
			Soldier soldier = armyA.get(mid);
			if (name.equalsIgnoreCase(soldier.getName())) {
				System.out.println("Se ha encontrado: " + soldier);
				return;
			} else if (name.compareTo(soldier.getName()) < 0) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		System.out.println("No fue encontrado");
	}

	public static void sequenceSearchByName(ArrayList<Soldier> armyB, String name) {
		for (int i = 0; i < armyB.size(); i++) {
			if (name.equalsIgnoreCase(armyB.get(i).getName())) {
				System.out.println("Se ha encontrado: " + armyB.get(i));
				return;
			}
		}
		System.out.println("No se ha encontrado coincidencias");
	}

}
