package pl.sebastiansulima.Heads.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import pl.sebastiansulima.Heads.GUI;
import pl.sebastiansulima.Heads.SimpleHeads;
import pl.sebastiansulima.Heads.Config.Message;
import pl.sebastiansulima.Heads.Util.Permissions;

public class CommandHead implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String label, String[] args) {
		
		if((sender instanceof Player)){
			Player player = (Player) sender;
			
			if(args.length <= 1 && label.equalsIgnoreCase("simplehead") || label.equalsIgnoreCase("simh") 
					|| label.equalsIgnoreCase("head") || label.equalsIgnoreCase("glowa")){
				if(args.length == 0){

					if(player.getInventory().firstEmpty() == -1 ){
						sender.sendMessage(Message.FullInv());
						return false;
					}

					if(Permissions.getOwn(player) && !Permissions.get(player)){
						ItemStack glowa = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());

						SkullMeta  mglowa = (SkullMeta) glowa.getItemMeta();
						mglowa.setDisplayName(ChatColor.RED + sender.getName());
						mglowa.setOwner(sender.getName());
						glowa.setItemMeta(mglowa);
						player.getInventory().addItem(glowa);
						sender.sendMessage(Message.give1());
					}else if(Permissions.get(player.getPlayer())){
						GUI.openMenu(player);
					}else{
						sender.sendMessage(Message.noPerm());
					}
				}
				else if(args.length == 1){
					if(!Permissions.get(player)){
						sender.sendMessage(Message.noPerm());
						return false;
					}
					if(player.getInventory().firstEmpty() == -1 ){
						sender.sendMessage(Message.FullInv());
						return false;
					}
					
					
					if(!SimpleHeads.List.containsKey(args[0])){
					ItemStack glowa = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());

					SkullMeta  mglowa = (SkullMeta) glowa.getItemMeta();
					mglowa.setDisplayName(ChatColor.RED+args[0]);
					mglowa.setOwner(args[0]);
					glowa.setItemMeta(mglowa);
					player.getInventory().addItem(glowa);
					sender.sendMessage(Message.give2());
					}else{
						ItemStack glowa = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());

						SkullMeta  mglowa = (SkullMeta) glowa.getItemMeta();
						mglowa.setDisplayName(ChatColor.RED + SimpleHeads.List.get(args[0]));
						mglowa.setOwner(SimpleHeads.List.get(args[0]));
						glowa.setItemMeta(mglowa);
						player.getInventory().addItem(glowa);
						sender.sendMessage(Message.give2());
					}
				}
			}
		}
		return false;
	}
}
