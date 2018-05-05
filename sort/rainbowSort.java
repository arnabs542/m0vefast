//0000 left 111 i??? right 2222
// 3 numbers 
public void rainbowSort(int[] arr){
	if(arr == null || arr.length <= 1)
		return;
	int left = 0;
	int right = arr.length -1;
	int i = 0;
	while(i <= right){
		if(arr[i] == 0){
			swap(arr, left++, i++);
			// left++;
			// i++;
		}else if(arr[i] == 1){
			i++;
		}else{
			swap(arr, right--, i);
			//right--;
		}
	}
}
