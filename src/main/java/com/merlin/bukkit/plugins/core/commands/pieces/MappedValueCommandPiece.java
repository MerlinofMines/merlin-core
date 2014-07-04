package com.merlin.bukkit.plugins.core.commands.pieces;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import com.merlin.bukkit.plugins.core.collections.factory.CollectionFactory;
import com.merlin.bukkit.plugins.core.commands.hooks.Hook;

public abstract class MappedValueCommandPiece<T> implements CommandPiece<T>{

	private Map<String,T> valueMap = null;

	protected ChatColor chatColor =  ChatColor.WHITE;
	protected int rank = 1;
	protected Hook<T> hook;
	protected CollectionFactory<String> optionFactory;
	
	public MappedValueCommandPiece(Map<String,T> valueMap, ChatColor chatColor, int rank, Hook<T> hook,
			CollectionFactory<String> optionFactory) {
		super();
		this.valueMap = valueMap;
		this.chatColor = chatColor;
		this.rank = rank;
		this.hook = hook;
		this.optionFactory = optionFactory;
	}

	public Hook<T> getHook() {
		return hook;
	}

	public void setHook(Hook<T> hook) {
		this.hook = hook;
	}

	public ChatColor getChatColor() {
		return chatColor;
	}

	public void setChatColor(ChatColor chatColor) {
		this.chatColor = chatColor;
	}

	@Override
	public int getRank() {
		return rank;
	}

	@Override
	public void setRank(int rank) {
		this.rank = rank;
	}

	public CollectionFactory<String> getOptionFactory() {
		return optionFactory;
	}

	protected void setOptionFactory(CollectionFactory<String> optionFactory) {
		this.optionFactory = optionFactory;
	}
	
	protected List<String> getOptions() {
		return optionFactory.getCollection();
	}
	
	@Override
	public boolean matches(String input, CommandSender sender) {
		for(String key : getOptions()) {
			if(key.toLowerCase().equals(input.toLowerCase()))return true;
		}
		return false;
	}

	@Override
	public List<String> possibilities(String input, CommandSender sender) {
		List<String> possibilities = new ArrayList<String>();
		for(String key : getOptions()) {
			if(key.toLowerCase().startsWith(input.toLowerCase()))possibilities.add(key);
		}
		return possibilities;
	}

	@Override
	public void setValueFromString(String input, CommandSender sender) throws IllegalArgumentException {
		for(String key : getOptions()) {
			if(key.toLowerCase().equals(input.toLowerCase())) {
				getHook().setValue(valueMap.get(key));
				return;
			}
		}
		throw new IllegalArgumentException("Unable to find a matching value for input: " + input);
		
	}
	
	public Map<String, T> getValueMap() {
		return valueMap;
	}

	public void setValueMap(Map<String, T> valueMap) {
		this.valueMap = valueMap;
	}
}
