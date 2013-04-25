package com.redpois0n;

import java.awt.Desktop;
import java.net.URI;

public class Util {
	
	public static void openUrl(String url) {
		try {
			Desktop.getDesktop().browse(new URI(url));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
