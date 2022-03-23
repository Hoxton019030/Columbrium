package SQLSyntax;

public class SQLSyntaxCollection {

	private String SQLsystax_create = "";
	private String SQLsystax_findAll = "SELECT * \r\n" + "  FROM [Columbarium].[dbo].[ColumbariumTable]";
	String SQLsystax_update = "";
	String SQLsystax_delete = "";
	
	public String getSQLsystax_create() {
		return SQLsystax_create;
	}
	public void setSQLsystax_create(String sQLsystax_create) {
		SQLsystax_create = sQLsystax_create;
	}
	public String getSQLsystax_findAll() {
		return SQLsystax_findAll;
	}
	public void setSQLsystax_findAll(String sQLsystax_findAll) {
		SQLsystax_findAll = sQLsystax_findAll;
	}

}
