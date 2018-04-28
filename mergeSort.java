public int[] mergeSort(int[] arr){
	if(arr == null || arr.length <= 1)
		return arr;
	int[] temp = new int[arr.length];
	divide(arr, temp, 0, arr.length-1);
	return arr;
}
private void divide(int[] arr, int[] temp, int left, int right){
	if(left >= right)
		return;
	int mid = left + (right - left)/2;
	divide(arr, temp, left, mid);
	divide(arr, temp, mid+1, right);
	merge(arr, temp, left, mid, right);
}
private void merge(int[] arr, int[] temp, int left, int mid, int right){
	//copy element at their index on temp and merge temp
	for(int i = left; i <= right; i++){
		temp[i] = arr[i];
	int leftIndex = left;
	int rightIndex = mid+1;
	while(leftIndex <= mid && rightIndex <= right){
		if(temp[leftIndex] <= temp[rightIndex])
			arr[left++] = temp[leftIndex++];
		else
			arr[left++] = temp[rightIndex++];
	}
	//if still have some elements on the left side, we need to copy them
	while(leftIndex <= mid)
		arr[left++] = temp[leftIndex++];
	}
	//if still have some elements on the left side, we dont need to copy them
	//since they are already there in the first for-loop
}
