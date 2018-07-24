//similar to the problem of counting ways of climbing stairs.
// The relation is dp[n]=dp[n-1]+dp[n-2].
    public int numDecodings(String s) {
        if(s==null || s.length()==0 || s.charAt(0)=='0')
            return 0;
        if(s.length()==1)
            return 1;
        int[] dp = new int[s.length()]
        //base case dp[0] and dp[1]
        dp[0]=1;
        if(s.charAt(1)!='0'){  //12: 1,2  or 12
            dp[1]=2;
        }else{     //10....: 10
            dp[1]=1;
        }
        //induction rule:
        for(int i=2; i < s.length(); i++){
            //since a single non zero number means at least one way to decode
            if(s.charAt(i)!='0'){
                dp[i] = dp[i-1];
            }
            //since 12 can be 1,2 and 12
            //since 10, the last 0 is 0, but + before make it 1 for 10
            int val = Integer.parseInt(s.substring(i-1, i+1));
            if(val <= 26 && val >= 10){
                dp[i] += dp[i-2];
            }
        }
        return dp[s.length()-1];
    }
if no check val >= 10
10012 should be 0 but 3
11000
1012 should be 2 but 3
1112
