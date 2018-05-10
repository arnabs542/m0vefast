//Q0: remove duplicate white space
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
