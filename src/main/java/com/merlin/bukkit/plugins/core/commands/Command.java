package com.merlin.bukkit.plugins.core.commands;

import static com.merlin.bukkit.plugins.core.path.SimplePath.simple;

import org.bukkit.command.CommandSender;

import com.merlin.bukkit.plugins.core.path.Path;

public abstract class Command {

	protected String permission = null;
	protected String description = null;
	protected Path successMessage = null;

	public Path getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(Path successMessage) {
		this.successMessage = successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = simple(successMessage);
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public abstract boolean execute(CommandSender sender);
}
