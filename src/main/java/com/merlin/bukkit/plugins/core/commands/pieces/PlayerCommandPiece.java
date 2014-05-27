package com.merlin.bukkit.plugins.core.commands.pieces;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.OfflinePlayer;
import org.bukkit.Server;

public class PlayerCommandPiece extends AbstractCommandPiece<OfflinePlayer> {

	private OfflinePlayer player = null;
	private Server server = null;
	private boolean requireOnline = false;
	
	public Server getServer() {
		return server;
	}

	public void setServer(Server server) {
		this.server = server;
	}

	public PlayerCommandPiece(Server server) {
		super();
		this.server = server;
	}

	@Override
	public boolean matches(String input) {
		return getExactPlayer(input)!=null;
	}

	@Override
	public List<String> possibilites(String input) {

		OfflinePlayer[] players = getPlayers();
		List<String> possibilities = new ArrayList<String>();

		if(players.length>0) {
			for(OfflinePlayer player : players) {
				if(player.getName().startsWith(input)) {
					possibilities.add(player.getName());
				}
			}
		}
		return possibilities;
	}

	@Override
	public String getDisplay() {
		return chatColor+"<player>";
	}

	@Override
	public OfflinePlayer getValue() {
		return player;
	}

	@Override
	public void setValue(OfflinePlayer value) {
		this.player = value;
	}

	@Override
	public void setValueFromString(String value)
			throws IllegalArgumentException {
		OfflinePlayer player = getExactPlayer(value);
		if(player==null) throw new IllegalArgumentException("Unable to find playe with name: " + value);
		this.player = player;
	}
	
	private OfflinePlayer[] getPlayers() {
		OfflinePlayer[] players = null;
		if(requireOnline) {
			players = (OfflinePlayer[])server.getOnlinePlayers();
		} else {
			players = server.getOfflinePlayers();
		}
		return players;
	}
	
	private OfflinePlayer getExactPlayer(String name) {
		OfflinePlayer[] players = getPlayers();
		if(players.length==0) {
			return null;
		}
		else {
			for(OfflinePlayer player : players) {
				if(player.getName().equals(name)) {
					return player;//Found a matching players.  According to 1.7.6 names are still expected to be unique so this
								//Is a valid check.
				}
			}
			//No matching players.  Return false
			return null;
		}
		
	}
}
