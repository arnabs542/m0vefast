public void shuffle(int[] arr){
	if(arr.length <= 1)
		return;
	for(int i = arr.length; i >= 1; i--){
		//Math.random() returns a number in[0,1)
		int index = (int)(Math.random() * i);
		swap(arr, i-1, index);
	}
}
private void swap(int[] arr, int left, int right){
	int temp = arr[left];
	arr[left] = arr[right];
	arr[right] = temp;
}