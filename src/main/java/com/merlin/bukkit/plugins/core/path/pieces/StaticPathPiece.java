package com.merlin.bukkit.plugins.core.path.pieces;

public class StaticPathPiece extends AbstractPathPiece {

	private String pathPiece = null;
	
	@Override
	public String getPathPiece() {
		return pathPiece;
	}

	public StaticPathPiece(String pathPiece) {
		super();
		this.pathPiece = pathPiece;
	}

	public static PathPiece constant(String pathPiece) {
		return new StaticPathPiece(pathPiece);
	}

}
