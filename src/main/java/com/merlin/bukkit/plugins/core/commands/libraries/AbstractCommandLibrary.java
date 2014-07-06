package com.merlin.bukkit.plugins.core.commands.libraries;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;

import com.merlin.bukkit.plugins.core.commands.Command;
import com.merlin.bukkit.plugins.core.commands.CommandMetaData;
import com.merlin.bukkit.plugins.core.commands.pieces.CommandPiece;

public abstract class AbstractCommandLibrary implements CommandLibrary {

	protected Map<Command,CommandMetaData> commandMap = new HashMap<Command, CommandMetaData>();

	protected CommandMetaData defaultMetaData = null;
	
	protected AbstractCommandLibrary(CommandMetaData defaultCommandMetaData) {
		this.defaultMetaData = defaultCommandMetaData;
	}
	
	@Override
	public void addCommand(List<CommandPiece<?>> pattern, Command command) {
		
		CommandMetaData metaData;
		try {
			metaData = defaultMetaData.clone();
			metaData.setCommandPattern(pattern);
			addCommand(metaData,command);
		} catch (CloneNotSupportedException e) {
			Bukkit.getServer().getLogger().warning("Error adding command to libary: " + e.getMessage());
		}
	}
	
	@Override
	public void addCommand(CommandMetaData metaData, Command command) {
		commandMap.put(command, metaData);
	}

	@Override
	public void removeCommand(Command command) {
		commandMap.remove(command);
	}

	public CommandMetaData getDefaultMetaData() {
		return defaultMetaData;
	}

	public void setDefaultMetaData(CommandMetaData defaultMetaData) {
		this.defaultMetaData = defaultMetaData;
	}

	@Override
	public List<CommandPiece<?>> getCommandPattern(Command command) {
		CommandMetaData data = commandMap.get(command);
		if(data==null)return null;
		return commandMap.get(command).getCommandPattern();
	}

}
