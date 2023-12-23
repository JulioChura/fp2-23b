public class Ejercicio1 {
    /*
     * Se pone el nivel protected ya que se usará herencia
     */
    public class Punto {
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

    //public class Circulo extends Punto {
    //}

    public static void main(String[] args) {
        Punto punto = new Punto(0, 0);
    }
}