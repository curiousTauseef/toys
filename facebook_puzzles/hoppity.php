<?php

function hoppity($n) {
	for ($i = 1; $i <= $n; $i++) {
		$iMod5 = $i % 5;
		$iMod3 = $i % 3;
		if ($iMod3 == 0 || $iMod5 == 0) {
			echo "Hop";

			if ($iMod5 == 0 ^ $iMod3 == 0) {
				if ($iMod5 == 0) echo "hop";
				if ($iMod3 == 0) echo "pity";
			}
			echo "\n";
		} 
	}
}

$in = fopen ("php://stdin","r");

while( ($line = trim(fgets($in)))) {
	hoppity($line);
}
