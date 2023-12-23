class Punto {
    /*
     * Se pone el nivel protected debido a que se
     * aplicará herencia. Esta es la clase padre
     */
    private double x;
    private double y;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // Este metodo calcula la distancia entre dos puntos
    public double distancia(Punto p) {
        return Math.sqrt(Math.pow(x - p.getX(), 2) +
                Math.pow(y - p.getY(), 2));
    }
}

class Circulo {
    private Punto puntoOrigen;
    private Punto puntoDestino;
    private double radio;

    public Circulo(Punto p1, Punto p2) {
        puntoOrigen = p1;
        puntoDestino = p2;
    }

    /*
     * Para evitar repetir codigo, se hace uso del metodo
     * distancia de la clase Punto
     */
    public double calcularRadio() {
        this.radio = puntoOrigen.distancia(puntoDestino);
        return this.radio;
    }

}

public class Ejercicio1 {
    public static void main(String[] args) {
        Punto p1 = new Punto(3, 4);
        Punto p2 = new Punto(0, 0);
        Circulo circulo = new Circulo(p1, p2);
        double radio = circulo.calcularRadio();
        System.out.println("El radio es: " + radio);

    }
}
