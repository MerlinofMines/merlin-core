package com.merlin.bukkit.plugins.core.commands.hooks;

public class AffirmationHook extends PersistableHook<Boolean> {

	@Override
	public String getValueAsString() {
		if(getValue()==null)return Boolean.FALSE.toString();
		else return getValue().toString();
	}

	@Override
	public Hook<Boolean> deepClone() {
		AffirmationHook hook = new AffirmationHook();
		hook.setValue(new Boolean(this.getValue()));
		return hook;
	}

	@Override
	public Object getPersistableRepresentation() {
		if(getValue()==null)return Boolean.FALSE;
			else return Boolean.valueOf(getValue());
		}
}
