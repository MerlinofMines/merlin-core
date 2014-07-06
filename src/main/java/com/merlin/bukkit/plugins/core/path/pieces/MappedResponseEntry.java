package com.merlin.bukkit.plugins.core.path.pieces;

import com.merlin.bukkit.plugins.core.path.Path;

public class MappedResponseEntry<T> {

	private T key;
	private Path value;

	public MappedResponseEntry(T key, Path value) {
		super();
		this.key = key;
		this.value = value;
	}

	public T getKey() {
		return key;
	}

	public Path getValue() {
		return value;
	}
	
	public static <T> MappedResponseEntry<T> entry(T key, Path value) {
		return new MappedResponseEntry<T>(key, value);
	}
	
}
