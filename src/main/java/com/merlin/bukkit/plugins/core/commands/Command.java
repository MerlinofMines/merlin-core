package com.merlin.bukkit.plugins.core.commands;

import org.bukkit.command.CommandSender;

public abstract class Command {

	protected String permission = null;
	protected String description = null;
	protected String successMessage = null;
	
	public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
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
