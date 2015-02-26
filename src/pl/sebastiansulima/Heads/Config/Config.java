package pl.sebastiansulima.Heads.Config;

import pl.sebastiansulima.Heads.SimpleHeads;

public class Config {
	
	public static float getVer(){
		return Float.parseFloat(SimpleHeads.config.getString("Ver"));
	}
	
	public static String getLang(){
		return SimpleHeads.config.getString("Lang");
	}

	public static boolean getAutoUpdate(){
		return SimpleHeads.config.getBoolean("AutoUpdateList");
	}
}
