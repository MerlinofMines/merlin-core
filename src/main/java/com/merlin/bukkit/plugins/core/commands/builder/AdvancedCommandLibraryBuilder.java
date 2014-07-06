package com.merlin.bukkit.plugins.core.commands.builder;

import java.util.List;
import java.util.Map;

import com.merlin.bukkit.plugins.core.commands.Command;
import com.merlin.bukkit.plugins.core.commands.libraries.CommandLibrary;
import com.merlin.bukkit.plugins.core.commands.pieces.CommandPiece;

public class AdvancedCommandLibraryBuilder {

	public static PathBuilder buildPath(CommandPiece<?> piece, Command command, PathBuilder... subPaths) {
		return new PathBuilder(piece,command,subPaths);
	}

	public static PathBuilder buildPath(CommandPiece<?> piece, PathBuilder... subPaths) {
		return new PathBuilder(piece,subPaths);
	}

	public static void buildLibrary(CommandLibrary library,PathBuilder path) {
		if(path==null||path.getCommandMap()==null||path.getCommandMap().isEmpty()) {
			throw new IllegalArgumentException("You can't create a library without any entries!");
		}

		Map<List<CommandPiece<?>>,Command> commandMap = path.getCommandMap();
		for(List<CommandPiece<?>> pattern : commandMap.keySet()) {
			Command command = commandMap.get(pattern);
			library.addCommand(pattern, command);
		}
		
	}
}
