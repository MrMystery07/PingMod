package net.pingmod.updater;

import java.awt.Desktop;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.pingmod.utils.PingMod;

public class UpdateAviable {

	public static boolean update = false;
	public static boolean updateErzwingen = false;
	
	public static List<String> list = new ArrayList<String>();
	
	public static String newBuildVersion = "0";
	
	public static void startClient() {
		
		try {
			Socket client = new Socket("pingmod.ddns.net", 1337);
			DataOutputStream output = new DataOutputStream(client.getOutputStream());
			output.writeUTF(String.valueOf(PingMod.buildNumber) + ":" + Minecraft.getMinecraft().getSession().getUsername());
			
			DataInputStream input = new DataInputStream(client.getInputStream());
			
			String datasFromServer = input.readUTF();
			
			update = Boolean.valueOf(datasFromServer.split(":")[0]);
			updateErzwingen = Boolean.valueOf(datasFromServer.split(":")[1]);
			newBuildVersion = datasFromServer.split(":")[2];
			
			String encodetList = input.readUTF();
			String[] count = encodetList.split("=");
			for(int i = 0; i < count.length; i++) {
				list.add(encodetList.split("=")[i]);
			}
			System.out.println(encodetList);
			client.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
			update = false;
		} catch (IOException e) {
			e.printStackTrace();
			update = false;
		}
		
		if(!update) {
			Minecraft.getMinecraft().displayGuiScreen(new GuiMainMenu());
		}else {
			Minecraft.getMinecraft().displayGuiScreen(new GuiUpdateAviable());
		}
	}
	
	public static void openWebpage(URI uri) {
	    Desktop desktop = Desktop.getDesktop();
	        try {
	            desktop.browse(uri);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}

	public static void openWebpage(URL url) {
	    try {
	        openWebpage(url.toURI());
	    } catch (URISyntaxException e) {
	        e.printStackTrace();
	    }
	}
	
}
