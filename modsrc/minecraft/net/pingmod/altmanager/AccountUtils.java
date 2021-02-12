package net.pingmod.altmanager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import net.pingmod.utils.PingMod;

public class AccountUtils {

	public static List<String> list = new ArrayList<String>();

	public static void saveAccount(String displayName, String name, String password) {
		list.clear();
		File file = new File(PingMod.minecraftPath + "/PingMod/accounts.txt");

		FileInputStream stream;
		BufferedReader reader = null;
		try {
			stream = new FileInputStream(PingMod.minecraftPath + "/PingMod/accounts.txt");
			reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8));
			String line;
			while ((line = reader.readLine()) != null) {
				list.add(line);
				System.out.println("Line:" + line);
			}
			System.out.println("1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		list.add(displayName + ":" + name + ":" + password);
		System.out.println(list.get(0));
		try {
			PrintWriter writer = new PrintWriter(PingMod.minecraftPath + "/PingMod/accounts.txt");
			for (String s : list) {
				writer.println(s);
				System.out.println(s);
			}
			writer.close();
			System.out.println("3");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void loadList() {
		list.clear();
		File file = new File(PingMod.minecraftPath + "/PingMod/accounts.txt");

		FileInputStream stream;
		BufferedReader reader = null;
		try {
			stream = new FileInputStream(PingMod.minecraftPath + "/PingMod/accounts.txt");
			reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8));
			String line;
			while ((line = reader.readLine()) != null) {
				list.add(line);
				System.out.println("Line:" + line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deleteAccount(String name) {
		list.clear();
		File file = new File(PingMod.minecraftPath + "/PingMod/accounts.txt");

		FileInputStream stream;
		BufferedReader reader = null;
		try {
			stream = new FileInputStream(PingMod.minecraftPath + "/PingMod/accounts.txt");
			reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8));
			String line;
			while ((line = reader.readLine()) != null) {
				if (!line.contains(name)) {
					list.add(line);
					System.out.println("Line:" + line);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			PrintWriter writer = new PrintWriter(PingMod.minecraftPath + "/PingMod/accounts.txt");
			for (String s : list) {
				writer.println(s);
				System.out.println(s);
			}
			writer.close();
			System.out.println("3");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void editAccount(String oldName, String newName, String newEmail, String newPassword) {
		list.clear();
		File file = new File(PingMod.minecraftPath + "/PingMod/accounts.txt");

		FileInputStream stream;
		BufferedReader reader = null;
		try {
			stream = new FileInputStream(PingMod.minecraftPath + "/PingMod/accounts.txt");
			reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8));
			String line;
			while ((line = reader.readLine()) != null) {
				if (!line.contains(oldName)) {
					list.add(line);
					System.out.println("Line:" + line);
				} else {
					list.add(newName + ":" + newEmail + ":" + newPassword);
				}
			}
			System.out.println("1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(list.get(0));
		try {
			PrintWriter writer = new PrintWriter(PingMod.minecraftPath + "/PingMod/accounts.txt");
			for (String s : list) {
				writer.println(s);
				System.out.println(s);
			}
			writer.close();
			System.out.println("3");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static final Minecraft mc = Minecraft.getMinecraft();

	private static void bindSkinTexture(String playerName) {
		File file = new File(
				"C:/Users/cziep/Desktop/PingMod-All/PingMod-1.8.0/workspace/src/minecraft/assets/minecraft/pingmod/"
						+ playerName + ".png");
		if(!file.exists()) {
		try {
			try {
				InputStream in = new URL("https://cravatar.eu/helmavatar/" + playerName + "/64.png").openStream();		
				Files.copy(in, Paths.get(file.getAbsolutePath()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}catch (Exception e) {
		}
	}
		ResourceLocation location = new ResourceLocation("pingmod/" + playerName + ".png");
		mc.getTextureManager().bindTexture(location);
	}

	public static void drawAltFace(int x, int y, int w, int h, boolean selected, String name) {
		try {
			bindSkinTexture(name);
			GL11.glEnable(3042);
			if (selected) {
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			} else {
				GL11.glColor4f(0.9F, 0.9F, 0.9F, 1.0F);
			}
			float fw = 192.0F;
			float fh = 192.0F;
			float u = 24.0F;
			float v = 24.0F;
			Gui.drawModalRectWithCustomSizedTexture(x, y, 23, 23.0F, w, h, 23.0F, 23.0F);
			fw = 192.0F;
			fh = 192.0F;
			u = 120.0F;
			v = 24.0F;
			// Gui.drawModalRectWithCustomSizedTexture(x, y, u, v, w, h, fw, fh);
			GL11.glDisable(3042);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
