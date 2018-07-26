//sorted no duplicate, using binary search
public int missing2(int[] array) {
  int left = 0;
  int right = array.length-1;
  //corner case: if empty
  if(array.length == 0){
    return 1;
  }
  //corner case2: if missing the last number
  if(array[right] == right + 1){
    return array[right] + 1;
  }
  while(left < right){
    int mid = left + (right-left)/2;
    if(array[mid] <= mid+1)
      left = mid+1;
    else
      right = mid;
  }
  //out of search space
  //return array[left]-1;
  //left = right
  return array[right]-1;
}

//124
left=0
right=2
mid=1
left=2
  //if numebr starting from 0, then target is mid not mid+1
public int findMissing(int[] arr){
  int left = 0;
  int right = arr.length-1;
  //edge cases:
  if(arr == null){
    return -1;
  }
  //missing first one and empty arr: covered
  //missing last one
  if(arr[right] == right){
    return right+1;
  }
  //normal case:
  while(left<right){
    int mid = left + (right - left)/2;
    if(arr[mid] <= mid){
      left = mid+1;
    }else{
      right = mid;  
    }
  }
  return left;
}
