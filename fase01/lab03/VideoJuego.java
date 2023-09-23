// Laboratorio Nro 1 - Ejercicio 4
// Autor: Julio
// Tiempo: 30 minutos
// No hubo colaboradores
import java.util.*;
public class VideoJuego{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Soldier soldier = new Soldier();
	Soldier[] army = new Soldier[5];
	for(int i = 0; i < army.length; i++){
            System.out.print("Enter the name of soldier "+(i+1)+": " );
            String name = sc.next();
            System.out.print("Enter the points life "+(i+1)+": " );
            int points = sc.nextInt();
            System.out.println();
            army[i] = new Soldier();
            army[i].setName(name);
            army[i].setLifePoints(points);           
        }
        System.out.println();	
        printArray(army);
    }   
    public static void printArray(Soldier[] a){
	for(int i = 0; i < a.length; i++){
	    System.out.println(a[i].toString() );
	}	
    }
}
