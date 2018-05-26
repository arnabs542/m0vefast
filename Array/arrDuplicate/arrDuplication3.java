//{1, 2, 2, 3, 3, 3} → {1}
//同向运动
//solution1: slow(including slow) are final results to return
public int[] arrDup3(int[] arr) {
    // Write your solution here.
    if(arr.length <= 1)
    	return arr;
    int slow = 0;
    int fast;
    boolean flag = false; //track to see if any duplicate
    for(fast = 1; fast < arr.length; fast++){
    	if(arr[slow] == arr[fast])
    		flag = true;
    	else if(flag == true){  //overlap with new element
    		arr[slow] = arr[fast];
    		flag = false;
    	}else{
    		arr[++slow] = arr[fast];
    	}
    }
    return flag? slow : slow+1;
    //return Arrays.copyOf(arr, slow+1);
}
public int[] arrDup3(int[] arr){
  if(arr == null || arr.length<= 1){
    return arr;
  }
  int fast = 0;
  int slow = 0;
  while(fast < arr.length){
    int begin = fast;
    while(fast < arr.length && arr[fast] == arr[begin]){
      fast++;
    }
    //if no duplicate, didnt skip the memeber
    if(fast - begin == 1){
      arr[slow++] = arr[begin];
    }
  }
  return arr;
}
