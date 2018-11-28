//https://leetcode.com/problems/license-key-formatting/
public String licenseKeyFormatting(String s, String k){
  StringBuilder sb = new StringBuilder();
  //working backwords to gaurantee the last part is k-len
  for(int i = s.length()-1; i>= 0; i--){
    if(s.charAt(i) != '-')
      //res string reach k capacity?
      if(sb.length() % (k+1) == k)
        sb.append("-");
      sb.append(s.charAt(i));
  }
  return sb.reverse().toString().toUpperCase();
}
