import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conectar {
    Connection sqlConexion;
    String host = "localhost";
    String port = "3306";
    String nameDB = "petclinic";
    String usuario = "alumnofp2";
    String pass = "12345678";
    Connection connection = null;
    PreparedStatement prepare = null;
    ResultSet result = null;
    String driver = "com.mysql.cj.jdbc.Driver";     
    String dbURL = "jdbc:mysql://"+host+":"+port+"/"+nameDB+"?useSSL=false";

    public Conectar(int cod){
        try {
            Class.forName(driver);
            sqlConexion = DriverManager.getConnection(dbURL, usuario, pass);
            prepare = sqlConexion.prepareStatement("SELECT*FROM owners WHERE id=?");
            prepare.setInt(1, cod); // (cantidad de inf que queremos ver, id del que queremos ver)
            result = prepare.executeQuery();
            
            while (result.next()) {
                int id = result.getInt("id");
                String firstName = result.getString("first_name");
                String lastName = result.getString("address");
                String city = result.getString("city");
                String telephone = result.getString("telephone");
                
                System.out.println("ID: "+ id);
                System.out.println("Name: "+ firstName);
                System.out.println("Lastname: "+ lastName);
                System.out.println("City: "+ city);
                System.out.println("Cellphone: "+ telephone);
            }     
            
        } catch (ClassNotFoundException e) {
            System.out.println("Ocurrio un error"+ e);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Conexion realizada");
        }
    }
       
}
