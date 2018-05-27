//https://www.programcreek.com/2014/06/leetcode-trapping-rain-water-java/
public int waterTrap(int[] arr){
  int res =0;
  int left = 0;
  int right = arr.length-1;
  int leftMax = 0;  //scan from left
  int rightMax = 0;   //scan from right
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
//https://www.programcreek.com/2014/03/leetcode-container-with-most-water-java/
public int maxArea(int[] height) {
	if (height == null || height.length < 2) {
		return 0;
	}

	int max = 0;
	int left = 0;
	int right = height.length - 1;

	while (left < right) {
		max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
		if (height[left] < height[right])
			left++;
		else
			right--;
	}

	return max;
}
