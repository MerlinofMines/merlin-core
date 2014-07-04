package com.merlin.bukkit.plugins.core.path.pieces;

import com.merlin.bukkit.plugins.core.commands.hooks.Hook;

public class HookPathPiece<T> extends AbstractPathPiece {

	protected Hook<T> hook = null;
	
	public HookPathPiece(Hook<T> hook) {
		super();
		this.hook = hook;
	}

	@Override
	public String getPathPiece() {
		return hook.getValueAsString();
	}
	
	public static <T> PathPiece hook(Hook<T> hook) {
		return new HookPathPiece<T>(hook);
	}

}
