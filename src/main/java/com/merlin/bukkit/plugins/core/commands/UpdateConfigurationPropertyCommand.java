package com.merlin.bukkit.plugins.core.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.java.JavaPlugin;

import com.merlin.bukkit.plugins.core.commands.pieces.CommandPiece;

public class UpdateConfigurationPropertyCommand<T extends CommandPiece<?>> extends PluginConfigurationCommand {

	protected T commandPiece;
	protected String propertyPath;
	
	@Override
	public boolean execute(CommandSender sender) {
		configuration.set(propertyPath,commandPiece.getValue());
		plugin.saveConfig();
		return true;
	}

	public UpdateConfigurationPropertyCommand(Configuration configuration,
			JavaPlugin plugin, T commandPiece, String propertyPath) {
		super(plugin,configuration);
		this.commandPiece = commandPiece;
		this.propertyPath = propertyPath;
	}

	public UpdateConfigurationPropertyCommand(JavaPlugin plugin,
			T commandPiece, String propertyPath) {
		super(plugin);
		this.commandPiece = commandPiece;
		this.propertyPath = propertyPath;
	}

	public T getCommandPiece() {
		return commandPiece;
	}

	public void setCommandPiece(T commandPiece) {
		this.commandPiece = commandPiece;
	}

	public String getPropertyPath() {
		return propertyPath;
	}

	public void setPropertyPath(String propertyPath) {
		this.propertyPath = propertyPath;
	}
}
