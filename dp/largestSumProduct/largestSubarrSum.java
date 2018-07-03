//solution1: O(n), O(n)
// base case: m[0] = input[0]
// induction rule: m[i]: from 0th - ith element, the value of the largest sum of the subarr including the ith element
//                       m[i] = m[i-1] + input[i] if m[i-1] >= 0
//                       m[i] = input[i]          otherwise

//optimize space to O(1)
public int subArrSum(int[] arr){
  if(arr == null || arr.length < 1){
    return 0;
  }
  int gloablMax = Integer.MIN_VALUE;
  int localMax = arr[0];
  for(int i = 1; i < arr.length; i++){
    localMax = Math.max(arr[i], arr[i] + localMax);
    gloablMax = Math.max(gloablMax, localMax);
  }
  return gloablMax;
}
//how to return the left-right border of the solution
public int[] largestSum(int[] arr){
  int localMax = arr[0];
  int globalMax = Integer.MIN_VALUE;
  int start = 0;
  int end = 0;
  int[] sol = new int[2];
  for(int i = 1; i < arr.length; i++){
    if(localMax > 0){
      localMax = localMax+arr[i];
      end++;
    }else{
      localMax = arr[i];
      start = i;
      end = i;
    }
    if(localMax > globalMax){
      globalMax = localMax;
      sol[0] = start;
      sol[1] = end;
    }
  }
  return sol;
}
