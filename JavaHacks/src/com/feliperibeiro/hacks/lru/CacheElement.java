package com.feliperibeiro.hacks.lru;

import java.util.Calendar;

class CacheElement {
	private long lastHit;
	private String key;
	private Object value;
	
	public CacheElement(String key, Object value, long lastHit) {
		this.key = key;
		this.value = value;
		this.lastHit = lastHit;
	}
	
	protected void setValue(Object value) {
		this.value = value;
	}
	
	protected Object getValue() {
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
