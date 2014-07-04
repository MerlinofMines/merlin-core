package com.merlin.bukkit.plugins.core.collections.factory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


public class StaticCollectionFactory<T> implements CollectionFactory<T> {

	List<T> collection = null;
	
	public StaticCollectionFactory(List<T> items) {
		this.collection = items;
	}
	
	public StaticCollectionFactory(T... items) {
		this(Arrays.asList(items));
	}
	
	public StaticCollectionFactory(Collection<T> items) {
		this(new ArrayList<T>(items));
	}
	
	public StaticCollectionFactory() {
		this(new ArrayList<T>());
	}

	@Override
	public List<T> getCollection() {
		return collection;
	}

	public void setCollection(List<T> collection) {
		this.collection = collection;
	}
	
}
