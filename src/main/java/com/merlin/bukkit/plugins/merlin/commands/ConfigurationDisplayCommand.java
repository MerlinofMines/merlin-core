package com.merlin.bukkit.plugins.merlin.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.java.JavaPlugin;

public class ConfigurationDisplayCommand extends PluginConfigurationCommand {

	protected String title = null;
	protected String indent = " ";
	protected ChatColor labelColor = ChatColor.GREEN;
	protected String keyValueSeparator = ChatColor.WHITE+" - ";
	protected List<PropertyDisplay> properties = null;
	
	@Override
	public boolean execute(CommandSender sender) {
		try {
			StringBuilder builder = new StringBuilder();
			builder.append(title).append("\n");
			for(PropertyDisplay key : properties) {
				builder.append(indent).append(labelColor).append(key.label).append(keyValueSeparator).append(key.propertyColor).append(configuration.get(key.property)).append("\n");
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
		this.properties = new ArrayList<PropertyDisplay>();
	}
	
	public ConfigurationDisplayCommand(JavaPlugin plugin, String title) {
		super(plugin);
		this.title = title;
		this.properties = new ArrayList<PropertyDisplay>();
	}

	public void addProperty(String label, String property) {
		addProperty(label, property,ChatColor.WHITE);
	}
	
	public void addProperty(String label, String property, ChatColor propertyColor) {
		properties.add(new PropertyDisplay(label, property, propertyColor));
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
	
	private class PropertyDisplay {
		private String label,property = null;
		private ChatColor propertyColor = null;
		
		public PropertyDisplay(String label,String property,ChatColor propertyColor) {
			this.label = label;
			this.property = property;
			this.propertyColor = propertyColor;
		}
		
	}
}
