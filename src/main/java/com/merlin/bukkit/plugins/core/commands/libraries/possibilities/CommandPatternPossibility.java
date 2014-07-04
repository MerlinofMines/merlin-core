package com.merlin.bukkit.plugins.core.commands.libraries.possibilities;

import java.util.HashMap;

import com.merlin.bukkit.plugins.core.commands.pieces.CommandPiece;

public class CommandPatternPossibility extends HashMap<CommandPiece<?>,String> implements Comparable<CommandPatternPossibility>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private Integer getIndex() {
		int index = 0;
		for(CommandPiece<?> piece : keySet()) {
			index+=piece.getRank();
		}
		return index;
	}
	
	@Override
	public int compareTo(CommandPatternPossibility o) {

		int comparison = -1*(new Integer(this.size()).compareTo(new Integer(o.size())));

		if(comparison == 0) {
			return -1*(getIndex().compareTo(o.getIndex()));
		} else {
			return comparison;
		}
	}
}
