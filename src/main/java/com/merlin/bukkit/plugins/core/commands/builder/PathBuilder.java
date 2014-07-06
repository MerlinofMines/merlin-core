package com.merlin.bukkit.plugins.core.commands.builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.merlin.bukkit.plugins.core.commands.Command;
import com.merlin.bukkit.plugins.core.commands.pieces.CommandPiece;

public class PathBuilder {
	
	private Map<List<CommandPiece<?>>,Command> commandMap = null;
	
	public static Map<List<CommandPiece<?>>,Command> prefixWith(Map<List<CommandPiece<?>>,Command> currentMap, CommandPiece<?> piece) {
		Map<List<CommandPiece<?>>,Command> newMap = new HashMap<List<CommandPiece<?>>, Command>();
				
		for(List<CommandPiece<?>> pattern : currentMap.keySet()) {
			Command command = currentMap.get(pattern);
			pattern.add(0,piece);
			newMap.put(pattern, command);
		}
		return newMap;
	}

	public static void addPaths(Map<List<CommandPiece<?>>,Command> commandMap,PathBuilder... paths) {
		for(PathBuilder path : paths) {
			commandMap.putAll(path.commandMap);
		}
	}

	public PathBuilder(CommandPiece<?> piece, Command command, PathBuilder... currentPaths) {
		if(piece==null) throw new IllegalArgumentException("You can't create a path with a null command piece!");
		if(command==null) throw new IllegalArgumentException("You can't create a path with a null command!");
		commandMap = new HashMap<List<CommandPiece<?>>, Command>();
		if(currentPaths.length>0) {
			addPaths(commandMap,currentPaths);
		}
		List<CommandPiece<?>> pieces = new ArrayList<CommandPiece<?>>();
		commandMap.put(pieces,command);
		commandMap = prefixWith(commandMap,piece);
	}
	
	public PathBuilder(CommandPiece<?> piece, PathBuilder... currentPaths) {
		if(piece==null) throw new IllegalArgumentException("You can't create a path with a null command piece!");
		if(currentPaths.length==0) throw new IllegalArgumentException("You can't create a path that leads to nowhere!");
		commandMap = new HashMap<List<CommandPiece<?>>, Command>();
		addPaths(commandMap,currentPaths);
		commandMap = prefixWith(commandMap, piece);
	}
	
	public Map<List<CommandPiece<?>>, Command> getCommandMap() {
		return commandMap;
	}

	public void setCommandMap(Map<List<CommandPiece<?>>, Command> commandMap) {
		this.commandMap = commandMap;
	}
	
}
