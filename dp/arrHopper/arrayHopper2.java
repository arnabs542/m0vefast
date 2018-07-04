//Determine the minimum number of jumps you need to reach the end of array.
//Return -1 if you can not do so.
//If you can not reach the end of the array, return -1.
//minSteptoRight
public int canJump(int[] array){
  int[] dp = new int[array.length+1];
  for(int i = 1; i <= array.length; i++){
    dp[0] = -1;
    for(int j = i-1; j>= 0; j--){
      if (array[j] + j >= array.length) {
        return dp[j] + 1;
      if(dp[j] + j >= i && dp[j] != -1){
        if(dp[i] > dp[j] + 1 || dp[i] == -1){
          dp[i] = dp[j]+1;
        }
      }
    }
  }
  return dp[dp.length-1] + 1;
}

{3, 3, 1, 0, 4}, the minimum jumps needed is 2 (jump to index 1 then to the end of array)
{2, 1, 1, 0, 2}, you are not able to reach the end of array, return -1 in this case.
