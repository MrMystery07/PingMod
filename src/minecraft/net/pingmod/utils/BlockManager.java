package net.pingmod.utils;


import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;

public class BlockManager {

	//Die PingMod Blöcke sind noch in der Alpha!
	
	public static List<String> blocks = new ArrayList<String>();
	
	public static int count = 198;
	
	public static void addBlocks() {
		blocks.add("oak_table");
		blocks.add("spruce_table");
		blocks.add("birch_table");
		blocks.add("jungle_table");
		blocks.add("acacia_table");
		blocks.add("dark_oak_table");
		blocks.add("stone_table");
		blocks.add("granite_table");
		blocks.add("diorite_table");
		blocks.add("andesite_table");
		blocks.add("stripped_oak_table");
		blocks.add("stripped_spruce_table");
		blocks.add("stripped_birch_table");
		blocks.add("stripped_jungle_table");
		blocks.add("stripped_acacia_table");
		blocks.add("stripped_dark_oak_table");
		
		blocks.add("white_sofa");
		blocks.add("black_sofa");
		blocks.add("blue_sofa");
		blocks.add("brown_sofa");
		blocks.add("cyan_sofa");
		blocks.add("gray_sofa");
		blocks.add("green_sofa");
		blocks.add("light_blue_sofa");
		blocks.add("lime_sofa");
		blocks.add("magenta_sofa");
		blocks.add("orange_sofa");
		blocks.add("pink_sofa");
		blocks.add("purple_sofa");
		blocks.add("red_sofa");
		blocks.add("silver_sofa");
		blocks.add("yellow_sofa");
	}
	
}
