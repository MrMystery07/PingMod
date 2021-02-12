package net.pingmod.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.pingmod.cosmetics.Controller;

public class PingModAddonManager {

	static List<PingModAddon> commands = new ArrayList<PingModAddon>();
	
	public static String startChar = "#";
	
	public PingModAddonManager() {
		addCommand(new CommandReload("reload"));
	}
	
	public static void onRightClick() {
		for(PingModAddon cmd : commands) {
			cmd.onRightClick();
		}
	}
	
	public static void onTick() {
		for(PingModAddon cmd : commands) {
			cmd.onTick();
		}
	}
	
	public static void onBlockRegister() {
		for(PingModAddon cmd : commands) {
			cmd.onBlockRegister();
		}
	}
	
	public static void addCommand(PingModAddon cmd) {
		commands.add(cmd);
		System.out.println("Command registered: " + cmd.getName());
	}
	
	public static boolean onCommand(String text) {
		if(!text.startsWith(startChar)) {
			return false;
		}
		text = text.substring(1);
		String[] arguments = text.split(" ");
		for(PingModAddon cmd : commands) {
			if(cmd.getName().equalsIgnoreCase(arguments[0])) {
				String[] args = (String[]) Arrays.copyOfRange(arguments, 1, arguments.length);
				cmd.onCommand(args);
				return true;
			}
		}
		return false;
	}
	
}
