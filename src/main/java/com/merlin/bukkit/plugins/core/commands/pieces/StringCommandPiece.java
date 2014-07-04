
package com.merlin.bukkit.plugins.core.commands.pieces;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import com.merlin.bukkit.plugins.core.collections.factory.StaticCollectionFactory;
import com.merlin.bukkit.plugins.core.commands.hooks.StringHook;

public class StringCommandPiece extends CollectionCommandPiece<String> {

	public StringCommandPiece() {
		super(ChatColor.WHITE,1,new StringHook(),new StaticCollectionFactory<String>());
	}
	
	@Override
	public boolean matches(String input,CommandSender sender) {
		return input!=null && !input.isEmpty();
	}

	@Override
	public String getDisplay() {
		return ChatColor.WHITE+"<string>";
	}

	@Override
	public List<String> possibilities(String input,CommandSender sender) {
		List<String> list = new ArrayList<String>();
		if(getOptions().isEmpty()) {
			list.add("");
			return list;
		}
		for(String option : getOptions()) {
			if(option.toLowerCase().startsWith(input.toLowerCase())) {
				list.add(option);
			}
		}
		return list;
	}

	@Override
	public void setValueFromString(String input, CommandSender sender) {
		if(input!=null && !input.isEmpty()) {
			hook.setValue(input);
		} else {
			throw new IllegalArgumentException("input must be a valid String");
		}

	}

	@Override
	protected String getString(String value) {
		return value;
	}
}	
