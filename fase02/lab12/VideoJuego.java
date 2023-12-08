// Laboratorio Nro 12
// Autor: Julio
// Tiempo: 
// No hubo colaboradores

import java.util.*;

public class VideoJuego {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (validation()) {
			HashMap<String, Soldier> armyA = generateArmy();
			HashMap<String, Soldier> armyB = generateArmyB(armyA);
			int a = totalLife(armyA);
			int b = totalLife(armyB);

			System.out.println("oooooooooooooooo  FASE 1 DE LA CONTIENDA  oooooooooooooooo");
			System.out.println("Mostrando estadisticas de cada ejercito" + "\n");
			System.out.println("Mostrando soldados por orden de creacion");
			System.out.println("DATOS DEL DEL EJERCITO A");
			showByCreation(armyA);
			System.out.println("Mayor vida en A: " + longerLife(armyA));
			System.out.println("El total de vida del ejercito A es: " + a);
			System.out.println("El promedio de vida del ejercito A es: " + (double) a / armyA.size());
			System.out.println("Mostrando soldados por ranking de poder de A");
			orderByPower(armyA);
			System.out.println("Ingrese el nombre del Soldier que desea buscar");
			String nameA = sc.next();
			binarySearchByName(armyA, nameA);
			System.out.println("DATOS DEL EJRCITO B");
			showByCreation(armyB);
			System.out.println("Mayor vida en B: " + longerLife(armyB));
			System.out.println("El total de vida del ejercito B es: " + b);
			System.out.println("El promedio de vida del ejercito B es: " + (double) b / armyB.size());
			System.out.println("Mostrando soldados por ranking de poder de B");
			orderByPower(armyB);
			System.out.println("Ingrese el nombre del Soldier que desea buscar");
			String nameB = sc.next();
			sequenceSearchByName(armyB, nameB);
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

	public static HashMap<String, Soldier> generateArmy() {
		int rowBoard = 10;
		int columnBoard = 10;
		HashMap<String, Soldier> army = new HashMap<String, Soldier>();
		Random random = new Random();
		int amount = random.nextInt(10) + 1;
		int n = 0;
		do {
			int row = random.nextInt(rowBoard) + 1;
			int column = random.nextInt(columnBoard) + 1;
			String key = "Soldier" + row + "X" + column;
			if (!army.containsKey(key)) {
				int lifePoints = random.nextInt(5) + 1;
				Soldier soldier = new Soldier();
				soldier.setColumn(column);
				soldier.setRow(row);
				soldier.setLifePoints(lifePoints);
				soldier.setName(key);
				army.put(key, soldier);
				n++;
			}
		} while (n < amount);
		return army;
	}

	public static HashMap<String, Soldier> generateArmyB(HashMap<String, Soldier> a) {
		int rowBoard = 10;
		int columnBoard = 10;
		HashMap<String, Soldier> army = new HashMap<String, Soldier>();
		Random random = new Random();
		int amount = random.nextInt(10) + 1;
		int n = 0;
		do {
			int row = random.nextInt(rowBoard) + 1;
			int column = random.nextInt(columnBoard) + 1;
			String key = "Soldier" + row + "X" + column;
			if (!army.containsKey(key) && !a.containsKey(key)) {
				int lifePoints = random.nextInt(5) + 1;
				Soldier soldier = new Soldier();
				soldier.setColumn(column);
				soldier.setRow(row);
				soldier.setLifePoints(lifePoints);
				soldier.setName(key);
				army.put(key, soldier);
				n++;
			}
		} while (n < amount);
		return army;
	}

	public static void showByCreation(HashMap<String, Soldier> army) {
		for (String key : army.keySet()) {
			System.out.println(key + ": " + army.get(key));
		}
	}

	// Se hará uso del ordenamiento por inserción
	public static Soldier longerLife(HashMap<String, Soldier> hashMap) {
		Soldier[] army = new Soldier[hashMap.size()];
		int index = 0;
		for (String key : hashMap.keySet()) {
			army[index] = hashMap.get(key);
			index++;
		}
		int n = army.length;
		for (int i = 1; i < n; i++) {
			Soldier key = army[i];
			int j = i - 1;
			while (j >= 0 && army[j].getLifePoints() > key.getLifePoints()) {
				army[j + 1] = army[j];
				j--;
			}
			army[j + 1] = key;
		}
		return army[army.length - 1];
	}

	public static int totalLife(HashMap<String, Soldier> army) {
		int addition = 0;
		for (String key : army.keySet()) {
			addition = addition + army.get(key).getLifePoints();
		}
		return addition;
	}

	// Por condiciones del problema se solicitan dos metodos de ordenamiento, por lo
	// que este seria el segundo. Se usara el burbuja.
	public static void orderByPower(HashMap<String, Soldier> army) {
		ArrayList<Map.Entry<String, Soldier>> list = new ArrayList<>(army.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Soldier>>() {
			public int compare(Map.Entry<String, Soldier> o1, Map.Entry<String, Soldier> o2) {
				return Integer.compare(o1.getValue().getLifePoints(), o2.getValue().getLifePoints());
			}
		});
		HashMap<String, Soldier> sortedMap = new LinkedHashMap<>();
		for (Map.Entry<String, Soldier> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		for (String key : sortedMap.keySet()) {
			System.out.println(key + ": " + sortedMap.get(key));
		}

	}

	public static void binarySearchByName(HashMap<String, Soldier> army, String name) {
		ArrayList<Map.Entry<String, Soldier>> list = new ArrayList<>(army.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Soldier>>() {
			public int compare(Map.Entry<String, Soldier> o1, Map.Entry<String, Soldier> o2) {
				return o1.getValue().getName().compareTo(o2.getValue().getName());
			}
		});
		HashMap<String, Soldier> sortedMap = new LinkedHashMap<>();
		for (Map.Entry<String, Soldier> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		ArrayList<String> keys = new ArrayList<>(sortedMap.keySet());
		int low = 0;
		int high = keys.size() - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			String str = keys.get(mid);
			if (str.equalsIgnoreCase(name)) {
				System.out.println("Se ha encontrado: " + army.get(str));
				return;
			} else if (str.compareTo(name) < 0) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		System.out.println("No se han encontrado coincidencias");

	}

	public static void sequenceSearchByName(HashMap<String, Soldier> army, String name) {
		ArrayList<String> keys = new ArrayList<>(army.keySet());
		for (int i = 0; i < army.size(); i++) {
			String myKey = keys.get(i);
			if (name.equalsIgnoreCase(myKey)) {
				System.out.println(army.get(myKey));
			}
		}
	}

	public static void myBoard(HashMap<String, Soldier> a, HashMap<String, Soldier> b) {
		String[][] tablero = new String[10][10];
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				tablero[i][j] = "|____|";
			}
		}
		for (String key : a.keySet()) {
			Soldier soldier = a.get(key);
			int lifePoints = soldier.getLifePoints();
			int row = soldier.getRow() - 1;
			int column = soldier.getColumn() - 1;
			String str = "|_" + "a" + lifePoints + "_|";
			tablero[row][column] = str;
		}
		for (String key : b.keySet()) {
			Soldier soldier = b.get(key);
			int lifePoints = soldier.getLifePoints();
			int row = soldier.getRow() - 1;
			int column = soldier.getColumn() - 1;
			String str = "|_" + "b" + lifePoints + "_|";
			tablero[row][column] = str;
		}
		System.out.print("    A     B     C     D     E    F     G     H     I     J \n");
		for (int i = 0; i < tablero.length; i++) {
			System.out.printf("%2d", (i + 1));
			for (int j = 0; j < tablero[i].length; j++) {
				System.out.print(tablero[i][j]);
			}
			System.out.println();
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

}