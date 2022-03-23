package startHere.start;

import java.util.List;
import java.util.Scanner;

import org.json.JSONException;

import columbariumDAO.bean.columbarium;
import columbariumDAO.impl.columbariumDAOImpl;
import exportCSV.CSV;

public class Meun {

	public void createStartMeun() {
		Scanner scn = new Scanner(System.in);
		System.out.println("想做什麼呢?請輸入[0-5]來進入選單。");
		System.out.println("1.新增資料。");
		System.out.println("2.查詢資料。");
		System.out.println("3.更新資料。");
		System.out.println("4.刪除資料。");
		System.out.println("0.離開");

		int i = scn.nextInt();
		switch (i) {
		case 1:
			createAddMeun();
			break;
		case 2:
			createSelectMeun();
			break;
		case 3:
			createUpdateMeun();
			break;
		case 4:
			createDeleteMenu();
			break;
		case 0:
			createLeaveMenu();
			break;
		}

	}

	public void createAddMeun() {
		columbariumDAOImpl cDAO = new columbariumDAOImpl();
		columbarium c = new columbarium();
		Scanner scn = new Scanner(System.in);
		System.out.println("請輸入資料");
		System.out.println("鄉鎮市:");
		c.setTown(scn.nextLine());
		System.out.println("公立或私立:");
		c.setPublicOrPrivacy(scn.nextLine());
		System.out.println("設施管理員:");
		c.setOwner(scn.nextLine());
		System.out.println("設施名稱:");
		c.setFacilityName(scn.nextLine());
		System.out.println("電話");
		c.setTelephone(scn.nextLine());

		System.out.println("鄉鎮市:" + c.getTown() + " 公立或私立:" + c.getPublicOrPrivacy() + " 設施管理員:" + c.getOwner()
				+ " 設施名稱:" + c.getFacilityName() + " 電話:" + c.getTelephone());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cDAO.addcolumbarium(c);
		createStartMeun();

	}

	public void createSelectMeun() {
		Scanner scn = new Scanner(System.in);
		System.out.println("請選擇你要的搜尋方式?");
		System.out.println("1.用編號搜尋。");
		System.out.println("2.用鄉鎮市搜尋。");
		System.out.println("3.用公立私立搜尋");
		System.out.println("4.用電話搜尋");
		System.out.println("0.退出");
		int i = scn.nextInt();
		switch (i) {
		case 1:
			selectByNumber();
			break;
		case 2:
			selectByTown();
			break;
		case 3:
			selectByPublicOrPrivacy();
		case 4:
			selectByTelephone();
		case 0:
		}

	}
	public void selectByNumber() {
		CSV csv = new CSV();
		System.out.println("你想要搜尋編號多少的資料?");
		Scanner scn = new Scanner(System.in);
		int Number = scn.nextInt();
		columbariumDAOImpl cDAO = new columbariumDAOImpl();
		List<columbarium> colList = cDAO.selectColumbariumByNumber(Number);
		try {
			csv.generateCSVFile(colList);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void selectByTown() {
		System.out.println("你想要搜尋什麼鄉鎮市的資料?");
		Scanner scn = new Scanner(System.in);
		String Town = scn.nextLine();
		columbariumDAOImpl cDAO = new columbariumDAOImpl();
		List<columbarium> colList = cDAO.selectColumbariumByTown(Town);
		System.out.println(colList);

	}
	
	public void selectByPublicOrPrivacy() {
		System.out.println("你想要搜尋公立還是私立的資料?");
		Scanner scn = new Scanner(System.in);
		String publicOrPravacy = scn.nextLine();
		columbariumDAOImpl cDAO = new columbariumDAOImpl();
		List<columbarium> colList = cDAO.selectColumbariumByPublicOrPrivacy(publicOrPravacy);
		System.out.println(colList);
		
	}
	
	public void selectByTelephone() {
		System.out.println("你想要搜尋的電話號碼是?");
		Scanner scn = new Scanner(System.in);
		String telephone = scn.nextLine();
		columbariumDAOImpl cDAO = new columbariumDAOImpl();
		List<columbarium> colList = cDAO.selectColumbariumByTelephone(telephone);
		System.out.println(colList);
	}

	public void createUpdateMeun() {
		Scanner scn = new Scanner(System.in);
		columbarium c = new columbarium();
		columbariumDAOImpl cDAO = new columbariumDAOImpl();
		cDAO.selectAllColumbarium();
		System.out.println(1);
		System.out.println(cDAO.selectAllColumbarium());
		System.out.println("請問要更新第幾筆資料呢?");
		int NumberOfUpdate = scn.nextInt();
		System.out.println(cDAO.selectColumbariumByNumber(NumberOfUpdate));
//		System.out.println("目前的鄉鎮市為: " + c.getTown()); // 這句有問題
		c.setTown(scn.nextLine());
		cDAO.updateColumbarium(c);
		createStartMeun();
	}

	public void createDeleteMenu() {
		columbarium c = new columbarium();
		Scanner scn = new Scanner(System.in);
		columbariumDAOImpl cDAO = new columbariumDAOImpl();

		cDAO.selectAllColumbarium();
		System.out.println("你想刪掉第幾筆資料呢?");
		int NumberOfDelete = scn.nextInt();
		System.out.println(123);
		cDAO.deleteColumbarium(NumberOfDelete);
		System.out.println("編號" + NumberOfDelete + "的資料已經刪除。");
		createStartMeun();
	}

	public void createLeaveMenu() {
		System.out.println("離開此程式。");
	}

	

	


}
