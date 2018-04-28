public List<String> validParentheses(int n) {
	List<String> res = new ArrayList<>();
	if(n <= 0)
		return res;
	//the final string has 2n chars
	char[] cur = new char[2*n];
	dfs(res, cur, n, n, 0);
	return res;
}
//left: how many ( we still have
//right: how many ) we still have
//index: the current position in cur we want to fill in with etiehr ()
private void dfs(List<String> res, char[] cur, int left, int right, int index){
	//terminate condition: when no () left
	if(left == 0 && right == 0){
		res.add(new String(cur));  //NOTICE
		return;
	}
	//when we can add a (? whenever there is some ( we can still use
	if(left > 0){
		cur[index] = '(';
		dfs(res, cur, left-1, right, index+1);
	}
	//when we can add a )? when there is more ( than ) used
	//since each ) should be associated with a previous (
	//???????????????????????????????
	if(right > left){
		cur[index] = ')';
		dfs(res, cur, left, right-1, index+1);
	}
}