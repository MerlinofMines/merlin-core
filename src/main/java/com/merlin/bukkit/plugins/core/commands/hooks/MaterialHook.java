package com.merlin.bukkit.plugins.core.commands.hooks;

import org.bukkit.Material;

public class MaterialHook extends PersistableHook<Material> {

	@Override
	public String getValueAsString() {
		return getValue().name();
	}

	@Override
	public Hook<Material> deepClone() {
		MaterialHook hook = new MaterialHook();
		hook.setValue(this.getValue());
		return hook;
	}

	@Override
	public Object getPersistableRepresentation() {
		return getValue().name();
	}

}
