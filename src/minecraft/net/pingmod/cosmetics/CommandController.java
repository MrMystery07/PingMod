package net.pingmod.cosmetics;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.util.ChatComponentText;

public class CommandController extends CommandBase{

	@Override
	public String getCommandName() {
		return "cosmetic";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "/cosmetic <list|cosmetic>";
	}

	public static void msg(String msg) {
		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(msg));	
	}
	
	@Override
	public void processCommand(ICommandSender sender, String[] args) throws CommandException {
		
		if(args.length < 1) {
			throw new WrongUsageException("/cosmetic <list|cosmetic>", new Object[0]);
		}else {
			if(args[0].equalsIgnoreCase("list")) {
				msg("§f|----------|§bCosmetics§f|----------|");
				
				msg("§eWings");
				msg("§eGhostwings");
				msg("§eWitchhat");
				msg("§eClassichat");
				msg("§eZylinder");
				
				msg("§f|----------|§bCosmetics§f|----------|");
			}
			if(args[0].equalsIgnoreCase("wings")){
				Controller.wings = !Controller.wings;
				if(Controller.wings) {
					msg("§3[§bPingMod§3] §fDu hast die §eFlügel §aaktiviert§f!");
				}else {
					msg("§3[§bPingMod§3] §fDu hast die §eFlügel §cdeaktiviert§f!");
				}
			}
			if(args[0].equalsIgnoreCase("ghostwings")){
				Controller.ghostWings = !Controller.ghostWings;
				if(Controller.ghostWings) {
					msg("§3[§bPingMod§3] §fDu hast die §eDurchsichtigen Flügel §aaktiviert§f!");
				}else {
					msg("§3[§bPingMod§3] §fDu hast die §eDurchsichtigen Flügel §cdeaktiviert§f!");
				}
			}
			if(args[0].equalsIgnoreCase("witchhat")){
				Controller.witchHat = !Controller.witchHat;
				if(Controller.witchHat) {
					msg("§3[§bPingMod§3] §fDu hast den §eHexenhut §aaktiviert§f!");
				}else {
					msg("§3[§bPingMod§3] §fDu hast den §eHexenhut §cdeaktiviert§f!");
				}
			}
			if(args[0].equalsIgnoreCase("classichat")){
				Controller.classicHat = !Controller.classicHat;
				if(Controller.classicHat) {
					msg("§3[§bPingMod§3] §fDu hast den §eKlassischen Hut §aaktiviert§f!");
				}else {
					msg("§3[§bPingMod§3] §fDu hast den §eKlassischen Hut §cdeaktiviert§f!");
				}
			}
			if(args[0].equalsIgnoreCase("zylinder")){
				Controller.zylinder = !Controller.zylinder;
				if(Controller.zylinder) {
					msg("§3[§bPingMod§3] §fDu hast den §eZylinder §aaktiviert§f!");
				}else {
					msg("§3[§bPingMod§3] §fDu hast den §eZylinder §cdeaktiviert§f!");
				}
			}
		}
	}
	
}
