package mysql;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestForConn {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "mysql");
		
		String connInfo = conn.toString();
		
		System.out.println("Schema : " + connInfo);
	
		
		
	}

}
