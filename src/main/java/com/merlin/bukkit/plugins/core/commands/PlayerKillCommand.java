package com.merlin.bukkit.plugins.core.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.merlin.bukkit.plugins.core.commands.hooks.Hook;

public class PlayerKillCommand extends Command {

	private Hook<Player> hook = null;
	
	public PlayerKillCommand(Hook<Player> hook) {
		super();
		this.hook = hook;
	}

	@Override
	public boolean execute(CommandSender sender) {

		Player player = (Player)hook.getValue();
		
		player.damage(100);
		return true;
	}
	
}