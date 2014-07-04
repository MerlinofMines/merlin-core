package com.merlin.bukkit.plugins.core.commands.pieces;

import org.bukkit.ChatColor;
import org.bukkit.World;

import com.merlin.bukkit.plugins.core.collections.factory.WorldCollectionFactory;
import com.merlin.bukkit.plugins.core.commands.hooks.WorldHook;

public class WorldCommandPiece extends CollectionCommandPiece<World> {

	public WorldCommandPiece() {
		super(ChatColor.LIGHT_PURPLE,5,new WorldHook(),new WorldCollectionFactory());
	}

	@Override
	public String getDisplay() {
		return chatColor+"<world>";
	}

	@Override
	protected String getString(World value) {
		return value.getName();
	}

	
}
