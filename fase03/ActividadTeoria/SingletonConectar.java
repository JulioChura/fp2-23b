import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SingletonConectar {
    private static SingletonConectar instancia;
    private Connection sqlConexion;
    private String host = "localhost";
    private String port = "3306";
    private String nameDB = "petclinic";
    private String usuario = "alumnofp2";
    private String pass = "12345678";
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String dbURL = "jdbc:mysql://" + host + ":" + port + "/" + nameDB + "?useSSL=false";
    
    private SingletonConectar() {
        try {
            Class.forName(driver);
            sqlConexion = DriverManager.getConnection(dbURL, usuario, pass);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static SingletonConectar obtenerInstancia() {
        if (instancia == null) {
            instancia = new SingletonConectar();
        }
        return instancia;
    }
    
    // Método para realizar una consulta
    public void realizarConsulta(int cod) {
        PreparedStatement prepare = null;
        ResultSet result = null;

        try {
            prepare = sqlConexion.prepareStatement("SELECT * FROM owners WHERE id=?");
            prepare.setInt(1, cod);
            result = prepare.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                String firstName = result.getString("first_name");
                String lastName = result.getString("address");
                String city = result.getString("city");
                String telephone = result.getString("telephone");

                System.out.println("ID: " + id);
                System.out.println("Name: " + firstName);
                System.out.println("Lastname: " + lastName);
                System.out.println("City: " + city);
                System.out.println("Cellphone: " + telephone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción según tus necesidades
        } finally {
            // Cerrar recursos
            try {
                if (result != null) result.close();
                if (prepare != null) prepare.close();
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
