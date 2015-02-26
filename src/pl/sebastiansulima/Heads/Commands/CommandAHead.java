package pl.sebastiansulima.Heads.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.sebastiansulima.Heads.SimpleHeads;
import pl.sebastiansulima.Heads.Config.Config;
import pl.sebastiansulima.Heads.Config.Downolader;
import pl.sebastiansulima.Heads.Config.GetHeads;
import pl.sebastiansulima.Heads.Config.Message;
import pl.sebastiansulima.Heads.Util.Permissions;

public class CommandAHead implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String label,String[] args) {
		if((sender instanceof Player)){

		
		Player player = (Player) sender;
		
		
		if(args.length == 0 || args.length > 3){
			
			Message.aHeadSyntax(player);
			
			return false;
		}

		 if(label.equalsIgnoreCase("ahead") || label.equalsIgnoreCase("adminsimplehead") || label.equalsIgnoreCase("aglowa")){
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////			 
			if(args.length == 1){
				if(args[0].equalsIgnoreCase("check") || args[0].equalsIgnoreCase("sprawdz")){
					if(!Permissions.check(player)){
						sender.sendMessage(Message.noPerm());
						return false;
					}
						if(Downolader.getVer() > Config.getVer()){
							sender.sendMessage(Message.newVer());
						}else{
							sender.sendMessage(Message.newVer());
						}	
					}	
				}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			else if(args.length ==  3 && args[0].equalsIgnoreCase("add") || args[0].equalsIgnoreCase("dodaj")){
				if(!Permissions.modify(player)){
					sender.sendMessage(Message.noPerm());
					return false;
				}

				if(args.length == 3){
					SimpleHeads.config.set("OwnHeads." + args[1], args[2]);
					GetHeads.ToList();
					SimpleHeads.plugin.saveConfig();
					sender.sendMessage("§2Head added!");

				}else{
					if(Config.getLang().equalsIgnoreCase("pl")){
						sender.sendMessage("§4Zla skladnia!");
						sender.sendMessage("§2/aglowa dodaj <nazwa> <nick> - Dodanie nowej glowy do listy.");
						
					}else{	
						sender.sendMessage("§4Syntax error!");
						sender.sendMessage("§2/ahead add <name> <nick> - To add new head to list.");
					}
				}				
			}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			else if(args.length ==  2 &&args[0].equalsIgnoreCase("remove") || args[0].equalsIgnoreCase("usun")){
				if(!Permissions.modify(player)){
					sender.sendMessage(Message.noPerm());
					return false;
				}

				if(args.length == 2){
					if(!SimpleHeads.config.contains("OwnHeads." + args[1]) || !SimpleHeads.List.containsKey(args[1])){
						sender.sendMessage(Message.noFind());
						return false;
					}
					
					SimpleHeads.config.getConfigurationSection("OwnHeads").set(args[1], null);
					SimpleHeads.getPlugin(SimpleHeads.class).saveConfig();
					GetHeads.ToList();
					sender.sendMessage("§2Head removed!");

				}else{
					if(SimpleHeads.config.getString("Lang").equalsIgnoreCase("pl")){
						sender.sendMessage("§4Zla skladnia!");
							sender.sendMessage("§2/aglowa usun <nazwa> <nick> - Usuniecie glowy z listy.");
						
					}else{	
						sender.sendMessage("§4Syntax error!");
							sender.sendMessage("§2/ahead remove <name> <nick> - Removing head from list.");
					}					}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////				
			}else if(args.length ==  1 && args[0].equalsIgnoreCase("reload")){
				if(!Permissions.reload(player)){
					sender.sendMessage(Message.noPerm());
					return false;
				}

				SimpleHeads.getPlugin(SimpleHeads.class).reloadConfig();
				SimpleHeads.List.clear();
				GetHeads.LoadConfig();
				GetHeads.ToList();
				sender.sendMessage(Message.reloaded() + "  " + SimpleHeads.List.size());	
			}
			else{
				Message.aHeadSyntax(player);
	
			}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		 }
	}
return false;
}
}
