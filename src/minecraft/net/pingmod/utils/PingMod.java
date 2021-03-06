package net.pingmod.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.client.Minecraft;
import net.pingmod.profile.GuiPinnwall;

public class PingMod {

	public static int emotes = 0;
	public static int cosmetics = 0;
	public static int onlinetimewithpingmod = 0;
	public static int addons = 0;
	public static PingModAddonManager addonManager;
	private static final Logger logger = LogManager.getLogger();
	public static boolean onlinetimeinit = false;
	
	public static int buildNumber = 8;
	
	public static String minecraftPath = System.getenv("APPDATA") + "/.minecraft";
	public static void initClient() {
		System.out.println("UPDATE");
		
		logger.info("\r\n"
				+ "\r\n"
				+ "          _____                   _____                   _____                   _____                   _____                  _______                  _____          \r\n"
				+ "         /\\    \\                 /\\    \\                 /\\    \\                 /\\    \\                 /\\    \\                /::\\    \\                /\\    \\         \r\n"
				+ "        /::\\    \\               /::\\    \\               /::\\____\\               /::\\    \\               /::\\____\\              /::::\\    \\              /::\\    \\        \r\n"
				+ "       /::::\\    \\              \\:::\\    \\             /::::|   |              /::::\\    \\             /::::|   |             /::::::\\    \\            /::::\\    \\       \r\n"
				+ "      /::::::\\    \\              \\:::\\    \\           /:::::|   |             /::::::\\    \\           /:::::|   |            /::::::::\\    \\          /::::::\\    \\      \r\n"
				+ "     /:::/\\:::\\    \\              \\:::\\    \\         /::::::|   |            /:::/\\:::\\    \\         /::::::|   |           /:::/~~\\:::\\    \\        /:::/\\:::\\    \\     \r\n"
				+ "    /:::/__\\:::\\    \\              \\:::\\    \\       /:::/|::|   |           /:::/  \\:::\\    \\       /:::/|::|   |          /:::/    \\:::\\    \\      /:::/  \\:::\\    \\    \r\n"
				+ "   /::::\\   \\:::\\    \\             /::::\\    \\     /:::/ |::|   |          /:::/    \\:::\\    \\     /:::/ |::|   |         /:::/    / \\:::\\    \\    /:::/    \\:::\\    \\   \r\n"
				+ "  /::::::\\   \\:::\\    \\   ____    /::::::\\    \\   /:::/  |::|   | _____   /:::/    / \\:::\\    \\   /:::/  |::|___|______  /:::/____/   \\:::\\____\\  /:::/    / \\:::\\    \\  \r\n"
				+ " /:::/\\:::\\   \\:::\\____\\ /\\   \\  /:::/\\:::\\    \\ /:::/   |::|   |/\\    \\ /:::/    /   \\:::\\ ___\\ /:::/   |::::::::\\    \\|:::|    |     |:::|    |/:::/    /   \\:::\\ ___\\ \r\n"
				+ "/:::/  \\:::\\   \\:::|    /::\\   \\/:::/  \\:::\\____/:: /    |::|   /::\\____/:::/____/  ___\\:::|    /:::/    |:::::::::\\____|:::|____|     |:::|    /:::/____/     \\:::|    |\r\n"
				+ "\\::/    \\:::\\  /:::|____\\:::\\  /:::/    \\::/    \\::/    /|::|  /:::/    \\:::\\    \\ /\\  /:::|____\\::/    / ~~~~~/:::/    /\\:::\\    \\   /:::/    /\\:::\\    \\     /:::|____|\r\n"
				+ " \\/_____/\\:::\\/:::/    / \\:::\\/:::/    / \\/____/ \\/____/ |::| /:::/    / \\:::\\    /::\\ \\::/    / \\/____/      /:::/    /  \\:::\\    \\ /:::/    /  \\:::\\    \\   /:::/    / \r\n"
				+ "          \\::::::/    /   \\::::::/    /                  |::|/:::/    /   \\:::\\   \\:::\\ \\/____/              /:::/    /    \\:::\\    /:::/    /    \\:::\\    \\ /:::/    /  \r\n"
				+ "           \\::::/    /     \\::::/____/                   |::::::/    /     \\:::\\   \\:::\\____\\               /:::/    /      \\:::\\__/:::/    /      \\:::\\    /:::/    /   \r\n"
				+ "            \\::/____/       \\:::\\    \\                   |:::::/    /       \\:::\\  /:::/    /              /:::/    /        \\::::::::/    /        \\:::\\  /:::/    /    \r\n"
				+ "             ~~              \\:::\\    \\                  |::::/    /         \\:::\\/:::/    /              /:::/    /          \\::::::/    /          \\:::\\/:::/    /     \r\n"
				+ "                              \\:::\\    \\                 /:::/    /           \\::::::/    /              /:::/    /            \\::::/    /            \\::::::/    /      \r\n"
				+ "                               \\:::\\____\\               /:::/    /             \\::::/    /              /:::/    /              \\::/____/              \\::::/    /       \r\n"
				+ "                                \\::/    /               \\::/    /               \\::/____/               \\::/    /                ~~                     \\::/____/        \r\n"
				+ "                                 \\/____/                 \\/____/                                         \\/____/                                         ~~              \r\n"
				+ "                                                                                                                                                                         \r\n"
				+ "\r\n"
				+ "");
		
		logger.info("\r\n"
				+ "\r\n"
				+ "  _                 __  __      __  __           _                  \r\n"
				+ " | |               |  \\/  |    |  \\/  |         | |                 \r\n"
				+ " | |__  _   _      | \\  / |_ __| \\  / |_   _ ___| |_ ___ _ __ _   _ \r\n"
				+ " | '_ \\| | | |     | |\\/| | '__| |\\/| | | | / __| __/ _ \\ '__| | | |\r\n"
				+ " | |_) | |_| |     | |  | | |  | |  | | |_| \\__ \\ ||  __/ |  | |_| |\r\n"
				+ " |_.__/ \\__, |     |_|  |_|_|  |_|  |_|\\__, |___/\\__\\___|_|   \\__, |\r\n"
				+ "         __/ |                          __/ |                  __/ |\r\n"
				+ "        |___/                          |___/                  |___/ \r\n"
				+ "\r\n"
				+ "");
		
		try {
			AddonLoader.loadAddons();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File pinnwallOrdner = new File(minecraftPath + "/PingMod/pinnwall");
		File pinnwallFile = new File(minecraftPath + "/PingMod/pinnwall/save.txt");
		try {
			pinnwallOrdner.mkdirs();
			pinnwallFile.createNewFile();
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		File onlinetimeFile = new File(minecraftPath + "/PingMod/onlinetime.txt");
		try {
			onlinetimeFile.createNewFile();
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		File scamFile = new File(minecraftPath + "/PingMod/scam.txt");
		try {
			scamFile.createNewFile();
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		File trustFile = new File(minecraftPath + "/PingMod/trust.txt");
		try {
			trustFile.createNewFile();
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		GuiPinnwall.toDo.add("PingMod:PingMod GUI's fertig programmieren:");
		
		GuiPinnwall.x.add("100");
		
		GuiPinnwall.y.add("100");
		
		File accountList = new File(minecraftPath + "/PingMod/accounts.txt");
		if(!accountList.exists()) {
			try {
				accountList.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		addonManager = new PingModAddonManager();
		
		FileInputStream stream = null;
		try {
			stream = new FileInputStream(PingMod.minecraftPath + "/PingMod/onlinetime.txt");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8));
		String line;
		try {
			while ((line = reader.readLine()) != null) {
				onlinetimewithpingmod = Integer.valueOf(line);
				System.out.println("Line:" + line);
			}
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

		
		
		
		Timer timer = new Timer();
		
		timer.scheduleAtFixedRate(new TimerTask() {
			  @Override
			  public void run() {
				  if(onlinetimeinit == true) {
				  onlinetimewithpingmod = onlinetimewithpingmod+1;
				  try {
					PrintWriter writer;
						writer = new PrintWriter(PingMod.minecraftPath + "/PingMod/onlinetime.txt");
					writer.write(String.valueOf(onlinetimewithpingmod));
					writer.close();
				  } catch (Exception e) {
					e.printStackTrace();
				}
				  }else {
					  onlinetimeinit = true;
				  }
			  }
			}, 60*1000*60, 60*1000*60);
		
		//ServerUtils.isUpdateAviable();
	}
}
