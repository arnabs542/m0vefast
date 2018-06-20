//Determine if C can be created by merging A and B in a way
//that maintains the relative order of the characters in A and B.
https://soulmachine.gitbooks.io/algorithm-essentials/java/dp/interleaving-string.html
//表示s1[0,i]和s2[0,j]，匹配s3[0, i+j]
//如果s1的最后一个字符等于s3的最后一个字符，则f[i][j]=f[i-1][j]
//f[i][j] = (s1[i - 1] == s3 [i + j - 1] && f[i - 1][j]) || (s2[j - 1] == s3 [i + j - 1] && f[i][j - 1]);
//solution： 时间复杂度O(n^2)，空间复杂度O(n^2)
public boolean interleave(String a, String b, String c){
  int alen = a.length();
  int blen = b.length();
  int clen = c.length();
  if(alen+blen != clen)
    return false;
  boolean[][] res = new boolean[alen+1][blen+1];
  //base case
  //res[0][0] = true
  for(int i = 0; i <= alen; i++){
    for(int j = 0; j <= blen; j++){
      //base case
      if(i == 0 && j == 0)
        res[i][j] = true;
      //2 cases to match
      if(i > 0 && a.charAt(i-1) == c.charAt(i+j-1))
        res[i][j] = res[i][j] || res[i-1][j];
      if(j > 0 && b.charAt(j-1) == c.charAt(i+j-1))
        res[i][j] = res[i][j] || res[i][j-1];
    }
  }
  return res[alen][blen];
}
