package testArea;

import columbariumDAO.columbariumDAO;
import columbariumDAO.bean.columbarium;
import columbariumDAO.impl.columbariumDAOImpl;
import startHere.start.Meun;

public class Test {

	public static void main(String[] args) {
		Test test = new Test();
		Meun meun = new Meun();
		columbariumDAO cDAO = new columbariumDAOImpl();
		columbarium c = new columbarium();
//		meun.createUpdateMeun();
		System.out.println(cDAO.selectColumbariums(2));
		System.out.println(123);


		
		
		
//		cDAO.selectColumbariums(1);
//		meun.createCreateMeun();
		
		
		
//		test.selectTest();
//		test.addTest();
//		test.updateTest();
//		test.deleteTest();
//		meun.ceateCreateMeun();
		

	}
	
	public void selectTest() {
		columbariumDAO cDAO = new columbariumDAOImpl();
		String list=cDAO.selectAllColumbarium().toString();
		System.out.println(list);
	}

	// addtest測試完成，沒問題。
	public void addTest() {
		columbariumDAO cDAO = new columbariumDAOImpl();
		columbarium fakeColumbarium = new columbarium();

		fakeColumbarium.setTown("紐約");
		fakeColumbarium.setPublicOrPrivacy("私人");
		fakeColumbarium.setOwner("紐約公所");
		fakeColumbarium.setFacilityName("市立公墓");
		fakeColumbarium.setTelephone("0989796943");
		cDAO.addcolumbarium(fakeColumbarium);
		System.out.println("資料已新增");

	}

	// deleteTest測試完成，沒問題。
	public void deleteTest() {
		columbariumDAO cDAO = new columbariumDAOImpl();
		cDAO.deleteColumbarium(45);
		System.out.println("資料已被刪除");
	}
	
	

	// updateTest測試完成，沒問題。
	public void updateTest() {
		columbariumDAO cDAO = new columbariumDAOImpl();
		columbarium fakeColumbarium = new columbarium();
		fakeColumbarium.setTown("大屌");
		fakeColumbarium.setPublicOrPrivacy("大屌");
		fakeColumbarium.setOwner("大屌");
		fakeColumbarium.setFacilityName("大屌");
		fakeColumbarium.setFacilityName("大屌");
		fakeColumbarium.setNumber("45");

		cDAO.updateColumbarium(fakeColumbarium);
		System.out.println("資料已變更");

	}
	
	

}
