package com.merlin.bukkit.plugins.core.commands.hooks;

import com.merlin.bukkit.plugins.core.collections.GroupAction;

public class GroupActionHook extends AbstractHook<GroupAction> {

	@Override
	public String getValueAsString() {
		return getValue().name();
	}

	@Override
	public Hook<GroupAction> deepClone() {
		GroupActionHook hook = new GroupActionHook();
		hook.setValue(this.getValue());
		return hook;
	}

}
