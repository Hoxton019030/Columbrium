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
import SQLSyntax.SQLSyntaxCollection;
import columbariumDAO.columbariumDAO;
import columbariumDAO.bean.columbarium;
import exportCSV.CSV;
import url.Url;

public class columbariumDAOImpl implements columbariumDAO {

	@Override
	public List<columbarium> selectAllColumbarium() {
		MyConnection_withDatabaseImp myconn = new MyConnection_withDatabaseImp();
		SQLSyntaxCollection sqlSyntax = new SQLSyntaxCollection();
		CSV csv = new CSV();
		List<columbarium> columbariumList = new ArrayList<columbarium>();

		try {
			Connection conn = myconn.getConnect();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqlSyntax.getSQLsystax_selectAll());
			while (rs.next()) {
				columbarium c = new columbarium();
				c.setNumber(rs.getString("編號"));
				c.setTown(rs.getString("鄉鎮市"));
				c.setPublicOrPrivacy(rs.getString("公立或私立"));
				c.setOwner(rs.getString("設施管理者"));
				c.setFacilityName(rs.getString("設施名稱"));
				c.setTelephone(rs.getString("電話"));
				columbariumList.add(c);
			}
//			System.out.println(columbariumList);
		
			csv.generateCSVFile(columbariumList);
			

			myconn.free(conn, stmt, rs);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return columbariumList;
	}

	@Override
	public List<columbarium> selectColumbariumByNumber(int i) {
		SQLSyntaxCollection sqlSyntax = new SQLSyntaxCollection();
		String sql = sqlSyntax.getSQLsystax_selectByNumber();
		MyConnection_withDatabaseImp myconn = new MyConnection_withDatabaseImp();
		Connection conn = myconn.getConnect();
		List<columbarium> colList = new ArrayList<columbarium>();
		try {
			columbarium c = new columbarium();
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
			myconn.free(conn, pstmt, rs);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(colList);

		return colList;

		// TODO Auto-generated method stub
	}

	@Override
	public List<columbarium> selectColumbariumByTown(String town) {
		SQLSyntaxCollection sqlSyntax = new SQLSyntaxCollection();
		MyConnection_withDatabaseImp myconn = new MyConnection_withDatabaseImp();
		CSV csv = new CSV();
		String sql = sqlSyntax.getSQLsystax_selectByTown();
		
		Connection conn = myconn.getConnect();
		List<columbarium> colList = new ArrayList<columbarium>();
		
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			town="%"+town+"%"; //正則表達式 
			pstmt.setString(1, town);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				columbarium c = new columbarium();
				c.setNumber(rs.getString("編號"));
				c.setTown(rs.getString("鄉鎮市"));
				c.setPublicOrPrivacy(rs.getString("公立或私立"));
				c.setOwner(rs.getString("設施管理者"));
				c.setFacilityName(rs.getString("設施名稱"));
				c.setTelephone(rs.getString("電話"));
				colList.add(c);
			}
			try {
				csv.generateCSVFile(colList);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			myconn.free(conn, pstmt, rs);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return colList;

		// TODO Auto-generated method stub
	}

	@Override
	public List<columbarium> selectColumbariumByPublicOrPrivacy(String publicOrPrivacy) {

		SQLSyntaxCollection sqlSyntax = new SQLSyntaxCollection();
		String sql = sqlSyntax.getSQLsystax_selectByPublicOrPrivacy();
		MyConnection_withDatabaseImp myconn = new MyConnection_withDatabaseImp();
		CSV csv = new CSV();
		Connection conn = myconn.getConnect();
		List<columbarium> colList = new ArrayList<columbarium>();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			publicOrPrivacy = "%"+publicOrPrivacy+"%";
			pstmt.setString(1, publicOrPrivacy);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				columbarium c = new columbarium();
				c.setNumber(rs.getString("編號"));
				c.setTown(rs.getString("鄉鎮市"));
				c.setPublicOrPrivacy(rs.getString("公立或私立"));
				c.setOwner(rs.getString("設施管理者"));
				c.setFacilityName(rs.getString("設施名稱"));
				c.setTelephone(rs.getString("電話"));
				colList.add(c);
			}
			try {
				csv.generateCSVFile(colList);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			myconn.free(conn, pstmt, rs);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return colList;

		// TODO Auto-generated method stub

		
		// TODO Auto-generated method stub
	}

	@Override
	public List<columbarium> selectColumbariumByTelephone(String telephone) {


		SQLSyntaxCollection sqlSyntax = new SQLSyntaxCollection();
		String sql = sqlSyntax.getSQLsystax_selectByTelephone();
		telephone="%"+telephone+"%";
		MyConnection_withDatabaseImp myconn = new MyConnection_withDatabaseImp();
		CSV csv = new CSV();
		Connection conn = myconn.getConnect();
		List<columbarium> colList = new ArrayList<columbarium>();
		
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, telephone);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				columbarium c = new columbarium();
				c.setNumber(rs.getString("編號"));
				c.setTown(rs.getString("鄉鎮市"));
				c.setPublicOrPrivacy(rs.getString("公立或私立"));
				c.setOwner(rs.getString("設施管理者"));
				c.setFacilityName(rs.getString("設施名稱"));
				c.setTelephone(rs.getString("電話"));
				colList.add(c);
			}
			try {
				csv.generateCSVFile(colList);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			myconn.free(conn, pstmt, rs);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return colList;

		// TODO Auto-generated method stub
	}

	@Override
	public boolean addJsoncolumbarium() {
		SQLSyntaxCollection sqlSyntax = new SQLSyntaxCollection();

		String sql = sqlSyntax.getSQLsystax_addJsonData();
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
		SQLSyntaxCollection sqlsyntax = new SQLSyntaxCollection();
		MyConnection_withDatabaseImp myconn = new MyConnection_withDatabaseImp();
		Connection conn = myconn.getConnect();

		String sql = sqlsyntax.getSQLsystax_add();
		boolean succeed = false;

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
		SQLSyntaxCollection sqlsyntax = new SQLSyntaxCollection();
		MyConnection_withDatabaseImp myconn = new MyConnection_withDatabaseImp();
		Connection conn = myconn.getConnect();

		String sql = sqlsyntax.getSQLsystax_update();
		boolean succeed = false;

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
		SQLSyntaxCollection sqlsyntax = new SQLSyntaxCollection();
		MyConnection_withDatabaseImp myconn = new MyConnection_withDatabaseImp();
		Connection conn = myconn.getConnect();

		String sql = sqlsyntax.getSQLsystax_delete();
		boolean succeed = false;

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

}
