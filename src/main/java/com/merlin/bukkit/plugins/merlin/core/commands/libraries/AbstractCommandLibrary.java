package com.merlin.bukkit.plugins.merlin.core.commands.libraries;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.merlin.bukkit.plugins.merlin.commands.Command;
import com.merlin.bukkit.plugins.merlin.core.commands.pieces.CommandPiece;

public abstract class AbstractCommandLibrary implements CommandLibrary {

	protected Map<Command,List<CommandPiece<?>>> commandMap = new HashMap<Command, List<CommandPiece<?>>>();
	
	@Override
	public void addCommand(List<CommandPiece<?>> pattern, Command command)
			throws Exception {
		commandMap.put(command, pattern);//TODO: DO some serious checking to see if a matching pattern already exists.
	}

	@Override
	public void removeCommand(Command command) throws Exception {
		commandMap.remove(command);
	}

}
