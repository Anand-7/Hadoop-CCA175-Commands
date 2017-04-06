class For_Loop(start: Int, end: Int){
	require(start < end,"Error.Start cannot be greater than end")

	val l = (start to end).toList
	var total = 0
	for(value <- l){
		total += value
	}
	println(total)
}
