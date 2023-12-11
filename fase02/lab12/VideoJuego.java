// Laboratorio Nro 7
// Autor: Julio
// Tiempo: 3 horas
// No hubo colaboradores

import java.util.*;

public class VideoJuego {
	public static final Scanner sc = new Scanner(System.in);
	public static final int ROW_BOARD = 10;
	public static final int COLUMN_BOARD = 10;
	public static final int MAX_SOLDIER = 10;
	public static final int MAX_VALUE = 5;

	public static void main(String[] args) {
		// Maneja las opciones del Switch Case
		int option;
		// Maneja las opciones de juego personalizado (exepto gestion de ejercitos)
		int optionsDuringGame;
		// Maneja el flujo general del juego (ir a juego rapido o personalizado)
		boolean caseGeneral = true;
		// Maneja la opcion de poder salir del modo rapido
		boolean continueGame;
		// Cuando hayamos presionado Juego personalizado y elijamos una opcion, podremos
		// retornar a Juego personalizado y elegir otra de las opciones
		boolean returnMenuOption2 = true;
		// este boolean permite salir de juego personalizado al menu principal
		boolean exit = true;
		// Estos ArrayList permitiran almancenar copias por ArrayList
		ArrayList<ArrayList<Soldier>> copyB;
		ArrayList<Soldier> copyU;
		ArrayList<ArrayList<Soldier>> anotherCopyB;
		ArrayList<Soldier> anotherCopyU;

		do {
			System.out.println("1: Juego rapido\n2: Juego personalizado\n3: Salir");
			option = sc.nextInt();
			ArrayList<ArrayList<Soldier>> empty = armyEmpty();
			ArrayList<ArrayList<Soldier>> armyAEmpty = armyEmpty();
			ArrayList<ArrayList<Soldier>> armyBEmpty = armyEmpty();
			ArrayList<ArrayList<Soldier>> armyA = generateArmy(armyAEmpty, empty);
			ArrayList<ArrayList<Soldier>> armyB = generateArmy(armyBEmpty, armyA);

			ArrayList<Soldier> armyAU = arrayListUnidimensional(armyA);
			ArrayList<Soldier> armyBU = arrayListUnidimensional(armyB);
			switch (option) {
				case 1:
					continueGame = validation();
					if (!continueGame) {
						continue;
					}

					while (continueGame) {
						stagesOfWar(armyA, armyB, armyAU, armyBU);

						if (quickBattle(armyA, armyB) == false) {
							continueGame = false;
						} else {
							continue;
						}

					}
					break;
				case 2:

					do {

						System.out.println("DATOS DEL EJRCITO A");
						showByCreation(armyAU);
						System.out.println("DATOS DEL EJRCITO B");
						showByCreation(armyBU);

						System.out.println(
								"1: Crear soldado\n2: Eliminar soldado\n3: Clonar soldado\n4: Modificar soldado\n5: Comparar Soldado\n6: Intercambiar soldado\n7: Ver soldado\n8: Ver ejercito\n9: Sumar niveles\n10: Jugar\n11: Volver al menu principal");
						optionsDuringGame = sc.nextInt();

						if (optionsDuringGame >= 1 && optionsDuringGame <= 10) {
							do {
								System.out.println("Elija el ejercito que editara:\n1: Ejercito A\n2: Ejercito B");
								option = sc.nextInt();
								if (option == 1) {
									copyB = armyA;
									copyU = armyAU;
									anotherCopyB = armyB;
									anotherCopyU = armyBU;
									break;
								} else if (option == 2) {
									copyB = armyB;
									copyU = armyBU;
									anotherCopyB = armyA;
									anotherCopyU = armyAU;
									break;

								} else {
									System.out.println("Opcion no valida!");
									continue;
								}

							} while (true);
							do {
								switch (optionsDuringGame) {
									case 1:
										createSoldier(copyB, copyU, anotherCopyB);
										break;
									case 2:
										System.out.println("Debe Eliminar un soldado");
										myBoard(armyA, armyB);
										removeSoldier(copyB, copyU);
										break;
									case 3:
										cloneSoldier(copyB, copyU);
										break;
									case 4:
										changeAttributes(copyB, copyU);
										break;
									case 5:
										compareSoldier(copyB);
										break;
									case 6:
										exchangePosition(copyB);
										break;
									case 7:
										System.out.println("Ingrese el nombre del soldado a buscar");
										String name = sc.next();
										binarySearchByName(copyU, name);
										break;
									case 8:
										showByCreation(copyU);
										break;
									case 9:
										sumOfAttributes(copyB, copyU);
										break;
									case 10:
										stagesOfWar(copyB, anotherCopyB, copyU, anotherCopyU);
										quickBattle(copyB, anotherCopyB);
										break;
									case 11:
										exit = false;
										break;

								}
								returnMenuOption2 = false;
							} while (returnMenuOption2);

						} else if (optionsDuringGame == 11) {
							exit = false;
						} else {
							System.out.println("No valido!");
							continue;
						}

					} while (exit);
					break;
				case 3:
					caseGeneral = false;
					break;
			}
		} while (caseGeneral);

	}

	// Transforma un ArrayList Bidimensional a Unidimensional
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

	// Genera un ArrayList bidimensional pero vacio
	public static ArrayList<ArrayList<Soldier>> armyEmpty() {
		ArrayList<ArrayList<Soldier>> army = new ArrayList<>(10);
		for (int i = 0; i < 10; i++) {
			army.add(new ArrayList<>(Collections.nCopies(10, null)));
		}
		return army;
	}

	// Inicializa ArrayList con objetos de tipo Soldier
	public static ArrayList<ArrayList<Soldier>> generateArmy(ArrayList<ArrayList<Soldier>> a,
			ArrayList<ArrayList<Soldier>> b) {

		Random random = new Random();
		int amount = random.nextInt(10) + 1;
		int n = 0;
		int row, column;
		int lifePoints;
		String name;
		do {
			row = random.nextInt(ROW_BOARD);
			column = random.nextInt(COLUMN_BOARD);
			if (a.get(row).get(column) == null && b.get(row).get(column) == null) {
				name = "Soldier" + (row + 1) + "x" + (column + 1);
				lifePoints = random.nextInt(MAX_VALUE) + 1;
				int attack = random.nextInt(MAX_VALUE) + 1;
				int defense = random.nextInt(MAX_VALUE) + 1;
				Soldier sol = new Soldier(name, row + 1, column + 1, attack, defense, lifePoints, 0);
				a.get(row).set(column, sol);
				n++;
			}
		} while (n < amount);
		return a;
	}

	// Este metodo genera el tablero y lo muestra
	public static void myBoard(ArrayList<ArrayList<Soldier>> a, ArrayList<ArrayList<Soldier>> b) {
		String[][] tablero = new String[ROW_BOARD][COLUMN_BOARD];
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				tablero[i][j] = "|____|";
			}
		}
		for (int i = 0; i < a.size(); i++) {
			for (int j = 0; j < a.get(i).size(); j++) {
				if (a.get(i).get(j) != null) {
					String strA = "|_" + "a" + a.get(i).get(j).getActualLife() + "_|";
					tablero[i][j] = strA;
				}
			}
		}
		for (int i = 0; i < b.size(); i++) {
			for (int j = 0; j < b.get(i).size(); j++) {
				if (b.get(i).get(j) != null && tablero[i][j] != "s") {
					String strB = "|_" + "b" + b.get(i).get(j).getActualLife() + "_|";
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
			while (j >= 0 && s.get(j).getActualLife() > key.getActualLife()) {
				s.set(j + 1, s.get(j));
				j--;
			}
			s.set(j + 1, key);
		}
		return s.get(s.size() - 1);
	}

	// Imprime los soldier de acuerdo a su orden de creación
	public static void showByCreation(ArrayList<Soldier> sol) {
		for (Soldier n : sol) {
			System.out.println(n);
		}
	}

	public static int totalLife(ArrayList<Soldier> sol) {
		int addition = 0;
		for (Soldier n : sol) {
			addition = addition + n.getActualLife();
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

	// Pregunta al jugador si quiere jugar una ronda
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

	public static void stagesOfWar(ArrayList<ArrayList<Soldier>> armyA,
			ArrayList<ArrayList<Soldier>> armyB, ArrayList<Soldier> armyAU, ArrayList<Soldier> armyBU) {

		System.out.println("oooooooooooooooo  FASE 1 DE LA CONTIENDA  oooooooooooooooo");
		System.out.println("Mostrando estadisticas de cada ejercito" + "\n");
		System.out.println("DATOS DEL DEL EJERCITO A");
		showByCreation(armyAU);
		System.out.println("DATOS DEL EJRCITO B");
		showByCreation(armyBU);
		System.out.println();

		System.out.println("oooooooooooooooo  FASE 2 DE LA CONTIENDA  oooooooooooooooo");
		System.out.println("Mostrando el tablero de juego");
		myBoard(armyA, armyB);
		System.out.println();

		System.out.println("+++++++++++++++++   FASE 3 DE LA CONTIENDA  +++++++++++++++++");

	}

	// Se encarga de devolver la coordenada del soldado que se quiere mover
	public static int[] coordinate(ArrayList<ArrayList<Soldier>> army) {
		int[] coordinate = new int[2];

		do {

			System.out.println("Ingrese las coordenadas");
			String position = sc.next().toLowerCase();
			int row;
			int column;
			if (position.length() == 2) {
				row = Integer.parseInt(position.substring(0, 1));
				column = position.charAt(1) - 'a' + 1;
			} else if (position.length() == 3) {
				row = Integer.parseInt(position.substring(0, 2));
				column = position.charAt(2) - 'a' + 1;
			} else if (position.equalsIgnoreCase("Salir")) {
				coordinate[0] = -1;
				coordinate[1] = -1;
				return coordinate;
			} else {
				System.out.println("Coordenda no válida");
				continue;
			}
			if (row >= 1 && row <= 10 && column <= 10 && column >= 1 && army.get(row - 1).get(column - 1) != null) {
				coordinate[0] = row - 1;
				coordinate[1] = column - 1;
				return coordinate;
			}
		} while (true);
	}

	/*
	 * Se encarga de validar la nueva posicion del soldier retornando asi la nueva
	 * coordenada (Solo se retorna dos enteros, siendo row y column)
	 */
	public static int[] newCoordinateToMove(int row, int column, ArrayList<ArrayList<Soldier>> attack) {
		int[] rowAndColumn = new int[2];
		do {
			System.out.println("Hacia donde quiere mover? up(1), down(2), left(3), right(4), exit(5) ");
			int direction = sc.nextInt();
			int newRowPosition = row;
			int newColumnPosition = column;

			switch (direction) {
				case 1: // arriba
					newRowPosition--;
					break;
				case 2: // abajo
					newRowPosition++;
					break;
				case 3: // izquierda
					newColumnPosition--;
					break;
				case 4: // derecha
					newColumnPosition++;
					break;
				case 5:
					rowAndColumn[0] = -1;
					rowAndColumn[1] = -1;
					return rowAndColumn;
				default:
					System.out.println("Dirección no válida");
					break;
			}

			if (newRowPosition < 0 || newRowPosition >= 10 || newColumnPosition < 0 || newColumnPosition >= 10) {
				System.out.println("Movimiento fuera del tablero");
				continue;
			}
			if (attack.get(newRowPosition).get(newColumnPosition) != null) {
				System.out.println("No se puede mover a una posición ocupada por un soldado del mismo bando");
				continue;
			}
			rowAndColumn[0] = newRowPosition;
			rowAndColumn[1] = newColumnPosition;
			return rowAndColumn;
		} while (true);

	}

	// Hace que el soldier se mueve a otra casilla
	public static boolean moveSoldier(ArrayList<ArrayList<Soldier>> attack, ArrayList<ArrayList<Soldier>> repose,
			String A) {
		int[] coordinates = coordinate(attack);
		int rowPosition = coordinates[0];
		int columnPosition = coordinates[1];

		// Se verifica que el usuario quiere o no seguir en el juego
		if (rowPosition == -1) {
			return false;
		}
		Soldier attackingSoldier = attack.get(rowPosition).get(columnPosition);
		int[] rowAndColumn = newCoordinateToMove(rowPosition, columnPosition, attack);
		int newRowPosition = rowAndColumn[0];
		int newColumnPosition = rowAndColumn[1];

		if (newRowPosition == -1) {
			return false;
		}

		Soldier targetSoldier = repose.get(newRowPosition).get(newColumnPosition);
		targetSoldier.advance();
		if (targetSoldier != null) {

			int actualLifeRepose = targetSoldier.getActualLife();
			int actualLifeAAttack = attackingSoldier.getActualLife();
			double totalLife = actualLifeAAttack + actualLifeRepose;
			double probabilityAttack = 100 * actualLifeAAttack / totalLife;

			double random = Math.random() * 101;
			System.out.println("Estadisticas de batalla:\tSoldado de atacante: " + probabilityAttack
					+ "%\tSoldado en reposo: " + Math.abs((100 - probabilityAttack)) + "\tSalio como aleatorio: "
					+ random);
			attackingSoldier.attack();
			targetSoldier.attack();
			System.out.println(targetSoldier + " \n " + attackingSoldier);
			if (random < probabilityAttack) {
				repose.get(newRowPosition).set(newColumnPosition, null);
				attack.get(newRowPosition).set(newColumnPosition, attackingSoldier);
				System.out.println(targetSoldier);
				System.out.println("Ha ganado el soldado del ejército atacante");
			} else if (random > probabilityAttack) {
				System.out.println("Ha ganado el soldado en reposo");
				System.out.println(attackingSoldier);
			} else {
				repose.get(newRowPosition).set(newColumnPosition, null);
				System.out.println("EMPATE, ambos son destruidos");
			}

		} else {
			attack.get(newRowPosition).set(newColumnPosition, attackingSoldier);
			System.out.println("El soldado se ha movido.");
		}
		attack.get(rowPosition).set(columnPosition, null);
		return true;

	}

	// Se encarga de revisar si un ejercito se ha quedado sin
	public static boolean isEmpty(ArrayList<ArrayList<Soldier>> a) {
		for (ArrayList<Soldier> row : a) {
			for (Soldier soldier : row) {
				if (soldier != null) {
					return false;
				}
			}

		}
		return true;
	}

	// Determina al ganador de la contienda
	public static boolean winnerBattle(ArrayList<ArrayList<Soldier>> a, ArrayList<ArrayList<Soldier>> b) {
		boolean emptyInA = isEmpty(a);
		boolean emptyInB = isEmpty(b);
		if (emptyInA && emptyInB) {
			System.out.println("EMPATE");
			return false;
		} else if (emptyInA) {
			System.out.println("Ha ganado B");
			return false;
		} else if (emptyInB) {
			System.out.println("Ha ganado A");
			return false;
		}
		return true;
	}

	// Case 1: Crear soldier.
	public static void createSoldier(ArrayList<ArrayList<Soldier>> army, ArrayList<Soldier> armyU,
			ArrayList<ArrayList<Soldier>> enemy) {
		int amount = armyU.size();
		int row, column, attack, defense, life, speed;
		String name;
		if (amount <= 9) {
			do {
				System.out.println(" Ingrese la fila (ejm 1,2,3..10)");
				row = sc.nextInt() - 1;
				System.out.println("Ingrese la columna (ejm 1,2,3...10)");
				column = sc.nextInt() - 1;
				if (army.get(row).get(column) == null && enemy.get(row).get(column) == null) {
					System.out.println("Ingrese el nivel de ataque");
					attack = sc.nextInt();

					System.out.println("Ingrese el nivel de defensa");
					defense = sc.nextInt();

					System.out.println("Ingrese el nivel de vida");
					life = sc.nextInt();

					System.out.println("Ingrese la velocidad");
					speed = sc.nextInt();

					name = "Soldier" + (row + 1) + "X" + (column + 1);

					Soldier newSoldier = new Soldier(name, row + 1, column + 1, attack, defense, life, speed);
					army.get(row).set(column, newSoldier);

					armyU.add(newSoldier);
					break;
				}
			} while (true);
		} else {
			System.out.println("Este ejército sobrepasó la cantidad permitida");
		}
	}

	// case 2: Este metodo elimina un soldado
	public static void removeSoldier(ArrayList<ArrayList<Soldier>> copyB, ArrayList<Soldier> copyU) {
		showByCreation(copyU);
		int row, column;
		int[] position;
		int size = copyU.size();
		if (size == 1) {
			return;
		}
		do {
			position = coordinate(copyB);
			row = position[0];
			column = position[1];
			Soldier temporary = copyB.get(row).get(column);
			if (temporary != null) {
				copyB.get(row).set(column, null);
				copyU.remove(temporary);
				break;
			} else {
				System.out.println("No existe ningun soldado en esa posicion!");
				continue;
			}
		} while (true);

	}

	// Este metodo clona un soldado tal cual
	public static void cloneSoldier(ArrayList<ArrayList<Soldier>> army, ArrayList<Soldier> armyUni) {
		System.out.println("Ingrese el soldado a clonar");
		int[] coordinates;
		int row, column, i, j;
		int size = armyUni.size();
		Soldier clonedSoldier;
		Soldier original;
		if (size >= 10) {
			System.out.println("Usted no puede agregar mas soldados");
			return;
		}
		do {
			coordinates = coordinate(army);
			row = coordinates[0];
			column = coordinates[1];
			clonedSoldier = new Soldier();
			original = army.get(row).get(column);

			if (original != null) {
				for (i = 0; i < army.size(); i++) {
					ArrayList<Soldier> rowArrayList = army.get(i);
					for (j = 0; j < rowArrayList.size(); j++) {
						if (army.get(i).get(j) == null) {
							clonedSoldier = original.clone();
							clonedSoldier.setRow(row);
							clonedSoldier.setColumn(column);
							army.get(i).set(j, clonedSoldier);
							armyUni.add(clonedSoldier);
							return;
						}
					}
				}
			}
		} while (true);

	}

	// case 4: Este metodo modifica cualqueira de los atributos de un soldado
	public static void changeAttributes(ArrayList<ArrayList<Soldier>> armyB, ArrayList<Soldier> armyU) {
		System.out.println("Modificaremos un soldado!");
		do {
			int[] rowAndColumn = coordinate(armyB);
			int row = rowAndColumn[0];
			int column = rowAndColumn[1];
			Soldier chosenSoldier = armyB.get(row).get(column);
			if (chosenSoldier != null) {
				System.out.println("1: Nivel de ataque\n2: Nivel de defensa\n3: Vida actual");
				int option = sc.nextInt();
				do {
					System.out.println("Ingrese el valor (1-5)");
					int value = sc.nextInt();
					if (value <= 5 && value >= 1) {
						switch (option) {
							case 1:
								chosenSoldier.setAttackLevel(value);
								break;
							case 2:
								chosenSoldier.setDefenseLevel(value);
								break;
							case 3:
								chosenSoldier.setActualLife(value);
								break;
						}
						armyB.get(row).set(column, chosenSoldier);

						return;

					} else {
						System.out.println("Valor no válido");
					}
				} while (true);
			} else {
				System.out.println("Soldado no encontrado!");
			}
		} while (true);
	}

	// CASE 5. Comparar soldados
	public static void compareSoldier(ArrayList<ArrayList<Soldier>> army) {
		int row1, column1, row2, column2;
		Soldier s1, s2;
		int[] rowAndColumn1, rowAndColumn2;
		do {
			rowAndColumn1 = coordinate(army);
			row1 = rowAndColumn1[0];
			column1 = rowAndColumn1[1];
			s1 = army.get(row1).get(column1);

			rowAndColumn2 = coordinate(army);
			row2 = rowAndColumn2[0];
			column2 = rowAndColumn2[1];
			s2 = army.get(row2).get(column2);

			if (s1 == null || s2 == null) {
				System.out.println("No se puede comparar nada!");
			} else {
				s2.compareTo(s1);
				return;
			}

		} while (true);
	}

	// CASE 6: Este metodo intercambia las posiciones
	public static void exchangePosition(ArrayList<ArrayList<Soldier>> army) {
		int[] rowAndColumn1, rowAndColumn2;
		int row1, row2, column1, column2;
		Soldier s1, s2;

		do {
			System.out.println("Coordenadas del primer soldado");
			rowAndColumn1 = coordinate(army);
			row1 = rowAndColumn1[0];
			column1 = rowAndColumn1[1];
			System.out.println("Coordenadas del segundo soldado ");
			rowAndColumn2 = coordinate(army);
			row2 = rowAndColumn2[0];
			column2 = rowAndColumn2[1];
			s1 = army.get(row1).get(column1);
			s2 = army.get(row2).get(column2);
			if (s1 == null && s2 == null) {
				System.out.println("No se puede intercambiar");
			} else {
				s1.setRow(row2 + 1);
				s1.setColumn(column2 + 1);
				s2.setRow(row1 + 1);
				s2.setColumn(column1 + 1);
				army.get(row1).set(column1, s2);
				army.get(row2).set(column2, s1);
				return;
			}
		} while (true);
	}

	// Case 9: Se suman los atributos de tipo int, (menos speed), sin embargo no se
	// agregara al ejercito dicho Soldie
	public static void sumOfAttributes(ArrayList<ArrayList<Soldier>> armyB, ArrayList<Soldier> armyU) {
		Soldier soldierA = new Soldier();
		for (ArrayList<Soldier> row : armyB) {
			for (Soldier soldier : row) {
				if (soldier == null) {
					continue;
				} else {
					soldierA.mightySoldier(soldier);
				}

			}
		}
		System.out.println("Se ha creado a: " + soldierA);
	}

	// Este metodo permite jugar
	public static boolean quickBattle(ArrayList<ArrayList<Soldier>> armyA,
			ArrayList<ArrayList<Soldier>> armyB) {
		boolean outPutOptions = true;
		int optionsDuringGameFast;
		myBoard(armyA, armyB);
		String str;
		int i = 0;
		do {
			if (i % 2 == 0) {
				str = "A";
			} else {
				str = "B";
			}
			System.out.println("Turno de " + str);

			if (i % 2 == 0) {
				outPutOptions = moveSoldier(armyA, armyB, str);
			} else {
				outPutOptions = moveSoldier(armyB, armyA, str);
			}
			myBoard(armyA, armyB);
			if (!outPutOptions) {
				System.out.println("1: Reinciar\n2: Volver al menú principal");
				optionsDuringGameFast = sc.nextInt();
				switch (optionsDuringGameFast) {
					case 1:
						return true;
					case 2:
						return false;
				}
				break;

			}

			i++;
		} while (winnerBattle(armyA, armyB));
		return false;
	}
}
