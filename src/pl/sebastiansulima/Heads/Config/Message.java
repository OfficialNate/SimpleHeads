package pl.sebastiansulima.Heads.Config;

import org.bukkit.entity.Player;

import pl.sebastiansulima.Heads.SimpleHeads;

public class Message {
	
	public static String Prefix(){
		String prefix = "";
		if(SimpleHeads.config.contains("Prefix")){
			prefix = SimpleHeads.config.getString("Prefix");
		}else{
			prefix = "&a[SH]&r ";
		}
		prefix = prefix.replaceAll("&", "§");
		return prefix;
	}

	
	
	public static String noPerm(){
		String message = "";
		if(Config.getLang().equalsIgnoreCase("pl")){
			message = "&4Nie masz uprawnien do tej komendy.";
		}else{
			message = "&4You do not have a permission to do this command.";
		}
		message = message.replaceAll("&", "§");
		return message;	
	}
	
	public static String FullInv(){
		String message = "";
		if(Config.getLang().equalsIgnoreCase("pl")){
			message = "&4Masz pelny ekwipunek!";
		}else{
			message = "&4You inventory is full!";
		}
		message = message.replaceAll("&", "§");
		return message;	
	}
	
	public static String give1(){
		String message = "";
		if(Config.getLang().equalsIgnoreCase("pl")){
			message = "&2Dostales/as swoja glowe.";
		}else{
			message = "&2You got your own head.";
		}
		message = message.replaceAll("&", "§");
		return message;	
	}
	
	public static String give2(){
		String message = "";
		if(Config.getLang().equalsIgnoreCase("pl")){
			message = "&2Dostales/as glowe";
		}else{
			message = "&2You got a head.";
		}
		message = message.replaceAll("&", "§");
		return message;	
	}
	
	public static String newVer(){
		String message = "";
		if(Config.getLang().equalsIgnoreCase("pl")){
			message = "&cNowa wersja dostepna.";
		}else{
			message = "&cNew version available.";
		}
		message = message.replaceAll("&", "§");
		return message;	
	}
	
	public static String noNewVer(){
		String message = "";
		if(Config.getLang().equalsIgnoreCase("pl")){
			message = "&cBrak nowszej wersji!";
		}else{
			message = "&cNo new version!";
		}
		message = message.replaceAll("&", "§");
		return message;	
	}
	
	
	public static String added(){
		String message = "";
		if(Config.getLang().equalsIgnoreCase("pl")){
			message = "&2Dodano nowa glowe.";
		}else{
			message = "&2New head added.";
		}
		message = message.replaceAll("&", "§");
		return message;	
	}
	
	public static String removed(){
		String message = "";
		if(Config.getLang().equalsIgnoreCase("pl")){
			message = "&cUsunieto glowe.";
		}else{
			message = "&cHead removed.";
		}
		message = message.replaceAll("&", "§");
		return message;	
	}
	
	public static String update(){
		String message = "";
		if(Config.getLang().equalsIgnoreCase("pl")){
			message = "&2List zostala zaktualizowana.";
		}else{
			message = "&2Head list updated.";
		}
		message = message.replaceAll("&", "§");
		return message;	
	}
	
	public static String updateError(){
		String message = "";
		if(Config.getLang().equalsIgnoreCase("pl")){
			message = "&4Blad aktalizacji!!";
		}else{
			message = "&4Update error!!";
		}
		message = message.replaceAll("&", "§");
		return message;	
	}
	
	public static String noFind(){
		String message = "";
		if(Config.getLang().equalsIgnoreCase("pl")){
			message = "&4Nie znaleziono glowy!!";
		}else{
			message = "&4Head not found!!";
		}
		message = message.replaceAll("&", "§");
		return message;	
	}
	
	
	public static String mainMenu(){
		String message = "";
		if(Config.getLang().equalsIgnoreCase("pl")){
			message = "&2   SimpleHeads - Menu glowne";
		}else{
			message = "&2      SimpleHeads - Main menu";
		}
		message = message.replaceAll("&", "§");
		return message;	
	}
	
	public static String YourHead(){
		String message = "";
		if(Config.getLang().equalsIgnoreCase("pl")){
			message = "&aWez swoja glowe.";
		}else{
			message = "&aTake your head.";
		}
		message = message.replaceAll("&", "§");
		return message;	
	}
	
/*	public static String headsList(){
		String message = "";
		if(Config.getLang().equalsIgnoreCase("pl")){
			message = "";
		}else{
			message = "";
		}
		message = message.replaceAll("&", "§");
		return message;	
	}*/

	public static String onlineList() {
		String message = "";
		if(Config.getLang().equalsIgnoreCase("pl")){
			message = "&2Wlasne glowy";
		}else{
			message = "&2Own heads";
		}
		message = message.replaceAll("&", "§");
		return message;	
	}

	public static String catMenu() {
		String message = "";
		if(Config.getLang().equalsIgnoreCase("pl")){
			message = "&2Wybierz katagorie";
		}else{
			message = "&2Select a category";
		}
		message = message.replaceAll("&", "§");
		return message;	
	}

	public static String reloaded() {
		String message = "";
		if(Config.getLang().equalsIgnoreCase("pl")){
			message = "&4Przeladowano";
		}else{
			message = "&4Reloaded";
		}
		message = message.replaceAll("&", "§");
		return message;	
	}



	public static String Exit() {
		String message = "";
		if(Config.getLang().equalsIgnoreCase("pl")){
			message = "&4Wyjscie";
		}else{
			message = "&4Exit";
		}
		message = message.replaceAll("&", "§");
		return message;	
	}



	public static String BackToMain() {
		String message = "";
		if(Config.getLang().equalsIgnoreCase("pl")){
			message = "&2Powrot do glownego menu.";
		}else{
			message = "&2Return to main menu.";
		}
		message = message.replaceAll("&", "§");
		return message;	
	}



	public static String BackToCat() {
		String message = "";
		if(Config.getLang().equalsIgnoreCase("pl")){
			message = "&2Powrot do katagori.";
		}else{
			message = "&2Return to category.";
		}
		message = message.replaceAll("&", "§");
		return message;	
	}



	public static String headsOfCat() {
		String message = "";
		if(Config.getLang().equalsIgnoreCase("pl")){
			message = "&2--> ";
		}else{
			message = "&2--> ";
		}
		message = message.replaceAll("&", "§");
		return message;
	}



	public static void aHeadSyntax(Player p) {
		if(Config.getLang().equalsIgnoreCase("pl")){
			p.sendMessage("&4Blad skladni!!".replaceAll("&", "§"));
			p.sendMessage("/ahead check - Check new plugin version");
			p.sendMessage("/ahead add <name> <nick> - add new head");
			p.sendMessage("/ahead remove <name> - remove head");
			p.sendMessage("/ahead reload - reload configuration and heads");


		}else{
			p.sendMessage("&4Syntax error!!".replaceAll("&", "§"));
			p.sendMessage("/ahead check - Check new plugin version");
			p.sendMessage("/ahead add <name> <nick> - add new head");
			p.sendMessage("/ahead remove <name> - remove head");
			p.sendMessage("/ahead reload - reload configuration and heads");


		}
	}



	public static String ownHeadList() {
		String message = "";
		if(Config.getLang().equalsIgnoreCase("pl")){
			message = "&2Wlasne glowy";
		}else{
			message = "&2Own heads";
		}
		message = message.replaceAll("&", "§");
		return message;
	}



	public static String ownMenu() {
		String message = "";
		if(Config.getLang().equalsIgnoreCase("pl")){
			message = "&2Wlasne glowy";
		}else{
			message = "&2Own heads";
		}
		message = message.replaceAll("&", "§");
		return message;
	}



	public static String ownPageS() {
		String message = "";
		if(Config.getLang().equalsIgnoreCase("pl")){
			message = "Strona";
		}else{
			message = "Pages";
		}
		message = message.replaceAll("&", "§");
		return message;
	}



	public static String BackToOwnMenu() {
		String message = "";
		if(Config.getLang().equalsIgnoreCase("pl")){
			message = "&2Powrot do menu wlasnych glow.";
		}else{
			message = "&2Return to own heads menu.";
		}
		message = message.replaceAll("&", "§");
		return message;
	}

}
