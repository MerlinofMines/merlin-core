package com.merlin.bukkit.plugins.core.commands;

import org.bukkit.plugin.java.JavaPlugin;

public abstract class PluginCommand extends Command {

	protected JavaPlugin plugin;

	public JavaPlugin getPlugin() {
		return plugin;
	}

	public void setPlugin(JavaPlugin plugin) {
		this.plugin = plugin;
	}

	public PluginCommand(JavaPlugin plugin) {
		super();
		this.plugin = plugin;
	}
}
