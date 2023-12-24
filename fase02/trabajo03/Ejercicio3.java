public class Ejercicio3 {
    public static void main(String[] args) {
        Hidroavion hidroavion = new Hidroavion(" Canadair CL-215", "China");
        hidroavion.amarrar();
        hidroavion.navegar();
        hidroavion.volar();
        hidroavion.aterrizar();
        System.out.print(hidroavion);
    }
}

interface Barco {
    void navegar();

    void amarrar();
}

interface Avion {
    void volar();

    void aterrizar();
}

class Hidroavion implements Barco, Avion {
    private String modelo;
    private String lugarProcedencia;

    public Hidroavion(String modelo, String lugar) {
        this.modelo = modelo;
        this.lugarProcedencia = lugar;
    }

    public void navegar() {
        System.out.println("El HidroaviÓn está avanzando en el agua!");
    }

    public void amarrar() {
        System.out.println("El Hidroavion se detuve en un muelle!");
    }

    public void volar() {
        System.out.println("El hidroavión está volando!");
    }

    public void aterrizar() {
        System.out.println("El hidroavión está aterrizando!");
    }

    public String toString() {
        return "Hidroavion [modelo=" + modelo + ", Lugar de Procedencia=" + lugarProcedencia + "]";
    }

}