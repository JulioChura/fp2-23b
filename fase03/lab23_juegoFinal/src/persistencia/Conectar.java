package persistencia;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conectar {
    private static Conectar instancia;
    private Connection sqlConexion;
    private String host = "localhost";
    private String port = "3306";
    private String nameDB = "juego";
    private String usuario = "root";
    private String pass = "";
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String dbURL = "jdbc:mysql://" + host + ":" + port + "/" + nameDB + "?useSSL=false";

    private Conectar() {
        try {
            Class.forName(driver);
            sqlConexion = DriverManager.getConnection(dbURL, usuario, pass);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Conectar obtenerInstancia() {
        if (instancia == null) {
            instancia = new Conectar();
        }
        return instancia;
    }

    // Método para realizar una consulta

    public String registrar(String nombre, int password) {
        PreparedStatement prepareConsulta = null;
        ResultSet result = null;
        String mensaje = "";
    
        try {
            prepareConsulta = sqlConexion.prepareStatement("SELECT * FROM jugadores WHERE Nombre=?");
            prepareConsulta.setString(1, nombre);
            result = prepareConsulta.executeQuery();
    
            if (!result.next()) {
                // El jugador no existe, realizar la inserción
                PreparedStatement prepareInsercion = null;
    
                try {
                    prepareInsercion = sqlConexion.prepareStatement("INSERT INTO jugadores(Nombre, Contraseña) VALUES (?, ?)");
                    prepareInsercion.setString(1, nombre);
                    prepareInsercion.setInt(2, password);
    
                    int filasAfectadas = prepareInsercion.executeUpdate();
    
                    if (filasAfectadas > 0) {
                        mensaje = "Se registró correctamente";
                    } else {
                        mensaje = "No se registró correctamente";
                    }
                } finally {
                    // Cerrar recursos de la inserción
                    if (prepareInsercion != null) {
                        prepareInsercion.close();
                    }
                }
            } else {
                mensaje = "El jugador ya existe";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción según tus necesidades
            mensaje = "Error en la operación";
        } finally {
            // Cerrar recursos de la consulta
            try {
                if (result != null) {
                    result.close();
                }
                if (prepareConsulta != null) {
                    prepareConsulta.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return mensaje;
    }
    
    
  
    public void realizarConsulta(int cod) {
        PreparedStatement prepare = null;
        ResultSet result = null;
        String mensaje;
        try {
            prepare = sqlConexion.prepareStatement("SELECT * FROM owners WHERE id=?");
            prepare.setInt(1, cod);
            result = prepare.executeQuery();

            if (result == null ) {
                prepare = sqlConexion.prepareStatement("INSERT INTO jugadores(nombre, password) VALUES (?, ?)");
                mensaje = "Se registró correctamente";
            } else {
                mensaje = "No se registró correctamente, intente de nuevo";
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción según tus necesidades
        } finally {
            // Cerrar recursos
            try {
                if (result != null)
                    result.close();
                if (prepare != null)
                    prepare.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void cerrarConexion() {
        try {
            if (sqlConexion != null && !sqlConexion.isClosed()) {
                sqlConexion.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
