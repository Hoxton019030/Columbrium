package startHere.start;

import columbariumDAO.columbariumDAO;
import columbariumDAO.bean.columbarium;
import columbariumDAO.impl.columbariumDAOImpl;

public class start {

	public static void main(String[] args) {
		System.out.println("目前資料表中的資料為");

		columbariumDAO cDAO = new columbariumDAOImpl();
		cDAO.selectAllColumbarium();
		
		

	}
}
