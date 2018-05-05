//solution1: recursion
public boolean match(String input, String pattern) {
	return helper(input, pattern, 0, 0);
}
private boolena helper(String s, String t, int si, int ti){
	//runing out of s and t at the same time
	if(si == s.length() && ti == t.length())
		return true;
	if(si >= s.length() || ti >= t.length())
		return false;
	//t.charAt() is not a digit
	if(t.charAt(ti) < '0' || t.charAt(ti) > '9'){
		if(t.charAt(ti) == s.charAt(si))
			helper(s, t, si+1, ti+1);
		return false;
	}
	//t.charAt() is a digit
	int count = 0;
	while(t1 < t.length() && t.charAt(ti) >= '0' && t.charAt(ti) <= '9'){
		count = count * 10 + (t.charAt(ti) - '0');
		ti++;
	}
	return helper(s, t, si + count, ti);
}
//solution2: iterative
public boolean match(String input, String pattern) {
	
}
