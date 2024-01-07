package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class ConnectionManager {
	static Scanner sc = new Scanner(System.in);
	static Connection conn;
	static String url = "jdbc:mysql://localhost:3306/";
	static String dbName = "restomanagement";
	static String userName = "root";
	static String pass = "";
	
	public static Connection createConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url + dbName, userName, pass);
		} catch (Exception e) {
		    e.printStackTrace();
		}return conn;
	}
	
	public static void closeConnection() {
		
		try {
		conn.close();
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}

	
}
