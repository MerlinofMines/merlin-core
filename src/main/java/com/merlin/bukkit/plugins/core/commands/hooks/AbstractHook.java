package com.merlin.bukkit.plugins.core.commands.hooks;

public abstract class AbstractHook<T> implements Hook<T> {
	private T hook = null;

	@Override
	public T getValue() {
		return this.hook;
	}

	@Override
	public void setValue(T value) {
		this.hook = value;
	}
	
}
