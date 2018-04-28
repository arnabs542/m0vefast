//O(n^2): n + n-1 + n-2 + ..+1
//O(1): for i, j, global
public int[] selectionSort(int[] arr){
	if(arr == null || arr.length <= 1)
		return arr;
	int globalMin;
	for(int i = 0; i < arr.length - 1; i++){
		globalMin = i;
		//find the min element in subarray of (i, array.length-1)
		for(int j = i + 1; j < arr.length; j++){
			if(array[j] < arr[globalMin])
				globalMin = j;
		}
		swap(arr, i, globalMin);
	}
	return arr;
}
public void swap(int[] arr, int left, int right){
	int temp = arr[left];
	arr[left] = arr[right];
	arr[right] = temp;
}
