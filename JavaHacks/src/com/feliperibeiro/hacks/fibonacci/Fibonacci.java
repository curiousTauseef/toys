package com.feliperibeiro.hacks.fibonacci;

import java.util.Scanner;

/**
 * The most efficient way to calculate Fibonacci, uses divide and conquer
 * and the running time is O(lg n), considering the matrix multiplication
 * as constant time, since it doesn't depend on n, it's always a 2x2 matrix
 *
 * @author Felipe Ribeiro <felipernb@gmail.com>
 */
public class Fibonacci {

	public static void main(String args[]) {
		int i, fib;
		Scanner in = new Scanner(System.in);
		while ((i = in.nextInt()) != 0) {
			System.out.println("Fib("+i+") = "+fibonacci(i));
		}
	}

	/**
	 * Uses the theorem that Fib(n) = [[1,1],[1,0]] ^ n
	 */
	public static int fibonacci(int n) {
		int matrix[][] = {{1,1},{1,0}};
		return powerMatrix(matrix,n)[0][1];
	}

	/**
	 * Powers the matrix m to the nth power using divide and conquer
	 */
	public static int[][] powerMatrix(int[][] m, int n) {
		if (n == 1) {
			return m;
		}
		int [][] m1;
		if (n % 2 == 1) {
			m1 = powerMatrix(m, (n-1)/2);
			return multiplyMatrix(m, multiplyMatrix(m1, m1));
		}
		m1 = powerMatrix(m, n/2);
		return multiplyMatrix(m1, m1);
	}
	
	/**
	 * Multiplies two matrixes
	 */
	public static int[][] multiplyMatrix(int[][] a, int[][] b) {
		int rowsA = a.length;
		int rowsB = b.length;
		int colsA = a[0].length;
		int colsB = b[0].length;
		int[][] c = new int[rowsA][colsB];
		for (int i = 0; i < rowsA; i++) {
			for (int j = 0; j < colsB; j++) {
				for(int k = 0; k < colsA; k++) {
					c[i][j] += a[i][k] * b[k][j];
				}
			}
		}
		return c;
	}
}
