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

public class ProfileUitls {

	public static List<String> listTrust = new ArrayList<String>();
	public static List<String> listScam = new ArrayList<String>();
	
	public static void saveAccountTrust(String displayName) {
		listTrust.clear();
		File file = new File(PingMod.minecraftPath + "/PingMod/trust.txt");

		FileInputStream stream;
		BufferedReader reader = null;
		try {
			stream = new FileInputStream(PingMod.minecraftPath + "/PingMod/trust.txt");
			reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8));
			String line;
			while ((line = reader.readLine()) != null) {
				listTrust.add(line);
				System.out.println("Line:" + line);
			}
			System.out.println("1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		listTrust.add(displayName);
		System.out.println(listTrust.get(0));
		try {
			PrintWriter writer = new PrintWriter(PingMod.minecraftPath + "/PingMod/trust.txt");
			for (String s : listTrust) {
				writer.println(s);
				System.out.println(s);
			}
			writer.close();
			System.out.println("3");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void loadListTrust() {
		listTrust.clear();
		File file = new File(PingMod.minecraftPath + "/PingMod/trust.txt");

		FileInputStream stream;
		BufferedReader reader = null;
		try {
			stream = new FileInputStream(PingMod.minecraftPath + "/PingMod/trust.txt");
			reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8));
			String line;
			while ((line = reader.readLine()) != null) {
				listTrust.add(line);
				System.out.println("Line:" + line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deleteAccountTrust(String name) {
		listTrust.clear();
		File file = new File(PingMod.minecraftPath + "/PingMod/trust.txt");

		FileInputStream stream;
		BufferedReader reader = null;
		try {
			stream = new FileInputStream(PingMod.minecraftPath + "/PingMod/trust.txt");
			reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8));
			String line;
			while ((line = reader.readLine()) != null) {
				if (!line.contains(name)) {
					listTrust.add(line);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			PrintWriter writer = new PrintWriter(PingMod.minecraftPath + "/PingMod/trust.txt");
			for (String s : listTrust) {
				writer.println(s);
			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void editAccountTrust(String oldName, String newName) {
		listTrust.clear();
		File file = new File(PingMod.minecraftPath + "/PingMod/trust.txt");

		FileInputStream stream;
		BufferedReader reader = null;
		try {
			stream = new FileInputStream(PingMod.minecraftPath + "/PingMod/trust.txt");
			reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8));
			String line;
			while ((line = reader.readLine()) != null) {
				if (!line.contains(oldName)) {
					listTrust.add(line);
				} else {
					listTrust.add(newName);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			PrintWriter writer = new PrintWriter(PingMod.minecraftPath + "/PingMod/trust.txt");
			for (String s : listTrust) {
				writer.println(s);
			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	
	
	public static void saveAccountScam(String displayName) {
		listScam.clear();
		File file = new File(PingMod.minecraftPath + "/PingMod/scam.txt");

		FileInputStream stream;
		BufferedReader reader = null;
		try {
			stream = new FileInputStream(PingMod.minecraftPath + "/PingMod/scam.txt");
			reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8));
			String line;
			while ((line = reader.readLine()) != null) {
				listScam.add(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		listScam.add(displayName);
		try {
			PrintWriter writer = new PrintWriter(PingMod.minecraftPath + "/PingMod/scam.txt");
			for (String s : listScam) {
				writer.println(s);
			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void loadListScam() {
		listScam.clear();
		File file = new File(PingMod.minecraftPath + "/PingMod/scam.txt");

		FileInputStream stream;
		BufferedReader reader = null;
		try {
			stream = new FileInputStream(PingMod.minecraftPath + "/PingMod/scam.txt");
			reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8));
			String line;
			while ((line = reader.readLine()) != null) {
				listScam.add(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deleteAccountScam(String name) {
		listScam.clear();
		File file = new File(PingMod.minecraftPath + "/PingMod/scam.txt");

		FileInputStream stream;
		BufferedReader reader = null;
		try {
			stream = new FileInputStream(PingMod.minecraftPath + "/PingMod/scam.txt");
			reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8));
			String line;
			while ((line = reader.readLine()) != null) {
				if (!line.contains(name)) {
					listScam.add(line);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			PrintWriter writer = new PrintWriter(PingMod.minecraftPath + "/PingMod/scam.txt");
			for (String s : listScam) {
				writer.println(s);
			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void editAccountScam(String oldName, String newName) {
		listScam.clear();
		File file = new File(PingMod.minecraftPath + "/PingMod/scam.txt");

		FileInputStream stream;
		BufferedReader reader = null;
		try {
			stream = new FileInputStream(PingMod.minecraftPath + "/PingMod/scam.txt");
			reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8));
			String line;
			while ((line = reader.readLine()) != null) {
				if (!line.contains(oldName)) {
					listScam.add(line);
				} else {
					listScam.add(newName);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			PrintWriter writer = new PrintWriter(PingMod.minecraftPath + "/PingMod/scam.txt");
			for (String s : listScam) {
				writer.println(s);
			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
