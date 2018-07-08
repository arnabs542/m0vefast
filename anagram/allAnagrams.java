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

//Sliding window
// Then we modify its element and restore it as we scan through s.

// If we find a match, decrease that matched character's apperance times by 1.

// To simulate the queue used in solution 1, we introduce a new variable matched that keeps track

// of how many characters we've matched so far.  This matched variable also saves us from

// the O(26) anagram check each time we've found a substring of length m in solution 1.

public List<Integer> allAnagrams(String p, String s) {
       // Write your code here
        List<Integer> ans = new ArrayList <Integer>();

        if (s.length() < p.length()) {
            return ans;
        }
        int[] sum = new int[26];
        int plength = p.length(), slength = s.length();
        //store all characters' frequencies from p
        for(char c : p.toCharArray()){
            sum[c - 'a']++;
        }
        int start = 0, end = 0, matched = 0;
        for(end = 0; end < slength; end++) {
            //find a character match
            if(sum[s.charAt(end) - 'a'] > 0){
                matched++;
            }
            sum[s.charAt(end) - 'a']--;
            //if find all needed matches, add index start to final result
            if(matched == plength) {
                ans.add(start);
            }
            //sliding window principle
            if(end - start  + 1 == plength){
                //restore the frequency of character s.charAt(start) for later check
                sum[s.charAt(start) - 'a']++;
                //found a match at index start before; need to decrease matched
                //by 1 as s.charAt(start) will be out of the sliding window
                //if before there is a match, previous sum[s.charAt(start) - 'a'] = 0
                if(sum[s.charAt(start) - 'a'] > 0){
                    matched--;
                }
                start++;
            }
        }
        return ans;
    }