<?php

$mapped_words = array();

function emit($k, $v) {
	global $mapped_words;
	array_push($mapped_words,array($k, $v));
}

function map($text) {
	array_map( function($word) { emit(preg_replace("/[^a-z]/","",strtolower($word)),1);}, explode(" ",$text));
}

function reduce($word) {
	global $mapped_words;
	return array_reduce($mapped_words, 
						function ($result, $w) use ($word) { 
							if($w[0] == $word) $result += $w[1]; 
							return $result;
						});
}

$text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam pellentesque metus at arcu sollicitudin fermentum. Morbi mattis ornare accumsan. Curabitur nec enim urna, malesuada pretium neque. Donec in eros quis dui ultrices ullamcorper vitae vitae dolor. Donec lacinia orci nec justo cursus sed imperdiet magna pharetra. Morbi pellentesque neque id odio elementum volutpat. Donec tincidunt, metus ut molestie dignissim, lacus tortor malesuada nisi, non vestibulum ante mauris quis dolor. Nullam magna ipsum, accumsan non posuere ornare, sagittis non ipsum. Aliquam erat volutpat. Suspendisse purus magna, pharetra pulvinar tempus nec, porttitor eu mauris. Etiam fringilla, quam vitae cursus tincidunt, lorem est sodales nisl, nec eleifend nibh odio eu augue. Etiam consectetur purus turpis. Duis ut nisi lectus, at commodo mi. Aenean sit amet est lacus. Phasellus urna urna, pulvinar vitae egestas id, iaculis quis ipsum. Proin non augue non nisl rhoncus volutpat. Curabitur sed varius justo. Mauris congue rutrum nullam.";

map($text);
echo reduce("non"),"\n";
echo reduce("lorem"),"\n";
echo reduce("ipsum"),"\n";
