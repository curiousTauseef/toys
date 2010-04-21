package com.feliperibeiro.hacks.lru;

import java.util.Comparator;

public class LRUComparator<T> implements Comparator<CacheElement<T>> {

	public int compare(CacheElement<T> o1, CacheElement<T> o2) {
		return o1.getLastHit() >= o2.getLastHit()? 1:-1;
	}

}
