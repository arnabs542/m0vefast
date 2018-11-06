//longest common substring 2D
base case:m[0][0] = 0, edge with 0
induction rule:longes common substr between first i and first j, including i and j
m[i] = m[i-1][j-1] + 1     if j = j the same
     = 0                   if i j not equal
     int[][] common = new int[aa.length+1][bb.length+1];
     for(int i = 1; i <= aa.length; i++){
       for(int j = 1; j <= bb.length; j++){
           if(aa[i] != bb[j]){
           //do nothign
           }else{
             common[i][j] = common[i-1][j-1]+1;
           }
         }
         if(common[i][j] > len){
           len = common[i][j];
           start = i - len + 1;
         }
       }
     }
     //substirng(startindex, endindex)
     return a.substring(start, start+len);

//longest common subsequence 2D
base case: m[0][0] = 0,edge with 0
induction rule:longes common substr between first i and first j, might not including ith and jth
m[i] = m[i-1][j-1] + 1                if j = j the same
     = max(m[i-1][j], m[i][j-1])      if i j not equal

     int[][] res = new int[alen+1][blen+1];

     for(int i = 1; i <= alen; i++){
       for(int j = 1; j <= blen; j++){
         if(a.charAt(i-1) != b.charAt(j-1)){
           res[i][j] = Math.max(res[i-1][j], res[i][j-1]);
         }else{
           res[i][j] = res[i-1][j-1]+1;
         }
       }
     }
     return res[alen][blen];
     }
//longest assending substring 1D
base case: m[0] = 1
induction rule:longes assending subarr from 0 to ith element, including ith
m[i] = m[i-1] +1              if increaseing
    = 1                          ow
    public int findLengthOfLCIS(int[] arr) {
            if(arr == null ||arr.length == 0)
                return 0;
            int[] dp = new int[arr.length];
            int globalmax = 1;
            //base case
            dp[0] = 1;
            //induction rule
            for(int i = 1; i < arr.length; i++){
                dp[i] = 1;
                if(arr[i] > arr[i-1]){
                    dp[i] = dp[i-1]+1;
                    globalmax = Math.max(globalmax, dp[i]);
                }
            }
            return globalmax;
        }
//longest assending subsequence 1D
base case: m[0] = 1
induction rule:longes assending subsequence from 0 to ith element, including ith
m[i] = max(m[j]+1, m[i])     if increaseing all j < i
     = 1                     ow
public int longestAssendingSubSequence(int[] arr){
  int[] dp = new int[arr.length];
  int globalmax = 1;
  //base case
  dp[0] = 1;
  //induction rule
  for(int i = 0; i < arr.length; i++{
      dp[i] = 1;
      for(int j = 0; j < i; j++){
        if(arr[i] > arr[j])
          dp[i] = Math.max(dp[j]+1, dp[i]);
      }
      globalmax = Math.max(global_max, dp[i]);
  }
  return globalmax;
}
//max subarr sum 东山再起
//base case  dp[0] = arr[0];
localmax = max(localmax+arr[i], arr[i])
globalmax = max(globalmax, localmax)
//min edit distance

//word ladder
