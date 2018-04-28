//iterative
public String reverse(String input) {
	if(input == null || input.length() <= 1)
		return input;
	char[] arr = input.toCharArray();
	int mirror = arr.length-1;
	for(int i = 0; i < n/2; i++){
		char temp = arr[i];
		arr[i] = arr[mirror-i];
		arr[mirror-i] = temp;
	}
	return new String(arr);
	//toString() only works for Object: stringBuilder, Integer....
}
//recursive
public String reverse(String input){
	if(input == null || input.length() <= 1)
		return input;
	char[] arr = input.toCharArray();
	reverseHelper(arr, 0, arr.length -1);
	return arr;
}
private void reverseHelper(char[] arr, int left, int right){
	//base case
	if(left >= right)
		return;
	//recursive rule
	swap(arr, left, right);
	reverseHelper(arr, left+1, right-1);
}
