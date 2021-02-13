package net.server.main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sound.midi.SysexMessage;

public class Main {

	private ServerSocket server;
	public static String build = "7";
	public static String updateErzwingen = "true";
	public static List<String> list = new ArrayList<String>();
	public static String encodetList = "";
	public static String path = "C:/Users/cziep/Desktop/PingMod-Server";
	public Main(int port) {
		try {
			server = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void updateDatas() {
		Scanner scVersion = null;
		Scanner scRequired = null;
		Scanner scChangelog = null;
		try {
			scVersion = new Scanner(new File(path + "/version.txt"));
			scRequired = new Scanner(new File(path + "/required.txt"));
			scChangelog = new Scanner(new File(path + "/changelog.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		build = scVersion.nextLine();
		updateErzwingen = scRequired.nextLine();
		
		while (scChangelog.hasNextLine()) {
			String s = scChangelog.nextLine();
			list.add(s);
			System.out.println(s);
		}
	}
	
	public void laufen() {
		while(true) {
			try {
			System.out.println("Waiting for client at " + server.getLocalPort());
			Socket client = server.accept();
			System.out.println(client.getRemoteSocketAddress());
			updateDatas();
			DataInputStream input = new DataInputStream(client.getInputStream());
			String clientBuildVersion = input.readUTF();
			DataOutputStream output = new DataOutputStream(client.getOutputStream());
			if(clientBuildVersion.split(":")[0].equalsIgnoreCase(build)) {
				output.writeUTF("false:" + updateErzwingen + ":" + build);
			}else {
				output.writeUTF("true:" + updateErzwingen + ":" + build);
			}
			output.writeUTF(encodetList);
			System.out.println("Der Spieler " + clientBuildVersion.split(":")[1] + " hat den PingMod gestartet!");
			client.close();
			updateDatas();
			}catch (Exception e) {
				e.printStackTrace();
				break;  
			}
		}
	}
	
	public static void main(String[] args) {
		
//		list.add("Bugfix #1/Der Bug mit Köpfen wurde gefixt");
//		list.add("Bugfix #2/Der Bug mit Köpfen wurde gefixt");
//		list.add("Bugfix #3/Der Bug mit Köpfen wurde gefixt");
		
		updateDatas();
		
		for(int i = 0; i < list.size(); i++){
			if(encodetList == "") {
				encodetList = encodetList + list.get(i);
			}else {
				encodetList = encodetList + "=" + list.get(i);
			}
		}
		
//		String input = sc.nextLine();
//		System.out.println(input);
//		build = input.split(":")[0];
//		updateErzwingen = input.split(":")[1];
		
		
		
		Main s = new Main(1337);
		s.laufen();
	}

}
