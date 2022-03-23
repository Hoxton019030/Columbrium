package SQLSyntax;

public class SQLSyntaxCollection {

	private String SQLsystax_add = "INSERT INTO[dbo].[ColumbariumTable] VALUES(?,?,?,?,?)";

	private String SQLsystax_selectAll = "SELECT * \r\n" + "  FROM [Columbarium].[dbo].[ColumbariumTable]";
	private String SQLsystax_selectByNumber = "SELECT [編號]\r\n" + "      ,[鄉鎮市]\r\n" + "      ,[公立或私立]\r\n"
			+ "      ,[設施管理者]\r\n" + "      ,[設施名稱]\r\n" + "      ,[電話]\r\n" + "  FROM [dbo].[ColumbariumTable]\r\n"
			+ "  WHERE 編號 = ?";
	private String SQLsystax_selectByTown = "SELECT  [編號]\r\n"
			+ "      ,[鄉鎮市]\r\n"
			+ "      ,[公立或私立]\r\n"
			+ "      ,[設施管理者]\r\n"
			+ "      ,[設施名稱]\r\n"
			+ "      ,[電話]\r\n"
			+ "  FROM [Columbarium].[dbo].[ColumbariumTable]\r\n"
			+ "  WHERE 鄉鎮市 = ? ";
	private String SQLsystax_selectByPublicOrPrivacy = "SELECT [編號]\r\n" + "      ,[鄉鎮市]\r\n" + "      ,[公立或私立]\r\n"
			+ "      ,[設施管理者]\r\n" + "      ,[設施名稱]\r\n" + "      ,[電話]\r\n"
			+ "  FROM [dbo].[ColumbariumTable] WHERE 公立或私立 = ? ";
	private String SQLsystax_selectByTelephone = "SELECT [編號],[鄉鎮市],[公立或私立],[設施管理者],[設施名稱],[電話] FROM [Columbarium].[dbo].[ColumbariumTable] WHERE 電話　LIKE ? ";

	private String SQLsystax_update = "UPDATE [dbo].[ColumbariumTable]\r\n" + "   SET [鄉鎮市] = ?" + "      ,[公立或私立] = ?"
			+ "      ,[設施管理者] = ?" + "      ,[設施名稱] = ?" + "      ,[電話] = ?" + " WHERE 編號=?";

	private String SQLsystax_delete = "DELETE FROM [dbo].[ColumbariumTable]      WHERE 編號= ? ";
	private String SQLsystax_addJsonData = "\"INSERT INTO[dbo].[ColumbariumTable] VALUES(?,?,?,?,?)\"";
	private String SQLsystax_createDatabase = "CREATE DATABASE Columbarium ";
	private String SQLsystax_dropDatabase = "Drop DATABASE Columbarium ";
	private String SQLsystax_createTable ="USE Columbarium\r\n" + "Create table ColumbariumTable\r\n"
			+ "(編號 int NOT NULL IDENTITY PRIMARY KEY,\r\n" + "鄉鎮市 varchar(10),\r\n" + "公立或私立 varchar(10),\r\n"
			+ "設施管理者 varchar(50),\r\n" + "設施名稱 varchar(50),\r\n" + "電話 char(12)\r\n" + ")";

	public String getSQLsystax_update() {
		return SQLsystax_update;
	}

	public void setSQLsystax_update(String sQLsystax_update) {
		SQLsystax_update = sQLsystax_update;
	}

	public String getSQLsystax_add() {
		return SQLsystax_add;
	}

	public void setSQLsystax_add(String sQLsystax_add) {
		SQLsystax_add = sQLsystax_add;
	}

	public String getSQLsystax_delete() {
		return SQLsystax_delete;
	}

	public void setSQLsystax_delete(String sQLsystax_delete) {
		SQLsystax_delete = sQLsystax_delete;
	}

	public String getSQLsystax_addJsonData() {
		return SQLsystax_addJsonData;
	}

	public void setSQLsystax_addJsonData(String sQLsystax_addJsonData) {
		SQLsystax_addJsonData = sQLsystax_addJsonData;
	}

	public String getSQLsystax_selectAll() {
		return SQLsystax_selectAll;
	}

	public void setSQLsystax_selectAll(String sQLsystax_selectAll) {
		SQLsystax_selectAll = sQLsystax_selectAll;
	}

	public String getSQLsystax_createDatabase() {
		return SQLsystax_createDatabase;
	}

	public void setSQLsystax_createDatabase(String sQLsystax_createDatabase) {
		SQLsystax_createDatabase = sQLsystax_createDatabase;
	}

	public String getSQLsystax_dropDatabase() {
		return SQLsystax_dropDatabase;
	}

	public void setSQLsystax_dropDatabase(String sQLsystax_dropDatabase) {
		SQLsystax_dropDatabase = sQLsystax_dropDatabase;
	}

	public String getSQLsystax_selectByNumber() {
		return SQLsystax_selectByNumber;
	}

	public void setSQLsystax_selectByNumber(String sQLsystax_selectByNumber) {
		SQLsystax_selectByNumber = sQLsystax_selectByNumber;
	}

	public String getSQLsystax_selectByTown() {
		return SQLsystax_selectByTown;
	}

	public void setSQLsystax_selectByTown(String sQLsystax_selectByTown) {
		SQLsystax_selectByTown = sQLsystax_selectByTown;
	}

	public String getSQLsystax_selectByPublicOrPrivacy() {
		return SQLsystax_selectByPublicOrPrivacy;
	}

	public void setSQLsystax_selectByPublicOrPrivacy(String sQLsystax_selectByPublicOrPrivacy) {
		SQLsystax_selectByPublicOrPrivacy = sQLsystax_selectByPublicOrPrivacy;
	}

	public String getSQLsystax_selectByTelephone() {
		return SQLsystax_selectByTelephone;
	}

	public void setSQLsystax_selectByTelephone(String sQLsystax_selectByTelephone) {
		SQLsystax_selectByTelephone = sQLsystax_selectByTelephone;
	}

	public String getSQLsystax_createTable() {
		return SQLsystax_createTable;
	}

	public void setSQLsystax_createTable(String sQLsystax_createTable) {
		SQLsystax_createTable = sQLsystax_createTable;
	}
	



}
