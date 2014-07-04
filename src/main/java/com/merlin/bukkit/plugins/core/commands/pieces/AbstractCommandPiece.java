package com.merlin.bukkit.plugins.core.commands.pieces;

import org.bukkit.ChatColor;

import com.merlin.bukkit.plugins.core.commands.hooks.Hook;

public abstract class AbstractCommandPiece<T> implements CommandPiece<T>{

	protected ChatColor chatColor =  ChatColor.WHITE;
	protected int rank = 1;
	protected Hook<T> hook;

	public AbstractCommandPiece(ChatColor chatColor,int rank, Hook<T> hook) {
		super();
		this.chatColor = chatColor;
		this.rank = rank;
		this.hook = hook;

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

}
