//{1} --> {1}
//{1, 0, 3, 0, 1} --> {1, 3, 1, 0, 0}
反向而行, 需要keep element order, quicksort
public int[] moveZero2(int[] arr){
	if(arr.length <= 1)
		return arr;
	int slow = 0;
	int fast;
	for(fast = 0; fast < arr.length; fast++){
		if(arr[fast] != 0)
			arr[slow++] = arr[fast];
	}
	for(int i = slow; i < arr.length; i++){
		arr[i] = 0;
	}
	return arr;
}



//{1} --> {1}
//{1, 0, 3, 0, 1} --> {1, 3, 1, 0, 0}
反向而行, 不需要keep element order, quicksort
//solution1:
public int[] moveZero(int[] arr){
	if(arr == null || arr.length <= 1)
		return arr;
	int left = 0;
	int right = arr.length -1;
	while(left <= right){
		if(arr[left] != 0)
			left++;
		else if(arr[right] == 0)
			right--;
		else
			swap(arr, left++, right
				}
	return arr;
}
//solution2:
public int[] moveZero(int[] arr){
	int n = arr.length;
	int count = 0;
	for(int i = 0; i < n; i++){
		if(arr[i] != 0)
			arr[count++] = a[i];
	}
	while(count < n)
		arr[count++] = 0;
	// for(int i = slow; i < arr.length; i++){
	// 	arr[i] = 0;
	// }
	return arr;
}