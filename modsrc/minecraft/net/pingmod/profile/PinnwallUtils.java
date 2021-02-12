package net.pingmod.profile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import net.pingmod.utils.PingMod;

public class PinnwallUtils {

	public static List<String> list = new ArrayList<String>();
	
	public static void loadLists() {
		list.clear();
		File file = new File(PingMod.minecraftPath + "/PingMod/pinnwall/save.txt");

		FileInputStream stream;
		BufferedReader reader = null;
		try {
			stream = new FileInputStream(PingMod.minecraftPath + "/PingMod/pinnwall/save.txt");
			reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8));
			String line;
			while ((line = reader.readLine()) != null) {
				list.add(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void saveList(String toDo, String x, String y) {
		list.clear();
		File file = new File(PingMod.minecraftPath + "/PingMod/pinnwall/save.txt");

		FileInputStream stream;
		BufferedReader reader = null;
		try {
			stream = new FileInputStream(PingMod.minecraftPath + "/PingMod/pinnwall/save.txt");
			reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8));
			String line;
			while ((line = reader.readLine()) != null) {
				
				list.add(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		list.add(x + ":" + y + ":" + toDo);
		try {
			PrintWriter writer = new PrintWriter(PingMod.minecraftPath + "/PingMod/pinnwall/save.txt");
			for (String s : list) {
				writer.println(s);
			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteAccount(String title) {
		list.clear();
		File file = new File(PingMod.minecraftPath + "/PingMod/pinnwall/save.txt");

		FileInputStream stream;
		BufferedReader reader = null;
		try {
			stream = new FileInputStream(PingMod.minecraftPath + "/PingMod/pinnwall/save.txt");
			reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8));
			String line;
			while ((line = reader.readLine()) != null) {
				if (!line.contains(title)) {
					list.add(line);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			PrintWriter writer = new PrintWriter(PingMod.minecraftPath + "/PingMod/pinnwall/save.txt");
			for (String s : list) {
				writer.println(s);
			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void editAccount(String title, String x, String y, String text) {
		list.clear();
		File file = new File(PingMod.minecraftPath + "/PingMod/pinnwall/save.txt");

		FileInputStream stream;
		BufferedReader reader = null;
		try {
			stream = new FileInputStream(PingMod.minecraftPath + "/PingMod/pinnwall/save.txt");
			reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8));
			String line;
			while ((line = reader.readLine()) != null) {
				if (!line.contains(title)) {
					list.add(line);
				} else {
					list.add(x + ":" + y + ":" + text);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			PrintWriter writer = new PrintWriter(PingMod.minecraftPath + "/PingMod/pinnwall/save.txt");
			for (String s : list) {
				writer.println(s);
			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
