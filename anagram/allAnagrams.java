//l = "abcbac", s = "ab", return [0, 3] since the substring with length 2 starting from index 0/3
//are all anagrams of "ab" ("ab", "ba").
//O(n) O(m)
public List<Integer> allAnagrams(String s, String l) {
    // Write your solution here.
    List<Integer> res = new ArrayList<>();
    if(l.length() == 0 || s.length() > l.length())
    	return res;
    Map<Character, Integer> map = countMap(s);
    int match = 0;
    //a sliding window of s.length(), need ro record end index of the window
    for(int i = 0; i < l.length(); i++){
      //handle the right most char that added in
    	char temp = l.charAt(i);
      //count is Integer, not int
    	Integer count = map.get(temp);
    	if(count != null){
    		map.put(temp, count -1);
    		if(count == 1)
    			match++;  //++ a fully match is when count from: 1=>0
    	}
    	//handle the leftmost char need to be excluded
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
