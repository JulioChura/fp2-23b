class Punto {
    /*Se pone el nivel protected debido a que se
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
    //Este metodo calcula la distancia entre dos puntos
    public double distancia(Punto p) {
        return Math.sqrt(Math.pow(x - p.getX(), 2) +
         Math.pow(y - p.getY(), 2));
    }

}

class Circulo {
    private Punto PuntoOrigen;
    private Punto PuntoDestino;
    private double distancia;

    public Circulo (Punto p1, Punto p2) {
        PuntoOrigen = p1;
        PuntoDestino = p2;
    }
}

public class Ejercicio1 {

    public static void main(String[] args) {
        Punto punto = new Punto(3, 4);
        double distancia = punto.distancia(new Punto(0, 0));
        System.out.println("La distancia es: " + distancia);

    }
}
