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
    public String registrar(String nombre, String password) {
        PreparedStatement prepareConsulta = null;
        ResultSet result = null;
        String mensaje = "";

        try {
            // Verificar si el jugador ya existe
            prepareConsulta = sqlConexion.prepareStatement("SELECT * FROM jugadores WHERE Nombre=?");
            prepareConsulta.setString(1, nombre);
            result = prepareConsulta.executeQuery();

            if (!result.next()) {
                // El jugador no existe, realizar la inserción
                PreparedStatement prepareInsercionJugador = null;
                try {
                    // Insertar en la tabla 'jugadores'
                    prepareInsercionJugador = sqlConexion.prepareStatement("INSERT INTO jugadores(Nombre, Contraseña) VALUES (?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
                    prepareInsercionJugador.setString(1, nombre);
                    prepareInsercionJugador.setString(2, password);
                    int filasAfectadasJugador = prepareInsercionJugador.executeUpdate();

                    // Obtener el ID del jugador recién insertado
                    ResultSet generatedKeysJugador = prepareInsercionJugador.getGeneratedKeys();
                    int jugadorID = -1;
                    if (generatedKeysJugador.next()) {
                        jugadorID = generatedKeysJugador.getInt(1);
                    }

                    if (filasAfectadasJugador > 0) {
                        // Insertar en la tabla 'partidas'
                        PreparedStatement prepareInsercionPartida = sqlConexion.prepareStatement("INSERT INTO partidas(Jugador_Nombre, RachaVictorias) VALUES (?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
                        prepareInsercionPartida.setString(1, nombre);
                        prepareInsercionPartida.setInt(2, 0);
                        int filasAfectadasPartida = prepareInsercionPartida.executeUpdate();

                        // Obtener el ID de la última partida insertada
                        ResultSet generatedKeysPartida = prepareInsercionPartida.getGeneratedKeys();
                        int partidaID = -1;
                        if (generatedKeysPartida.next()) {
                            partidaID = generatedKeysPartida.getInt(1);
                        }

                        if (filasAfectadasPartida > 0) {
                            // Insertar en la tabla 'ejercitos'
                            PreparedStatement prepareInsercionEjercito = sqlConexion.prepareStatement("INSERT INTO ejercitos(Partida_ID) VALUES (?)");
                            prepareInsercionEjercito.setInt(1, partidaID);
                            prepareInsercionEjercito.executeUpdate();
                        } else {
                            // Manejar error en la inserción en 'partidas'
                            mensaje = "Error al insertar en la tabla 'partidas'";
                        }
                    } else {
                        // Manejar error en la inserción en 'jugadores'
                        mensaje = "Error al insertar en la tabla 'jugadores'";
                    }
                    mensaje = "Se registró satisfactoriamente";
                } finally {
                    // Cerrar recursos de la inserción del jugador
                    if (prepareInsercionJugador != null) {
                        prepareInsercionJugador.close();
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

    public String realizarConsulta(String nombre, String contraseña) {
        PreparedStatement prepare = null;
        ResultSet result = null;
        String mensaje = "";
        try {
            prepare = sqlConexion.prepareStatement("SELECT * FROM jugadores WHERE Nombre=? AND Contraseña=?");
            prepare.setString(1, nombre);
            prepare.setString(1, contraseña);
            result = prepare.executeQuery();

            if (result == null) {
                mensaje = "No se registró correctamente, intente de nuevo";
            } else {
                mensaje = "Se registró correctamente";
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción según tus necesidades
        } finally {
            // Cerrar recursos
            try {
                if (result != null) {
                    result.close();
                }
                if (prepare != null) {
                    prepare.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return mensaje;
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
