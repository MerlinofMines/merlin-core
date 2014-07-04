package com.merlin.bukkit.plugins.core.util;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PlayerUtil {
	
	public static Player getOnlinePlayer(String name) {
		Player[] players = Bukkit.getServer().getOnlinePlayers();
		if(players.length==0) {
			return null;
		}
		else {
			for(Player player : players) {
				if(player.getName().toLowerCase().equals(name.toLowerCase())) {
					return player;//Found a matching players.  According to 1.7.6 names are still expected to be unique so this
								//Is a valid check.
				}
			}
			//No matching players.  Return false
			return null;
		}
	}
}
