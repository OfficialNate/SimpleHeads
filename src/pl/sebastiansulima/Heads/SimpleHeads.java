package pl.sebastiansulima.Heads;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.mcstats.Metrics;

import pl.sebastiansulima.Heads.Commands.CommandAHead;
import pl.sebastiansulima.Heads.Commands.CommandHead;
import pl.sebastiansulima.Heads.Config.GetHeads;

public class SimpleHeads extends JavaPlugin {
	
	public static Map<String,String> List = new HashMap<String,String>();
	public static Map<String, Set<String>> map = new HashMap<String, Set<String>>();

	public static Configuration config;
	public static Plugin plugin;
	


	public void onEnable() {

		
		//xxx();
		
		
		plugin = this;
        this.saveDefaultConfig();
        config = getConfig();
        
		//if(Config.getAutoUpdate()){
		//	if(Config.getVer() < Downolader.getVer()){
		//		try {
		//			Downolader.Downolad();
		//			System.out.println("SimpleHeads - New heads downloaded - V" + Downolader.getVer());
		//			getConfig().set("Ver", Downolader.getVer());
		//			saveConfig();
					
		//		} catch (IOException e) {
		//			e.printStackTrace();
		//		}
		//	}
		//}
        
        
        
		
		getServer().getPluginManager().registerEvents(new GUI(), this);//rejestracja eventow

		getCommand("head").setExecutor(new CommandHead());
		getCommand("ahead").setExecutor(new CommandAHead());

		
	    try {
	        Metrics metrics = new Metrics(this);
			GetHeads.reloadCustomConfig();
			GetHeads.ToList();
	        metrics.start();
	    } catch (IOException e) {
	        // Failed to submit the stats :-(
	    }
		        
 
	    System.out.println("SimpleHeads = Loaded " + List.size() + " heads");


	}

	public void onDisable() {

		//saveConfig();
	}
	
	

	
	
	
	
	
	
	
	
	
	
	}


	
