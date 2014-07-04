package com.merlin.bukkit.plugins.core.commands.hooks;

import org.bukkit.entity.Player;

public class PlayerHook extends PersistableHook<Player> {

	@Override
	public String getValueAsString() {
		return getValue().getName();
	}

	@Override
	public Hook<Player> deepClone() {
		PlayerHook hook = new PlayerHook();
		hook.setValue(this.getValue());
		return hook;
	}

	@Override
	public Object getPersistableRepresentation() {
		return getValueAsString();
	}

}
