// Laboratorio Nro 1 - Ejercicio 5
// Autor: Julio
// Tiempo: 20 minutos
// No hubo colaboradores
import java.util.*;
public class VideoJuego{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
	
	String[] army1 = generateArmy();
	String[] army2 = generateArmy(); 

	System.out.println("ARMY 1");
	printArray(army1);
	System.out.println("ARMY 2");
	printArray(army2);

	if (army1.length < army2.length ) {
	    System.out.println("The winner is the army 2");
	} else if ( army1.length > army2.length) {
	    System.out.println("The winner is the army 1");		
	} else {
	    System.out.println("IT WAS A TIE");
	}
    }

    public static String[] generateArmy(){
        Random random = new Random();
	int amount = random.nextInt(5)+1;
	String[] army = new String[amount];		
	for(int i = 0; i < army.length; i++){
	    army[i] = "Soldier"+(i+1);
	}
	return army;
    }
	
    public static void printArray(String[] a){
	for(int i = 0; i < a.length; i++){
	    System.out.println(a[i] );
	}
	System.out.println();		
    }
}
