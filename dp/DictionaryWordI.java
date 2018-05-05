public boolean canBreak(String input String[] dict){
	Set<String> set = buildSet(dict);
	//arr[i]: input[i-1] or input.substring(0,i)
	boolean[] arr = new boolean[input.length()+1];
	arr[0] = true;
	for(int i = 1; i < arr.length; i++){
		for(int j = 0; j < i; j++){
			if(set.contains(input.substring(j, i)) && arr[j]){
				arr[i] = true;
				break;
			}
		}
	}
	return arr[arr.length-1];
}
private Set<String> buildSet(String[] dict){
	Set<String> set = new HashSet<>();
	for(String s : dict)
		set.add(s);
	return set;
}
