package com.merlin.bukkit.plugins.merlin.commands;

import java.util.Map;
import java.util.TreeMap;

import org.bukkit.command.CommandSender;
import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.java.JavaPlugin;

public class ConfigurationDisplayCommand extends PluginConfigurationCommand {

	protected String title = null;
	protected Map<String,String> propertyDisplayMap = null;
	
	@Override
	public boolean execute(CommandSender sender) {
		try {
			StringBuilder builder = new StringBuilder();
			builder.append(title).append("\n");
			for(String key : propertyDisplayMap.keySet()) {
				builder.append(" ").append(key).append(": ").append(configuration.get(propertyDisplayMap.get(key))).append("\n");
			}
			sender.sendMessage(builder.toString());
			return true;
		} catch(Exception e) {
			sender.getServer().getLogger().warning("Unable to execute command:" + e.getMessage());
			return false;
		}
	}
	
	public ConfigurationDisplayCommand(String title, JavaPlugin plugin, Configuration config) {
		super(plugin,config);
		this.title = title;
		this.propertyDisplayMap = new TreeMap<String,String>();
	}

	public ConfigurationDisplayCommand(String title, JavaPlugin plugin, Configuration config, Map<String,String> propertyDisplayMap) {
		super(plugin,config);
		this.title = title;
		this.propertyDisplayMap = propertyDisplayMap;
	}
	
	public ConfigurationDisplayCommand(JavaPlugin plugin, String title) {
		super(plugin);
		this.title = title;
		this.propertyDisplayMap = new TreeMap<String,String>();
	}

	public ConfigurationDisplayCommand(String title, JavaPlugin plugin, Map<String,String> propertyDisplayMap) {
		super(plugin);
		this.title = title;
		this.propertyDisplayMap = propertyDisplayMap;
	}

	public Map<String, String> getPropertyDisplayMap() {
		return propertyDisplayMap;
	}

	public void setPropertyDisplayMap(Map<String, String> propertyDisplayMap) {
		this.propertyDisplayMap = propertyDisplayMap;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Configuration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}
}
