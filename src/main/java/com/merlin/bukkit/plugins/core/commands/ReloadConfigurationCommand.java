package com.merlin.bukkit.plugins.core.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class ReloadConfigurationCommand extends PluginConfigurationCommand {

	
	public ReloadConfigurationCommand(JavaPlugin plugin) {
		super(plugin);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(CommandSender sender) {
		try {
			this.plugin.reloadConfig();
			return true;
		} catch(Exception e) {
			sender.getServer().getLogger().warning("Command did not execute successfully: " + e.getMessage());
			return false;
		}
	}

}
