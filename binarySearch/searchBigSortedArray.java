public int searchBigSortedArray(ArrayReaer reader, int target){
	if(reader == null)
		return -1;
	int i = 1;
	while(reader.get(i-1) != null && reader.get(i-1) < target)
		i = i * 2;
	int left = 0;
	int right = i-1;
	while(left + 1 < right){
		int mid = left + (right - left)/2;
		if(reader.get(mid) == target)
			right = mid;
		if(reader.get(mid) < target)
			left = mid;
		else
			right = mid;
	}
	if(reader.get(left) == target)
		return left;
	if(reader.get(right) == target)
		return right;
	return -1;
}