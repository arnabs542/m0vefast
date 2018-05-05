public int[] reorder(int[] array) {
 	if(array.length % 2 == 0)
 		helper(array, 0, arrary.length -1);
 	else //odd number: ignore the last one
 		helper(array, 0, array.length -2);
 	return array;
}
private void helper(int[] array, int left, int right){
	int size = right - left + 1;
	//base case
	if(size <= 2)
		return;
	//the importatn mid point
	int mid = left + size/2;
	int leftmid = left + size/4;
	int rightmid = left + size * 3/4;

	reverse(array, leftmid, mid-1);
	reverse(array, mid, rmid-1);
	reverse(array, leftmid, rightmid-1);
	helper(array, left, left + (leftmid-left)*2-1);
	helper(array, left + (leftmid - left)*2, right);
}
private void reverse(int[] array, int left, int right){
	while(left < right){
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
		left++;
		right--;
	}
}

123|4567 | abc| defg
123|7654 | cba| defg
123|abc | 4567| defg
