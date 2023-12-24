public class Ejercicio2 {
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
    
    }

    class Cilindro {
        private double altura;

        
    }
}
