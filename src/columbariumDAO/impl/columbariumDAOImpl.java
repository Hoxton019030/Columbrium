package columbariumDAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import ConnectSql.MyConnection_withDatabaseImp;
import columbariumDAO.columbariumDAO;
import columbariumDAO.bean.columbarium;
import url.Url;

public class columbariumDAOImpl implements columbariumDAO {

	@Override
	public List<columbarium> selectAllColumbarium() {
		MyConnection_withDatabaseImp myconn = new MyConnection_withDatabaseImp();
		String sql = "SELECT * \r\n" + "  FROM [Columbarium].[dbo].[ColumbariumTable]";
		List<columbarium> columbariumList = new ArrayList<columbarium>();

		try {
			Connection conn = myconn.getConnect();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				columbarium c = new columbarium();

				c.setTown(rs.getString("鄉鎮市"));
				c.setPublicOrPrivacy(rs.getString("公立或私立"));
				c.setOwner(rs.getString("設施管理者"));
				c.setFacilityName(rs.getString("設施名稱"));
				c.setTelephone(rs.getString("電話"));
				columbariumList.add(c);

			}
			System.out.println(columbariumList);

			myconn.free(conn, stmt, rs);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return columbariumList;
	}

	@Override
	public List<columbarium> selectColumbariums(int i) {
		String sql = "SELECT [編號]\r\n" + "      ,[鄉鎮市]\r\n" + "      ,[公立或私立]\r\n" + "      ,[設施管理者]\r\n"
				+ "      ,[設施名稱]\r\n" + "      ,[電話]\r\n" + "  FROM [dbo].[ColumbariumTable]\r\n" + "  WHERE 編號 = ?";
		MyConnection_withDatabaseImp myconn = new MyConnection_withDatabaseImp();
		Connection conn = myconn.getConnect();
		List<columbarium> colList = new ArrayList<columbarium>();
		columbarium c = new columbarium();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, i);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			c.setNumber(rs.getString("編號"));
			c.setTown(rs.getString("鄉鎮市"));
			c.setPublicOrPrivacy(rs.getString("公立或私立"));
			c.setOwner(rs.getString("設施管理者"));
			c.setFacilityName(rs.getString("設施名稱"));
			c.setTelephone(rs.getString("電話"));
			colList.add(c);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return colList;

		// TODO Auto-generated method stub
	}

	@Override
	public boolean addJsoncolumbarium() {
		String sql = "INSERT INTO[dbo].[ColumbariumTable] VALUES(?,?,?,?,?)";
		boolean succeed = false;
		MyConnection_withDatabaseImp myconn = new MyConnection_withDatabaseImp();
		Connection conn = myconn.getConnect();

		Url url = new Url();
		String jString = url.getJsonString();

		try {
			JSONArray jArray = new JSONArray(jString);

			for (int i = 0; i < jArray.length(); i++) {
				PreparedStatement pstmt = conn.prepareStatement(sql);

				columbarium col = new columbarium();
				JSONObject jObject = jArray.getJSONObject(i);
				String town = jObject.getString("鄉鎮市");
				String publicOrPrivacy = jObject.getString("公立或私立");
				String owner = jObject.getString("設施管理者");
				String facilityName = jObject.getString("設施名稱");
				String telephone = jObject.getString("電話");

				pstmt.setString(1, town);
				pstmt.setString(2, publicOrPrivacy);
				pstmt.setString(3, owner);
				pstmt.setString(4, facilityName);
				pstmt.setString(5, telephone);
				int count = pstmt.executeUpdate();

				if (count > 1) {
					succeed = true;
				}

			}
			System.out.println("Json Data has been inserted");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return succeed;
	}

	@Override
	public boolean addcolumbarium(columbarium c) {
		String sql = "INSERT INTO[dbo].[ColumbariumTable] VALUES(?,?,?,?,?)\r\n" + "";
		boolean succeed = false;
		MyConnection_withDatabaseImp myconn = new MyConnection_withDatabaseImp();
		Connection conn = myconn.getConnect();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getTown());
			pstmt.setString(2, c.getPublicOrPrivacy());
			pstmt.setString(3, c.getOwner());
			pstmt.setString(4, c.getFacilityName());
			pstmt.setString(5, c.getTelephone());
			int count = pstmt.executeUpdate();
			if (count > 1) {
				succeed = true;
			}
			return succeed;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return succeed;
	}

	@Override
	public boolean updateColumbarium(columbarium c) {
		String sql = "UPDATE [dbo].[ColumbariumTable]\r\n" + "   SET [鄉鎮市] = ?" + "      ,[公立或私立] = ?"
				+ "      ,[設施管理者] = ?" + "      ,[設施名稱] = ?" + "      ,[電話] = ?" + " WHERE 編號=?";
		boolean succeed = false;
		MyConnection_withDatabaseImp myconn = new MyConnection_withDatabaseImp();
		Connection conn = myconn.getConnect();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getTown());
			pstmt.setString(2, c.getPublicOrPrivacy());
			pstmt.setString(3, c.getOwner());
			pstmt.setString(4, c.getFacilityName());
			pstmt.setString(5, c.getTelephone());
			pstmt.setString(6, c.getNumber());
			int count = pstmt.executeUpdate();
			if (count > 1)
				succeed = true;
			myconn.free(conn, pstmt, null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return succeed;
	}

	@Override
	public boolean deleteColumbarium(int columbariumid) {
		String sql = "DELETE FROM [dbo].[ColumbariumTable]\r\n" + "      WHERE 編號=? ";
		boolean succeed = false;
		MyConnection_withDatabaseImp myconn = new MyConnection_withDatabaseImp();
		Connection conn = myconn.getConnect();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, columbariumid);
			int count = pstmt.executeUpdate();
			if (count >= 1) {
				succeed = true;
			}
			myconn.free(conn, pstmt, null);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return succeed;
	}

	@Override
	public columbarium selectColumbariums() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public columbarium selectColumbariums(String s) {
		// TODO Auto-generated method stub
		return null;
	}

}
