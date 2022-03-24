package testArea;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;

import columbariumDAO.columbariumDAO;
import columbariumDAO.bean.columbarium;
import columbariumDAO.impl.columbariumDAOImpl;
import exportCSV.CSV;
import startHere.start.Meun;

public class Test {

	public static void main(String[] args) {
		Test test = new Test();
		Meun meun = new Meun();
		columbariumDAO cDAO = new columbariumDAOImpl();
		columbarium c = new columbarium();
		CSV csv = new CSV();
//		meun.createUpd ateMeun();
//		System.out.println(cDAO.selectColumbariums(2));
//		System.out.println(123);
//		meun.createDeleteMenu();
//      meun.createDeleteMenu();
//		meun.createStartMeun();
//		test.test3();
//		cDAO.selectAllColumbarium();
		test.updateTest();
	
		
//		try {
//			csv.generateCSVFile(cDAO.selectAllColumbarium());
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		cDAO.selectAllColumbarium();
		
	}
		public void test3(){
			columbarium c = new columbarium();
			CSV csv = new CSV();
			List<columbarium> colList = new ArrayList<columbarium>();
			
			c.setFacilityName("1");
			c.setNumber("2");
			c.setOwner("3");
			c.setPublicOrPrivacy("公立");
			c.setTelephone("4");
			c.setTown("5");
			colList.add(c);
			System.out.println(colList);
		}
	

//		cDAO.selectColumbariums(1);ㄉ
//		meun.createCreateMeun();

//		test.selectTest();
//		test.addTest();
//		test.updateTest();
//		test.deleteTest();
//		meun.ceateCreateMeun();

//	}

	public void selectTest() {
		columbariumDAO cDAO = new columbariumDAOImpl();
		String list = cDAO.selectAllColumbarium().toString();
		System.out.println(list);
	}

	// addtest測試完成，沒問題。
	public void addTest() {
		columbariumDAO cDAO = new columbariumDAOImpl();
		columbarium fakeColumbarium = new columbarium();

		fakeColumbarium.setTown("公立");
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
		fakeColumbarium.setTown("公立");
		fakeColumbarium.setPublicOrPrivacy("公立");
		fakeColumbarium.setOwner("大屌");
		fakeColumbarium.setFacilityName("大屌");
		fakeColumbarium.setTelephone("大屌");
		fakeColumbarium.setNumber("1");
		System.out.println(fakeColumbarium);

		cDAO.updateColumbarium(fakeColumbarium);
		System.out.println("資料已變更");

	}

}
