package com.merlin.bukkit.plugins.core.commands.pieces;

import java.util.Map;
import java.util.TreeMap;

import org.bukkit.ChatColor;

import com.merlin.bukkit.plugins.core.collections.GroupAction;
import com.merlin.bukkit.plugins.core.collections.factory.StaticCollectionFactory;
import com.merlin.bukkit.plugins.core.commands.hooks.GroupActionHook;
import com.merlin.bukkit.plugins.core.commands.hooks.Hook;

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

	public GroupCommandPiece(Hook<GroupAction> groupHook) {
		super(getDefaultGroupActions(),ChatColor.YELLOW,5,groupHook,new StaticCollectionFactory<String>("add","remove"));
	}

	public static GroupCommandPiece group() {
		return new GroupCommandPiece();
	}
	
	public static GroupCommandPiece group(Hook<GroupAction> groupHook) {
		return new GroupCommandPiece(groupHook);
	}
	@Override
	public String getDisplay() {
		return this.chatColor+"(add/remove)";
	}
}
