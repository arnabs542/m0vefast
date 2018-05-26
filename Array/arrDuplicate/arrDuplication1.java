//{1, 2, 2, 3, 3, 3} → {1, 2, 3}
//同向运动
//solution1: slow(including slow) are final results to return
public int[] arrDup1(int[] arr) {
    // Write your solution here.
    if(arr.length <= 1)
    	return arr;
    int slow = 0;
    int fast;
    for(fast = 1; fast < arr.length; fast++){
    	if(arr[fast] != arr[slow])
    		arr[++slow] = arr[fast];
    }
    return slow+1;  //length of the after arr
    //return Arrays.copyOf(arr, slow+1);
}

//solution2: slow(not including slow) are final results to return
public int[] arrDup1(int[] arr) {
    // Write your solution here.
    if(arr.length <= 1)
    	return arr;
    int slow = 1;
    int fast = 1;
    for(fast = 1; fast < arr.length; fast++){
      if(arr[fast] == array[slow-1]){
        continue;
      }
      arr[slow++] = arr[fast];
    }
    return slow;

    //return Arrays.copyOf(arr, slow+1);
}
