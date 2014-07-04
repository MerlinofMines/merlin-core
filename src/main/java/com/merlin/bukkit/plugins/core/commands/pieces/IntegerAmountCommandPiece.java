package com.merlin.bukkit.plugins.core.commands.pieces;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.math.NumberUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import com.merlin.bukkit.plugins.core.commands.hooks.Hook;
import com.merlin.bukkit.plugins.core.commands.hooks.IntegerHook;

public class IntegerAmountCommandPiece extends AbstractCommandPiece<Integer> {
	
	public IntegerAmountCommandPiece() {
		this(new IntegerHook());
	}
	
	public IntegerAmountCommandPiece(Hook<Integer> hook) {
		this(new ArrayList<Integer>(),hook);
	}
	
	public IntegerAmountCommandPiece(List<Integer> integerOptions) {
		this(integerOptions,new IntegerHook());
	}

	public IntegerAmountCommandPiece(List<Integer> integerOptions,Hook<Integer> hook) {
		super(ChatColor.BLUE,5,hook);
	}

	@Override
	public boolean matches(String input,CommandSender sender) {
		return NumberUtils.isDigits(input);
	}
	
	@Override
	public List<String> possibilities(String input,CommandSender sender) {
		return null;
	}
	
	@Override
	public void setValueFromString(String input, CommandSender sender) throws IllegalArgumentException{
		hook.setValue(Integer.parseInt(input));
	}

	@Override
	public String getDisplay() {
		return chatColor+"<int>";
	}
	
	public static IntegerAmountCommandPiece integer() {
		return new IntegerAmountCommandPiece();
	}

	public static IntegerAmountCommandPiece integer(Hook<Integer> hook) {
		return new IntegerAmountCommandPiece(hook);
	}

	public static IntegerAmountCommandPiece integer(List<Integer> options) {
		return new IntegerAmountCommandPiece(options);
	}
	
	public static IntegerAmountCommandPiece integer(List<Integer> options, Hook<Integer> hook) {
		return new IntegerAmountCommandPiece(options, hook);
	}

}
