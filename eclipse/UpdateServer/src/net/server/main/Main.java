package net.server.main;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.sound.midi.SysexMessage;

public class Main {

	private ServerSocket server;
	public static boolean update = true;
	
	public Main(int port) {
		try {
			server = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void laufen() {
		while(true) {
			try {
				
			System.out.println("Waiting for client at " + server.getLocalPort());
			Socket client = server.accept();
			System.out.println(client.getRemoteSocketAddress());
			DataOutputStream output = new DataOutputStream(client.getOutputStream());
			output.writeUTF(String.valueOf(update));
			client.close();
			
			}catch (Exception e) {
				e.printStackTrace();
				break;  
			}
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String enter = sc.next();
		System.out.println(enter);
		if(enter.equalsIgnoreCase("true")) {
			update = true;
			System.out.println("TRUE");
		}
		if(enter.equalsIgnoreCase("false")) {
			update = false;
			System.out.println("FALSE");
		}
		
		Main s = new Main(1337);
		s.laufen();
	}

}
