package com.feliperibeiro.hacks.lru.tests;

import com.feliperibeiro.hacks.lru.LRUCache;

import junit.framework.TestCase;

public class LRUCacheTest extends TestCase {

	public void testCache() {
		LRUCache cache = new LRUCache(2);
		assertFalse(cache.hasCache("key1"));
		cache.set("key1", "value1");
		assertTrue(cache.hasCache("key1"));
		assertEquals("value1", cache.get("key1"));
		
		assertFalse(cache.hasCache("key2"));
		cache.set("key2", "value2");
		assertTrue(cache.hasCache("key1"));
		assertEquals("value1", cache.get("key1"));
		assertTrue(cache.hasCache("key2"));
		assertEquals("value2", cache.get("key2"));
		
		assertFalse(cache.hasCache("key3"));
		cache.set("key3", "value3");
		assertFalse(cache.hasCache("key1"));
		assertTrue(cache.hasCache("key2"));
		assertEquals("value2", cache.get("key2"));
		assertTrue(cache.hasCache("key3"));
		assertEquals("value3", cache.get("key3"));
		
		cache.get("key2"); //Should make key3 be the first to be removed
		cache.set("key4","value4");
		assertFalse(cache.hasCache("key3"));
		assertTrue(cache.hasCache("key2"));
		assertEquals("value2", cache.get("key2"));
		assertEquals("value4", cache.get("key4"));
	}

}
