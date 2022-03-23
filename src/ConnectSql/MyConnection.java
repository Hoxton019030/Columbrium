package ConnectSql;

import java.sql.Connection;
import java.sql.ResultSet;

public interface MyConnection {
	Connection getConnect();
	void free(Connection conn,java.sql.Statement stmt, ResultSet rs);
}
