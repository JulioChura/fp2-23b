// Laboratorio Nro 1 - Ejercicio
// Autor: Julio
// Tiempo: 4 mnutos
// No hubo colaboradores
import java.util.*;
public class VideoJuego{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	String soldado1, soldado2, soldado3, soldado4, soldado5;

        System.out.println("Ingrese el nombre del soldado 1");
	soldado1 = sc.nextLine();
	
        System.out.println("Ingrese el nombre del soldado 2");
	soldado2 = sc.nextLine();

        System.out.println("Ingrese el nombre del soldado 3");
	soldado3 = sc.nextLine();
	
        System.out.println("Ingrese el nombre del soldado 4");
	soldado4 = sc.nextLine();
	
        System.out.println("Ingrese el nombre del soldado 5");
	soldado5 = sc.nextLine();

	System.out.println("El soldado 1 se llama: "+ soldado1);     
	System.out.println("El soldado 2 se llama: "+ soldado2);
	System.out.println("El soldado 3 se llama: "+ soldado3);
	System.out.println("El soldado 4 se llama: "+ soldado4);
	System.out.println("El soldado 5 se llama: "+ soldado5);
   }       
}
