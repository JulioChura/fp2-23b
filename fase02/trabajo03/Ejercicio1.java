
class Punto {
    /*
     * Se pone el nivel protected debido a que se 
     * aplicará herencia. Esta es la clase padre
     */
    protected double x;
    protected double y;

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

    public double distancia(Punto p) {
        return Math.sqrt(Math.pow(x - p.getX(), 2) + Math.pow(y - p.getY(), 2));
    }
}

//class Circulo extends Punto {
    
//}

public class Ejercicio1 {

    public static void main(String[] args) {
        Punto punto = new Punto(0, 0);
    }
}



