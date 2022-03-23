package columbariumDAO;

import java.util.List;

import columbariumDAO.bean.columbarium;

public interface columbariumDAO {
	// 查詢
	List<columbarium> selectColumbariums(int i);
	
	
	columbarium selectColumbariums(String s);
	columbarium selectColumbariums();
	
	List<columbarium> selectAllColumbarium();
	//新增
	boolean addcolumbarium(columbarium c);
    //修改
	boolean updateColumbarium(columbarium c);
    //刪除
	boolean deleteColumbarium(int columbariumid);
	//新增Json資料
	boolean addJsoncolumbarium();
	
	

	
	

}
