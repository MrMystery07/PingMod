package net.pingmod.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C10PacketCreativeInventoryAction;
import net.minecraft.util.ChatComponentText;

public abstract class PingModAddon {

	private String name;
	private Minecraft mc;
	
	public PingModAddon(String name) {
		this.name = name;
	}
	
	public abstract void onTick();
	
	public abstract void onRightClick();
	
	public abstract void onCommand(String[] args);
	
	public String getName() {
		return name;
	}
	
	public abstract void onBlockRegister();
	
	public static void msg(String msg) {
		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§3[§bPingMod§3] §f" + msg));	
	}
	
	public static void sendMessageWithoutPrefix(String msg) {
		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(msg));	
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	  public static void giveItem(int slot, ItemStack item) {
		    (Minecraft.getMinecraft()).thePlayer.sendQueue.addToSendQueue((Packet)new C10PacketCreativeInventoryAction(slot, item));
		  }
		  
		  public static ItemStack addItemToOfen(ItemStack itm) {
		    ItemStack funarce = new ItemStack(Blocks.furnace);
		    NBTTagCompound base = new NBTTagCompound();
		    NBTTagCompound blockEntityTag = new NBTTagCompound();
		    blockEntityTag.setShort("BurnTime", (short)0);
		    blockEntityTag.setShort("CookTime", (short)0);
		    blockEntityTag.setShort("BurnTimeTotal", (short)200);
		    blockEntityTag.setString("id", "furnace");
		    blockEntityTag.setString("Lock", "");
		    NBTTagList items = new NBTTagList();
		    NBTTagCompound item = new NBTTagCompound();
		    item.setByte("Count", (byte)1);
		    item.setShort("Damage", (short)itm.getItemDamage());
		    item.setString("id", "minecraft:mob_spawner");
		    item.setShort("Slot", (short)0);
		    item.setTag("tag", (NBTBase)itm.getTagCompound());
		    items.appendTag((NBTBase)item);
		    blockEntityTag.setTag("Items", (NBTBase)items);
		    base.setTag("BlockEntityTag", (NBTBase)blockEntityTag);
		    funarce.setTagCompound(base);
		    return funarce;
		  }
		  
		  public static void giveItemInOfen(int slot, ItemStack item) {
		    (Minecraft.getMinecraft()).thePlayer.sendQueue.addToSendQueue((Packet)new C10PacketCreativeInventoryAction(slot, addItemToOfen(item)));
		  }
		  
		  public static void addCommand(PingModAddon cmd) {
			  PingModAddonManager.addCommand(cmd);
		  }
	
}

