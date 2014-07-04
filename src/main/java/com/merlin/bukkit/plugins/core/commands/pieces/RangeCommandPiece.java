package com.merlin.bukkit.plugins.core.commands.pieces;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import com.merlin.bukkit.plugins.core.commands.hooks.Hook;

public abstract class RangeCommandPiece<T> extends AbstractCommandPiece<T>{

	private T lowerValue,upperValue,increment;
	
	public RangeCommandPiece(ChatColor chatColor, int rank, Hook<T> hook) {
		super(chatColor, rank, hook);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean matches(String input, CommandSender sender) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<String> possibilities(String input, CommandSender sender) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setValueFromString(String input, CommandSender sender) {
		// TODO Auto-generated method stub
		
	}
}

