//Laboratorio Nro 2 - Ejercicio2
//Autor: Julio Chura
//Colaboró: Nadie
//Tiempo:
import java.util.Scanner;

public class Ejercicio02 {
    public static void main(String[] args) {
        String ahor1 = "+---+ \n"+
                       "|   | \n"+
                       "    | \n"+ 
                       "    | \n"+
                       "    | \n"+ 
                       "    | \n"+
                        "========= ";
        String ahor2 = " +---+ \n"+
                       " |   | \n"+
                       " O   | \n"+
                       "     | \n"+
                       "     | \n"+
                       "     | \n"+
                       "=========";

        String ahor3 = " +---+ \n"+
                       " |   | \n"+
                       " O   | \n"+
                       " |   | \n"+
                       " |     \n"+
                       " |     \n"+
                       "=========";

        String ahor4 = " +---+ \n"+
                       " |   | \n"+
                       " O   | \n"+
                       "/|   | \n"+
                       "     | \n"+
                       "     | \n"+
                       "=========";

        String ahor5 = " +---+ \n"+
                       " |   | \n"+
                       " O   | \n"+
                       " /|\\| \n"+
                       "     | \n"+
                       "     | \n"+
                       "=========";
 
        String ahor6 = " +---+ \n"+
                       " |    |\n"+
                       " O    |\n"+
                       " /|\\ |\n"+
                       " /    |\n"+
                       "      |\n"+
                       "=========";

        String ahor7 = " +---+ \n"+
                      " |    | \n"+
                      " O    | \n"+
                      " /|\\ | \n"+
                      " / \\ | \n"+
                      "      | \n"+
                    "=========";

        String[] figuras = {ahor1, ahor2, ahor3,ahor4,ahor5,ahor6,ahor7};
        int contador = 1;
        String letra;
        String[] palabras = {"programacion", "java", "identacion", "clases",
                            "objetos", "desarrollador", "pruebas"};

        String palSecreta = getPalabraSecreta(palabras);
        System.out.println(figuras[0]);
        mostrarBlancos(palSecreta);
        System.out.println("\n");
        while(contador <= 6){
            letra = ingreseLetra();
            if (letraEnPalabraSecreta(letra, palSecreta))
                mostrarBlancosActualizados(letra);
            else
                System.out.println(figuras[contador]);
                contador = contador +1;
        }
		//COMPLETAR PARA INDICAR SI GANÓ, PERDIÓ Y CUÁNTOS TURNOS NECESITÓ
        System.out.println("\n");
    }
    public static String getPalabraSecreta(String [] lasPalabras){
        String palSecreta;
	int ind;
	int indiceMayor = lasPalabras.length -1;
	int indiceMenor =0;
        ind = (int) ((Math.random() * (indiceMayor - indiceMenor + 1) + indiceMenor));
	return lasPalabras[ind];
    }

    public static void mostrarBlancos(String palabra){
        for(int i=0; i< palabra.length(); i++)
        System.out.print("_ " );

    }
    public static String ingreseLetra(){
	String laLetra;
	Scanner sc = new Scanner(System.in);
	System.out.println("Ingrese letra: ");
	laLetra = sc.next();
	while(laLetra.length()!= 1 || !Character.isLetter(laLetra.charAt(0))){
            System.out.println("Ingrese letra: ");
            laLetra = sc.next();
	}
	return laLetra;
    }

    public static boolean letraEnPalabraSecreta(String letra, String palSecreta ){
	for(int i = 0; i < palSecreta.length();i++){
        if(Character.toString(palSecreta.charAt(i)).equalsIgnoreCase(letra))
            return true;		
	}
        return false;
    }

    public static void mostrarBlancosActualizados(String palabrajuego, String letra, String[] array){
	System.out.println("PROCESANDO.....");
	for(int i =0; i< palabraJuego.length();i++){
            if(Character.toString(palabraJuego.charAt(i)).equals(letra) ){
                arregloVacio[i] = letra;
            }
        }
        for( int i = 0; i < arregloVacio.length; i++){
            System.out.print(arregloVacio[i]+" " );
        }
    }

    public static String[] arregDeSubguiones(String str){
    	String[] arraySubguiones = new String[str.length()];
	for(int i = 0; i <str.length();i++){
	    arraySubguiones[i] = "_ ";
	}
	return arraySubguiones 
    }

}
