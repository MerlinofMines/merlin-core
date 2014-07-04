package com.merlin.bukkit.plugins.core.commands;

import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.merlin.bukkit.plugins.core.commands.hooks.Hook;

public class PlayerTPCommand extends Command {

	private Hook<World> hook = null;
	public PlayerTPCommand(Hook<World> hook) {
		super();
		this.hook = hook;
	}

	@Override
	public boolean execute(CommandSender sender) {

		World world = hook.getValue();

		Player player = (Player)sender;//TODO Check this!
		
		player.teleport(world.getSpawnLocation());
		
		return true;
	}
	
}