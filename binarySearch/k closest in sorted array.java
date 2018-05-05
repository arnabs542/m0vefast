public int[] kClosest(int[] arr, int target, int k){
	if(array == null || array.length == 0)
		return array;
	if(k == 0)
		return new int[0];
	//left is the index of the smallest/biggest element
	//left and right are closet to target
	int left = largestSmallestEqual(arr, target);
	int right = left + 1;
	int[] res = new int[k];
	for(int i = 0; i < k; i++){
		//merge if 1) right out of bound
		//				 2) left, right in bound, but arr[left] closer to target
		if(right >= array.length
		|| left >= 0 && target - arr[left] <= arr[right] - target)
			res[i] = arr[left--];
		else
			res[i] = arr[right++];
	}
	return res;
}
//find the largest smaller or equal element's index in the arr
//last occurance
private int largestSmallestEqual(int[] arr, int target){
	int left = 0;
	int right = arr.length - 1;
	while(left + 1 < right){
		int mid = left + (right - left)/2;
		if(arr[mid] <= target)
			left = mid;
		else
			right = mid;
	}
	//notice its <= here not ==
	//right can only be == to target, not smaller than target
	if(arr[right] == target)
		return right;
	if(arr[left] <= target)
		return left;
	return -1;
}
