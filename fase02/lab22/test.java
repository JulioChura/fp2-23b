import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class test {
	public static void main(String[] args) {

		

		String kigdom1 = showDialogToChooseKingdom();
		String kingdom2 = showDialogToChooseKingdom();
		String battleField1 = showDialogToChooseBattleField();
		String battleField2 = showDialogToChooseBattleField();
		String definitiveBattlefield = randomBattlefield(battleField1, battleField2);
		
		Army a = new Army("a");
		Army b = new Army("b");
		a.generateArmy(b);
		b.generateArmy(a);

		Tablero tab = new Tablero(a, b, definitiveBattlefield);
		juego(tab);

		a.showArmy();
		System.out.println();
		b.showArmy();
		System.out.println();

		tab.init();
		tab.init();
		tab.init();

	}

	public static void juego(Tablero tabla) {
		Army e1 = tabla.getEjercito1();
		Army e2 = tabla.getEjercito2();
		int turno = 0;
		JOptionPane.showMessageDialog(null, "Bienvenido al simulador");
		tabla.repintarTablero();
		do {
			if (turno % 2 == 0) {
				int x = 0, y = 0, tox = 0, toy = 0;
				do {
					JOptionPane.showMessageDialog(null, "Turno del reino Azul");
					int arr[] = tabla.getCoordinates();
					x = arr[0];
					y = arr[1];
					int toarr[] = tabla.getCoordinates();
					tox = toarr[0];
					toy = toarr[1];
					System.out.println("Coordenadas obtenidas: x=" + x + ", y=" + y + "\n" + tox + " " + toy);
				} while (Army.validatePosition(e2, x, y, tox, toy));
				Army.moveSoldier(e1, e2, x, y, tox, toy);
			} else {
				int x = 0, y = 0, tox = 0, toy = 0;
				do {
					JOptionPane.showMessageDialog(null, "Turno del reino Rojo");
					int arr[] = tabla.getCoordinates();
					x = arr[0];
					y = arr[1];
					int toarr[] = tabla.getCoordinates();
					tox = toarr[0];
					toy = toarr[1];
					System.out.println("Coordenadas obtenidas: x=" + x + ", y=" + y + "\n" + tox + " " + toy);
				} while (Army.validatePosition(e1, x, y, tox, toy));
				Army.moveSoldier(e2, e1, x, y, tox, toy);
			}
			tabla.repintarTablero();
			turno++;
		} while (true);
	}

	public static String showDialogToChooseKingdom() {
		String[] kingdoms = { "Francia", "Inglaterra", "Castilla", "Romanos", "Moros" };
		String seleccion = (String) JOptionPane.showInputDialog(
				null,
				"Selecciona una opción:",
				"Elegir Opción",
				JOptionPane.QUESTION_MESSAGE,
				null,
				kingdoms,
				kingdoms[0]);

		// Verifica si el usuario seleccionó una opción
		if (seleccion != null) {
			JOptionPane.showMessageDialog(null, "Seleccionaste: " + seleccion);
		} else {
			JOptionPane.showMessageDialog(null, "No seleccionaste ninguna opción");
		}

		return seleccion;
	}

	public static String  showDialogToChooseBattleField() {
		String userInput = JOptionPane.showInputDialog(null,
                "Ingrese algún texto:",
                "Entrada de Texto",
                JOptionPane.PLAIN_MESSAGE
        );

        if (userInput != null && !userInput.isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Texto ingresado: " + userInput,
                    "Resultado",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "No se ingresó ningún texto",
                    "Resultado",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
		return userInput;
	}

	public static String randomBattlefield(String battleField1, String battleField2) {
		Random random = new Random();
		int selection = random.nextInt(2);
		if (0== selection) {
			return battleField1;
		} else {
			return battleField2;
		}
	}
}
