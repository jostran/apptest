package model.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDatabase {
	public static Connection conn;

	public static Connection CreateConnectDB() {
		try {
			if (conn == null || conn.isClosed()) {
				conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/quanlycanbo", "root",
						"admin");
				System.out.println("connected");
			}// end if
			else {
				return conn;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return conn;
	}// end

	public static void main(String[] args) {
		ConnectDatabase.CreateConnectDB();
	}// end
}
