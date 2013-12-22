package com.merlin.bukkit.plugins.merlin.core.commands.libraries;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.merlin.bukkit.plugins.merlin.commands.Command;
import com.merlin.bukkit.plugins.merlin.commands.CommandMetaData;
import com.merlin.bukkit.plugins.merlin.core.commands.pieces.CommandPiece;

public abstract class AbstractCommandLibrary implements CommandLibrary {

	protected Map<Command,CommandMetaData> commandMap = new HashMap<Command, CommandMetaData>();
	
	@Override
	public void addCommand(List<CommandPiece<?>> pattern, Command command)
			throws Exception {
		
		CommandMetaData metaData = new CommandMetaData();
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
}
