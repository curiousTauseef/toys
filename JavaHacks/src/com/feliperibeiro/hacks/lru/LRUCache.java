package com.feliperibeiro.hacks.lru;

import java.util.Calendar;
import java.util.PriorityQueue;

public class LRUCache <T> {
	
	private PriorityQueue<CacheElement<T>> storage;
	private int capacity = 10;
	
	public LRUCache() {
		storage = new PriorityQueue<CacheElement<T>>(capacity, new LRUComparator<T>());
	}
	
	public LRUCache(int capacity) {
		storage = new PriorityQueue<CacheElement<T>>(capacity, new LRUComparator<T>());
		this.capacity = capacity;
	}

	public boolean hasCache(String key) {
		return get(key) != null;
	}
	
	public T get(String key) {
		for (CacheElement<T> e : storage) {
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
	private void hit(CacheElement<T> e) {
		storage.remove(e);
		this.set(e.getKey(), e.getValue());
	}

	public void set(String key, T value) {
		CacheElement<T> e = new CacheElement<T>(key, value, Calendar.getInstance().getTimeInMillis());
		storage.add(e);
		while(storage.size() > capacity) storage.poll();
	}
	
	public void printStatus() {
		System.out.print("{");
		for (CacheElement<T> e : storage) {
			System.out.print(e.getKey()+" => "+e.getValue()+ "("+e.getLastHit()+"),");
		}
		System.out.println("}");
	}

}
