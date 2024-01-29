package persistencia;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
                        PreparedStatement prepareInsercionPartida = sqlConexion.prepareStatement("INSERT INTO partidas(Jugador_Nombre) VALUES (?)", PreparedStatement.RETURN_GENERATED_KEYS);
                        prepareInsercionPartida.setString(1, nombre);
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
            prepare.setString(2, contraseña);
            result = prepare.executeQuery();

            if (result.next()) {
                mensaje = "Se encontró jugador";
            } else {
                mensaje = "No hay registro";
            }

        } catch (SQLException e) {
            e.printStackTrace();
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

    public int victorias(String nombre, String contraseña) {
        if (nombre == null || contraseña == null || nombre.isEmpty() || contraseña.isEmpty()) {
            System.out.println("Nombre y contraseña no pueden ser nulos o vacíos");
            return 0; // O cualquier otro valor predeterminado según tu lógica de negocio
        }
        PreparedStatement prepare = null;
        ResultSet result = null;
        int victorias = 0;
        try {
            prepare = sqlConexion.prepareStatement("SELECT Victorias FROM jugadores "
                    + "WHERE Nombre=? AND Contraseña=?");
            prepare.setString(1, nombre);
            prepare.setString(2, contraseña);
            result = prepare.executeQuery();

            if (result.next()) { // Verificar si hay resultados antes de intentar obtener el valor
                victorias = result.getInt("Victorias");
            } else {
                // No hay resultados, podrías lanzar un mensaje o hacer algo en consecuencia
                System.out.println("No hay resultados para la consulta.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
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
        return victorias;
    }

    public void registrarVictoria(String nombre, String contraseña) {
        PreparedStatement prepare = null;
        ResultSet result = null;
        int victorias = 0;

        try {
            // Obtener el número actual de victorias
            prepare = sqlConexion.prepareStatement("SELECT Victorias FROM jugadores "
                    + "WHERE Nombre=? AND Contraseña=?");
            prepare.setString(1, nombre);
            prepare.setString(2, contraseña);
            result = prepare.executeQuery();

            if (result.next()) {
                victorias = result.getInt("Victorias");
                victorias++;

                // Actualizar el número de victorias en la base de datos
                prepare = sqlConexion.prepareStatement("UPDATE jugadores SET Victorias=? "
                        + "WHERE Nombre=? AND Contraseña=?");
                prepare.setInt(1, victorias);
                prepare.setString(2, nombre);
                prepare.setString(3, contraseña);
                prepare.executeUpdate();
            } else {
                // No hay resultados, podrías lanzar un mensaje o hacer algo en consecuencia
                System.out.println("No hay resultados para la consulta.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
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
    }
    
    public void mostrarTablaJugadores() {
        try {
            String consultaSQL = "SELECT Nombre, Victorias FROM jugadores";
            PreparedStatement preparedStatement = sqlConexion.prepareStatement(consultaSQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.addColumn("Jugador");
            tableModel.addColumn("Partidas Ganadas");

            //Se llena la tabla con los resultados de la consulta
            while (resultSet.next()) {
                String jugador = resultSet.getString("Nombre");
                int victorias = resultSet.getInt("Victorias");
                Object[] rowData = {jugador, victorias};
                tableModel.addRow(rowData);
            }

            // Crear la tabla y configurar el modelo
            JTable table = new JTable(tableModel);

            // Añadir la tabla a un JScrollPane para permitir desplazarse por los resultados
            JScrollPane scrollPane = new JScrollPane(table);

            // Crear un JFrame para mostrar la tabla
            JFrame frame = new JFrame("Tabla de Jugadores");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
            frame.setSize(400, 300);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

        } catch (SQLException e) {
            e.printStackTrace();
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
