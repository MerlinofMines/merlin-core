package com.merlin.bukkit.plugins.core.commands.pieces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.bukkit.ChatColor;

public class AffirmationCommandPiece extends AbstractCommandPiece<Boolean> {
	
	Map<String,Boolean> affirmations;
	boolean value = false;
	
	public AffirmationCommandPiece() {
		affirmations = new TreeMap<String,Boolean>();
//		affirmations.put("yes",true);
//		affirmations.put("no",false);
//		affirmations.put("true",true);
//		affirmations.put("false",false);
//		affirmations.put("on", true);
//		affirmations.put("off",false);
		affirmations.put("enable", true);
//		affirmations.put("enabled", true);
		affirmations.put("disable",false);
//		affirmations.put("disabled",false);
//		affirmations.put("start",true);
//		affirmations.put("stop",false);
//		affirmations.put("begin",true);
//		affirmations.put("end",false);
		chatColor = ChatColor.YELLOW;
		rank = 5;
	}
	
	public AffirmationCommandPiece(Map<String,Boolean> affirmations) {
		if(affirmations.isEmpty()) {
			throw new ArrayIndexOutOfBoundsException("affirmations must not be empty");
		}
		affirmations = new HashMap<String,Boolean>();
		affirmations.putAll(affirmations);
		chatColor = ChatColor.YELLOW;
		rank = 5;
	}
	
	@Override
	public boolean matches(String input) {
		Boolean value = affirmations.get(input);
		if(value!=null) {
			this.value = value;
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public List<String> possibilites(String input) {
		List<String> possibilities = new ArrayList<String>();
		
		for(String affirmation : affirmations.keySet()) {
			if(affirmation.startsWith(input))possibilities.add(affirmation);
		}
		return possibilities;		
	}

	@Override
	public String getDisplay() {
		return chatColor+"(affirmative)";
	}

	@Override
	public Boolean getValue() {
		return value;
	}

	@Override
	public void setValue(Boolean value) {
		this.value = value;
	}

	@Override
	public void setValueFromString(String value) {
		this.value = affirmations.get(value);
	}
}
