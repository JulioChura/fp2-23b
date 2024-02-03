package persistencia;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import logica.Army;
import logica.Soldier;

public class Conectar {

    private static Conectar instancia;
    private Connection sqlConexion;
    private String host = "localhost";
    private String port = "3306";
    private String nameDB = "fp2_23b";
    private String usuario = "fp2_23b";
    private String pass = "12345678";
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String dbURL = "jdbc:mysql://" + host + ":" + port + "/" + nameDB + "?useSSL=false";

    private Conectar() {
        try {
            Class.forName(driver);
            sqlConexion = DriverManager.getConnection(dbURL, usuario, pass);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "La conexion no se pudo establecer");
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
            prepareConsulta = sqlConexion.prepareStatement("SELECT * FROM jugadores WHERE id_jugador=?");
            prepareConsulta.setString(1, nombre);
            result = prepareConsulta.executeQuery();

            if (!result.next()) {
                // El jugador no existe, realizar la inserción
                PreparedStatement prepareInsercionJugador = null;
                try {
                    // Insertar en la tabla 'jugadores'
                    prepareInsercionJugador = sqlConexion.prepareStatement("INSERT INTO jugadores(id_jugador, password) VALUES (?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
                    prepareInsercionJugador.setString(1, nombre);
                    prepareInsercionJugador.setString(2, password);
                    int filasAfectadasJugador = prepareInsercionJugador.executeUpdate();

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
            prepare = sqlConexion.prepareStatement("SELECT * FROM jugadores WHERE id_jugador=? AND password=?");
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
            prepare = sqlConexion.prepareStatement("SELECT racha_victorias FROM jugadores "
                    + "WHERE id_jugador=? AND password=?");
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
            prepare = sqlConexion.prepareStatement("SELECT racha_victorias FROM jugadores "
                    + "WHERE id_jugador=? AND password=?");
            prepare.setString(1, nombre);
            prepare.setString(2, contraseña);
            result = prepare.executeQuery();

            if (result.next()) {
                victorias = result.getInt("Victorias");
                victorias++;

                // Actualizar el número de victorias en la base de datos
                prepare = sqlConexion.prepareStatement("UPDATE jugadores SET racha_victorias=? "
                        + "WHERE id_jugador=? AND password=?");
                prepare.setInt(1, victorias);
                prepare.setString(2, nombre);
                prepare.setString(3, contraseña);
                prepare.executeUpdate();
            } else {
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
            String consultaSQL = "SELECT id_jugador, racha_victorias FROM jugadores";
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

    public void guardarPartida(String id_PlayerRed, String id_PlayerBlue, Army armyBlue, Army armyRed, int turno, String arena) {

        PreparedStatement preparePartida = null;
        PreparedStatement prepareSoldados = null;

        try {
            // Insertar en la tabla 'partidas'
            preparePartida = sqlConexion.prepareStatement("INSERT INTO partidas(id_jugador1, id_jugador2, estado, arena) VALUES (?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparePartida.setString(1, id_PlayerRed);
            preparePartida.setString(2, id_PlayerBlue);
            preparePartida.setInt(3, 1);
            preparePartida.setString(4, arena);
            int filasAfectadasPartida = preparePartida.executeUpdate();

            // Obtener el id_partida generado
            ResultSet generatedKeys = preparePartida.getGeneratedKeys();
            int idPartida = 0;
            if (generatedKeys.next()) {
                idPartida = generatedKeys.getInt(1);
            }

            // Insertar en la tabla 'soldados' para el armyRed
            prepareSoldados = sqlConexion.prepareStatement("INSERT INTO soldados(id_partida, id_jugador, fila, columna, nombre,"
                    + " tipo, ataque, defensa, vida) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");

            
            insertarSoldadoes(prepareSoldados, armyRed, idPartida, id_PlayerRed);
            insertarSoldadoes(prepareSoldados, armyBlue, idPartida, id_PlayerBlue);
            
            
            // Cerrar recursos
            if (preparePartida != null) {
                preparePartida.close();
            }
            if (prepareSoldados != null) {
                prepareSoldados.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void insertarSoldadoes(PreparedStatement prepare, Army army, int idPartida, String id_Player) throws SQLException {
        int fila;
        int columna;
        int vida;
        String nombre;
        String tipo;
        int opcion;
        int ataque;
        int defensa;
        //"INSERT INTO soldados(id_partida, id_jugador, fila, otra_columna) VALUES (?, ?, ?, ?)");
        for (Soldier sol : army.converterToArrayUni()) {
            
            
            fila = sol.getRow();
            columna = sol.getColumn();
            nombre = sol.getName();
            opcion = Army.typeSoldier( sol);
            ataque = sol.getAttackLevel();
            defensa = sol.getDefenseLevel();
            vida = sol.getActualLife();
            
            if (opcion == 0) {
                tipo = "Arquero";
            } else if (opcion == 1) {
                tipo = "Caballero";
            } else if (opcion == 2) {
                tipo = "Spearman";
            } else if (opcion == 3) {
                tipo = "Espadachin";
            } else if (opcion == 4) {
                tipo = "EspadachinConquistador";
            } else if (opcion == 5) {
                tipo = "CaballeroFranco";
            } else if (opcion ==6) {
                tipo = "EspadachinGermano";
            } else if (opcion == 7) {
                tipo = "EspadachinMoro";
            } else {
                tipo = "EspadachinReal";
            }
            
            
            prepare.setInt(1, idPartida);
            prepare.setString(2, id_Player);
            prepare.setInt(3, fila);
            prepare.setInt(4, columna);
            prepare.setString(5, nombre);
            prepare.setString(6, tipo);
            prepare.setInt(7, ataque);
            prepare.setInt(8, defensa);
            prepare.setInt(9, vida);
            
            prepare.executeUpdate();
            prepare.clearParameters();
        }
    }

}
