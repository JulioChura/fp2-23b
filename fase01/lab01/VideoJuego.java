// Laboratorio Nro 1 - Ejercicio 2
// Autor: Julio
// Tiempo: 8 minutos
// No hubo colaboradores
import java.util.*;
public class VideoJuego{
    public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		String[] ejercito1 = army();
		String[] ejercito2 = army(); 
	
		printArray(ejercito1);
		printArray(ejercito2);
		if(ejercito1.length < ejercito2.length ){
			System.out.println("El ganador es el ejercito 2");
		}else if( ejercito1.length > ejercito2.length){
			System.out.println("El ganador es el ejercito 1");		
		}else{
		System.out.println("Empate");
		}
	}
	public static String[] army(){
		Random aleatorio = new Random();
		int cantidad = aleatorio.nextInt(5)+1;
		String[] ejercito = new String[cantidad];
		String soldado = "";		
		for(int i = 0; i < ejercito.length; i++){
			soldado = "soldado"+(i+1);
			ejercito[i] = soldado;
		}
		return ejercito;
	}
	
	public static void printArray(String[] a){
		for(int i = 0; i < a.length; i++){
			System.out.println(a[i] );
		}
		
	}
}
