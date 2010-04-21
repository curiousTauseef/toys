package com.feliperibeiro.hacks.lru;

import java.util.Calendar;
import java.util.PriorityQueue;

public class LRUCache {
	
	private PriorityQueue<CacheElement> storage;
	private int capacity = 10;
	
	public LRUCache() {
		storage = new PriorityQueue<CacheElement>(capacity, new LRUComparator());
	}
	
	public LRUCache(int capacity) {
		storage = new PriorityQueue<CacheElement>(capacity, new LRUComparator());
		this.capacity = capacity;
	}

	public boolean hasCache(String key) {
		return get(key) != null;
	}
	
	public Object get(String key) {
		for (CacheElement e : storage) {
			if(e.getKey().equals(key)) {
				hit(e);
				return e.getValue();
			}
		}
		return null;
	}
	
	/**
	 * Necessary to make PriorityQueue refresh the order
	 */
	private void hit(CacheElement e) {
		storage.remove(e);
		this.set(e.getKey(), e.getValue());
	}

	public void set(String key, Object value) {
		CacheElement e = new CacheElement(key, value, Calendar.getInstance().getTimeInMillis());
		storage.add(e);
		while(storage.size() > capacity) storage.poll();
	}
	
	public void printStatus() {
		System.out.print("{");
		for (CacheElement e : storage) {
			System.out.print(e.getKey()+" => "+e.getValue()+ "("+e.getLastHit()+"),");
		}
		System.out.println("}");
	}

}
