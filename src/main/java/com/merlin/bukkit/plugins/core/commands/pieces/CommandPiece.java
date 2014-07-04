package com.merlin.bukkit.plugins.core.commands.pieces;

import java.util.List;

import org.bukkit.command.CommandSender;

import com.merlin.bukkit.plugins.core.commands.hooks.Hook;

public interface CommandPiece<T> {
	public boolean matches(String input,CommandSender sender);
	public List<String> possibilities(String input,CommandSender sender);
	public void setValueFromString(String input,CommandSender sender);
	public String getDisplay();
	public int getRank();
	public void setRank(int rank);
	public Hook<T> getHook();
	public void setHook(Hook<T> hook);
}
