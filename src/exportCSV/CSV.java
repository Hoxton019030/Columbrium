package exportCSV;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import columbariumDAO.bean.columbarium;

public class CSV {

	columbarium col = new columbarium();

	public void generateCSVFile(List<columbarium> colList) throws JSONException {
		String colString = colList.toString();
		StringBuffer sb = new StringBuffer();
		sb.append("編號,鄉鎮市,公立或私立,設施管理員,設施名稱,電話\r\n");
		JSONArray jArray = new JSONArray(colString);
		for (int i = 0; i < jArray.length(); i++) {
			try {
				JSONObject jObject = jArray.getJSONObject(i);
				int number = jObject.getInt("編號");
				String town = jObject.getString("鄉鎮市");
				String publicOrPrivacy = jObject.getString("公立或私立");
				String owner = jObject.getString("設施管理者");
				String facilityName = jObject.getString("設施名稱");
				String telephone = jObject.getString("電話");
				sb.append(number + "," + town + "," + publicOrPrivacy + "," + owner + "," + facilityName + ","
						+ telephone + "\n");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		String csvFile = sb.toString();
		File file = new File("output.csv");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		FileWriter fw;
		try {
			fw = new FileWriter("output.csv", false);
			PrintWriter pw = new PrintWriter(fw);
			pw.print(csvFile);
			pw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}