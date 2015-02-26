package pl.sebastiansulima.Heads;

import java.util.Map.Entry;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import pl.sebastiansulima.Heads.Config.GetHeads;
import pl.sebastiansulima.Heads.Config.Message;
import pl.sebastiansulima.Heads.Util.Permissions;

public class GUI implements Listener {

	public static void openMenu(Player p) {
		Inventory spectate;
		spectate = Bukkit.createInventory(p, 1 * 9, Message.mainMenu());
		ItemStack item = new ItemStack(Material.SKULL_ITEM, 1,
				(short) SkullType.PLAYER.ordinal());
		SkullMeta sm = (SkullMeta) item.getItemMeta();
		sm.setDisplayName(p.getDisplayName());
		sm.setOwner(p.getName());
		item.setItemMeta(sm);
		spectate.setItem(1, item);

		ItemStack item2 = new ItemStack(Material.BOOK, 1);
		ItemMeta sm2 = item2.getItemMeta();
		sm2.setDisplayName(Message.catMenu());
		item2.setItemMeta(sm2);
		spectate.setItem(4, item2);

		ItemStack item3 = new ItemStack(Material.BOOK_AND_QUILL, 1);
		ItemMeta sm3 = item3.getItemMeta();
		sm3.setDisplayName(Message.onlineList());
		item3.setItemMeta(sm3);
		spectate.setItem(7, item3);

		p.openInventory(spectate);
	}

	public void openCatMenu(Player p) {
		Set<String> cat = GetHeads.getCategory();
		int box = cat.size() * 2;
		int z = 0;
		int exit = 0;
		Inventory spectate = null;
		if (box <= 10) {
			spectate = Bukkit.createInventory(p, 2 * 9, Message.catMenu());
			exit = 11;
		} else if (box <= 18 && box > 10) {
			spectate = Bukkit.createInventory(p, 3 * 9, Message.catMenu());
			exit = 20;
		} else if (box <= 28 && box > 18) {
			spectate = Bukkit.createInventory(p, 4 * 9, Message.catMenu());
			exit = 29;
		} else if (box <= 36 && box > 28) {
			spectate = Bukkit.createInventory(p, 5 * 9, Message.catMenu());
			exit = 38;
		} else if (box <= 46 && box > 36) {
			spectate = Bukkit.createInventory(p, 6 * 9, Message.catMenu());
			exit = 47;
		} else {
			p.sendMessage(Message.Prefix() + "§4To mach category");
		}

		for (String s : GetHeads.getCategory()) {

			ItemStack item = new ItemStack(Material.SKULL_ITEM, 1,
					(short) SkullType.PLAYER.ordinal());
			SkullMeta sm = (SkullMeta) item.getItemMeta();
			sm.setDisplayName("Cat " + s);
			if (GetHeads.getIcon(s) != null) {
				sm.setOwner(GetHeads.getIcon(s));
			}
			item.setItemMeta(sm);
			spectate.setItem(z, item);
			z = z + 2;
		}

		ItemStack item = new ItemStack(Material.WOODEN_DOOR);
		ItemMeta sm = item.getItemMeta();
		sm.setDisplayName(Message.Exit());
		item.setItemMeta(sm);

		ItemStack item2 = new ItemStack(Material.COAL_BLOCK);
		ItemMeta sm2 = item2.getItemMeta();
		sm2.setDisplayName(Message.BackToMain());
		item2.setItemMeta(sm2);

		spectate.setItem(exit, item);
		spectate.setItem(exit + 4, item2);

		p.openInventory(spectate);

	}
	
	
	
	
	public void openOwnMenu(Player p) {

		Inventory spectate = null;
		spectate = Bukkit.createInventory(p, 2 * 9, Message.ownPageS());
		int z = 0;
		for (Entry<String, Set<String>> s : GetHeads.getPagesOwn().entrySet()) {
			
			if(!s.getValue().isEmpty()){
			
			ItemStack item = new ItemStack(Material.SKULL_ITEM, 1,
					(short) SkullType.PLAYER.ordinal());
			SkullMeta sm = (SkullMeta) item.getItemMeta();
			
			
			sm.setDisplayName(s.getKey());
			sm.setOwner(p.getName());
			
			item.setItemMeta(sm);
			spectate.setItem(z, item);
			z = z + 2;}
		}

		ItemStack item = new ItemStack(Material.WOOD_DOOR);
		ItemMeta sm = item.getItemMeta();
		sm.setDisplayName(Message.Exit());
		item.setItemMeta(sm);

		ItemStack item2 = new ItemStack(Material.ACACIA_DOOR);
		ItemMeta sm2 = item2.getItemMeta();
		sm2.setDisplayName(Message.BackToMain());
		item2.setItemMeta(sm2);
		
		//ItemStack item3 = new ItemStack(Material.COAL_BLOCK);
		//ItemMeta sm3 = item3.getItemMeta();
		//sm3.setDisplayName(Message.BackToOwnMenu());
		//item3.setItemMeta(sm3);
		

		spectate.setItem(11, item);
		spectate.setItem(15, item2);
		//spectate.setItem(13, item3);

		p.openInventory(spectate);

	}

	public void openCat(Player p, String cat, int items, String GuiName) {
		Inventory spectate = null;
		items = GetHeads.getByCategory(cat).size();
		int exit = 0;

		if (items <= 45) {
			if (items <= 9) {
				spectate = Bukkit.createInventory(p, 2 * 9,
						Message.headsOfCat() + cat);
				exit = 11;
			} else if (items > 9 && items <= 18) {
				spectate = Bukkit.createInventory(p, 3 * 9,
						Message.headsOfCat() + cat);
				exit = 20;
			} else if (items > 18 && items <= 27) {
				spectate = Bukkit.createInventory(p, 4 * 9,
						Message.headsOfCat() + cat);
				exit = 29;
			} else if (items > 27 && items <= 36) {
				spectate = Bukkit.createInventory(p, 5 * 9,
						Message.headsOfCat() + cat);
				exit = 38;
			}

			int z = 0;
			for (String s : GetHeads.getByCategory(cat)) {

				String[] ss = s.split(":");

				ItemStack item = new ItemStack(Material.SKULL_ITEM, 1,
						(short) SkullType.PLAYER.ordinal());
				SkullMeta sm = (SkullMeta) item.getItemMeta();
				sm.setDisplayName(ss[0]);
				sm.setOwner(ss[1]);
				item.setItemMeta(sm);
				spectate.setItem(z, item);
				z++;
			}

			ItemStack item = new ItemStack(Material.WOOD_DOOR);
			ItemMeta sm = item.getItemMeta();
			sm.setDisplayName(Message.Exit());
			item.setItemMeta(sm);

			ItemStack item2 = new ItemStack(Material.COAL_BLOCK);
			ItemMeta sm2 = item2.getItemMeta();
			sm2.setDisplayName(Message.BackToCat());
			item2.setItemMeta(sm2);

			ItemStack item3 = new ItemStack(Material.ACACIA_DOOR);
			ItemMeta sm3 = item3.getItemMeta();
			sm3.setDisplayName(Message.BackToMain());
			item3.setItemMeta(sm3);

			spectate.setItem(exit - 1, item);
			spectate.setItem(exit + 2, item2);
			spectate.setItem(exit + 5, item3);

			p.openInventory(spectate);
		} else {
			p.sendMessage("Za duzo");
		}
	}

	public void openOwnHeads(Player p, String b) {
		Inventory spectate = null;
	


			spectate = Bukkit.createInventory(p, 5 * 9,
						Message.ownHeadList());	



			
			int z = 0;
			for (String s : GetHeads.getPageOwn(b)) {
				


				ItemStack item = new ItemStack(Material.SKULL_ITEM, 1,
						(short) SkullType.PLAYER.ordinal());
				SkullMeta sm = (SkullMeta) item.getItemMeta();
				sm.setDisplayName(s);
				sm.setOwner(GetHeads.OwnHeadNick(s).replaceAll(" ", ""));
				item.setItemMeta(sm);
				spectate.setItem(z, item);
				z++;
				
			}

			ItemStack item = new ItemStack(Material.WOOD_DOOR);
			ItemMeta sm = item.getItemMeta();
			sm.setDisplayName(Message.Exit());
			item.setItemMeta(sm);

			ItemStack item2 = new ItemStack(Material.COAL_BLOCK);
			ItemMeta sm2 = item2.getItemMeta();
			sm2.setDisplayName(Message.BackToOwnMenu());
			item2.setItemMeta(sm2);

			ItemStack item3 = new ItemStack(Material.ACACIA_DOOR);
			ItemMeta sm3 = item3.getItemMeta();
			sm3.setDisplayName(Message.BackToMain());
			item3.setItemMeta(sm3);

			spectate.setItem(38, item);
			spectate.setItem(40, item2);
			spectate.setItem(42, item3);

			p.openInventory(spectate);
		
	}

	@EventHandler
	public void onClick(InventoryClickEvent e) {
		
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		if (e.getInventory().getTitle().equalsIgnoreCase(Message.mainMenu())) {
			if (e.getCurrentItem() != null
					&& e.getCurrentItem().getType() != null) {

				e.setCancelled(true);
				Player p = (Player) e.getWhoClicked();
				if (e.getCurrentItem().hasItemMeta()
						&& e.getCurrentItem().getItemMeta().hasDisplayName()) {

					if (e.getCurrentItem().getItemMeta().getDisplayName()
							.equalsIgnoreCase(Message.catMenu())) {
						openCatMenu(p);
					} else if (e.getCurrentItem().getItemMeta()
							.getDisplayName()
							.equalsIgnoreCase(Message.onlineList())) {
						openOwnMenu(p);
					}

					else if (e.getCurrentItem().getItemMeta().getDisplayName()
							.equalsIgnoreCase(p.getDisplayName())) {

						if (p.getInventory().firstEmpty() == -1) {
							p.sendMessage(Message.FullInv());
							return;
						}

						if (Permissions.getOwn(p)) {
							ItemStack glowa = new ItemStack(
									Material.SKULL_ITEM, 1,
									(short) SkullType.PLAYER.ordinal());

							SkullMeta mglowa = (SkullMeta) glowa.getItemMeta();
							mglowa.setDisplayName(ChatColor.RED + p.getName());
							mglowa.setOwner(p.getName());
							glowa.setItemMeta(mglowa);
							p.getInventory().addItem(glowa);
							p.sendMessage(Message.give1());
						} else {
							p.sendMessage(Message.noPerm());
						}
						p.closeInventory();

					}

				}
			}
		}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		else if (e.getInventory().getTitle()
				.equalsIgnoreCase(Message.catMenu())) {

			if (e.getCurrentItem() != null
					&& e.getCurrentItem().getType() != null) {

				e.setCancelled(true);
				Player p = (Player) e.getWhoClicked();
				if (e.getCurrentItem().hasItemMeta()
						&& e.getCurrentItem().getItemMeta().hasDisplayName()) {

					if (e.getCurrentItem().getItemMeta().getDisplayName()
							.equalsIgnoreCase(Message.Exit())) {
						p.closeInventory();

					} else if (e.getCurrentItem().getItemMeta()
							.getDisplayName()
							.equalsIgnoreCase(Message.BackToMain())) {
						GUI.openMenu(p);

					} else if (e.getCurrentItem().getItemMeta()
							.getDisplayName().startsWith("Cat")) {
						openCat(p, e.getCurrentItem().getItemMeta()
								.getDisplayName().replaceAll("Cat ", ""), 0, e
								.getCurrentItem().getItemMeta()
								.getDisplayName());
					}
				}
			}
		} 
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		else if (e.getInventory().getTitle().contains(Message.headsOfCat())) {

			if (e.getCurrentItem() != null
					&& e.getCurrentItem().getType() != null) {

				e.setCancelled(true);
				Player p = (Player) e.getWhoClicked();
				if (e.getCurrentItem().hasItemMeta()
						&& e.getCurrentItem().getItemMeta().hasDisplayName()) {

					if (e.getCurrentItem().getItemMeta().getDisplayName()
							.equalsIgnoreCase(Message.Exit())) {
						p.closeInventory();

					} else if (e.getCurrentItem().getItemMeta()
							.getDisplayName()
							.equalsIgnoreCase(Message.BackToMain())) {
						openMenu(p);

					} else if (e.getCurrentItem().getItemMeta()
							.getDisplayName()
							.equalsIgnoreCase(Message.BackToCat())) {
						openCatMenu(p);

					} else if (SimpleHeads.List.containsKey(e.getCurrentItem()
							.getItemMeta().getDisplayName())) {

						ItemStack glowa = new ItemStack(Material.SKULL_ITEM, 1,
								(short) SkullType.PLAYER.ordinal());

						SkullMeta mglowa = (SkullMeta) glowa.getItemMeta();
						mglowa.setDisplayName(e.getCurrentItem().getItemMeta()
								.getDisplayName());
						mglowa.setOwner(SimpleHeads.List.get(e.getCurrentItem()
								.getItemMeta().getDisplayName()));
						glowa.setItemMeta(mglowa);
						p.getInventory().addItem(glowa);

					}
				}
			}
		}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		else if (e.getInventory().getTitle().startsWith(Message.ownHeadList())) {

			if (e.getCurrentItem() != null
					&& e.getCurrentItem().getType() != null) {

				e.setCancelled(true);
				Player p = (Player) e.getWhoClicked();
				if (e.getCurrentItem().hasItemMeta()
						&& e.getCurrentItem().getItemMeta().hasDisplayName()) {

					if (e.getCurrentItem().getItemMeta().getDisplayName()
							.equalsIgnoreCase(Message.Exit())) {
						p.closeInventory();

					} else if (e.getCurrentItem().getItemMeta()
							.getDisplayName()
							.equalsIgnoreCase(Message.BackToMain())) {
						openMenu(p);

					} else if (e.getCurrentItem().getItemMeta()
							.getDisplayName()
							.equalsIgnoreCase(Message.BackToOwnMenu())) {
						openOwnMenu(p);

					} else if (SimpleHeads.List.containsKey(e.getCurrentItem()
							.getItemMeta().getDisplayName())) {

						ItemStack glowa = new ItemStack(Material.SKULL_ITEM, 1,
								(short) SkullType.PLAYER.ordinal());

						SkullMeta mglowa = (SkullMeta) glowa.getItemMeta();
						mglowa.setDisplayName(e.getCurrentItem().getItemMeta()
								.getDisplayName());
						mglowa.setOwner(SimpleHeads.List.get(e.getCurrentItem()
								.getItemMeta().getDisplayName()));
						glowa.setItemMeta(mglowa);
						p.getInventory().addItem(glowa);

					}
				}
			}
		}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		else if (e.getInventory().getTitle().equalsIgnoreCase(Message.ownPageS())) {

			
			if (e.getCurrentItem() != null
					&& e.getCurrentItem().getType() != null) {

				e.setCancelled(true);
				Player p = (Player) e.getWhoClicked();

				if (e.getCurrentItem().hasItemMeta()
						&& e.getCurrentItem().getItemMeta().hasDisplayName()) {
					
				

					if (e.getCurrentItem().getItemMeta().getDisplayName()
							.equalsIgnoreCase(Message.Exit())) {
						p.closeInventory();

					} else if (e.getCurrentItem().getItemMeta()
							.getDisplayName()
							.equalsIgnoreCase(Message.BackToMain())) {
						     openMenu(p);

					} else if (e.getCurrentItem().getItemMeta()
							.getDisplayName()
							.equalsIgnoreCase(Message.BackToOwnMenu())) {
						    openOwnMenu(p);

					} else if (GetHeads.map.containsKey(e.getCurrentItem().getItemMeta()
							.getDisplayName())) {
						
						
						openOwnHeads(p, e.getCurrentItem().getItemMeta()
								.getDisplayName());

					}
				}
			}
		}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	}
	
	

}