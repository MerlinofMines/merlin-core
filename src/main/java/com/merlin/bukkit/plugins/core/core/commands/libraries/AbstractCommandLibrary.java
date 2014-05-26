package com.merlin.bukkit.plugins.core.core.commands.libraries;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.merlin.bukkit.plugins.core.commands.Command;
import com.merlin.bukkit.plugins.core.commands.CommandMetaData;
import com.merlin.bukkit.plugins.core.core.commands.pieces.CommandPiece;

public abstract class AbstractCommandLibrary implements CommandLibrary {

	protected Map<Command,CommandMetaData> commandMap = new HashMap<Command, CommandMetaData>();

	protected CommandMetaData defaultMetaData = null;
	
	protected AbstractCommandLibrary(CommandMetaData defaultCommandMetaData) {
		this.defaultMetaData = defaultCommandMetaData;
	}
	
	@Override
	public void addCommand(List<CommandPiece<?>> pattern, Command command)
			throws Exception {
		
		CommandMetaData metaData = defaultMetaData.clone();
		metaData.setCommandPattern(pattern);
		addCommand(metaData,command);
	}
	
	@Override
	public void addCommand(CommandMetaData metaData, Command command)
			throws Exception {
		commandMap.put(command, metaData);
	}

	@Override
	public void removeCommand(Command command) throws Exception {
		commandMap.remove(command);
	}

	public CommandMetaData getDefaultMetaData() {
		return defaultMetaData;
	}

	public void setDefaultMetaData(CommandMetaData defaultMetaData) {
		this.defaultMetaData = defaultMetaData;
	}

	

}