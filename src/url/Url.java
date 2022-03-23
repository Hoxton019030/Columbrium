package url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Url {
	public String getJsonString() {
		URL url;
		String line = "";
		try {
			url = new URL(
					"https://ws.hsinchu.gov.tw/001/Upload/1/opendata/8774/185/83ca353b-1af8-4239-bcb4-483a9bed2ea2.json");
			InputStream in = url.openStream();
			InputStreamReader inr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(inr);
			StringBuffer sr = new StringBuffer();
			while ((line = br.readLine()) != null) {
				sr.append(line);
			}
			line = sr.toString();
			return line;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return line;
	}
}
