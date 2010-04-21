package com.feliperibeiro.hacks.oddintegerout.tests;

import com.feliperibeiro.hacks.oddintegerout.OddIntegerOut;

import junit.framework.TestCase;

public class OddIntegerOutTest extends TestCase {
	
	private OddIntegerOut o;
	
	public void setUp() {
		o = new OddIntegerOut();
	}
	
	public void testOddIntegerOut() {
		int[] nums = {1,2,3,4,3,2,1};
		assertEquals(4,o.oddIntegerOut(nums));

		int[] nums2 = {1,1,2,2,3,4,4};
		assertEquals(3,o.oddIntegerOut(nums2));
		
		int[] nums3 = {1,1,1,2,2,3,3,4,4};
		assertEquals(1,o.oddIntegerOut(nums3));
		
	}

}
