package com.merlin.bukkit.plugins.core.path.pieces;

import static com.merlin.bukkit.plugins.core.path.SimplePath.simple;

import java.util.HashMap;
import java.util.Map;

import com.merlin.bukkit.plugins.core.collections.GroupAction;
import com.merlin.bukkit.plugins.core.commands.hooks.Hook;
import com.merlin.bukkit.plugins.core.path.Path;

public class GroupPathPiece extends MappedResponsePathPiece<GroupAction>{

	public static Map<GroupAction,Path> getMap(Path ifAdded,Path ifRemoved) {
		Map<GroupAction,Path> pathPieceMap = new HashMap<GroupAction, Path>();
		pathPieceMap.put(GroupAction.ADD, ifAdded);
		pathPieceMap.put(GroupAction.REMOVE, ifRemoved);
		return pathPieceMap;
	}
	
	public GroupPathPiece(Hook<GroupAction> hook,Path ifAdded, Path ifRemoved) {
		super(hook, getMap(ifAdded,ifRemoved));
	}

	public GroupPathPiece(Hook<GroupAction> hook,String ifAdded, String ifRemoved) {
		this(hook,simple(ifAdded),simple(ifRemoved));
	}

	public static GroupPathPiece group(Hook<GroupAction> condition,Path ifAdded,Path ifRemoved) {
		return new GroupPathPiece(condition,ifAdded,ifRemoved);
	}
	
	public static GroupPathPiece group(Hook<GroupAction> condition,String ifAdded,String ifRemoved) {
		return new GroupPathPiece(condition,ifAdded,ifRemoved);
	}

}
