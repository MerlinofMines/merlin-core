package com.merlin.bukkit.plugins.core.commands.libraries.possibilites;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.merlin.bukkit.plugins.core.commands.Command;
import com.merlin.bukkit.plugins.core.commands.CommandMetaData;
import com.merlin.bukkit.plugins.core.commands.libraries.CommandLibraryUtil;
import com.merlin.bukkit.plugins.core.commands.pieces.CommandPiece;

public class CommandPossibility implements Comparable<CommandPossibility> {
	
	private Command command;
	private CommandMetaData metaData;
	private List<CommandPiece<?>> commandPattern;
	
	private List<CommandPatternPossibility> bestPatternMatches;
	private int piecesSize;

	public Command getCommand() {
		return command;
	}

	public void setCommand(Command command) {
		this.command = command;
	}

	public List<CommandPiece<?>> getCommandPattern() {
		return commandPattern;
	}

	public void setCommandPattern(List<CommandPiece<?>> commandPattern) {
		this.commandPattern = commandPattern;
	}

	public List<CommandPatternPossibility> getBestPatternMatches() {
		return new ArrayList<CommandPatternPossibility>(bestPatternMatches);
	}

	public void setBestPatternMatches(List<CommandPatternPossibility> bestPatternMatches) {
		this.bestPatternMatches = bestPatternMatches;
		Collections.sort(this.bestPatternMatches);
	}
	
	public double getBestCommandMatchPercentage() {
		if(bestPatternMatches.isEmpty())return 0.0;
		return CommandLibraryUtil.getPatternMatchPercentage(commandPattern,piecesSize,bestPatternMatches.get(0).size());
	}
	
	public CommandPatternPossibility getBestCommandMatch() {
		if(bestPatternMatches.isEmpty())return null;
		else return bestPatternMatches.get(0);
	}

	@Override
	public int compareTo(CommandPossibility o) {
		return -1*(new Double(getBestCommandMatchPercentage()).compareTo(o.getBestCommandMatchPercentage()));
	}

	public int getPiecesSize() {
		return piecesSize;
	}

	public void setPiecesSize(int piecesSize) {
		this.piecesSize = piecesSize;
	}

	public CommandMetaData getMetaData() {
		return metaData;
	}

	public void setMetaData(CommandMetaData metaData) {
		this.metaData = metaData;
	}
	
}

