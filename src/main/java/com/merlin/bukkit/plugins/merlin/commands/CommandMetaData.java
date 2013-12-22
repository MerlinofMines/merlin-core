package com.merlin.bukkit.plugins.merlin.commands;

import java.util.List;

import com.merlin.bukkit.plugins.merlin.core.commands.pieces.CommandPiece;

public class CommandMetaData {

	private List<CommandPiece<?>> commandPattern = null;

	public List<CommandPiece<?>> getCommandPattern() {
		return commandPattern;
	}

	public void setCommandPattern(List<CommandPiece<?>> commandPattern) {
		this.commandPattern = commandPattern;
	}
}
