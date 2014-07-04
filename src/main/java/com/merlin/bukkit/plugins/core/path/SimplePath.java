package com.merlin.bukkit.plugins.core.path;

import java.util.Arrays;
import java.util.List;

import com.merlin.bukkit.plugins.core.path.pieces.PathPiece;
import com.merlin.bukkit.plugins.core.path.pieces.StaticPathPiece;

public class SimplePath extends AbstractPath {

	public SimplePath(List<PathPiece> pathPieces) {
		super(pathPieces,"");
	}

	public SimplePath(PathPiece...pathPieces) {
		this(Arrays.asList(pathPieces));
	}

	public static SimplePath simple(List<PathPiece> pieces) {
		return new SimplePath(pieces);
	}
	
	public static SimplePath simple(PathPiece... pieces) {
		return simple(Arrays.asList(pieces));
	}
	
	public static SimplePath simple(String piece) {
		return simple(new StaticPathPiece(piece));
	}
}
