package com.merlin.bukkit.plugins.core.path.pieces;

import java.util.HashMap;
import java.util.Map;

import com.merlin.bukkit.plugins.core.commands.hooks.Hook;
import com.merlin.bukkit.plugins.core.path.Path;

public class MappedResponsePathPiece<T> extends HookPathPiece<T> {

	Map<T,Path> pathPieceMap = null;
	
	public MappedResponsePathPiece(Hook<T> hook,Map<T,Path> pathPieceMap) {
		super(hook);
		this.pathPieceMap = pathPieceMap;
	}

	@Override
	public String getPathPiece() {
		Path path = pathPieceMap.get(hook.getValue());
		if(path!=null)return path.getPath();
		else return "";
	}
	
	public static <T> MappedResponsePathPiece<T> map(Hook<T> hook,MappedResponseEntry<T>... entries) {
		Map<T,Path> pathPieceMap = new HashMap<T, Path>();
		for(MappedResponseEntry<T> entry : entries) {
			pathPieceMap.put(entry.getKey(), entry.getValue());
		}
		return new MappedResponsePathPiece<T>(hook, pathPieceMap);
	}
}
