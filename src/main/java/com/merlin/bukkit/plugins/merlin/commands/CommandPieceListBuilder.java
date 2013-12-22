package com.merlin.bukkit.plugins.merlin.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.merlin.bukkit.plugins.merlin.core.commands.pieces.AffirmationCommandPiece;
import com.merlin.bukkit.plugins.merlin.core.commands.pieces.CommandPiece;
import com.merlin.bukkit.plugins.merlin.core.commands.pieces.LabelCommandPiece;
import com.merlin.bukkit.plugins.merlin.core.commands.pieces.StringCommandPiece;

public class CommandPieceListBuilder {

	private List<CommandPiece<?>> pieces;	
	public CommandPieceListBuilder integer(CommandPiece<Integer> integerHook) {
		pieces.add(integerHook);
		return this;
	}
	
	public CommandPieceListBuilder label(String... labels) {
		pieces.add(new LabelCommandPiece(Arrays.asList(labels)));
		return this;
	}
	
	public CommandPieceListBuilder label(List<String> labels) {
		pieces.add(new LabelCommandPiece(labels));
		return this;
	}

	public CommandPieceListBuilder string(StringCommandPiece stringHook) {
		pieces.add(stringHook);
		return this;
	}
	
	public CommandPieceListBuilder affirmation(AffirmationCommandPiece affirmationHook) {
		pieces.add(affirmationHook);
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
}
