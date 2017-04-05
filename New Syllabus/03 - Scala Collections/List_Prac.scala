class List_Prac(start: Int, end: Int){
	require(start < end,"Error.Start cannot be greater than end")

	var l = (start to end).toList

	println("First element of list: " + l.head)
	println("Last element of list: " + l.last)
	println("Size of list: " + l.size)
	println("First 6 elements of list: " + l.take(6))
	println("First 9 elements of list: " + l.take(9))
	println("Last 3 elements of list: " + l.reverse.take(3))
	println("Last 9 elements of list: " + l.reverse.take(9))
	println("List contains 7: " + l.contains(7))
	l = 0 :: l
	println("List after adding 0 to head of the list: " + l)
	var m = (11 to 15).toList
	l = l ++ m
	println("List after appending another list(m) to the initial list: " + l)
}