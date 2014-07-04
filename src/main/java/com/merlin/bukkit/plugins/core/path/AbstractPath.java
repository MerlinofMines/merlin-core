package com.merlin.bukkit.plugins.core.path;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.merlin.bukkit.plugins.core.path.pieces.PathPiece;

public abstract class AbstractPath implements Path {

	private List<PathPiece> pathPieces = null;
	
	private String pathSeparator = null;

	public AbstractPath(List<PathPiece> pathPieces,String pathSeparator) {
		super();
		this.pathPieces = pathPieces;
		this.pathSeparator = pathSeparator;
	}

	public List<PathPiece> getPathPieces() {
		return pathPieces;
	}

	public void setPathPieces(List<PathPiece> pathPieces) {
		this.pathPieces = pathPieces;
	}

	@Override
	public String getPath() {
		return StringUtils.join(pathPieces,pathSeparator);
	}
	
	@Override
	public String toString() {
		return getPath();
	}

}
