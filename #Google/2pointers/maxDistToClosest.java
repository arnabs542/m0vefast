//https://massivealgorithms.blogspot.com/search?q=Maximize+Distance+to+Closest+Person
// looks lika a DP optimization problem : continuous 0 in prefix, aournd, suffix
// prefix: continuous 0 from the begining
// around: continuous 0 in the middle (not starting from the first and last index
// suffix: continuou 0 ending at the last index of the array
public int maxDistToClosest(int[] seats) {
  //i is the seat = 1, right pointer
  //j is the first empty seat of a continuous block of 0s
  int j = 0;
  int res = 0;
  for(int i = 0; i < seats.length; i++){
    //prefix
    if(searts[0] == 1){
      res = Math.max(res, i - j);
    }else{  //middle block
      res = Math.max(res, (i - j + 1) /2);
    }
    j = i + 1;
  }
  //suffix
  res = Math.max(res, n - j);
  return res;
}
