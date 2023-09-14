// Laboratorio Nro 1 - Ejercicio 2
// Autor: Julio
// Tiempo: 8 minutos
// No hubo colaboradores
import java.util.*;
public class VideoJuego{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);

	String[] army = new String[5];
	for(int i = 0; i < army.length; i++){
	    System.out.println("Enter the name of soldier "+ (i+1));
	    army[i] = sc.next();
	}
	for(int i = 0; i < army.length; i++){
	    System.out.println("Soldier "+(i+1)+": "+ army[i]);
	}    
   }       
}
