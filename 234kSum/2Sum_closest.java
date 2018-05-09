//Return the difference between the sum of the two integers and the target.
//return 2 numbers
public List<Integer> 2Sumclosest(int[] array, int target) {
  int left = 0;
  int right = array.length-1;
  List<Integer> res = new ArrayList<>();
  res.add(array[left]);
  res.add(array[right]);
  Arrays.sort(array);

  if(array.length == 2){
      res.add(array[0]);
      res.add(array[1]);
      return res;
  }

  int min_diff = Integer.MAX_VALUE;

  while(left < right){
      int sum = array[left] + array[right];
      int diff = Math.abs(sum - target);

      if(diff == 0){
        //set function used after list.add()
          res.set(0, array[left]);
          res.set(1, array[right]);
          return res;
      }

      if(diff < min_diff){
          min_diff = diff;
          res.set(0, array[left]);
          res.set(1, array[right]);
      }

      if(sum > target){
          right--;
      }else{
          left++;
      }
  }
  return res;
}
