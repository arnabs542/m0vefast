//[((()))", "(()())", "(())()", "()(())", "()()()"]
public List<String> vaidParenthesis1(int n) {  // n pairs of
	List<String> res = new ArrayList<>();
	if(n <= 0)
		return res;
	//the final string has 2n chars
	char[] path = new char[2*n];
	dfs(res, path, n, n, 0);
	return res;
}
//left: how many ( we still have NOT used
//right: how many ) we still have NOT used
//index: the current position in cur we want to fill in with etiehr ()
private void dfs(List<String> res, char[] path, int left, int right, int index){
	//terminate condition: when no () left
	if(left == 0 && right == 0){
		res.add(new String(path));  //NOTICE
		return;
	}
	//when we can add a (? whenever there is some ( we can still use
	if(left > 0){
		path[index] = '(';
		dfs(res, path, left-1, right, index+1);
	}
	//when we can add a )? when there is more ( than ) used
	//since each ) should be associated with a previous (
	if(right > left){
		path[index] = ')';
		dfs(res, path, left, right-1, index+1);
	}
}
