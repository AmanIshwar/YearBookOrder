import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
public static Connection getConnection(){
		
		
		Connection con=null;
		String driverName ="oracle.jdbc.driver.OracleDriver"; 
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="SYSTEM";
		String password="aman";

try {
	Class.forName(driverName);

con=DriverManager.getConnection(url, user, password);


} catch (ClassNotFoundException | SQLException e) {
	
	e.printStackTrace();
}
return con;
}


}
