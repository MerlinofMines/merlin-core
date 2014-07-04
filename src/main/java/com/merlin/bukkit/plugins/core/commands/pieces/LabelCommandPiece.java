package com.merlin.bukkit.plugins.core.commands.pieces;

import java.util.Arrays;
import java.util.List;

import org.bukkit.ChatColor;

import com.merlin.bukkit.plugins.core.collections.factory.StaticCollectionFactory;
import com.merlin.bukkit.plugins.core.commands.hooks.StringHook;

public class LabelCommandPiece extends CollectionCommandPiece<String> {

	public LabelCommandPiece(String... labels) {
		this(Arrays.asList(labels));
	}
	
	public LabelCommandPiece(List<String> labels) {
		super(ChatColor.GREEN,10,new StringHook(),new StaticCollectionFactory<String>(labels));
		if(labels==null || labels.isEmpty()) {
			throw new NullPointerException("Labels cannot be empty");
		}
		hook.setValue(labels.get(0));
	}
	
	@Override
	public String getDisplay() {
		return chatColor+getHook().getValue();
	}

	@Override
	protected String getString(String value) {
		return value;
	}

	public static LabelCommandPiece label(String... labels) {
		return new LabelCommandPiece(labels);
	}
	
	public static LabelCommandPiece label(List<String> labels) {
		return new LabelCommandPiece(labels);
	}


}
