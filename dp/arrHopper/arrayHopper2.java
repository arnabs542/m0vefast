//Determine the minimum number of jumps you need to reach the end of array.
//Return -1 if you can not do so.
//If you can not reach the end of the array, return -1.
//minSteptoRight
public int canJump(int[] array){
  int[] dp = new int[array.length];
  for(int i = 1; i < array.length; i++){
    //dp record the min jumps form 0 to each of the index
    dp[0] = 0;
    for(int j = 0; j < i; j++){
      // if (array[j] + j >= array.length) {
      //   return dp[j] + 1;
      dp[I] = -1; //initialize as unreablable
      if(array[j] + j >= i && dp[j] != -1){
        if(dp[i] > dp[j] + 1 || dp[i] == -1){
          dp[i] = dp[j]+1;
        }
      }
    }
  }
  return dp[dp.length-1];
}

{3, 3, 1, 0, 4}, the minimum jumps needed is 2 (jump to index 1 then to the end of array)
{2, 1, 1, 0, 2}, you are not able to reach the end of array, return -1 in this case.
