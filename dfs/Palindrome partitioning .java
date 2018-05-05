public List<List<String>> partition(String s) {
	List<List<String>> res = new ArrayList<>();
	dfs(res, new ArrayList<String>(), s, 0);
	return res;
}
public void dfs(List<List<String>> res, 
				List<String> path,
				String s,
				int start){
	//收敛条件
	if(start == s.length())  //out of bound
		res.add(new ArrayList<>(path));
	else{
		for(int i = start; i<s.length(); i++){
			//String subString = s.substring(start, i + 1);
			//if(isPalindrome(substring)){///}
			if(isPalindrome(s, start, i)){
				path.add(s.substring(start, i+1));
				dfs(res, path, s, i+1);
				path.remove(path.size()-1);
			}
		}
	}
}
public boolean isPalindrome(String s, int low, int high){
	while(low < high)
		if(s.charAt(low++) != s.charAt(high--))
			return false;
	return true;
}
// private boolean isPalindrome(String s) {
//  	for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
//   		if (s.charAt(i) != s.charAt(j)) {
//    			return false;
//   		}
//  	}	
//  	return true;
// }