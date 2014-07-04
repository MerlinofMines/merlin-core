package com.merlin.bukkit.plugins.core.commands.pieces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.Configuration;

import com.merlin.bukkit.plugins.core.collections.factory.CollectionFactory;
import com.merlin.bukkit.plugins.core.collections.factory.StaticCollectionFactory;
import com.merlin.bukkit.plugins.core.collections.factory.configuration.MaterialConfigurationFactory;
import com.merlin.bukkit.plugins.core.commands.hooks.Hook;
import com.merlin.bukkit.plugins.core.commands.hooks.MaterialHook;
import com.merlin.bukkit.plugins.core.path.Path;

public class MaterialCommandPiece extends CollectionCommandPiece<Material> {

	public MaterialCommandPiece() {
		this(new ArrayList<Material>());
	}
	
	public MaterialCommandPiece(Hook<Material> hook) {
		this(hook,new ArrayList<Material>());
	}

	public MaterialCommandPiece(Material... materials) {
		this(new MaterialHook(),Arrays.asList(materials));
	}
	
	public MaterialCommandPiece(Hook<Material> hook,Material... materials) {
		this(hook,Arrays.asList(materials));
	}

	public MaterialCommandPiece(List<Material> materials) {
		this(new MaterialHook(),materials);
	}
	public MaterialCommandPiece(Hook<Material> hook,List<Material> materials) {
		this(hook,new StaticCollectionFactory<Material>(materials));
		if(materials==null||materials.isEmpty()) {
			throw new IllegalArgumentException("Materials cannot be empty");
		}
	}
	
	public MaterialCommandPiece(Hook<Material> hook, Configuration configuration, Path rootPath) {
		this(hook,new MaterialConfigurationFactory(configuration, rootPath, hook));
	}
	
	public MaterialCommandPiece(Hook<Material> hook,CollectionFactory<Material> factory) {
		super(ChatColor.GREEN,5,hook,factory);
	}
	
	@Override
	public String getDisplay() {
		return ChatColor.DARK_BLUE+"<Material>";
	}

	@Override
	protected String getString(Material value) {
		return value.toString();
	}
	
	public static MaterialCommandPiece material() {
		return new MaterialCommandPiece();
	}
	
	public static MaterialCommandPiece material(Hook<Material> hook) {
		return new MaterialCommandPiece(hook);
	}

	public static MaterialCommandPiece material(Material... materials) {
		return new MaterialCommandPiece(materials);
	}

	public static MaterialCommandPiece material(Hook<Material> hook,Material... materials) {
		return new MaterialCommandPiece(hook,materials);
	}

	public static MaterialCommandPiece material(List<Material> materials) {
		return new MaterialCommandPiece(materials);
	}

	public static MaterialCommandPiece material(Hook<Material> hook,List<Material> materials) {
		return new MaterialCommandPiece(hook,materials);
	}
	
	public static MaterialCommandPiece material(Configuration config,Path path,Hook<Material> hook) {
		return new MaterialCommandPiece(hook,config,path);
	}

}
