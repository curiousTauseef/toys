package com.feliperibeiro.hacks.merge;

/**
 * Given 2 arrays, A and B: 
 * A = [ 1, 3, 5, 7 , 9, __, __, __, __ ]
 * A has n numbers and m empty slots
 * In this case, n = 5, m = 4
 * B = [ 2, 4, 6, 8 ]
 * B has exactly m elements
 * The two arrays are sorted
 * Calculate A merged with B (sorted). The algorithm should be In-place and O(n) time:
 * [ 1, 2, 3, 4, 5, 6, 7, 8, 9 ] 
 */

public class MergeSortedArray {

	public int[] merge(int[] a, int[] b) {
		int ultimoElementoDeA = a.length - b.length-1;
		int ultimoElementoDeB = b.length -1;
		int pontoDeInsercao = a.length - 1;
		while(ultimoElementoDeB >= 0) {
			if(ultimoElementoDeA >= 0 && a[ultimoElementoDeA] > b[ultimoElementoDeB]) {
				a[pontoDeInsercao] = a[ultimoElementoDeA];
				ultimoElementoDeA--;
			} else {
				a[pontoDeInsercao] = b[ultimoElementoDeB];
				ultimoElementoDeB--;
			}
			pontoDeInsercao--;
			
		}
		return a;		
	}


}
