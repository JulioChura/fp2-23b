public class Ejercicio2 {
    public static void main(String[] args) {
        Punto p1 = new Punto(0, 0);
        Punto p2 = new Punto(8, 15);
        Circulo circulo = new Circulo(p1, p2);
        Cilindro cilindro = new Cilindro(circulo, 4);
        System.out.println("La superficie es: " + cilindro.calcularSuperficie());
    }
}

class Punto {
    /*
     * Se establecen como atributos dos valores de tipo
     * double que seran una coordenada
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

    /*
     * Se crea el metodo que devuelve el perimetro del circulo
     */
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }

    // se crea el metodo que permite acceder al atributo de radio
    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }
}

class Cilindro {
    private double altura;
    private Circulo circulo;

    public Cilindro(Circulo circulo, double altura) {
        this.circulo = circulo;
        this.altura = altura;
    }

    /*
     * Este metodo, para calcular la superficie multiplica la superficie
     * de la base del cilindro por la suma del radio de la base y la
     * altura
     */
    public double calcularSuperficie() {
        circulo.setRadio(circulo.calcularRadio());
        return circulo.calcularPerimetro() * (circulo.getRadio() + altura);
    }

}
