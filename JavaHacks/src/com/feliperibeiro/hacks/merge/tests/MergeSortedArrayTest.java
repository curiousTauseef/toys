package com.feliperibeiro.hacks.merge.tests;

import com.feliperibeiro.hacks.merge.MergeSortedArray;

import junit.framework.TestCase;

public class MergeSortedArrayTest extends TestCase {
	
	private MergeSortedArray m;

	public void setUp() {
		m = new MergeSortedArray();
	}
	
	public void testMerge() {
		
		int[] a = new int[9];
		int[] b = {2,4,6,8};
		a[0] = 1;
		a[1] = 3;
		a[2] = 5;
		a[3] = 7;
		a[4] = 9;
		int[] solution = {1,2,3,4,5,6,7,8,9};
		m.merge(a, b);
		assertEquals(a.length, solution.length);
		for(int i=0; i < a.length; i++)
			assertEquals(solution[i], a[i]);
		
		
		a = new int[2];
		int[] c = {1};
		a[0] = 2;
		m.merge(a, c);
		int[] solution2 = {1,2};
		assertEquals(a.length, solution2.length);
		for(int i=0; i < a.length; i++)
			assertEquals(solution2[i], a[i]);
	}

}
