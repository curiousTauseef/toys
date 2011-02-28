<?php

/*
 * Implementing integer division without division operator
 * @author Felipe Ribeiro <felipernb@gmail.com>
 */
function division($dividend, $divisor) {

	if ($divisor == $dividend) {
		return 1;
	} else if ($dividend < $divisor) {
		return 0;
	}

	$quotient = 1;

	while ($divisor*$quotient <= $dividend) {
		$quotient = $quotient << 1;
	}

	/* quotient * divisor > $dividend */
	$quotient = $quotient >> 1;

	/* Call division recursively for the difference to get the
	 exact quotient */
	$quotient = $quotient + division($dividend - $divisor*$quotient, $divisor);

	return $quotient;
}


$in = fopen('php://stdin', 'r');
while (($dividend = (int)fgets($in))) {
	$divisor = (int)fgets($in);
	$division = division($dividend,$divisor);
	//validates correctness
	assert($division == floor($dividend/$divisor));
	echo $division	. "\n";
}
