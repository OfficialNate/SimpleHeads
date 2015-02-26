package pl.sebastiansulima.Heads.Config;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import pl.sebastiansulima.Heads.SimpleHeads;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;


public class Downolader {

  public static void Downolad() throws IOException {
	  
		 
		 String fileName = SimpleHeads.getPlugin(SimpleHeads.class).getDataFolder() +  "/heads.yml"; //The file that will be saved on your computer
		 
		 URL link_ang = new URL("http://sebastiansulima.pl/projects/heads/heads_ang.yml"); //The file that you want to download
		 URL link_pl = new URL("http://sebastiansulima.pl/projects/heads/heads_pl.yml"); //The file that you want to download

		 File Dir = SimpleHeads.getPlugin(SimpleHeads.class).getDataFolder();
		 
		 if(!Dir.exists()){
			 Dir.mkdir();
		 }
		 InputStream in;
		 if(Config.getLang().equalsIgnoreCase("pl")){
		 in = new BufferedInputStream(link_pl.openStream());}
		 else{
			 in = new BufferedInputStream(link_ang.openStream());
		 }
		 ByteArrayOutputStream out = new ByteArrayOutputStream();
		 byte[] buf = new byte[1024];
		 int n = 0;
		 while (-1!=(n=in.read(buf)))
		 {

		    out.write(buf, 0, n);
		 }
		 out.close();
		 in.close();
		 byte[] response = out.toByteArray();
 
		 FileOutputStream fos = new FileOutputStream(fileName);
		 fos.write(response);
		 fos.close();
		 
		 System.out.println("SIMH - New heads loaded!!");

	}
  
  
	public static float getVer() {
		try {
			URL xmlData = new URL("http://sebastiansulima.pl/projects/heads/ver");
			return Float.parseFloat(Resources.toString(xmlData, Charsets.UTF_8));
		} catch (IOException e) {
			e.printStackTrace();
			return 0;
		}
	}

	
	
	public static boolean checkVer(float a) {
		String data = null;
		try {
			URL xmlData = new URL("http://sebastiansulima.pl/projects/heads/ver");
			data = Resources.toString(xmlData, Charsets.UTF_8);
			if(Float.parseFloat(data) > a){
				return true;
			}
			else{
				return false;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

}