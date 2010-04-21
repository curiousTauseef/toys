package com.feliperibeiro.hacks.lru;

import java.util.Comparator;

public class LRUComparator implements Comparator<CacheElement> {

	public int compare(CacheElement o1, CacheElement o2) {
		return o1.getLastHit() >= o2.getLastHit()? 1:-1;
	}

}
