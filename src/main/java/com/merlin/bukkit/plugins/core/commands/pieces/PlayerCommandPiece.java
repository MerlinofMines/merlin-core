package com.merlin.bukkit.plugins.core.commands.pieces;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.merlin.bukkit.plugins.core.collections.factory.PlayerCollectionFactory;
import com.merlin.bukkit.plugins.core.commands.hooks.PlayerHook;

public class PlayerCommandPiece extends CollectionCommandPiece<Player> {

	public PlayerCommandPiece() {
		super(ChatColor.AQUA,5,new PlayerHook(),new PlayerCollectionFactory());
	}

	@Override
	public String getDisplay() {
		return chatColor+"<player>";
	}

	@Override
	protected String getString(Player value) {
		return value.getName();
	}

}
