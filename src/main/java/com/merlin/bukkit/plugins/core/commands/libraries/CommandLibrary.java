package com.merlin.bukkit.plugins.core.commands.libraries;

import java.util.List;

import org.bukkit.command.CommandSender;

import com.merlin.bukkit.plugins.core.commands.Command;
import com.merlin.bukkit.plugins.core.commands.CommandMetaData;
import com.merlin.bukkit.plugins.core.commands.libraries.possibilities.CommandPossibility;
import com.merlin.bukkit.plugins.core.commands.pieces.CommandPiece;

public interface CommandLibrary {
	
	public Command getCommand(List<String> commandPieces,CommandSender sender) throws Exception;	
	public List<CommandPossibility> getPossibleCommands(List<String> commandPieces,CommandSender sender) throws Exception;
	public void addCommand(List<CommandPiece<?>> pattern, Command command);
	public void addCommand(CommandMetaData metaData, Command command);
	public void removeCommand(Command command);
	public List<String> getCommandPieceSuggestions(String commandPieceStart,List<String> otherCommandPieces,CommandSender sender);
	public List<CommandPiece<?>> getCommandPattern(Command command);
}
