//{1, 2, 3, 3, 3, 2, 2} → {1, 2, 2, 2} → {1}, return {1}
//同向运动
//solution1: slow(including slow) are final results to return
public int[] arrDup4(int[] arr) {
    //stack: push the stack if stack is empty or element is != stack top(slow)
    //stack: otherwise, ignore consecutive element and remove top stack element
    int slow = -1;
    int fast = 0;
    for(fast = 0; fast < arr.length; fast++){
    	if(slow == -1 || arr[slow] != arr[fast])
    		arr[++slow] = arr[fast];
    	else{
    		while(fast + 1 < arr.length && arr[fast+1] == arr[slow])
    			fast++;
    		slow--;  //arr[slow] = arr[fast]
    	}
    }
    return Arrays.copyOf(arr, slow+1);
}


//Q5: same as zuma
//"abbbaaccz" → "aaaccz" → "ccz" → "z"
//"aabccdc" → "bccdc" → "bdc"
public String deDup(String input) {
	if(input == null || input.length() <=1)
		return input;
	char[] arr = input.toCharArray();
	int slow = 0;  //stack top ptr
	for(int fast = 1; fast < arr.length; fast++){
		//slow = -1, stack is empty
		//or when no duplicate, we push on to the stack
		//only looks at next one
		if(slow == -1 || arr[fast] != arr[slow])
			arr[++slow] = arr[fast];
		else{
			//otherwise, pop the element at index cur
			slow--;  //this might cause cur = -1, cur stays at latest char index
			while(fast+1 < arr.length && arr[fast] == arr[fast+1])
				fast++;
		}
	}
	return new String(arr, 0, slow+1);
}
