package generator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static String name = "yellow_sofa";
		
	public static void main(String[] args) {
		File blockstate = new File("C:\\Users\\cziep\\Desktop\\PingMod-All\\PingMod-1.8.0\\workspace\\src\\minecraft\\assets\\minecraft\\blockstates\\" + name + ".json");
		try {
			blockstate.createNewFile();
		} catch (IOException e) {
		}
		PrintWriter blockstateWriter = null;
		try {
			blockstateWriter = new PrintWriter(blockstate);
		} catch (Exception e) {
		}
		
		blockstateWriter.write("{\n");
		blockstateWriter.write("    \"variants\": {\n");
		blockstateWriter.write("        \"facing=south\": { \"model\": \"" + name + "\", \"y\": 90 },\n");
		blockstateWriter.write("        \"facing=west\": { \"model\": \"" + name + "\", \"y\": 180 },\n");
		blockstateWriter.write("        \"facing=north\": { \"model\": \"" + name + "\", \"y\": 270 },\n");
		blockstateWriter.write("        \"facing=east\": { \"model\": \"" + name + "\", \"y\": 0 }\n");
		blockstateWriter.write("    }\n");
		blockstateWriter.write("}\n");
		
		blockstateWriter.close();
		
		File modelItem = new File("C:\\Users\\cziep\\Desktop\\PingMod-All\\PingMod-1.8.0\\workspace\\src\\minecraft\\assets\\minecraft\\models\\item\\" + name + ".json");
		try {
			modelItem.createNewFile();
		} catch (IOException e) {
		}
		PrintWriter modelItemWriter = null;
		try {
			modelItemWriter = new PrintWriter(modelItem);
		} catch (Exception e) {
		}
		modelItemWriter.write("{\n");
		modelItemWriter.write("    \"parent\": \"block/");
		modelItemWriter.write(name);
		modelItemWriter.write("\",\n");
		modelItemWriter.write("    \"display\": {\n");
		modelItemWriter.write("        \"thirdperson\": {\n");
		modelItemWriter.write("            \"rotation\": [ 10, -45, 170 ],\n");
		modelItemWriter.write("            \"translation\": [ 0, 1.5, -2.75 ],\n");
		modelItemWriter.write("            \"scale\": [ 0.375, 0.375, 0.375 ]\n");
		modelItemWriter.write("        }\n");
		modelItemWriter.write("    }\n");
		modelItemWriter.write("}\n");
		modelItemWriter.close();
	}

}
