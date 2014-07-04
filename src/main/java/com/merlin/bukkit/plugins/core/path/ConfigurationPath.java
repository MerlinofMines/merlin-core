package com.merlin.bukkit.plugins.core.path;

import java.util.Arrays;
import java.util.List;

import com.merlin.bukkit.plugins.core.path.pieces.PathPiece;

public class ConfigurationPath extends AbstractPath {

	public ConfigurationPath(List<PathPiece> pathPieces) {
		super(pathPieces,".");
	}

	public ConfigurationPath(PathPiece...pathPieces) {
		this(Arrays.asList(pathPieces));
	}

	public static ConfigurationPath configuration(List<PathPiece> pieces) {
		return new ConfigurationPath(pieces);
	}
	
	public static ConfigurationPath configuration(PathPiece... pieces) {
		return configuration(Arrays.asList(pieces));
	}
	
}
