package net.pingmod.utils;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import com.mojang.realmsclient.client.Ping;

public class AddonLoader {

	public static void loadAddons() throws Exception {
		File ordner = new File(PingMod.minecraftPath + "/PingMod/addons-1.8.8/");
		ordner.mkdir();
		String pfad = ordner.getPath();
		String dateiname[] = ordner.list();
		System.out.println("AddonManager geladen");
		if (!ordner.exists()) {
			ordner.mkdirs();
		}
		for (String name : dateiname) {
			String orginalname = name;
			name = name.replace(".txt", "");
			name = name.replace(".jar", "");
			System.out.println("Das Modul " + orginalname + " wurde geladen!");
			URL jarURL = new File(PingMod.minecraftPath + "/PingMod/addons-1.8.8/" + orginalname).toURL();
			ClassLoader classLoader = new URLClassLoader(new URL[] { jarURL });
			if (classLoader != null && (classLoader instanceof URLClassLoader)) {
				System.out.println("OK");
				URLClassLoader urlClassLoader = (URLClassLoader) classLoader;
				Method addURL = URLClassLoader.class.getDeclaredMethod("addURL", new Class[] { URL.class });
				addURL.setAccessible(true);
				addURL.invoke(urlClassLoader, new Object[] { jarURL });
			}
			Class testRunnerClass = classLoader.loadClass("net." + name + ".addon." + name);
			testRunnerClass.getMethod("main", new Class[] { String[].class }).invoke(null,
					new Object[] { new String[0] });
			System.out.println("OK");
		}
	}

}
