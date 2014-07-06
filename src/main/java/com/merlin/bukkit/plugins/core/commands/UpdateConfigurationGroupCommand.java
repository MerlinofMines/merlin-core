package com.merlin.bukkit.plugins.core.commands;

import java.util.Map;
import java.util.Set;

import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import com.merlin.bukkit.plugins.core.collections.GroupAction;
import com.merlin.bukkit.plugins.core.commands.hooks.Hook;
import com.merlin.bukkit.plugins.core.commands.hooks.Persistable;
import com.merlin.bukkit.plugins.core.path.ConfigurationPath;

public class UpdateConfigurationGroupCommand extends PluginConfigurationCommand {

	protected ConfigurationPath propertyPath;
	protected Hook<GroupAction> groupHook;
	protected Persistable persistable;
	protected Map<?,?> defaults = null;
	
	
	@Override
	public boolean execute(CommandSender sender) {

		Set<String> keys = getConfiguration().getConfigurationSection(propertyPath.getPath()).getKeys(false);

		if(groupHook.getValue().equals(GroupAction.ADD)) {
			if(keys.contains(persistable.getPersistableRepresentation().toString())) {
				sender.sendMessage("This value is already present in the list.");
				return false;
			} else {
				if(defaults!=null) {
					getConfiguration().getConfigurationSection(propertyPath.getPath()).createSection(persistable.getPersistableRepresentation().toString(),defaults);
				} else {
					getConfiguration().getConfigurationSection(propertyPath.getPath()).createSection(persistable.getPersistableRepresentation().toString());
				}
			}
		} else if(groupHook.getValue().equals(GroupAction.REMOVE)){
			if(!keys.contains(persistable.getPersistableRepresentation().toString())) {
				sender.sendMessage("This value does not exist in the list");
				return false;
			} else {
				getConfiguration().getConfigurationSection(propertyPath.getPath()).set(persistable.getPersistableRepresentation().toString(),null);
			}
		}//Currently no other actions
		
		plugin.saveConfig();
		return true;
	}

	public UpdateConfigurationGroupCommand(JavaPlugin plugin,
			ConfigurationPath propertyPath, Hook<GroupAction> groupHook, Persistable persistable,
			Map<?, ?> defaults) {
		super(plugin);
		this.propertyPath = propertyPath;
		this.groupHook = groupHook;
		this.persistable = persistable;
		this.defaults = defaults;
	}

	public Hook<GroupAction> getGroupHook() {
		return groupHook;
	}

	public void setGroupHook(Hook<GroupAction> groupHook) {
		this.groupHook = groupHook;
	}
	
	
}
