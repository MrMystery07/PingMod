package net.pingmod.utils;

public class CommandReload extends PingModAddon{

	public CommandReload(String name) {
		super(name);
	}

	@Override
	public void onTick() {
		
	}

	@Override
	public void onRightClick() {
		
	}

	@Override
	public void onCommand(String[] args) {
		PingModAddonManager.commands.clear();
		try {
			AddonLoader.loadAddons();
		} catch (Exception e) {
			e.printStackTrace();
		}
		PingModAddonManager.commands.add(new CommandReload("reload"));
		PingModAddon.msg("§eDeine installierten Addons wurden neugeladen!");
		
	}

	@Override
	public void onBlockRegister() {
		
	}
	
}
