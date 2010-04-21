package com.feliperibeiro.hacks.lru;

import java.util.Calendar;
import java.util.PriorityQueue;

public class LRUCache {
	
	private PriorityQueue<CacheElement> storage;
	private final static int CAPACITY = 10;
	private int capacity = CAPACITY;
	
	public LRUCache() {
		storage = new PriorityQueue<CacheElement>(CAPACITY, new LRUComparator());
	}
	
	public LRUCache(int initialCapacity) {
		storage = new PriorityQueue<CacheElement>(initialCapacity, new LRUComparator());
		capacity = initialCapacity;
	}

	public boolean hasCache(String key) {
		return get(key) != null;
	}
	
	public Object get(String key) {
		for (CacheElement e : storage) {
			if(e.getKey().equals(key)) {
				storage.remove(e);
				this.set(e.getKey(), e.getValue());
				return e.getValue();
			}
		}
		return null;
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
