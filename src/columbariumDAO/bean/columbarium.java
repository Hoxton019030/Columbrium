package columbariumDAO.bean;

public class columbarium {
	
	private String town;
	private String publicOrPrivacy;
	private String owner;
	private String facilityName;
	private String telephone;
	private String number;
	
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		if(town.length()<=5) {
			this.town = town;
		}else if(town.length()>5){
			System.out.println("超過上限，最多只能輸入5個字喔");
		}
	}
	public String getPublicOrPrivacy() {
		return publicOrPrivacy;
	}
	public void setPublicOrPrivacy(String publicOrPrivacy) {
		if(publicOrPrivacy.equals("私立")||publicOrPrivacy.equals("公立")){
			this.publicOrPrivacy = publicOrPrivacy;
		}else {
			System.out.println("只能輸入[私立]或是[公立]兩個字喔！");
		}
		
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		if(owner.length()<=25) {
			this.owner = owner;
		}else if(owner.length()>25) {
			System.out.println("長度超過了，最多只能用25個字喔!");
		}
	}
	public String getFacilityName() {
		return facilityName;
	}
	public void setFacilityName(String facilityName) {
		if(facilityName.length()<=25) {
			this.facilityName = facilityName;
		}else if(facilityName.length()>25) {
			System.out.println("長度超過了，最多只能用25個字喔!");
		}
		
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		if(telephone.length()<=12) {
			this.telephone = telephone;
		}else if(telephone.length()>12) {
			System.out.println("長度超過囉，只能輸入12個字元喔");
		}
	}
	@Override
	public String toString() {
		return "靈骨塔資料 鄉鎮市=" + town + ",公立或私立=" + publicOrPrivacy + ", 設施管理者="
				+ owner + ", 設施名稱=" + facilityName + ", 電話=" + telephone + "\n";
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	
	
}
