package com.merlin.bukkit.plugins.core.collections.factory.configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.configuration.Configuration;

import com.merlin.bukkit.plugins.core.collections.factory.CollectionFactory;
import com.merlin.bukkit.plugins.core.commands.hooks.Hook;
import com.merlin.bukkit.plugins.core.path.Path;

public abstract class ConfigurationCollectionFactory<T> implements CollectionFactory<T>{

	private Configuration configuration;
	private Path rootPath;
	private Hook<T> hook;
	
	public ConfigurationCollectionFactory(Configuration configuration,
			Path rootPath, Hook<T> hook) {
		super();
		this.configuration = configuration;
		this.rootPath = rootPath;
		this.hook = hook;
	}

	@Override
	public List<T> getCollection() {
		List<T> collection = new ArrayList<T>();
		Set<String> keys = configuration.getConfigurationSection(rootPath.getPath()).getKeys(false);
		for(String key : keys) {
			try {
				Hook<T> newHook = hook.deepClone();
				newHook.setValue(parseValue(key));
				collection.add(newHook.getValue());
			} catch(IllegalArgumentException e) {
				Bukkit.getServer().getLogger().warning("Unable to bind value to " +hook.getClass()+": "+e.getMessage()+". Configuration may be corrupt or invalid path specified.");
			}
		}
		return collection;
	}
	
	public abstract T parseValue(String configurationValue) throws IllegalArgumentException;
}
