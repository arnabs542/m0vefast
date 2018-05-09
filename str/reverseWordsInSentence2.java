//with heading or ending white spaces
//no duplicate white space
//“ I  love  Google  ” → “Google love I”
public String remove(String input){

}

public String reverseWords(String input) {
    // Write your solution here
    if(input.length() <= 1)
      return input;
    String res = removeSpaces(input);
    char[] arr = res.toCharArray();
    reverse(arr, 0, arr.length-1);
    return new String(arr);

  }
  private void reverse(char[] arr, int left, int right){
    while(left < right){
      swap(arr, left, right);
      reverse(arr, left + 1, right-1);
    }
  }
  private void swap(char[] arr, int left, int right){
  	char temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
  }

  private String removeSpaces(String input) {
	if(input == null || input.length() == 0)
		return input;
	char[] arr = input.toCharArray();
	int slow = 0;
	for(int fast = 0; fast < arr.length; fast++){
		//igore consecutive ' '
		//ignore first ' '
		if(arr[fast] == ' ' && (fast == 0 || arr[fast-1] == ' '))
			continue;
		else
			arr[slow++] = arr[fast];
	}
	//ignore last ' ', not catched in the for loop
	if(slow > 0 && arr[slow-1] == ' ')
		return new String(arr, 0, slow-1);
	return new String(arr, 0, slow);
}




//remvoe heading/ending/duplciate spaces
//" I   love TV" -> "I love TV"
public String removeSpaces(String input) {
	if(input == null || input.length() == 0)
		return input
	char[] arr = input.toCharArray();
	int slow = 0;
	for(int fast = 0; fast < arr.length; fast++){
		//igore consecutive ' '
		//ignore first ' '
		if(arr[fast] == ' ' && (fast == 0 || arr[fast-1] == ' '))
			continue;
		else
			arr[slow++] = arr[fast];
	}
	//ignore last ' ', not catched in the for loop
	if(slow > 0 && arr[slow-1] == ' ')
		return new String(arr, 0, slow-1);
	return new String(arr, 0, slow);
}
