	package com.merlin.bukkit.plugins.core.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.java.JavaPlugin;

import com.merlin.bukkit.plugins.core.path.Path;
import com.merlin.bukkit.plugins.core.path.ConfigurationPath;
import com.merlin.bukkit.plugins.core.path.pieces.StaticPathPiece;

public class ConfigurationDisplayCommand extends PluginConfigurationCommand {

	protected Path title = null;
	protected String indent = " ";
	protected ChatColor labelColor = ChatColor.GREEN;
	protected String keyValueSeparator = ChatColor.WHITE+" - ";
	protected List<PropertyDisplay> properties = null;
	
	@Override
	public boolean execute(CommandSender sender) {
		try {
			StringBuilder builder = new StringBuilder();
			builder.append(title.getPath()).append("\n");
			for(PropertyDisplay key : properties) {
				builder.append(indent).append(labelColor).append(key.label).append(keyValueSeparator).append(key.propertyColor).append(configuration.get(key.property.getPath())).append("\n");
			}
			sender.sendMessage(builder.toString());
			return true;
		} catch(Exception e) {
			sender.getServer().getLogger().warning("Unable to execute command:" + e.getMessage());
			return false;
		}
	}
	
	public ConfigurationDisplayCommand(String title, JavaPlugin plugin) {
		this(new ConfigurationPath(new StaticPathPiece(title)) ,plugin);
	}
	
	public ConfigurationDisplayCommand(Path title, JavaPlugin plugin) {
		super(plugin);
		this.title = title;
		this.properties = new ArrayList<PropertyDisplay>();
	}
	
	public void addProperty(String label, ConfigurationPath property) {
		addProperty(label, property,ChatColor.WHITE);
	}
	
	public void addProperty(String label, ConfigurationPath property, ChatColor propertyColor) {
		properties.add(new PropertyDisplay(label, property, propertyColor));
	}
	
	public String getTitle() {
		return title.getPath();
	}

	public void setTitle(Path title) {
		this.title = title;
	}

	public Configuration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}
	
	private class PropertyDisplay {
		private String label;
		
		private Path property = null;
		private ChatColor propertyColor = null;
		
		public PropertyDisplay(String label,ConfigurationPath property,ChatColor propertyColor) {
			this.label = label;
			this.property = property;
			this.propertyColor = propertyColor;
		}
		
	}
}
