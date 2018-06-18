//{1} --> {1}
//{1, 0, 3, 0, 1} --> {1, 3, 1, 0, 0}
反向而行, 需要keep element order, quicksort
public int[] moveZero2(int[] arr){
	if(arr.length <= 1)
		return arr;
	int slow = 0;  //not included in the non-zero subarr
	int fast = 0;
	for(fast = 0; fast < arr.length; fast++){
		if(arr[fast] != 0)
			arr[slow++] = arr[fast];
	}
	//fill in right part with 0
	for(int i = slow; i < arr.length; i++){
		arr[i] = 0;
	}
	return arr;
}



