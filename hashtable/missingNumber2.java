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
