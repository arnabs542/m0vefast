//follow up: https://www.youtube.com/watch?v=MNDOsYgVRyY
//mapping is 'a' <-> 'x', 'b' <-> 'y', 'c' <-> 'z'.
public boolean isomorphic(String s, String t) {
    // Write your solution here
    if(s == null||s.length()<=1)
      return true;
    HashMap<Character, Character> map = new HashMap<>();
    for(int i = 0; i < s.length; i++){
      char a = s.charAt(i);
      char b = t.charAt(i);
      if(map.containsKey(a)){
        if(map.get(a) != (b))
         return false;
      }else{
        if(map.containsValue(b)){
          return false;
        else
          map.put(a, b);
        }
      }
    }
    return true;
  }
