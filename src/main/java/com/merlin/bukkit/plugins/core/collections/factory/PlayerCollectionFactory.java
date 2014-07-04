package com.merlin.bukkit.plugins.core.collections.factory;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PlayerCollectionFactory implements CollectionFactory<Player> {

	@Override
	public List<Player> getCollection() {
		return Arrays.asList(Bukkit.getServer().getOnlinePlayers());
	}
}
