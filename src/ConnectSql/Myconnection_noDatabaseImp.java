package ConnectSql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Myconnection_noDatabaseImp implements MyConnection {
	String url = "jdbc:sqlserver://localhost:1433;";
	String userName = "Hoxton";
	String password = "orz93098";

	@Override
	public Connection getConnect() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	// TODO Auto-generated method stub
	}

	@Override
	public void free(Connection conn, Statement stmt, ResultSet rs) {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		// TODO Auto-generated method stub
		
	}
