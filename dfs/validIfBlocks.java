public List<String> validParentheses(int n){
	List<String> res = new ArrayList<>();
	if(n <= 0)
		return blocks;
	char[] arr = new char[2*n];
	dfs(arr, n, n, 0, res);
	return res;
}
private void dfs(char[] arr, int left, int right, int index, List<String> res){
	//base case
	//left, right: how many bracket have not been added into
	if(left == 0 && right == 0){
		res.add(new String(arr));
		return;
	}
	//case1: add (
	if(left > 0){
		arr[index] = '(';
		dfs(arr, left-1, right, index+1, res);
	}
	if(right > left){
		arr[index] = ')';
		dfs(arr, left, right-1, index+1, res);
	}
}
private void print(List<String> blocks){
	for(String s : blocks)
		System.out.println(s);
	System.out.println("===============");
}
