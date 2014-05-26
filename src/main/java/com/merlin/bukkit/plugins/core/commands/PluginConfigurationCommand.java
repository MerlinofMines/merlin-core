package com.merlin.bukkit.plugins.core.commands;

import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class PluginConfigurationCommand extends PluginCommand {

	protected Configuration configuration;
	
	public PluginConfigurationCommand(JavaPlugin plugin,
			Configuration configuration) {
		super(plugin);
		this.configuration = configuration;
	}

	public Configuration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}

	public PluginConfigurationCommand(JavaPlugin plugin) {
		super(plugin);
		this.configuration = plugin.getConfig();
	}
}
