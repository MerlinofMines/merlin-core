package com.merlin.bukkit.plugins.core.commands.pieces;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.bukkit.ChatColor;

import com.merlin.bukkit.plugins.core.collections.factory.StaticCollectionFactory;
import com.merlin.bukkit.plugins.core.commands.hooks.AffirmationHook;
import com.merlin.bukkit.plugins.core.commands.hooks.Hook;

public class AffirmationCommandPiece extends MappedValueCommandPiece<Boolean> {
	
	public static Map<String,Boolean> getAffirmationMap() {
		Map<String,Boolean> affirmations = new TreeMap<String, Boolean>();
		affirmations.put("yes",true);
		affirmations.put("no",false);
		affirmations.put("true",true);
		affirmations.put("false",false);
		affirmations.put("on", true);
		affirmations.put("off",false);
		affirmations.put("enable", true);
		affirmations.put("enabled", true);
		affirmations.put("disable",false);
		affirmations.put("disabled",false);
		affirmations.put("start",true);
		affirmations.put("stop",false);
		affirmations.put("begin",true);
		affirmations.put("end",false);
		return affirmations;
	}
	
	public AffirmationCommandPiece(String... affirmations) {
		this(Arrays.asList(affirmations));
	}
	
	public AffirmationCommandPiece(List<String> affirmations) {
		this(getAffirmationMap(),affirmations);
	}
	
	public AffirmationCommandPiece(Map<String,Boolean> affirmationMap,List<String> affirmations) {
		this(affirmationMap,affirmations,new AffirmationHook());
	}
	
	public AffirmationCommandPiece(List<String> affirmations,Hook<Boolean> hook) {
		this(getAffirmationMap(),affirmations,hook);
	}
	
	public AffirmationCommandPiece(Map<String,Boolean> affirmationMap,List<String> affirmations,Hook<Boolean> hook) {
		super(affirmationMap,ChatColor.YELLOW,5,hook,new StaticCollectionFactory<String>(affirmations));
	}
	
	@Override
	public String getDisplay() {
		return chatColor+"(affirmative)";
	}
	
	public static AffirmationCommandPiece affirm(String... affirmations) {
		return new AffirmationCommandPiece(affirmations);
	}
	
	public static AffirmationCommandPiece affirm(Hook<Boolean> hook,String... affirmations) {
		return new AffirmationCommandPiece(Arrays.asList(affirmations),hook);
	}
	
}
