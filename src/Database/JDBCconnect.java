package Database;
import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Toan
 */
public class JDBCconnect {
    public static Connection getConnection(){
        Connection c=null;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String url ="jdbc:mySQL://localhost:3306/quanlybansua";
            String username="root";
            String password="1234";
            c=DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }
    public static void closeConnection(Connection c){
        
    }
    public static void main(String[] args) {
        Connection connection=JDBCconnect.getConnection();
        System.out.println(connection);
    }
    
}
