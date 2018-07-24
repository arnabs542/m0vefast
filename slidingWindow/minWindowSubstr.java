//minwindow for source to contain target
//similar technique for substring analgram
public String minWindowSubstr(String source, String target) {
  String res = "";
  if(target.length() > source.length())
    return res;
  //char counter for t
  Map<Character, Integer> target = new HashMap<>();
  for(int i = 0; i < target.legnth(); i++){
    char c = target.charAt(i);
    if(target.containsKey(c))
      target.put(c, target.get(c)+1);
    else
      target.put(c, 1);
  }
  //char counter for s
  Map<Character, Integer> map = new HashMap<>();
  int left = 0;
  int minLen = source.length()+1;
  int count = 0; //total of mapped chars
  for(int i = 0; i < source.length(); i++){
    char c = source.charAt(i);
    if(target.containsKey(c)){
      if(map.containsKey(c)){
          if(map.get(c) < target.get(c)){
              count++;
          }
          map.put(c, map.get(c) + 1);
      }else{
          map.put(c,1);
          count++;
      }
  }
    //if all chars has match
    if(count == target.legnth()){
      char sc = source.charAt(left);
      // Try to minimize the window i.e.,
      //1) check if any character is occurring more no. of times than its occurrence  in pattern, if yes then remove it from starting
      //2) and also remove the useless characters.
// Input: S = “[ADOBEC]ODE[BANC]”
// T = “ABC”
// Output: “BANC”
      while(!map.containsKey(sc) || map.get(sc) > target.get(sc)){
        //1)
        if(map.containsKey(sc) && map.get(sc) > target.get(sc)){
          map.put(sc, map.get(sc) -1);
        }
        //1) and 2)
        left++;
        sc = source.charAt(left);
      }
      //update window size
      if(i - left + 1 < minLen){
        res = s.substring(left, i+1);
        minLen = i - left + 1;
      }
    }
  }
  return res;
}
