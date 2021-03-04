package atmpro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {
    public static Connection Connection()   {
        try {
        	
//            
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/emploee", "root", "root");
            return conn;
        } catch (SQLException ex) {
          System.out.println("cn no sucess");
          ex.printStackTrace();
        }
		return null;
    }
}