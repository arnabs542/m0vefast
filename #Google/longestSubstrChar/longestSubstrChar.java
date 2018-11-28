//without repeating   2121  33122
//https://massivealgorithms.blogspot.com/search?q=Longest+Substring+Without+Repeating+Characters
public int lengthOfLongestSubstring(String s) {
  if(s.length() == 0)
    return 0;
  //< char, ending index >
  Map<Character, Integer> counter = new HashMap<>();
  char[] arr = s.toCharArray();
  int left = 0;
  int max_len = 0;
  for(int i = 0; i < arr.length; i++){
    if(map.containsKey(arr[i])){
      //abba left right can only move to right
      left = Math.max(left, map.get(arr[i] + 1));
    map.put(arr[i], i);
    max_len = Math.max(man_len, i - left + 1);
  }
  return max_len;
}

//at most 2
public int lengthOfLongestSubstringTwoDistinct(String s) {

}

//at most k
//https://massivealgorithms.blogspot.com/search?q=Longest+Substring+with+At+Most+Two+Distinct+Characters
//1）如果当前字符跟前一个字符是一样的，直接继续。
//2）如果不一样，则需要判断当前字符跟j是不是一样的
    //a）一样的话sliding window左边不变，右边继续增加，但是j的位置需要调整到k-1。
    //b）不一样的话，sliding window的左侧变为j的下一个字符（也就是去掉包含j指向的字符的区间），
        //j的位置也需要调整到k-1。
public int lengthOfLongestSubstringKDistinct(String s, int k) {
  //to track the unique() elements in the map
  Map<Character, Integer> map = new HashMap<>();
  int num = 0;
  int left = 0;
  int right= 0;
  int max_len = 0;
  for(right = 0; right < s.length(); right++){
    char cur = s.charAt(right);
    map.put(cur, map.getOrDefault(cur,0) +1);
    while(map.size() > k){
      char leftChar = s.charAt(left);
      map.put(leftChar, map.get(leftChar) - 1);
      if(map.get(leftChar) == 0)
        map.remove(leftChar);
      left++;
    }
    //update when map size is k
    max_len = Math.max(max_len, right - left + 1);
  }
  return max_len;
}
//exactly k
public int lengthOfLongestSubstringKDistinct(String s, int k) {
       int i = 0, j = -1, maxLen = 0;
       for (int k = 1; k < s.length(); k++) {
           if (s.charAt(k) == s.charAt(k - 1))
               continue;
           if (j >= 0 && s.charAt(j) != s.charAt(k)) {
               maxLen = Math.max(k - i, maxLen);
               i = j + 1;
           }
           j = k - 1;
       }
       return Math.max(s.length() - i, maxLen);
}

//at least k repeating char
//https://massivealgorithms.blogspot.com/2016/09/leetcode-395-longest-substring-with-at.html
基本原理是，先遍历整个string，并记录每个不同的character的出现次数。如果所有character出现次数都不小于k，
那么说明整个string就是满足条件的longest substring，返回原string的长度即可；如果有character的出现次数小于k
，假设这个character是c，因为满足条件的substring永远不会包含c，所以满足条件的substring一定是在以c为分割参考
下的某个substring中。所以我们需要做的就是把c当做是split的参考，在得到的String[]中再次调用我们的method，
找到最大的返回值即可。
public int longestSubstring(String s, int k) {
  if(s == null || s.length()<k || k == 0)
    return 0;
  int max_len = 0;
  int[] count = new int[26];
  for(int i = 0; i < s.length(); i++){
      count[s.charAt(i) - 'a']++;
  }
  List<Integer> pos = new ArrayList<>();
  for(int i = 0; i < s.length(); i++){
    if(count[s.charAt(i) - 'a'] < k)
      pos.add(i);
  }
  //base case
  if(pos.size() == 0)
    return s.length();

  pos.add(0, -1);//considering the first pos
  pos.add(s.length());  //sondiering the last pos
  // aaabb, pos=[-1, 3, 4, 5], k = 3
  for(int i = 1; i < pos.size(); i++){
    int start = pos.get(i-1) + 1;
    int end = pos.get(i);
    int next = longestSubstring(s.substring(start, end), k);
    max_len = Math.max(max_len, next);
  }
  return max_len;
}
