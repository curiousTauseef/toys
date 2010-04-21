package com.feliperibeiro.hacks.lru;

import java.util.Calendar;

class CacheElement<T> {
	private long lastHit;
	private String key;
	private T value;
	
	public CacheElement(String key, T value, long lastHit) {
		this.key = key;
		this.value = value;
		this.lastHit = lastHit;
	}
	
	protected void setValue(T value) {
		this.value = value;
	}
	
	protected T getValue() {
		return value;
	}
	
	protected long getLastHit() {
		return lastHit;
	}

	protected String getKey() {
		return key;
	}

	public void hit() {
		lastHit = Calendar.getInstance().getTimeInMillis();
	}
	

}
