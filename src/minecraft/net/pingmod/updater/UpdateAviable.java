package net.pingmod.updater;

import java.awt.Desktop;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;

public class UpdateAviable {

	public static boolean update = false;
	
	public static void startClient() {
		
		try {
			Socket client = new Socket("pingmod.ddns.net", 1337);
			DataInputStream input = new DataInputStream(client.getInputStream());
			update = Boolean.valueOf(input.readUTF());
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
