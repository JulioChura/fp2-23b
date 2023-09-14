// Laboratorio Nro 1 - Ejercicio 2
// Autor: Julio
// Tiempo: 4 mnutos
// No hubo colaboradores
import java.util.*;
public class VideoJuego{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	String soldado1, soldado2, soldado3, soldado4, soldado5;
	int vida1, vida2, vida3, vida4, vida5;

        System.out.println("Ingrese el nombre del soldado 1");
	soldado1 = sc.next();
        System.out.println("Ingrese el nivel de vida del soldado 1");
	vida1 = sc.nextInt();
	
        System.out.println("Ingrese el nombre del soldado 2");
	soldado2 = sc.next();
        System.out.println("Ingrese el nivel de vida del soldado 2");
	vida2 = sc.nextInt();

        System.out.println("Ingrese el nombre del soldado 3");
	soldado3 = sc.next();
        System.out.println("Ingrese el nivel de vida del soldado 3");
	vida3 = sc.nextInt();
	
        System.out.println("Ingrese el nombre del soldado 4");
	soldado4 = sc.next();
        System.out.println("Ingrese el nombre del soldado 4");
	vida4 = sc.nextInt();

        System.out.println("Ingrese el nombre del soldado 5");
	soldado5 = sc.next();
        System.out.println("Ingrese el nivel de vida del soldado 5");
	vida5 = sc.nextInt();

	System.out.println("El soldado 1 se llama: "+ soldado1 + "  Nivel de vida: "+ vida1);     
	System.out.println("El soldado 2 se llama: "+ soldado2 + "  Nivel de vida: "+ vida2);     
	System.out.println("El soldado 3 se llama: "+ soldado3 + "  Nivel de vida: "+ vida3);     
	System.out.println("El soldado 4 se llama: "+ soldado4 + "  Nivel de vida: "+ vida4);     
	System.out.println("El soldado 5 se llama: "+ soldado5 + "  Nivel de vida: "+ vida5);     
   }       
}
