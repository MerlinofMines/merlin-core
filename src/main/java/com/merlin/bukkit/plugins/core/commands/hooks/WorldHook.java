package com.merlin.bukkit.plugins.core.commands.hooks;

import org.bukkit.World;

public class WorldHook extends PersistableHook<World> {

	@Override
	public String getValueAsString() {
		return getValue().getName();
	}

	@Override
	public Hook<World> deepClone() {
		WorldHook hook = new WorldHook();
		hook.setValue(this.getValue());
		return hook;
	}

	@Override
	public Object getPersistableRepresentation() {
		return getValueAsString();
	}

}
