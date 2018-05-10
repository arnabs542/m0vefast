public String removeCertainChar(String input, String t){
	char[] arr = input.toCharArrary();

	Set<character> set = new HashSet<>();
	for(int i = 0; i < t.length(); i++)
		set.add(t.charAt(i));

	int slow = 0;
	for(int fast = 0; fast < arr.length; fast++){
		if(!set.contains(arr[fast]))
			arr[slow++] = arr[fast];
	}
	return new String(arr, 0, slow);
}
//another version: more space for sb, and time: for-in-for
public String removeCertainChar(String input, String t){
	StringBuilder sb = new StringBuilder();

	for(int i = 0; i < input.length(); i++){
		if(!t.contains(String.valueOf(input.charAt(i))))
			sb.append(input.charAt(i));
	}
	return sb.toString();
}
//not good time: for-in-for
public String removeCertainChar(String input, String t) {
    // Write your solution here.
    char[] arr = input.toCharArray();
    int cur = 0;
    for(int i = 0; i < input.length(); i++){
      if(!t.contains(String.valueOf(input.charAt(i))))
        arr[cur++] = input.charAt(i);
    }
    return new String(arr, 0, cur);
}
