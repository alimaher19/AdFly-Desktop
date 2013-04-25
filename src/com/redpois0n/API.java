package com.redpois0n;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class API {
	
	public static String get(String key, String uid, String advert_type, String domain, String url) {
		String response = null;
		
		try {
			URL req = new URL("http://api.adf.ly/api.php?key=" + key + "&uid=" + uid + "&advert_type=" + advert_type + "&domain=" + domain + "&url=" + url);
			BufferedReader reader = new BufferedReader(new InputStreamReader(req.openStream()));
			response = reader.readLine();
			reader.close();
			
			return response;
		} catch (Exception ex) {
			ex.printStackTrace();
			return "Error: " + ex.getClass().getSimpleName() + ": " + ex.getMessage();
		}
	}

}
