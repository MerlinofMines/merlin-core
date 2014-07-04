package com.merlin.bukkit.plugins.core.path.pieces;

import static com.merlin.bukkit.plugins.core.path.SimplePath.simple;

import java.util.HashMap;
import java.util.Map;

import com.merlin.bukkit.plugins.core.commands.hooks.Hook;
import com.merlin.bukkit.plugins.core.path.Path;

public class ConditionalPathPiece extends MappedResponsePathPiece<Boolean>{

	public static Map<Boolean,Path> getMap(Path ifTrue,Path ifFalse) {
		Map<Boolean,Path> pathPieceMap = new HashMap<Boolean, Path>();
		pathPieceMap.put(Boolean.TRUE, ifTrue);
		pathPieceMap.put(Boolean.FALSE, ifFalse);
		return pathPieceMap;
	}
	
	public ConditionalPathPiece(Hook<Boolean> hook,Path ifTrue, Path ifFalse) {
		super(hook, getMap(ifTrue,ifFalse));
	}

	public ConditionalPathPiece(Hook<Boolean> hook,String ifTrue, String ifFalse) {
		this(hook,simple(ifTrue),simple(ifFalse));
	}

	public static ConditionalPathPiece condition(Hook<Boolean> condition,Path ifTrue,Path ifFalse) {
		return new ConditionalPathPiece(condition,ifTrue,ifFalse);
	}
	
	public static ConditionalPathPiece condition(Hook<Boolean> condition,String ifTrue,String ifFalse) {
		return new ConditionalPathPiece(condition,ifTrue,ifFalse);
	}
}
