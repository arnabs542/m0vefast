public List<Integer> 3SumCloset(int[] array, int target){
  List<Integer> res = new ArrayList<>();
  Arrays.sort(array);
  res.add(array[0]);
  res.add(array[1]);
  res.add(array[2]);
  int minDiff = Integer.MAX_VALUE;
  for(int i = 0; i < array.length; i++){
    int j = i+1;
    int k = array.length-1;
    while (j < k){
      int sum = array[i] + array[j] + array[k];
      int diff = Math.abs(target - sum);
      if(diff == 0){
        res.set(0, array[i]);
        res.set(1, array[j]);
        res.set(2, array[k]);
        return res;
      }
      if(diff < minDiff){
        res.set(0, array[i]);
        res.set(1, array[j]);
        res.set(2, array[k]);
      }

      if(sum < target){
        j++;
      }else{
        k--;
      }
    }
    return res;
  }
}
