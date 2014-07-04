package com.merlin.bukkit.plugins.core.commands.hooks;

public interface Hook<T> {
	
	public T getValue();
	public void setValue(T value);
	public String getValueAsString();
	public Hook<T> deepClone();
}
