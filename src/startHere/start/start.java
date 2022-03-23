package startHere.start;

import columbariumDAO.columbariumDAO;
import columbariumDAO.impl.columbariumDAOImpl;

public class start {

	public static void main(String[] args) {
		Meun meun = new Meun();
		
		System.out.println("目前資料表中的資料為");

		columbariumDAO cDAO = new columbariumDAOImpl();
//		cDAO.selectAllColumbarium();
		meun.createStartMeun();
	}
}
