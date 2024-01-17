import java.sql.Connection;
import java.sql.DriverManager;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        Conectar c1 = new Conectar(1);
        Conectar c2 = new Conectar(2);
        int a = c1.hashCode();
        int b = c2.hashCode();
        System.out.println(a);
        System.out.println(b);

        System.out.println();

        System.out.println("Se hace uso de Singleton");
        SingletonConectar s1 = SingletonConectar.obtenerInstancia();
        SingletonConectar s2 = SingletonConectar.obtenerInstancia();
        s1.realizarConsulta(1);
        s2.realizarConsulta(2);
        int c = s1.hashCode();
        int d = s2.hashCode();

        System.out.println(c);
        System.out.println(d);
    }
}
