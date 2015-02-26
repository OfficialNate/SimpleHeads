package pl.sebastiansulima.Heads.Config;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import pl.sebastiansulima.Heads.SimpleHeads;

public class GetHeads {
	private static FileConfiguration customConfig = null;
	private static File customConfigFile = new File(SimpleHeads.getPlugin(SimpleHeads.class).getDataFolder(), "/heads.yml");
	private static InputStream filefromjar = SimpleHeads.getPlugin(SimpleHeads.class).getResource("heads.yml");
	public static Map<String, Set<String>> map = new HashMap<String, Set<String>>();

	public static void reloadCustomConfig() throws IOException {
	    if (!customConfigFile.exists()) {	        
			OutputStream output = new FileOutputStream(customConfigFile);
			try {
				byte[] buf = new byte[1024];
				int bytesRead;
				while ((bytesRead = filefromjar.read(buf)) > 0) {
					output.write(buf, 0, bytesRead);
				}
			} finally {
				filefromjar.close();
				output.close();
			}	     	
	    }
	    
	    customConfig = YamlConfiguration.loadConfiguration(customConfigFile);
	 
	    // Look for defaults in the jar

	    System.out.println(getCategory().toString());


	}
	
	public static void LoadConfig(){
		try {
			customConfig.load(customConfigFile);
		} catch (IOException | InvalidConfigurationException e) {
			e.printStackTrace();
		}		
	}
	
	
	public static Set<String> getCategory(){
		return customConfig.getConfigurationSection("Category").getKeys(false);
	}
	
	public static List<String> getByCategory(String s){
		return customConfig.getStringList("Category." + s + ".Heads");
	}
	
	public static String getIcon(String a){
		return customConfig.getString("Category." + a + ".Icon");
	}
	
	private static void headsToList(){
		for(String c : getCategory()){
			for(String l : getByCategory(c)){
				if(l.contains(":")){
					String[] ll = l.split(":");
					if(!SimpleHeads.List.containsKey(ll[0])){
						SimpleHeads.List.put(ll[0], ll[1]);
					}
				}
				
			}	
		}
	}
	
	public static String OwnHeadNick(String a){
		return SimpleHeads.config.getString("OwnHeads." + a);
	}
	
	public static Set<String> OwnHeadList(){
		return SimpleHeads.config.getConfigurationSection("OwnHeads").getKeys(false);
	}
	
	
	private static void ownHeadsToList() {
		Set<String> oh = SimpleHeads.config.getConfigurationSection("OwnHeads").getKeys(false);		
		if (oh != null) {
			//SimpleHeads.List.clear();
			for(String line : oh){
					if(!SimpleHeads.List.containsKey(line)){
						SimpleHeads.List.put(line, OwnHeadNick(line));
						
					}	

			}
		}
	}
	
	public static Map<String, Set<String>> getPagesOwn(){
		//Map<String, Set<String>> map = new HashMap<String, Set<String>>();
		int x = 0;
		Set<String> a1 = new HashSet<String>();
		Set<String> a2 = new HashSet<String>();
		Set<String> a3 = new HashSet<String>();
		Set<String> a4 = new HashSet<String>();
		Set<String> a5 = new HashSet<String>();

		
		
		for(String s : OwnHeadList()){
			if(x <= 35){
				a1.add(s);
			}
			
			else if (x <= 71 && x > 35){
				a2.add(s);
			 }
			
			else if(x <= 107 && x > 71){
				a3.add(s);
			 }
			
			else if(x <= 143 && x > 107){
				a4.add(s);
			 }
				
			else if(x <= 179 && x > 143){
				a5.add(s);
			 }
			 
			 map.put(Message.ownPageS() + " 1", a1);
			 map.put(Message.ownPageS() + " 2", a2);
			 map.put(Message.ownPageS() + " 3", a3);
			 map.put(Message.ownPageS() + " 4", a4);
			 map.put(Message.ownPageS() + " 5", a5);

			 
			 x++;
		}
		
		return map;
	}
	
	public static void ToList(){
		SimpleHeads.List.clear();
		headsToList();
		ownHeadsToList();
	}
	
	public static Set<String> getPageOwn(String s){
		return map.get(s);
		
	}

}
