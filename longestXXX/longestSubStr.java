 public int longestSubStr(String input) {
   set<Character> unique = new HashSet<>();
   //a sliding window of(slow, fast)
   //unique continas all unique char in sliding window

   //[slow, fast) the length string
   int slow = 0;  //starting index of unique str
   int fast = 0;  //started to explored
   int longest = 0;
   //cant use for-loop here
   while(fast < input.length()){
   	//if there is duplicate, need to move slow ptr
   	if(unique.contains(input.charAt(fast)))
   		unique.remove(input.charAt(slow++));
   	else{
   		//if no duplicate, slide fast ptr and have a new window with all unique chars
   		unique.add(input.charAt(fast++));
   		longest = Math.max(longest, fast-slow);
   	}
   }
   return longest;
}
