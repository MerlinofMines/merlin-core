package com.merlin.bukkit.plugins.core.path.pieces;

import com.merlin.bukkit.plugins.core.commands.hooks.Persistable;

public class PersistablePathPiece extends AbstractPathPiece {

	private Persistable persistable;
	
	public PersistablePathPiece(Persistable persistable) {
		super();
		this.persistable = persistable;
	}



	@Override
	public String getPathPiece() {
		return persistable.getPersistableRepresentation().toString();
	}
	
	public static PathPiece configuration(Persistable persistable) {
		return new PersistablePathPiece(persistable);
	}

}
