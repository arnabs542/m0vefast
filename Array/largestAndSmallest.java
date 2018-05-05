public int[] largestAndSmallest(int[] arr) {
    // Write your solution here.
	int n = arr.length;
	//pair up(i, n-1-i), large put on the left, small put on the right
	for(int i = 0; i < n/2; i++){
		if(arr[i] < arr[n-1-i])
			swap(arr, i, n-1-i);
	}
    // The first element is the largest number,
    // the second element is the smallest number.
		//n = 1 large[0] small[0]
    //n = 5 large[0,1,2] small[2,3,4]
    //n = 4 large[0,1] small[2,3]
    return new int[]{largest(arr, 0, (n-1)/2), smallest(arr, n/2, n-1))};
}
private int largest(int[] arr, int left, int right){
	int largest = arr[left];
	for(int i = left+1; i <= right; i++){
		largest = Math.max(largest, arr[i]);
	}
	return largest;
}
private int smallest(int[] arr, int left, int right){
	int smallest = arr[left];
	for(int i = left+1; i <= right; i++){
		smallest = Math.min(smallest, arr[i]);
	}
	return smallest;
}

private void swap(int[] arr, int left, int right){
	int temp = arr[left];
	arr[left] = arr[right];
	arr[right] = temp;
}
