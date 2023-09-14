// Laboratorio Nro 1 - Ejercicio 2
// Autor: Julio
// Tiempo: 4 mnutos
// No hubo colaboradores
import java.util.*;
public class VideoJuego{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	String soldier1, soldier2, soldier3, soldier4, soldier5;
	int life1, life2, life3, life4, life5;

        System.out.println("Ingrese el nombre del soldado 1");
	soldier1 = sc.next();
        System.out.println("Ingrese el nivel de vida del soldado 1");
	life1 = sc.nextInt();
	
        System.out.println("Ingrese el nombre del soldado 2");
	soldier2 = sc.next();
        System.out.println("Ingrese el nivel de vida del soldado 2");
	life2 = sc.nextInt();

        System.out.println("Ingrese el nombre del soldado 3");
	soldier3 = sc.next();
        System.out.println("Ingrese el nivel de vida del soldado 3");
	life3 = sc.nextInt();
	
        System.out.println("Ingrese el nombre del soldado 4");
	soldier4 = sc.next();
        System.out.println("Ingrese el nombre del soldado 4");
	life4 = sc.nextInt();

        System.out.println("Ingrese el nombre del soldado 5");
	soldier5 = sc.next();
        System.out.println("Ingrese el nivel de vida del soldado 5");
	life5 = sc.nextInt();

	System.out.println("El soldado 1 se llama: "+ soldier1 + "  Nivel de vida: "+ life1);     
	System.out.println("El soldado 2 se llama: "+ soldier2 + "  Nivel de vida: "+ life2);     
	System.out.println("El soldado 3 se llama: "+ soldier3 + "  Nivel de vida: "+ life3);     
	System.out.println("El soldado 4 se llama: "+ soldier4 + "  Nivel de vida: "+ life4);     
	System.out.println("El soldado 5 se llama: "+ soldier5 + "  Nivel de vida: "+ life5);     
   }       
}
