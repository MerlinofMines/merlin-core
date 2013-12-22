package com.merlin.bukkit.plugins.merlin.commands;

import java.util.List;

import com.merlin.bukkit.plugins.merlin.core.commands.pieces.CommandPiece;

public class CommandMetaData {

	private List<CommandPiece<?>> commandPattern = null;
	private boolean reorder = false;

	public CommandMetaData() {
		super();
	}

	public CommandMetaData(List<CommandPiece<?>> commandPattern, boolean reorder) {
		super();
		this.commandPattern = commandPattern;
		this.reorder = reorder;
	}

	public List<CommandPiece<?>> getCommandPattern() {
		return commandPattern;
	}

	public void setCommandPattern(List<CommandPiece<?>> commandPattern) {
		this.commandPattern = commandPattern;
	}

	public boolean getReorder() {
		return reorder;
	}

	public void setReorder(boolean reorder) {
		this.reorder = reorder;
	}
	
	
}
