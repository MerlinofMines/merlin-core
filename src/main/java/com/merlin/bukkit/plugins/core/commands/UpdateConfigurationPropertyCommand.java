package com.merlin.bukkit.plugins.core.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import com.merlin.bukkit.plugins.core.commands.hooks.PersistableHook;
import com.merlin.bukkit.plugins.core.path.Path;

public class UpdateConfigurationPropertyCommand<T> extends PluginConfigurationCommand {

	protected PersistableHook<T> hook;
	protected Path propertyPath;
	
	@Override
	public boolean execute(CommandSender sender) {
		configuration.set(propertyPath.getPath(),hook.getPersistableRepresentation());
		plugin.saveConfig();
		return true;
	}

	public UpdateConfigurationPropertyCommand(JavaPlugin plugin, Path propertyPath, PersistableHook<T> hook) {
		super(plugin);
		this.propertyPath = propertyPath;
		this.hook = hook;
	}

	public PersistableHook<T> getHook() {
		return hook;
	}

	public void setHook(PersistableHook<T> hook) {
		this.hook = hook;
	}

	public Path getPropertyPath() {
		return propertyPath;
	}

	public void setPropertyPath(Path propertyPath) {
		this.propertyPath = propertyPath;
	}

}
