package logica;

/**
 *
 * @author Julio Chura
 */
public class Player {
    protected String nombre = "";
    protected String password;
    protected Army army;
    protected int victorias;
    protected int estado;

    
    public Player(String nombre, Army army) {
        this.nombre = nombre;
        this.army = army;
    }
    public Player(String nombre, String password, int victorias) {
        this.nombre = nombre;
        this.password = password;
        this.victorias = victorias;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }

    public Army getArmy() {
        return army;
    }

    public int getVictorias() {
        return victorias;
    }

    public int getEstado() {
        return estado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setArmy(Army army) {
        this.army = army;
    }

    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
}
