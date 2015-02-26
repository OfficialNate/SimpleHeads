package pl.sebastiansulima.Heads.Util;

import org.bukkit.entity.Player;

public class Permissions {
	
	public static boolean getOwn(Player p){
		if(p.hasPermission("simh.getown") || p.isOp()){
			return true;
		}else{
			return false;
		}	
	}
	public static boolean get(Player p){
		if(p.hasPermission("simh.get") || p.isOp()){
			return true;
		}else{
			return false;
		}	
	}
	public static boolean list(Player p){
		if(p.hasPermission("simh.list") || p.isOp()){
			return true;
		}else{
			return false;
		}	
	}
	public static boolean check(Player p){
		if(p.hasPermission("simh.check") || p.isOp()){
			return true;
		}else{
			return false;
		}	
	}
	public static boolean update(Player p){
		if(p.hasPermission("simh.update") || p.isOp()){
			return true;
		}else{
			return false;
		}	
	}
	public static boolean modify(Player p){
		if(p.hasPermission("simh.modify") || p.isOp()){
			return true;
		}else{
			return false;
		}	
	}
	public static boolean reload(Player p){
		if(p.hasPermission("simh.reload") || p.isOp()){
			return true;
		}else{
			return false;
		}	
	}
}
