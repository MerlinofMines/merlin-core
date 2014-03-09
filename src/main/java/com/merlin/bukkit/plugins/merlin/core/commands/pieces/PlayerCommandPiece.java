package com.merlin.bukkit.plugins.merlin.core.commands.pieces;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Server;
import org.bukkit.entity.Player;

public class PlayerCommandPiece extends AbstractCommandPiece<Player> {

	private Player player = null;
	private Server server = null;
	
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
		return server.getPlayer(input)!=null;//TODO: This might need to be "getExactPlayer" 
	}

	@Override
	public List<String> possibilites(String input) {

		List<Player> playerList = server.matchPlayer(input);
		List<String> possibilities = new ArrayList<String>();
		for(int i = 0;i<playerList.size();i++) {
			possibilities.add(playerList.get(i).getName());
		}
		return possibilities;
	}

	@Override
	public String getDisplay() {
		return chatColor+"<player>";
	}

	@Override
	public Player getValue() {
		return player;
	}

	@Override
	public void setValue(Player value) {
		this.player = value;
	}

	@Override
	public void setValueFromString(String value)
			throws IllegalArgumentException {
		Player player = server.getPlayer(value);
		if(player==null) throw new IllegalArgumentException("Unable to find a player with name: " + value);
		this.player = player;
	}

}
