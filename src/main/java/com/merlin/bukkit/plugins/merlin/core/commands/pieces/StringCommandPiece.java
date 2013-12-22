
package com.merlin.bukkit.plugins.merlin.core.commands.pieces;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;

public class StringCommandPiece extends AbstractCommandPiece<String> {

	private String string = null;
	
	public StringCommandPiece() {
		this.chatColor = ChatColor.WHITE;
		this.rank = 1;
}
	
	@Override
	public boolean matches(String input) {
		return true;
	}

	@Override
	public String getDisplay() {
		return ChatColor.WHITE+string;
	}

	@Override
	public String getValue() {
		return string;
	}

	@Override
	public void setValue(String value) {
		this.string = value;
	}

	@Override
	public void setValueFromString(String value) {
		this.string = value;
	}

	@Override
	public List<String> possibilites(String input) {
		List<String> list = new ArrayList<String>();
		if(input == null || input.length()==0) {
			list.add("<string>");
			list.add("");
		}
		return list;
	}
}	
