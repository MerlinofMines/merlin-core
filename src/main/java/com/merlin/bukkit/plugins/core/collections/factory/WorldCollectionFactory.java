package com.merlin.bukkit.plugins.core.collections.factory;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.World;

public class WorldCollectionFactory implements CollectionFactory<World>{

	@Override
	public List<World> getCollection() {
		return Bukkit.getServer().getWorlds();
	}
	
}
