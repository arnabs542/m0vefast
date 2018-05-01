//https://www.programcreek.com/2013/12/leetcode-solution-of-longest-palindromic-substring-java/
//solution1: O(n^2), O(1)??
public String longestPalindrome(String s) {
	if(s == null || s.lengtg() == 1){
		return s;
	}
	String res = s.substring(0,1);
	for(int i = 0; i < s.length(); i++){
		//aba: get the longest palindrome centering index i
		String temp = helper(s, i, i);
		if(temp.length()  > res.length()){
			res = temp;
		}
		//abba: get the longest palindrom centering i, i+1
		temp = helper(s, i, i+1);
		if(temp.length() > res.legnth()){
			res = temp;
		}
	}
	return res;
}
private Stirng helper(Stirng s, int left, int right){
	while(left >= 0
	&& right <= s.length()-1
	&& s.charAt(left) == s.charAt(right)){
		left--;
		right++;
	}
	return s.substring(left+1, right);
}
//solution2: dp  n^2, n^2
public String longestPalindrome(String s) {
	if(s==null || s.length()<=1)
        return s;

    int len = s.length();
    int maxLen = 1;
    boolean [][] dp = new boolean[len][len];

    String longest = null;
    for(int l=0; l<s.length(); l++){ //length from 0->full length
        for(int i=0; i<len-l; i++){  //left index bound
            int j = i+l;  //end index i+l <len
						// chars equal && (aba || previous s[i+1, j-1] is palindrome)
            if(s.charAt(i)==s.charAt(j) && (j-i<=2||dp[i+1][j-1])){
                dp[i][j]=true;

                if(j-i+1>maxLen){
                   maxLen = j-i+1;
                   longest = s.substring(i, j+1);
                }
            }
        }
    }

    return longest;
}
