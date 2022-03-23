package method.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import ConnectSql.MyConnection;
import ConnectSql.Myconnection_noDatabaseImp;

public class Database {

	public void createDatabase() {
		String sql = "CREATE DATABASE Columbarium ";
		try {
			MyConnection myconn = new Myconnection_noDatabaseImp();
			Connection conn = myconn.getConnect();
			Statement stmt = conn.createStatement();
			stmt.execute(sql);
			System.out.println("Database created successfully...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void dropDatabase() {
		String sql = "Drop DATABASE Columbarium ";
		try {
			MyConnection myconn = new Myconnection_noDatabaseImp();
			Connection conn = myconn.getConnect();
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("Database Drop successfully...");
			myconn.free(conn, stmt, null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
