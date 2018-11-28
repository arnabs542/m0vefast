//solution1: O(n^2)
public int longestAcesdingSubSequence(int[] arr){
  if(arr.length == 0)
    return 0;
  int[] long = new int[arr.length]; //till cur index, the result length
  int gloablMax = 1;
  for(int i = 0; i < arr.length; i++){
    long[i] = 1;  //+1 and then compare
    for(int j = 0; j < i; j++){
      //arr[] and long[] are different concept
      if(arr[j] < arr[i]){
        //arr=2343,5,067, long=1232,4,156
        long[i] = Math.max(long[j] + 1, long[i]);
      }
    }
    gloablMax = Math.max(long[i], gloablMax);
  }
  return gloablMax;

}

//solution0: O(nlgn)
//https://yanjia.me/zh/2018/11/05/70/
//https://leetcode.com/problems/longest-increasing-subsequence/discuss/74824/JavaPython-Binary-search-O(nlogn)-time-with-explanation
public int longestIncreasingSubsequence(int[] nums) {
    // write your code here
    if(nums.length == 0){
        return 0;
    }
    // len表示当前最长的升序序列长度（为了方便操作tails我们减1）
    int len = 0;
    // tails[i]表示长度为i的升序序列其末尾的数字
    int[] tails = new int[nums.length];
    tails[0] = nums[0];
    // 根据三种情况更新不同升序序列的集合
    for(int i = 1; i < nums.length; i++){
        if(nums[i] < tails[0]){
            tails[0] = nums[i];
        } else if (nums[i] >= tails[len]){
            tails[++len] = nums[i];
        } else {
        // 如果在中间，则二分搜索   tails[len-1] < nums[i] < tails[len]
            tails[binarySearch(tails, 0, len, nums[i])] = nums[i];
        }
    }
    return len + 1;
}

private int binarySearch(int[] tails, int min, int max, int target){
    while(min <= max){
        int mid = min + (max - min) / 2;
        if(tails[mid] == target){
            return mid;
        }
        if(tails[mid] < target){
            min = mid + 1;
        }
        if(tails[mid] > target){
            max = mid - 1;
        }
    }
    return min;
}
