public int longestCommonSubSequence(String a, String b){
  int alen = a.length();
  int blen = b.length();
  int[][] res = new int[alen+1][blen+1];

  for(int i = 1; i <= alen; i++){
    for(int j = 1; j <= blen; j++){
      if(a.charAt(i) != b.charAt(j)){
        res[i][j] = Math.max(res[i-1][j], res[i][j-1]);
      }else{
        res[i][j] = res[i-1][j-1]+1;
      }
    }
  }
  return res[alen][blen];
}
