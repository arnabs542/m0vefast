//https://www.programcreek.com/2014/06/leetcode-trapping-rain-water-java/
public int waterTrap(int[] arr){
  int res =0;
  int left = 0;
  int right = arr.length-1;
  int leftMaxHeight = 0;  //scan from left
  int rightMaxHeight = 0;   //scan from right
  while(left <= right){
    leftMaxHeight = Math.max(leftMaxHeight, arr[left]);
    rightMaxHeight = Math.max(rightMaxHeight, arr[right]);
    if(leftMaxHeight < rightMaxHeight){
      res += (leftMaxHeightftMax - arr[left]);
      left++;
    }else{
      res += (rightMaxHeight - arr[right]);
      right--;
    }
  }
  return res;
}
//solution2
//can also use dp to keep 2 arr
// [m1] from left to right, the height number in arr
// [m1] from right to left, the height number in arr
// input:
// loop: res = Math.max(Math.min(m1, m2) - input[i])

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
