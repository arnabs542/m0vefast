//{1, 2, 2, 3, 3, 3} → {1, 2, 2, 3, 3}   //keep two copy
//同向运动
//solution1: slow(including slow) are final results to return
public int[] arrDup2(int[] arr) {
    // Write your solution here.
    if(arr.length <= 1)
    	return arr;
    int slow = 0;
    int fast;
    int counter = 0;
    for(fast = 1; fast < arr.length; fast++){
    	//fast = slow
    	if(arr[fast] == arr[slow]){
    		if(counter < 2){
    			counter++;
    			arr[++slow] = arr[fast];
    		}
    	//fast != slow
    	}else{
    		counter = 1;
    		arr[++slow] = arr[fast];
    	}
    //return slow+1;  //length of the after arr
    return Arrays.copyOf(arr, slow+1);
}

//solution2: slow(not including slow) are final results to return
ppublic int[] arrDup2(int[] arr) {
    // Write your solution here.
    if(arr.length <= 1)
    	return arr;
    int slow = 2;
    int fast = 2;
    for(fast = 2; fast < arr.length; fast++){
      if(arr[fast] == arr[slow-2]){
        continue;
      }
      arr[slow++] = arr[fast];
    }

    return slow;  //length of the after arr
    //return Arrays.copyOf(arr, slow+1);
}
