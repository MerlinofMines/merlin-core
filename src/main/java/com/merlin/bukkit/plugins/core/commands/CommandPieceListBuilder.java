package com.merlin.bukkit.plugins.core.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.merlin.bukkit.plugins.core.commands.pieces.CommandPiece;

public class CommandPieceListBuilder {

	private List<CommandPiece<?>> pieces;	
	public CommandPieceListBuilder integer(CommandPiece<Integer> integerHook) {
		pieces.add(integerHook);
		return this;
	}
	
	public <T> CommandPieceListBuilder add(CommandPiece<T> commandPiece) {
		pieces.add(commandPiece);
		return this;
	}
	
	private CommandPieceListBuilder() {
		pieces = new ArrayList<CommandPiece<?>>();
	}
	
	public static CommandPieceListBuilder build() {
		return new CommandPieceListBuilder();
	}

	public List<CommandPiece<?>> getPieces() {
		return pieces;
	}
	
	public static List<CommandPiece<?>> build(CommandPiece<?>... commandPieces) {
		return Arrays.asList(commandPieces);
	}
	
}
