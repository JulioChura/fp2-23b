import java.util.Scanner;

import javax.swing.JOptionPane;

public class test {
     public static void main(String[] args) {
        

        Army a = new Army("a");
        Army b = new Army("b");
        a.generateArmy(b);
        b.generateArmy(a);

        Tablero tab = new Tablero(a, b, "a", "b");

        juego(tab);

        a.showArmy();
        System.out.println();
        b.showArmy();
        System.out.println();

        tab.init();
        tab.init();
        tab.init();

    }

    

    public static void juego(Tablero tabla){
		Army e1 = tabla.getEjercito1();
        Army e2 = tabla.getEjercito2();
		int turno = 0;
		JOptionPane.showMessageDialog(null, "Bienvenido al simulador");
		tabla.repintarTablero();
		do{
			if(turno%2==0){
				int x=0, y=0, tox=0, toy=0;
				do{
					JOptionPane.showMessageDialog(null, "Turno del reino Azul");
					int arr[] = tabla.getCoordinates();
					x = arr[0];
					y = arr[1];
					int toarr[] = tabla.getCoordinates();
					tox = toarr[0];
					toy = toarr[1];
				}while(Army.validatePosition(e1,  x,y,tox,toy));
				Army.moveSoldier(e1, e2, x,y,tox, toy);
			}else{
				int x=0, y=0, tox=0, toy=0;
				do{
					JOptionPane.showMessageDialog(null, "Turno del reino Rojo");
					int arr[] = tabla.getCoordinates();
					x = arr[0];
					y = arr[1];
					int toarr[] = tabla.getCoordinates();
					tox = toarr[0];
					toy = toarr[1];		
				}while(Army.validatePosition(e2, x,y,tox,toy));
				Army.moveSoldier(e2, e1, x, y, tox, toy);   
			}
			tabla.repintarTablero();
			turno++;
		}while(true);
	}
}
