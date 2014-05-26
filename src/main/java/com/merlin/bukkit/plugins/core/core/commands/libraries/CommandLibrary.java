package com.merlin.bukkit.plugins.core.core.commands.libraries;

import java.util.List;

import com.merlin.bukkit.plugins.core.commands.Command;
import com.merlin.bukkit.plugins.core.commands.CommandMetaData;
import com.merlin.bukkit.plugins.core.core.commands.libraries.possibilites.CommandPossibility;
import com.merlin.bukkit.plugins.core.core.commands.pieces.CommandPiece;

public interface CommandLibrary {
	
	public Command getCommand(List<String> commandPieces) throws Exception;	
	public List<CommandPossibility> getPossibleCommands(List<String> commandPieces) throws Exception;
	public void addCommand(List<CommandPiece<?>> pattern, Command command) throws Exception;
	public void addCommand(CommandMetaData metaData, Command command) throws Exception;
	public void removeCommand(Command command) throws Exception;
	public List<String> getCommandPieceSuggestions(String commandPieceStart,List<String> otherCommandPieces);
}
