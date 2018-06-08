public String longestCommonSubstr(String a, String b){
  char[] aa = a.toCharArray();
  char[] bb = b.toCharArray();
  int start = 0;
  int len = 0;
  int[][] common = new int[aa.length][bb.length];
  for(int i = 0; i < aa.length; i++){
    for(int j = 0; j < bb.length; j++){
      if(aa[i] == bb[j]){
        //matrix base case
        if(i == 0 || j == 0){
          common[i][j] = 1;
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

}
