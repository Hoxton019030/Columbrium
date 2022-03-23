package startHere.start;

import java.util.Scanner;

import columbariumDAO.bean.columbarium;
import columbariumDAO.impl.columbariumDAOImpl;

public class Meun {

	public void createStartMeun() {
		Meun meun = new Meun();
		Scanner scn = new Scanner(System.in);
		System.out.println("想做什麼呢?請輸入[1-5]來進入選單。");
		System.out.println("1.新增資料。");
		System.out.println("2.查詢資料。");
		System.out.println("3.更新資料。");
		System.out.println("4.刪除資料。");
		System.out.println("5.離開");

		int i = scn.nextInt();
		switch (i) {
		case 1:
			meun.createUpdateMeun();
			break;
		case 2:
			break;
		case 3:
			meun.createUpdateMeun();
			break;
			
		}

	}

	public void createCreateMeun() {
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
	}

	public void createFindMeun() {

	}

	public void createUpdateMeun() {
		Scanner scn = new Scanner(System.in);
		columbarium c = new columbarium();
		columbariumDAOImpl cDAO = new columbariumDAOImpl();
		cDAO.selectAllColumbarium();
		System.out.println(1);
		System.out.println("請問要更新第幾筆資料呢?");
		int NumberOfUpdate = scn.nextInt();
		cDAO.selectColumbariums(NumberOfUpdate);
		System.out.println("目前的鄉鎮市為: "+c.getTown()); //這句有問題
		c.setTown(scn.nextLine());
		cDAO.updateColumbarium(c);
	}

	public void createDeleteMenu() {
		columbarium c = new columbarium();
		Scanner scn = new Scanner(System.in);
		columbariumDAOImpl cDAO = new columbariumDAOImpl();
		cDAO.selectAllColumbarium();
		System.out.println("你想刪掉第幾筆資料呢?");
		int NumberOfDelete = scn.nextInt();
		cDAO.deleteColumbarium(NumberOfDelete);
		System.out.println("第" + NumberOfDelete + "筆資料已經刪除。");
	}
}
