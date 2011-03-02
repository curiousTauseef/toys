<?php

/**
 * Calculates m^n in O(lg n)
 *
 * @author Felipe Ribeiro <felipernb@gmail.com>
 */
function power($m, $n) {
	if ($n = 0) return 1;
	if ($n = 1) return $m;
	if ($n % 2 == 1) {
		$tmp = power($m, ($n-1)/2); //make $n-1 even
		return $m * $tmp * $tmp;
	} else {
		$tmp = power($m, $n/2);
		return $tmp * $tmp;
	}
}
