package com.merlin.bukkit.plugins.core.path.pieces;

import org.bukkit.ChatColor;

import com.merlin.bukkit.plugins.core.path.Path;
import com.merlin.bukkit.plugins.core.path.SimplePath;

public class ColoredPathPiece extends AbstractPathPiece {

	public static final ChatColor originalColor = ChatColor.WHITE;
	private ChatColor color = null;
	private Path path = null;
	
	public ColoredPathPiece(ChatColor color, PathPiece piece) {
		this(color,new SimplePath(piece));
	}
	
	public ColoredPathPiece(ChatColor color, PathPiece...pathPieces) {
		this(color,new SimplePath(pathPieces));
	}
	
	public ColoredPathPiece(ChatColor color, Path path) {
		this.color = color;
		this.path = path;
	}
	
	@Override
	public String getPathPiece() {
		return color.toString()+path.getPath()+originalColor.toString();
	}
	
	public static PathPiece color(ChatColor color, PathPiece piece) {
		return new ColoredPathPiece(color, piece);
	}

	public static PathPiece color(ChatColor color, Path path) {
		return new ColoredPathPiece(color,path);
	}
	
	public static PathPiece color(ChatColor color, PathPiece...pathPieces) {
		return new ColoredPathPiece(color, pathPieces);
	}
	
}
