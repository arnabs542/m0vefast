public int[] quickSort(int[] arr){
	if(arr == null)
		return arr;
	quickSort(arr, 0, arr.length-1);
	return arr;
}
private void quickSort(int[] arr, int left, int right){
	if(left >= right)  //only one element left in left/right part
		return;
	//pivot in right place
	int pivotIndex = partition(arr, left, right);
	//recursive call on left and right, not including pivot
	quickSort(arr, left, pivotIndex-1);
	quickSort(arr, pivotIndex+1, right);
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
			swap(arr, i, j--);  //swap and  --
	}
	swap(arr, i, right);   //swap pivot and i
	return i;
}
//or while loop
while(i <= j){
			if(arr[i] < pivot){
				i++;
			}else if(arr[j] >  pivot){
				j--;
			}else{
				swap(arr, i, j--);
			}
	 }
	 swap(arr, pivot_index, i);
	 return i;

 }
private int randomIndex(int left, int, right){
	return left + (int)(Math.random() * (right-left+1));
}
