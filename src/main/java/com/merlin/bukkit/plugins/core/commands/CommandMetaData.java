package com.merlin.bukkit.plugins.core.commands;

import java.util.List;

import com.merlin.bukkit.plugins.core.commands.pieces.CommandPiece;

public class CommandMetaData implements Cloneable {

	private List<CommandPiece<?>> commandPattern = null;
	private boolean reorder = false;

	public CommandMetaData(List<CommandPiece<?>> commandPattern, boolean reorder) {
		super();
		this.commandPattern = commandPattern;
		this.reorder = reorder;
	}

	public CommandMetaData( boolean reorder) {
		super();
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
	
	@Override
	public CommandMetaData clone() throws CloneNotSupportedException {
		return new CommandMetaData(getReorder());
	}
	
	
}
