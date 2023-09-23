import java.util.*;
public class DemoBatalla {
	public static void main(String [] args){
		Nave [] misNaves = new Nave[1];
		Scanner sc = new Scanner(System.in);
		String nomb, col;
		int fil, punt;
		boolean est;
		for (int i = 0; i < misNaves.length; i++) {
			System.out.println("Nave " + (i+1));
			System.out.print("Nombre: ");
			nomb = sc.next();
			System.out.println("Fila ");
			fil = sc.nextInt();
			System.out.print("Columna: ");
			col = sc.next();
			System.out.print("Estado: ");
			est = sc.nextBoolean();
			System.out.print("Puntos: ");
			punt = sc.nextInt();
			misNaves[i] = new Nave(); //Se crea un objeto Nave y se asigna su referencia a misNaves
			misNaves[i].setNombre(nomb);
			misNaves[i].setFila(fil);
			misNaves[i].setColumna(col);
    		misNaves[i].setEstado(est);
			misNaves[i].setPuntos(punt);
		}
		System.out.println("Naves creadas:");
		mostrarNaves(misNaves);
        System.out.println();
		mostrarPorNombre(misNaves);
        System.out.println();
		mostrarPorPuntos(misNaves);
		System.out.println("Nave con mayor número de puntos: " + mostrarMayorPuntos(misNaves));
        //Nave[] navesAleatorias = copiarNavesAleatoriamente(misNaves);
        //mostrarNaves(navesAleatorias);
	}
	//Método para mostrar todas las naves
	public static void mostrarNaves(Nave [] flota){
	    for(int i = 0; i < flota.length; i++){
            System.out.println("Nave "+(i+1)+": "+flota[i]);        
        }
    }
	//Método para mostrar todas las naves de un nombre que se pide por teclado
	public static void mostrarPorNombre(Nave [] flota){

	}
	//Método para mostrar todas las naves con un número de puntos inferior o igual
	//al número de puntos que se pide por teclado
	public static void mostrarPorPuntos(Nave [] flota){
	}
	//Método que devuelve la Nave con mayor número de Puntos
	public static Nave mostrarMayorPuntos(Nave [] flota){
        return null;
	}
	//Crear un método que devuelva un nuevo arreglo de objetos con todos los objetos previamente ingresados		
	//pero aleatoriamente desordenados
    public static Nave[] copiarNavesAleatoriamente(Nave[] naves){
        return null;
    }
}
