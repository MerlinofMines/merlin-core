package com.merlin.bukkit.plugins.core.path.pieces;

import org.bukkit.ChatColor;

public class ColoredPathPiece extends AbstractPathPiece {

	private ChatColor color = null;
	private PathPiece piece = null;
	
	public ColoredPathPiece(ChatColor color, PathPiece piece) {
		super();
		this.color = color;
		this.piece = piece;
	}

	@Override
	public String getPathPiece() {
		return color.toString()+piece.getPathPiece();
	}
	
	public static PathPiece color(ChatColor color, PathPiece piece) {
		return new ColoredPathPiece(color, piece);
	}

}
