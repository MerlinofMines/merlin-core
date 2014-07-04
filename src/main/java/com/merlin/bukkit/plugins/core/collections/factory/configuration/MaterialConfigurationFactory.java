package com.merlin.bukkit.plugins.core.collections.factory.configuration;

import org.bukkit.Material;
import org.bukkit.configuration.Configuration;

import com.merlin.bukkit.plugins.core.commands.hooks.Hook;
import com.merlin.bukkit.plugins.core.path.Path;

public class MaterialConfigurationFactory extends ConfigurationCollectionFactory<Material>{

	public MaterialConfigurationFactory(Configuration configuration,
			Path rootPath, Hook<Material> hook) {
		super(configuration, rootPath, hook);
	}

	@Override
	public Material parseValue(String configurationValue)
			throws IllegalArgumentException {
		Material material = Material.getMaterial(configurationValue);
		if(material == null) {
			throw new IllegalArgumentException("Invalid Material found in configuration: " + configurationValue);
		}
		return material;
	}

}
