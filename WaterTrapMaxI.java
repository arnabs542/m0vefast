public int waterTrap(int[] arr){
  int res =0;
  int left = 0;
  int right = arr.length-1;
  int leftMax = 0;
  int rightMax = 0;
  while(left <= right){
    leftMax = Math.max(leftMax, arr[left]);
    rightMax = Math.max(rightMax, arr[right]);
    if(leftMax < rightMax){
      res += (leftMax - arr[left]);
      left++;
    }else{
      res += (rightMax - arr[right]);
      right--;
    }
  }
  return res;
}
