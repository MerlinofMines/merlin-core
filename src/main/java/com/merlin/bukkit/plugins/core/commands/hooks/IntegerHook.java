package com.merlin.bukkit.plugins.core.commands.hooks;

public class IntegerHook extends PersistableHook<Integer> {

	@Override
	public String getValueAsString() {
		return getValue().toString();
	}

	@Override
	public Hook<Integer> deepClone() {
		IntegerHook hook = new IntegerHook();
		hook.setValue(new Integer(this.getValue()));
		return hook;
	}

	@Override
	public Object getPersistableRepresentation() {
		return getValue();
	}

}
