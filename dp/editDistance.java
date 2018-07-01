//Replace, Delete, and Insert operations needed to transform one to two
//https://leetcodenotes.wordpress.com/2013/07/16/edit-distance/
public int editDistance(String one, String two) {
    //dp[i][j] 将one的0~i这个substring转化成two的0~j这个substring要的最少次数。
    //在二维递归的时候，我们已知有三个已经算好的值: d[i-1][j-1], d[i-1][j], d[i][j-1]
    //eg: lamb - > slav
    int[][] dp = new int[one.length()+1][two.length()+1];
    for(int i = 0; i <= one.length(); i++){
    	for(int j = 0; j <= two.length(); j++){
        // DP[0][j] = j： word1为空，要转化到word2[0:i-1]，需要添加i个字符。
        // DP[i][0] = i： word2为空，要从word1转化到空字符串，需要删除i个字符。
        if(i == 0){
        	dp[i][j] = j;
        }else if(j == 0){
        	dp[i][j] = i;
          //if ith letter and jth letter are equal
        }else if(one.charAt(i-1) == two.charAt(j-1)){
        	dp[i][j] = dp[i-1][j-1];
        }else{ //min_operation(delete, insert, replace)
          //delete: we know: d[i-1][j] / la -> slav, we want lam -> slav, delete m: la->slav
          //insert: we know: d[i][j-1] / lam -> sla, we want lam -> slav, insert v: lam->lamv
          //replace: we know: d[i-1][j-1] / la -> sla, we want lam -> slav, replace m: lam->lav
        	dp[i][j] = Math.min(dp[i-1][j]+1, dp[i][j-1]+1);
          dp[i][j] = Math.min(dp[i-1][j-1]+1, dp[i][j]);

        }
      }
    }

    return dp[one.length()][two.length()];
  }
