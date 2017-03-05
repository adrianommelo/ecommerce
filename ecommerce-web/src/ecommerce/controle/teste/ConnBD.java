package ecommerce.controle.teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnBD {
 
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "ecommerce_les";
		String password = "ecomm";
		Class.forName(driver);
		
		Connection conn = DriverManager.getConnection(url, user, password);
		return conn;
	}
}
