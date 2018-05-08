//Return the difference between the sum of the two integers and the target.
//return 2 numbers
public List<Integer> 2Sumclosest(int[] array, int target) {
  List<Integer> res = new ArrayList<>();
  int minDiff = Integer.MAX_VALUE;
  int left = 0;
  int right = array.length-1;
  while(left < right){
    int sum = array[left] + array[right];
    int diff = Math.abs(target - sum);
    if(diff == 0)
      return res;
    if(sum < target){
      left++;
    }else{
      right--;
    }
  }
  return res;
}
