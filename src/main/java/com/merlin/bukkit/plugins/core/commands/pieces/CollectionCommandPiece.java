package com.merlin.bukkit.plugins.core.commands.pieces;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import com.merlin.bukkit.plugins.core.collections.factory.CollectionFactory;
import com.merlin.bukkit.plugins.core.commands.hooks.Hook;

public abstract class CollectionCommandPiece<T> extends AbstractCommandPiece<T>{
	protected CollectionFactory<T> optionFactory;
	
	public CollectionCommandPiece(ChatColor chatColor, int rank, Hook<T> hook,
			CollectionFactory<T> optionFactory) {
		super(chatColor,rank,hook);
		this.optionFactory = optionFactory;
	}

	public CollectionFactory<T> getOptionFactory() {
		return optionFactory;
	}

	protected void setOptionFactory(CollectionFactory<T> optionFactory) {
		this.optionFactory = optionFactory;
	}
	
	protected List<T> getOptions() {
		return optionFactory.getCollection();
	}
	
	protected abstract String getString(T value);
	
	@Override
	public boolean matches(String input,CommandSender sender) {
		for(T t : getOptions()) {
			if(getString(t).toLowerCase().equals(input.toLowerCase())) {
				return true;
			}
		}
		return false;

	}
	
	@Override
	public List<String> possibilities(String input,CommandSender sender) {
		
		List<String> possibilities = new ArrayList<String>();

		for(T t : getOptions()) {
			if(getString(t).toLowerCase().startsWith(input.toLowerCase())) {
				possibilities.add(getString(t));
			}
		}
		return possibilities;
	}
	
	@Override
	public void setValueFromString(String input, CommandSender sender) {
		for(T t : getOptions()) {
			if(getString(t).toLowerCase().startsWith(input.toLowerCase())) {
				hook.setValue(t);
				return;
			}
		}
		throw new IllegalArgumentException(input + " is not an acceptable value for this command piece");
	}


}
