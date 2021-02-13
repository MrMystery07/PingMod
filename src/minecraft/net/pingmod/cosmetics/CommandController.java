package net.pingmod.cosmetics;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;

public class CommandController extends CommandBase{

	@Override
	public String getCommandName() {
		return "cosmetic";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "/cosmetic list";
	}

	public static void msg(String msg) {
		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(msg));	
	}
	
	@Override
	public void processCommand(ICommandSender sender, String[] args) throws CommandException {
		
		if(args.length < 1) {
			throw new WrongUsageException("/cosmetic list", new Object[0]);
		}else {
			if(args[0].equalsIgnoreCase("list")) {
				msg("§f|----------|§bCosmetics§f|----------|");
				
				msg("");
				Minecraft.getMinecraft().thePlayer.addChatMessage(IChatComponent.Serializer.jsonToComponent("[\"\",{\"text\":\"Wings \",\"color\":\"yellow\"},{\"text\":\"[TOGGLE]\",\"bold\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/cosmetic wings\"},\"hoverEvent\":{\"action\":\"show_text\",\"contents\":{\"text\":\"Flügel aktivieren\"}}}]"));
				Minecraft.getMinecraft().thePlayer.addChatMessage(IChatComponent.Serializer.jsonToComponent("[\"\",{\"text\":\"Ghostwings \",\"color\":\"yellow\"},{\"text\":\"[TOGGLE]\",\"bold\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/cosmetic ghostwings\"},\"hoverEvent\":{\"action\":\"show_text\",\"contents\":{\"text\":\"Flügel aktivieren\"}}}]"));
				Minecraft.getMinecraft().thePlayer.addChatMessage(IChatComponent.Serializer.jsonToComponent("[\"\",{\"text\":\"Witchhat \",\"color\":\"yellow\"},{\"text\":\"[TOGGLE]\",\"bold\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/cosmetic witchhat\"},\"hoverEvent\":{\"action\":\"show_text\",\"contents\":{\"text\":\"Flügel aktivieren\"}}}]"));
				Minecraft.getMinecraft().thePlayer.addChatMessage(IChatComponent.Serializer.jsonToComponent("[\"\",{\"text\":\"Classichat \",\"color\":\"yellow\"},{\"text\":\"[TOGGLE]\",\"bold\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/cosmetic classichat\"},\"hoverEvent\":{\"action\":\"show_text\",\"contents\":{\"text\":\"Flügel aktivieren\"}}}]"));
				Minecraft.getMinecraft().thePlayer.addChatMessage(IChatComponent.Serializer.jsonToComponent("[\"\",{\"text\":\"Zylinder \",\"color\":\"yellow\"},{\"text\":\"[TOGGLE]\",\"bold\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/cosmetic zylinder\"},\"hoverEvent\":{\"action\":\"show_text\",\"contents\":{\"text\":\"Flügel aktivieren\"}}}]"));
				Minecraft.getMinecraft().thePlayer.addChatMessage(IChatComponent.Serializer.jsonToComponent("[\"\",{\"text\":\"Cloaks \",\"color\":\"yellow\"},{\"text\":\"[TOGGLE]\",\"bold\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/cosmetic cape toggle\"},\"hoverEvent\":{\"action\":\"show_text\",\"contents\":{\"text\":\"Flügel aktivieren\"}}},{\"text\":\"[<]\",\"bold\":true,\"color\":\"aqua\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/cosmetic cape remove\"}},{\"text\":\"[>]\",\"bold\":true,\"color\":\"aqua\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/cosmetic cape add\"}}]"));
				Minecraft.getMinecraft().thePlayer.addChatMessage(IChatComponent.Serializer.jsonToComponent("[\"\",{\"text\":\"Partikel \",\"color\":\"yellow\"},{\"text\":\"[TOGGLE]\",\"bold\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/cosmetic particle toggle\"},\"hoverEvent\":{\"action\":\"show_text\",\"contents\":{\"text\":\"Flügel aktivieren\"}}},{\"text\":\"[<]\",\"bold\":true,\"color\":\"aqua\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/cosmetic particle remove\"}},{\"text\":\"[>]\",\"bold\":true,\"color\":\"aqua\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/cosmetic particle add\"}}]"));

				
//				msg("§eGhostwings");
//				msg("§eWitchhat");
//				msg("§eClassichat");
				msg("");
				
				msg("§f|----------|§bCosmetics§f|----------|");
			}
			if(args[0].equalsIgnoreCase("wings")){
				Controller.wings = !Controller.wings;
			}
			if(args[0].equalsIgnoreCase("ghostwings")){
				Controller.ghostWings = !Controller.ghostWings;
			}
			if(args[0].equalsIgnoreCase("witchhat")){
				Controller.witchHat = !Controller.witchHat;
			}
			if(args[0].equalsIgnoreCase("classichat")){
				Controller.classicHat = !Controller.classicHat;
			}
			if(args[0].equalsIgnoreCase("zylinder")){
				Controller.zylinder = !Controller.zylinder;
			}
			if(args[0].equalsIgnoreCase("cape")){
				if(args[1].equalsIgnoreCase("toggle")) {
					
		    		if(Controller.capeCount == 0) {
		    			CosmeticCape.ar = new AnimatedResourceLocation("pingmod/capes/bausucht", 13, 8);
		    		}
		    		if(Controller.capeCount == 1) {
		    			CosmeticCape.ar = new AnimatedResourceLocation("pingmod/capes/christmas", 10, 8);
		    		}
		    		if(Controller.capeCount == 2) {
		    			CosmeticCape.ar = new AnimatedResourceLocation("pingmod/capes/firework", 14, 8);
		    		}
		    		if(Controller.capeCount == 3) {
		    			CosmeticCape.ar = new AnimatedResourceLocation("pingmod/capes/flower", 14, 8);
		    		}
		    		if(Controller.capeCount == 4) {
		    			CosmeticCape.ar = new AnimatedResourceLocation("pingmod/capes/griefer", 14, 8);
		    		}
		    		if(Controller.capeCount == 5) {
		    			CosmeticCape.ar = new AnimatedResourceLocation("pingmod/capes/griefergames", 13, 8);
		    		}
		    		if(Controller.capeCount == 6) {
		    			CosmeticCape.ar = new AnimatedResourceLocation("pingmod/capes/halloween", 12, 8);
		    		}
		    		if(Controller.capeCount == 7) {
		    			CosmeticCape.ar = new AnimatedResourceLocation("pingmod/capes/heart", 10, 8);
		    		}
		    		if(Controller.capeCount == 8) {
		    			CosmeticCape.ar = new AnimatedResourceLocation("pingmod/capes/lightning", 14, 8);
		    		}
		    		if(Controller.capeCount == 9) {
		    			CosmeticCape.ar = new AnimatedResourceLocation("pingmod/capes/moon", 14, 8);
		    		}
		    		if(Controller.capeCount == 10) {
		    			CosmeticCape.ar = new AnimatedResourceLocation("pingmod/capes/rainbow", 12, 8);
		    		}
		    		if(Controller.capeCount == 11) {
		    			CosmeticCape.ar = new AnimatedResourceLocation("pingmod/capes/snow", 14, 8);
		    		}
					
					Controller.cape = !Controller.cape;
				}
				if(args[1].equalsIgnoreCase("add")) {
					Minecraft.getMinecraft().thePlayer.sendChatMessage("/cosmetic toggle");
					Controller.capeCount++;
					
		    		if(Controller.capeCount == 0) {
		    			CosmeticCape.ar = new AnimatedResourceLocation("pingmod/capes/bausucht", 13, 8);
		    		}
		    		if(Controller.capeCount == 1) {
		    			CosmeticCape.ar = new AnimatedResourceLocation("pingmod/capes/christmas", 10, 8);
		    		}
		    		if(Controller.capeCount == 2) {
		    			CosmeticCape.ar = new AnimatedResourceLocation("pingmod/capes/firework", 14, 8);
		    		}
		    		if(Controller.capeCount == 3) {
		    			CosmeticCape.ar = new AnimatedResourceLocation("pingmod/capes/flower", 14, 8);
		    		}
		    		if(Controller.capeCount == 4) {
		    			CosmeticCape.ar = new AnimatedResourceLocation("pingmod/capes/griefer", 14, 8);
		    		}
		    		if(Controller.capeCount == 5) {
		    			CosmeticCape.ar = new AnimatedResourceLocation("pingmod/capes/griefergames", 13, 8);
		    		}
		    		if(Controller.capeCount == 6) {
		    			CosmeticCape.ar = new AnimatedResourceLocation("pingmod/capes/halloween", 12, 8);
		    		}
		    		if(Controller.capeCount == 7) {
		    			CosmeticCape.ar = new AnimatedResourceLocation("pingmod/capes/heart", 10, 16);
		    		}
		    		if(Controller.capeCount == 8) {
		    			CosmeticCape.ar = new AnimatedResourceLocation("pingmod/capes/lightning", 14, 8);
		    		}
		    		if(Controller.capeCount == 9) {
		    			CosmeticCape.ar = new AnimatedResourceLocation("pingmod/capes/moon", 14, 8);
		    		}
		    		if(Controller.capeCount == 10) {
		    			CosmeticCape.ar = new AnimatedResourceLocation("pingmod/capes/rainbow", 12, 8);
		    		}
		    		if(Controller.capeCount == 11) {
		    			CosmeticCape.ar = new AnimatedResourceLocation("pingmod/capes/snow", 14, 8);
		    		}
					
					Minecraft.getMinecraft().thePlayer.sendChatMessage("/cosmetic toggle");
				}
				if(args[1].equalsIgnoreCase("remove")) {
					Minecraft.getMinecraft().thePlayer.sendChatMessage("/cosmetic toggle");
					Controller.capeCount--;
					
		    		if(Controller.capeCount == 0) {
		    			CosmeticCape.ar = new AnimatedResourceLocation("pingmod/capes/bausucht", 13, 8);
		    		}
		    		if(Controller.capeCount == 1) {
		    			CosmeticCape.ar = new AnimatedResourceLocation("pingmod/capes/christmas", 10, 8);
		    		}
		    		if(Controller.capeCount == 2) {
		    			CosmeticCape.ar = new AnimatedResourceLocation("pingmod/capes/firework", 14, 8);
		    		}
		    		if(Controller.capeCount == 3) {
		    			CosmeticCape.ar = new AnimatedResourceLocation("pingmod/capes/flower", 14, 8);
		    		}
		    		if(Controller.capeCount == 4) {
		    			CosmeticCape.ar = new AnimatedResourceLocation("pingmod/capes/griefer", 14, 8);
		    		}
		    		if(Controller.capeCount == 5) {
		    			CosmeticCape.ar = new AnimatedResourceLocation("pingmod/capes/griefergames", 13, 8);
		    		}
		    		if(Controller.capeCount == 6) {
		    			CosmeticCape.ar = new AnimatedResourceLocation("pingmod/capes/halloween", 12, 8);
		    		}
		    		if(Controller.capeCount == 7) {
		    			CosmeticCape.ar = new AnimatedResourceLocation("pingmod/capes/heart", 10, 16);
		    		}
		    		if(Controller.capeCount == 8) {
		    			CosmeticCape.ar = new AnimatedResourceLocation("pingmod/capes/lightning", 14, 8);
		    		}
		    		if(Controller.capeCount == 9) {
		    			CosmeticCape.ar = new AnimatedResourceLocation("pingmod/capes/moon", 14, 8);
		    		}
		    		if(Controller.capeCount == 10) {
		    			CosmeticCape.ar = new AnimatedResourceLocation("pingmod/capes/rainbow", 12, 8);
		    		}
		    		if(Controller.capeCount == 11) {
		    			CosmeticCape.ar = new AnimatedResourceLocation("pingmod/capes/snow", 14, 8);
		    		}
					
					Minecraft.getMinecraft().thePlayer.sendChatMessage("/cosmetic toggle");
				}
			}
			if(args[0].equalsIgnoreCase("particle")){
				if(args[1].equalsIgnoreCase("toggle")) {
					Controller.particle = !Controller.particle;
				}
				if(args[1].equalsIgnoreCase("add")) {
					Controller.particle = false;
					
					Controller.particleCount++;
					if(Controller.particleCount == 9) {
						Controller.particleCount = 8;
					}
					Controller.particle = true;
				}
				if(args[1].equalsIgnoreCase("remove")) {
					Controller.particle = false;
					
					Controller.particleCount--;
					
					if(Controller.particleCount == -1) {
						Controller.particleCount = 0;
					}
					
					Controller.particle = true;
				}
			}
		}
	}
	
}
