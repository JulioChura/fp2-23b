package persistencia;

public class ComprobarUsuario {
    private Conectar conectar;
    private String nombre;
    private int password;
    public String validar(String nombre, int password) {
        this.nombre = nombre;
        this.password = password;
        conectar = Conectar.obtenerInstancia();

        conectar.realizarConsulta(password);

        return ";";

    } 
}
