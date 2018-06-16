//substring anagram
public List<Integer> substringAnagram(String s, String p) {
        // Write your code here
        List<Integer> ans = new ArrayList<>();
        if (s.length() < p.length()) {
            return ans;
        }
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();
        int[] det = new int[256];

        for (int i = 0; i < p.length(); i++) {
            det[pc[i]]--;
            det[sc[i]]++;
        }
        //first check
        int absSum = 0;
        for(int item : det)
            absSum += Math.abs(item);
        //same length. same word: abc-bca
        if(absSum == 0)
            res.add(0);
        //second check
        //2 pointers distance of p.length, starting check position at s[1]
        for (int i = p.length(); i < s.length(); i++) {
            int r = sc[i];                  //char-int
            int l = sc[i - p.length()];     //char-int
            //absSum always has plen char debt
            //purpose: get rid of effect of leftChar and rightChar of s window
            //if rightChar never seen before, then -0;
            //if rightChar seen before, then -effect
            //ccaa-abc
            absSum = absSum - Math.abs(det[r]) - Math.abs(det[l]);

            det[r]++;  //new encountered char ++
            det[l]--;  //just checked/will no be considered char --
            //adding updated effect of leftChar and rightChar
            //if leftChar effect is deleted throughly, then add 0;
            //if leftChar effect is not deleted throughly, then add left effect
            absSum = absSum + Math.abs(det[r]) + Math.abs(det[l]);

            if (absSum == 0) {
                ans.add(i - p.length() + 1);  //return index of the left+1
            }
        }
        return ans;
    }



    //l = "abcbac", s = "ab", return [0, 3] since the substring with length 2 starting from index 0/3
//are all anagrams of "ab" ("ab", "ba").
//O(n) O(m)
public List<Integer> allAnagrams(String s, String l) {
    // s is pattern, l is source
    List<Integer> res = new ArrayList<>();
    if(l.length() == 0 || s.length() > l.length())
        return res;
    Map<Character, Integer> map = countMap(s);
    int match = 0;
    //a sliding window of s.length(), need ro record end index of the window
    for(int i = 0; i < l.length(); i++){
        //handle the right most char: effect need to considered for the map => reduce
        char temp = l.charAt(i);
        Integer count = map.get(temp);
        if(count != null){
            map.put(temp, count -1);
            if(count == 1)
                match++;  //++ a fully match is when count from: 1=>0
        }
        //handle the leftmost char: effect should not be considred for the map => add back
        if(i >= s.length()){
            temp = l.charAt(i - s.length());  //====================
            count = map.get(temp);
            if(count != null){
                map.put(temp, count + 1);
                if(count == 0)
                    match--;  //-- only when count: 0=>1
            }
        }
        if(match == map.size())
            res.add(i - s.length() + 1);  //====================
    }
    return res;
}
private Map<Character, Integer> countMap(String s){
    Map<Character, Integer> map = new HashMap<>();
  //below is char not Character
    for(char c : s.toCharArray()){
      if(map.containsKey(c))
        map.put(c, map.get(c)+1);
      else
        map.put(c, 1);
    }
    return map;
}
