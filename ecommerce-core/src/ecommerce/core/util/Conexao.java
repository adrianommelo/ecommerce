
package ecommerce.core.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Conexao {
	
	public static Connection getConnection() 
			throws ClassNotFoundException, 
		SQLException{
		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521/ecommerce_les";
		String user = "ecommerce_les";
		String password = "ecomm";
		Class.forName( driver );
		Connection conn = 
				DriverManager.getConnection( url, user, password);
		return conn;
	}

}
