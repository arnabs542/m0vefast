//solution1: O(n^2)
public int longestAcesdingSubSequence(int[] arr){
  if(arr.length == 0)
    return 0;
  int[] long = new int[arr.length];
  int gloablMax = 1;
  for(int i = 0; i < arr.length; i++){
    long[i] = 1;
    for(int j = 0; j < i; j++){
      if(arr[j] < arr[i]){
        //when long[i] > long[j] + 1   ==>> 2345067, long[0]+1 < long[]
        long[i] = Math.max(long[j] + 1, long[i]);
      }
    }
    res = Math.max(long[i], gloablMax);
  }
  return gloablMax;

}

//solution2: O(nlgn)
public int longestAcesdingSubSequence(int[] arr){

}
