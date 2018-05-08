public int smallerPairs(int[] array, int target) {
    // Write your solution here
    int left = 0, right = nums.length - 1;
            while(left < right){
                int sum = nums[left] + nums[right];
                // 如果三个数的和大于等于目标数，那将尾指针向左移
                if(sum >= target){
                    right--;
                // 如果三个数的和小于目标数，那将头指针向右移
                } else {
                    // right - left个组合都是小于目标数的
                    cnt += right - left;
                    left++;
                }
            }
  }


https://piazza.com/class/j0eqhhdregb3i?cid=1159

Arrays.sort(array);
int count = 0;
for(int i = 0; i < array.length; i++){
  int index = array.length-1;
  while(index > i && array[index] + array[i] >= target){
    index--;
  }
  count += (index - i);
}
return count;

排好序之后， 用for loop确定第一个数，然后用一个尾指针, 如果这两个数相加大于等于 target，
尾指针--，当sum小于target的时候，直接count＋=(index - i),
这是我写的code， 但这样的话worst case不还是O(n^2)吗？
