//{1} --> {1}
//{1, 0, 3, 0, 1} --> {1, 3, 1, 0, 0}
反向而行, 不需要keep element order, quicksort
//solution1:   relative order
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
			swap(arr, left++, right--);
	return arr;
}
