package com.merlin.bukkit.plugins.core.core.commands.pieces;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;

public class IntegerAmountCommandPiece extends AbstractCommandPiece<Integer> {
	
	private int value = 0;
	
	public IntegerAmountCommandPiece() {
		chatColor = ChatColor.BLUE;
		rank = 5;
}
	
	@Override
	public boolean matches(String input) {
		try {
			value = Integer.parseInt(input);
			return true;
		} catch(NumberFormatException nfe) {
			return false;
		}
	}
	
	@Override
	public List<String> possibilites(String input) {
		List<String> list = new ArrayList<String>();
		if(input == null || input.length()==0) {
			list.add("");
		}
		return list;
	}

	@Override
	public String getDisplay() {
		return chatColor+"<int>";
	}

	
	@Override
	public Integer getValue() {
		return value;
	}

	@Override
	public void setValue(Integer value) {
		this.value = value;
	}

	@Override
	public void setValueFromString(String value) {
		setValue(Integer.parseInt(value));
	}

	
}
