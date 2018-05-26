public String reduceString(String s){
	if(s == null || s.length() == 0)
		return null;
	StringBuilder sb = new StringBuilder();
	char cur = s.charAt(0);
	sb.append(cur);
	int i = 0;
	for(int i = 0; i < s.length(); i++){
		if(s.charAt(i) == cur){}//no nothing
		else{
			sb.append(String.valueOf(cur));
			cur = s.charAt(i);
		}
	}
	sb.append(String.valueOf(cur));
	return sb.toString();
}
//better solution: inplace
public String reduceString(String s){
	if(s == null || s.length() == 0)
		return null;
	char[] arr = s.toCharArray();
	int slow = 0;
	int fast = 0;
	for(fast = 0; fast < arr.length; fast++){
		if(fast == 0 || arr[fast] != arr[slow-1]){
			arr[slow++] = arr[fast];
		}
	}
	return new String(arr, 0, slow);
}
