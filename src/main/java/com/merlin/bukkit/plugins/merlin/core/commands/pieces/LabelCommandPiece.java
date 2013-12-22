package com.merlin.bukkit.plugins.merlin.core.commands.pieces;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;

public class LabelCommandPiece extends AbstractCommandPiece<String> {

	private List<String> labels = null;
	private String currentLabel = null;

	public LabelCommandPiece(String label) {
		if(label==null) {
			throw new NullPointerException("Label cannot be null");
		}
		this.labels = new ArrayList<String>();
		labels.add(label);
		this.currentLabel = label;
		this.chatColor = ChatColor.GREEN;
		this.rank = 10;
	}
	
	public LabelCommandPiece(List<String> labels) {
		if(labels==null || labels.isEmpty()) {
			throw new NullPointerException("Label cannot be null");
		}
		this.labels = new ArrayList<String>(labels);
		this.currentLabel = labels.get(0);
		this.chatColor = ChatColor.GREEN;
		this.rank = 10;
	}
	
	@Override
	public boolean matches(String input) {

		for(String label : labels) {
			if(label.toLowerCase().equals(input.toLowerCase())) {
				this.currentLabel = input;
				return true;
			}
		}
		return false;
	}

	@Override
	public String getDisplay() {
		return chatColor+currentLabel;
	}


	@Override
	public String getValue() {
		return currentLabel;
	}

	@Override
	public void setValue(String value) {
		if(!this.labels.contains(value)) {
			labels.add(value);
		}
		currentLabel = value;
	}

	@Override
	public void setValueFromString(String value) {
		setValue(value);
	}

	@Override
	public List<String> possibilites(String input) {
		List<String> possibilities = new ArrayList<String>();
		
		for(String label : labels) {
			if(label.startsWith(input)) {
				possibilities.add(label);
			}
		}
		return possibilities;
	}
	
	
}
