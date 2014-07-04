package com.merlin.bukkit.plugins.core.commands.hooks;


public class StringHook extends PersistableHook<String> {

	@Override
	public String getValueAsString() {
		return getValue();
	}

	@Override
	public Hook<String> deepClone() {
		StringHook hook = new StringHook();
		hook.setValue(this.getValue());
		return hook;
	}

	@Override
	public Object getPersistableRepresentation() {
		return getValue();
	}

}
