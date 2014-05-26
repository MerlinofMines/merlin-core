package com.merlin.bukkit.plugins.core.core.commands.pieces;

import java.util.List;

public interface CommandPiece<T> {
	public boolean matches(String input);
	public List<String> possibilites(String input);
	public String getDisplay();
	public T getValue();
	public void setValue(T value);
	public void setValueFromString(String value) throws IllegalArgumentException;
	public int getRank();
	public void setRank(int rank);
}
