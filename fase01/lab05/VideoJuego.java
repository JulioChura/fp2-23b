// Laboratorio Nro 5
// Autor: Julio
// Tiempo: 
// No hubo colaboradores

import java.util.*;

public class VideoJuego {
	public static void main(String[] args) {

	}

	public static void printArray(Soldier[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i].toString());
		}
	}

	public static Soldier[] generateArmy() {
		Random random = new Random();
		int amount = random.nextInt(5) + 1;
		Soldier[] myArmy = new Soldier[amount];
		for (int i = 0; i < myArmy.length; i++) {
			String theName = "Soldier" + i;
			myArmy[i] = new Soldier();
			myArmy[i].setName(theName);
		}
		return myArmy;
	}

}
