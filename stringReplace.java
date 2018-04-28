//Q6: string replace
//Given an original string input, and two strings S and T, replace all occurrences of S in input with T.
//solution1: not using StringBuilder
//assuming inputs are not null
public String replace(String input, String s, String t) {
    char[] arr = input.toCharArray();
    if(s.length() >= t.length())
    	return replaceShorter(arr, s, t);
    else
    	return replaceLonger(arr, s, t);
}
private String replaceShorter(char[] arr, String s, String t){
	int slow = 0; //left not including slow is res
	int fast = 0;  //used to traverse
	while(fast < arr.length){
		if(fast <= arr.length - s.length() && equalSubStr(arr, fast, s)){
			copySubStr(arr, slow, t);
			slow += t.length();
			fast += s.length();
		}else{
			arr[slow++] = arr[fast++];
		}
	}
	return new String(arr, 0, slow);
}
private String replaceLonger(char[] arr, String s, String t){


	ArrayList<Integer> matches = getAllMatches(arr, s);

	//get new length if needed
	char[] res = new char[arr.length+matches.size()*(t.length()-s.length(xp))];
	int lastIndex = matches.size()-1;

  int slow = res.length-1; //position when traversing the new length, right->left
	int fast = arr.length-1; //position when traversing the old length, right->left

	while(slow > 0){
		//copy t when 1)still have some match and
		//2) slow is in the position of rightmost matching end position
		if(lastIndex >= 0 && fast == matches.get(lastIndex)){
			copySubStr(res, slow-t.length() + 1, t);
			fast -= t.length();
			slow -= s.length(); //slow behind fast
			lastIndex--;
		}else{
			res[slow--] = arr[fast--];
		}
	}
	return new String(res);
}


//chekc if substring from fromIndex is the same as s
private boolean equalSubStr(char[] arr, int fromIndex, String s){
	for(int i = 0; i < s.length(); i++){
		if(arr[fromIndex + i] != s.charAt(i))
			return false;
	}
	return true;
}
//copy t to res at fromIndex
private void copySubStr(char[] res, int fromIndex, String s){
	for(int i = 0; i < t.length(); i++)
		res[fromIndex+i] = t.charAt(i);
}
//get all the matches of s end positions in arr
private ArrayList<Integer> getAllMatches(char[] arr, String s){
	ArrayList<Integer> matches = new ArrayList<>();
	int i = 0;
	wihle(i <= arr.length - s.length()){
		if(equalSubStr(arr, i, s)){
			//record the match substring's end index for later convenience
			matches.add(i + s.length()-1);
			i += s.length();
		}else{
			i++;
		}
	}
	return matches;
}

//solution2: using StringBuilder, but not string.replace()
public String replace(String input, String s, String t) {
    StringBuilder sb = new StringBuilder();
    int fromIndex = 0;
    //fromIndex: starting search position
    int matchIndex = input.indexOf(s, fromIndex);
    while(matchIndex != -1){
    	sb.append(input, fromIndex, matchIndex).append(t);
    	fromIndex = matchIndex + s.length();
    	matchIndex = input.indexOf(s, fromIndex);
    }
    sb.append(input, fromIndex, input.length());
    return sb.toString();
}
