package com.feliperibeiro.hacks.oddintegerout;

/**
 * Question: You're given an unsorted array of integers where every integer 
 * appears exactly twice, except for one integer which appears only once. 
 * Write the algorithm that finds that integer. 
 */
public class OddIntegerOut {
	
	public int oddIntegerOut(int[] nums) {
		int oddInteger = 0;
		for (int i : nums) 
			oddInteger ^= i;
		return oddInteger;
	}

}
