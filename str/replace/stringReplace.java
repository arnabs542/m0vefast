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
	int slow = 0;  //tracking resulting string , slow not included
	int fast = 0;  //traverse arr
  //make sure we going outside after finish the last replacement
	while(fast < arr.length){
    //fast index goes to the last starting position of s && need to replace
		if(fast <= arr.length - s.length() && equalSubStr(arr, fast, s)){
			copySubStr(arr, slow, t);
			slow += t.length();
			fast += s.length();
    //no need to replace
		}else{
			arr[slow++] = arr[fast++];
		}
	}
	return new String(arr, 0, slow);
}
private String replaceLonger(char[] arr, String s, String t){
    //get all ending index match s in arr
    List<Integer> matches = getAllMathces(arr, s);
  	char[] res = new char[arr.length + matches.size() * (t.length() - s.length())];
  	int lastIndex = matches.size()-1;
    int fast = arr.length -1;   //traverse arr
    int slow = res.length -1;   //tracking resulting string

    while(fast >= 0){
    	if(lastIndex >= 0 && fast == matches.get(lastIndex)){
      	copySubStr(res, slow - t.length() + 1, t);
        slow -= t.length();
        fast -= s.length();
        lastIndex--;
      }else{
      	res[slow--] = arr[fast--];
      }
    }
    return new String(res);
  }
  private List<Integer> getAllMathces(char[] arr, String s){
    //all ending matching index of s in arr
  	List<Integer> matches = new ArrayList<>();
    int start_index = 0;
    //for all possible starting index
    while(start_index <= arr.length - s.length()){
    	if(equalSubStr(arr, start_index, s)){
      	matches.add(start_index + s.length() - 1);  //record the end index
        start_index += s.length(); //check next possible starting index
      }else{
      	start_index++;
      }
    }
    return matches;
  }

  private boolean equalSubStr(char[] arr, int fromIndex, String s){
    //char[] ss = s.toCharArray();
  	for(int i = 0; i < s.length(); i++){
    	if(arr[i+fromIndex] != s.charAt(i))
        return false;
    }
    return true;
  }
  private void copySubStr(char[] arr, int fromIndex, String t){
  	for(int i = 0; i < t.length(); i++){
    	arr[i+fromIndex] = t.charAt(i);
    }
  }
