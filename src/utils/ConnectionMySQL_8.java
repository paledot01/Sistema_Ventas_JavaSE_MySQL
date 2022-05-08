package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySQL_8 {

	public static Connection getConnection() {
		
		Connection con= null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://localhost:3306/shoesformen?serverTimezone=UTC";
			String user = "root";
			String psw = "12345";
			con= DriverManager.getConnection(url,user,psw);
			
		} catch (ClassNotFoundException e) {
			System.out.println("Error >> Driver no Instalado" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Error >> de conexión con la BD" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error >> general : " + e.getMessage());
		} 
		return con;
	}
	
}
