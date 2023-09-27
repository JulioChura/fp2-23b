// Laboratorio Nro 3 - Ejercicio 5
// Autor: Julio
// Tiempo: 20 minutos
// No hubo colaboradores
import java.util.*;
public class VideoJuego{
    public static void main(String[] args){
		Soldier[] army1 = generateArmy();
		Soldier[] army2 = generateArmy();
	
		printArray(army1);
		System.out.println();	
   		printArray(army2);
	
		if (army1.length < army2.length ) {
	    	System.out.println("The winner is the army 2");
		} else if ( army1.length > army2.length) {
	    	System.out.println("The winner is the army 1");		
		} else {
	   	 	System.out.println("IT WAS A TIE");
		}	
    }  

    public static void printArray(Soldier[] a){
		for(int i = 0; i < a.length; i++){
	    System.out.println(a[i].toString() );
		}	
    }

    public static Soldier[] generateArmy(){
    	Random random = new Random();
		int amount =  random.nextInt(5)+1;
		Soldier[] myArmy = new Soldier[amount];
		for(int i = 0; i < myArmy.length; i++){
  	    	String theName = "Soldier"+i;
	    	myArmy[i] = new Soldier();
	    	myArmy[i].setName(theName);
		}	
		return myArmy;
	}

}
