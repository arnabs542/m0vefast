//solution logk https://www.programcreek.com/2012/12/leetcode-median-of-two-sorted-arrays-java/
public int kSmallest2SortedArr(int[] a, int[] b, int k){
  return helper(a, 0, b, 0, k);
}
private int helper(int[] a, int aleft, int[] b, int bleft, int k){
  //base case
  if(aleft >= a.length)
    return b[bleft+k/2-1];
  if(bleft >= b.length)
    return a[aleft+k/2-1];
  if(k == 1)
    return Math.min(a[aleft], b[bleft]);
  int ak = aleft+k/2-1 < a.length ? a[aleft+k/2-1]:Integer.MAX_VALUE;
  int bk = bleft+k/2-1 < b.length ? b[bleft+k/2-1]:Integer.MAX_VALUE;
  if (ak < bk){
    return helper(a, aleft+k/2, b, bleft, k-k/2);
  }
  return helper(a, aleft, b, bleft+k/2, k-k/2);
}



//solution k https://www.geeksforgeeks.org/median-of-two-sorted-arrays/
