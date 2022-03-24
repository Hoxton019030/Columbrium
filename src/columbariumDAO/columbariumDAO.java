package columbariumDAO;

import java.util.List;

import columbariumDAO.bean.columbarium;

public interface columbariumDAO {
	// 查詢

	List<columbarium> selectAllColumbarium();

	List<columbarium> selectColumbariumByNumber(int number);

	List<columbarium> selectColumbariumByTown(String town);

	List<columbarium> selectColumbariumByPublicOrPrivacy(String publicOrPrivacy);

	List<columbarium> selectColumbariumByTelephone(String telephone);

	// 新增
	boolean addcolumbarium(columbarium c);

	boolean addJsoncolumbarium();

	// 修改
	boolean updateColumbarium(columbarium c);

	// 刪除
	boolean deleteColumbarium(int columbariumid);

}
