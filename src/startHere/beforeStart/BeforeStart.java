package startHere.beforeStart;

import columbariumDAO.columbariumDAO;
import columbariumDAO.impl.columbariumDAOImpl;
import method.Database.Database;
import method.Table.Table;

public class BeforeStart {
	
//在一開始要做的東西，創建資料庫、新增表格、填入資料
	public static void main(String[] args) {
		Table table = new Table();
		Database database = new Database();
		columbariumDAO cDAO = new columbariumDAOImpl();
		
//		1.創建資料庫
		database.createDatabase();
//		2.創建表格
		table.createTable();
//		3.增加json檔案
		cDAO.addJsoncolumbarium();
	}
}
