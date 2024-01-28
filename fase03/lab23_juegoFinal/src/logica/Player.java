package logica;

/**
 *
 * @author Julio Chura
 */
public class Player {
    protected String nombre;
    protected String password;
    protected Army army;
    protected int victorias;
    protected int estado;

    public Player(String nombre, String password, int victorias) {
        this.nombre = nombre;
        this.password = password;
        this.victorias = victorias;
    }
    
    
}
