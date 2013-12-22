package com.merlin.bukkit.plugins.merlin.core.commands.pieces;

import org.bukkit.ChatColor;

public abstract class AbstractCommandPiece<T> implements CommandPiece<T>{
	protected ChatColor chatColor =  ChatColor.WHITE;
	protected int rank = 1;
	
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
	
	
}
