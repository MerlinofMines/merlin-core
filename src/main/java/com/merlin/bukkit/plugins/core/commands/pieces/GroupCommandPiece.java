package com.merlin.bukkit.plugins.core.commands.pieces;

import java.util.Map;
import java.util.TreeMap;

import org.bukkit.ChatColor;

import com.merlin.bukkit.plugins.core.collections.GroupAction;
import com.merlin.bukkit.plugins.core.collections.factory.StaticCollectionFactory;
import com.merlin.bukkit.plugins.core.commands.hooks.GroupActionHook;

public class GroupCommandPiece extends MappedValueCommandPiece<GroupAction> {

	public static Map<String,GroupAction> getDefaultGroupActions() {
		Map<String,GroupAction> actions = new TreeMap<String, GroupAction>();
		actions.put("add",GroupAction.ADD);
		actions.put("remove",GroupAction.REMOVE);
		return actions;
	}
	public GroupCommandPiece() {
		this(new GroupActionHook());
	}

	public GroupCommandPiece(GroupActionHook groupHook) {
		super(getDefaultGroupActions(),ChatColor.YELLOW,5,groupHook,new StaticCollectionFactory<String>("add","remove"));
	}
	@Override
	public String getDisplay() {
		// TODO Auto-generated method stub
		return null;
	}

	public static GroupCommandPiece group() {
		return new GroupCommandPiece();
	}
	
	public static GroupCommandPiece group(GroupActionHook groupHook) {
		return new GroupCommandPiece(groupHook);
	}
}
