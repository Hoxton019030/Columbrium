package method.Table;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import ConnectSql.MyConnection;
import ConnectSql.MyConnection_withDatabaseImp;
import SQLSyntax.SQLSyntaxCollection;

public class Table {

	public void createTable() {
		SQLSyntaxCollection sqlSyntax = new SQLSyntaxCollection();
		String sql = sqlSyntax.getSQLsystax_createTable();
		try {
			MyConnection myconn = new MyConnection_withDatabaseImp();
			Connection conn = myconn.getConnect();
			Statement stmt;
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("Table created successfully...");
			myconn.free(conn, stmt, null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void dropTable() {
		String sql = "USE Columbarium\r\n" + "Drop table ColumbariumTable\r\n";
		try {
			MyConnection myconn = new MyConnection_withDatabaseImp();
			Connection conn = myconn.getConnect();
			Statement stmt;
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("Table dropped successfully...");
			myconn.free(conn, stmt, null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated catch block

	}

}
