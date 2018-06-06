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
        //when long[i] > long[j] + 1   ==>> 2345067, long=1,2,3,4,1,5!,6
        //when long[i] > long[j] + 1   ==>> 2345367, long=1,2,3,4,2,5!,6
        long[i] = Math.max(long[j] + 1, long[i]);
      }
    }
    gloablMax = Math.max(long[i], gloablMax);
  }
  return gloablMax;

}

//solution2: O(nlgn)
public int longestAcesdingSubSequence(int[] arr){

}
