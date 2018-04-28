public int[] quickSort(int[] arr){
	if(arr == null)
		return arr;
	helper(arr, 0, arr.length-1);
	return arr;
}
private void helper(int[] arr, int left, int right){
	if(left >= right)
		return;
	//pivot in right place
	int pivot = partition(arr, left, right);
	//recursive call on left and right, not including pivot
	helper(arr, left, pivot-1);
	helper(arr, pivot+1, right);
}
private int partition(int[] arr, int left, int right){
	int pivotIndex = randomIndex(left, right);
	int pivot = arr[pivotIndex];
	//pivot in the rightMost
	swap(arr, pivotIndex, right);
	int i = left;     //leftBound
	int j = right-1;  //rightBound
	while(i <= j){
		if(arr[i] < pivot)
			i++;
		else if(arr[j] >= pivot)
			j--;
		else
			swap(arr, i++, j--);  //swap and ++ --
	}
	swap(arr, i, right);   //swap pivot and i
	return i;
}
private int randomIndex(int left, int, right){
	return left + (int)(Math.random() * (right-left+1));
}
