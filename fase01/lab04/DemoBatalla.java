// Laboratorio Nro 3 - Ejercicio 1
// Autor: Julio
// Tiempo: 4 horas
// No hubo colaboradores
import java.util.*;
public class DemoBatalla {
	public static void main(String [] args){
		Nave [] misNaves = new Nave[3];
		Scanner sc = new Scanner(System.in);
		String nombre, col;
		int fil, punt, pos;
		boolean est;
		for (int i = 0; i < misNaves.length; i++) {
			System.out.println("Nave " + (i+1));
			System.out.print("Nombre: ");
			nombre = sc.next();
			System.out.println("Fila ");
			fil = sc.nextInt();
			System.out.print("Columna: ");
			col = sc.next();
			System.out.print("Estado: ");
			est = sc.nextBoolean();
			System.out.print("Puntos: ");
			punt = sc.nextInt();
			misNaves[i] = new Nave(); //Se crea un objeto Nave y se asigna su referencia a misNaves
			misNaves[i].setNombre(nombre);
			misNaves[i].setFila(fil);
			misNaves[i].setColumna(col);
    		misNaves[i].setEstado(est);
			misNaves[i].setPuntos(punt);
		}
		/*
		System.out.println("\nNaves creadas:");
		mostrarNaves(misNaves);
		mostrarPorNombre(misNaves);
		mostrarPorPuntos(misNaves);
		System.out.println("\nNave con mayor número de puntos: " + mostrarMayorPuntos(misNaves));
		*/
  		//leer un nombre
		//mostrar los datos de la nave con dicho nombre, mensaje de “no encontrado” en caso contrario
		//System.out.println("Ingrese algun nombre de una nave");
        //nombre = sc.next();
		//pos=busquedaLinealNombre(misNaves,nombre);
		/*if(pos==-1) 
	        System.out.println("Nave no encontrada");
		else 
	        System.out.println("Nave encontrada "+ misNaves[pos].toString());*/

		//ordenarPorPuntosBurbuja(misNaves);
		//mostrarNaves(misNaves);
		//ordenarPorNombreBurbuja(misNaves);
		//mostrarNaves(misNaves);
		//mostrar los datos de la nave con dicho nombre, mensaje de “no encontrado” en caso contrario
		/*System.out.println("Ingrese la nave que desea buscar");
		nombre = sc.next();
		pos=busquedaBinariaNombre(misNaves,nombre);
		if(pos==-1) 
	        System.out.println("Nave no encontrada");
		else 
	        System.out.println("Nave encontrada"+ misNaves[pos].toString());
		*/
		ordenarPorPuntosSeleccion(misNaves);
		mostrarNaves(misNaves);
		ordenarPorPuntosInsercion(misNaves);
		//mostrarNaves(misNaves);
		ordenarPorNombreSeleccion(misNaves);
		//mostrarNaves(misNaves);
		ordenarPorNombreInsercion(misNaves);
		//mostrarNaves(misNaves);

	}
	//Método para mostrar todas las naves
	public static void mostrarNaves(Nave [] flota){
	    for(int i = 0; i < flota.length; i++){
            System.out.println("Nave "+(i+1)+": "+flota[i]);        
        }
    }

	//Método para mostrar todas las naves de un nombre que se pide por teclado
	public static void mostrarPorNombre(Nave [] flota){
        Scanner sc = new Scanner(System.in);
	    System.out.println("Ingrese el nombre de la nave que desea buscar");
		String naveNombre = sc.nextLine();
		Boolean encontrado = false;
		for(int i = 0; i < flota.length; i++){
            if(naveNombre.equalsIgnoreCase(flota[i].getNombre() ) ){
                System.out.println(flota[i].toString());
                encontrado = true;
             }                
         }
         if(encontrado == false){
            System.out.println("No fue encontrada");
         }
	}

	//Método para mostrar todas las naves con un número de puntos inferior o igual
	//al número de puntos que se pide por teclado
	public static void mostrarPorPuntos(Nave [] flota){
	    Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese los puntos para hacer la búsqueda de resultados menores o igual");
            int puntos = sc.nextInt();
            Boolean encontrado = false;
            for(int i = 0; i < flota.length; i++) {
                if(puntos >= flota[i].getPuntos()){
                    System.out.println(flota[i].toString());
                    encontrado = true;
                }           
            }
            if(encontrado==false){
                System.out.println("No fue encontrado");
            }
            System.out.println();
	}

	//Método que devuelve la Nave con mayor número de Puntos
	public static Nave mostrarMayorPuntos(Nave [] flota){
	    int puntosMaximos = flota[0].getPuntos();
        int indice = 0;
        for(int i = 1; i < flota.length; i++ ){
            if(puntosMaximos < flota[i].getPuntos()){
                puntosMaximos = flota[i].getPuntos();
                indice = i;
            }  
        }
        return flota[indice];
	}

	//Método para buscar la primera nave con un nombre que se pidió por teclado
	public static int busquedaLinealNombre(Nave[] flota, String s){
		for(int i = 0; i < flota.length; i++){
        	if(s.equalsIgnoreCase(flota[i].getNombre())){
            	return i;
           	}
      	}
        return -1;
	}

	//Método que ordena por número de puntos de menor a mayor
	public static void ordenarPorPuntosBurbuja(Nave[] flota){
    	for(int i = 0; i < flota.length-1; i++){
        	for(int j = 0; j < flota.length-1; j++){
            	if(flota[j].getPuntos() > flota[j+1].getPuntos()){
                	Nave auxiliar = flota[j];
                    flota[j] = flota[j+1];
                    flota[j+1] = auxiliar;                                   
                }
            }
		}
	}
	//Método que ordena por nombre de A a Z
	public static void ordenarPorNombreBurbuja(Nave[] flota){
    	for(int i = 0; i < flota.length-1;i++){
        	for(int j = 0; j < flota.length-1; j++){
            	if(flota[j].getNombre().compareTo(flota[j+1].getNombre())>0){
                	Nave aux = flota[j];
                	flota[j] = flota[j+1];
                	flota[j+1] = aux;
                }
            }
        }
	}
	//Método para buscar la primera nave con un nombre que se pidió por teclado
	public static int busquedaBinariaNombre(Nave[] flota, String s){
    	int baja = 0;
        int alta = flota.length-1;
        while(baja <= alta ){
        	int media = (baja+alta)/2;
                if (flota[media].getNombre().equals(s)){
                    return media;                      
                }else{
                    if(flota[media].getNombre().compareTo(s)  < 0){
                        alta = media-1;
                    }else{
                        baja = media+1;
                    }
                }
		}
        return -1;
	}
	//Método que ordena por número de puntos de menor a mayor
	public static void ordenarPorPuntosSeleccion(Nave[] flota){
		for(int i = 0; i < flota.length-1; i++){
			int minIndex = i;
			for(int j = i+1; j < flota.length; j++){
				if(flota[j].getPuntos() < flota[minIndex].getPuntos()){
					minIndex = j;
				}
			}
			Nave auxiliar = flota[minIndex];
			flota[minIndex] = flota[i];
			flota[i] = auxiliar;
		}	
	}

	//Método que ordena por nombre de A a Z
	public static void ordenarPorNombreSeleccion(Nave[] flota){
		
	}

	//Método que muestra las naves ordenadas por número de puntos de mayor a menor
	public static void ordenarPorPuntosInsercion(Nave[] flota){
	}

	//Método que muestra las naves ordenadas por nombre de Z a A
	public static void ordenarPorNombreInsercion(Nave[] flota){

	}


	

}
