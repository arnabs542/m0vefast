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
			swap(arr, left, right--);
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
	return arr;
}
