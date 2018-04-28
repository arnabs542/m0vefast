public int percentile95(List<Integer> lengths) {
	int[] counter = new int[4097]; //each index = lenght of url, value[index] = counter
	for(int length : lengths)
		count[length]++;
	int countsSoFar = 0;
	int cur_length = 4097;
	while(countsSoFar <= 0.05 * lengths.size())
		countsSoFar += counter[--cur_length];
	return cur_length;
}