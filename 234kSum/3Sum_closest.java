public List<Integer> 3SumCloset(int[] array, int target){
  List<Integer> res = new ArrayList<>();
  int minDiff = Integer.MAX_VALUE;
  for(int i = 0; i < array.length; i++){
    int j = i+1;
    int k = array.length-1;
    while (j < k){
      int sum = array[i] + array[j] + array[k];
      int diff = Math.abs(target - sum);
      if(diff == 0)
        return sum;
      if(sum < target){
        j++;
      }else{
        k--;
      }
    }
    return res;
  }
}
