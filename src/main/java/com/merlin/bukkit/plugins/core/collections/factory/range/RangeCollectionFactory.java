package com.merlin.bukkit.plugins.core.collections.factory.range;

import com.merlin.bukkit.plugins.core.collections.factory.CollectionFactory;


public abstract class RangeCollectionFactory<T> implements CollectionFactory<T> {

	private T lowerValue,upperValue,increment;

	public RangeCollectionFactory(T lowerValue, T upperValue, T increment) {
		super();
		this.lowerValue = lowerValue;
		this.upperValue = upperValue;
		this.increment = increment;
	}

	public T getLowerValue() {
		return lowerValue;
	}

	public void setLowerValue(T lowerValue) {
		this.lowerValue = lowerValue;
	}

	public T getUpperValue() {
		return upperValue;
	}

	public void setUpperValue(T upperValue) {
		this.upperValue = upperValue;
	}

	public T getIncrement() {
		return increment;
	}

	public void setIncrement(T increment) {
		this.increment = increment;
	}
	
	

}
