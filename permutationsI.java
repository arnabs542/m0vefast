//permutationI
public List<List<Integer>> permutation(int[] arr){
	List<List<Integer>> res = new ArrayList<>();
	//not necessary to Arrays.sort(arr);
	dfs(res, new ArrayList<Integer>(), arr);
	return res;
}
private void dfs(List<List<Integer>> res,
				 ArrayList<Integer> path,
				 int[] arr){
    //收敛条件
	if(path.size() == arr.length)
		res.add(new ArrayList<>(path));
	else{
		for(int i = 0; i<arr.length; i++){
			//elements alrady exist, skip
			if(path.contains(arr[i]))
				continue;
			path.add(arr[i]);
			dfs(res, path, arr);
			path.remove(path.size()-1);
		}
	}
}
//time: O(n!)
//space: O(n)
public List<String> permutations(String set) {
    List<String> res = new ArrayList<>();
    if(set == null)
        return res;
    char[] input = set.toCharArray();
    dfs(input, res, new StringBuilder());
    return res;
}
private void dfs(char[] input, List<String> res, StringBuilder path){
    if(path.length() == input.length){
        res.add(path.toString());
    }else{
        for(int i = 0; i < input.length; i++){
            if(path.indexOf(input[i]) != -1)   //indexOf => O(n) in side loop
            	continue;
            path.append(input[i]);
            dfs(input, res, path);
            path.deleteCharAt(path.length()-1);
        }
    }
}
//lai version: use boolean[] visited for extra space, but less time compared with above
public List<String> permutations(String set){
	List<String> res = new ArrayList<>();
	if(set == null)
		return res;
	char[] arr = set.toCharArray();
	StringBuilder path = new StringBuilder();
	boolean[] visited = new boolean[arr.length];
	dfs(arr, res, path, visited);
	return res;
}
private void dfs(char[] arr, List<String> res, StringBuilder path, boolean[] visited){
	if(path.length() == arr.length){ //termination
		res.add(path.toString());
	}else{
		for(int i = 0; i < arr.length; i++){
			if(visited[i])
				continue;
			visited[i] = true;
			path.append(arr[i]);
			dfs(arr, res, path, visited);
			visited[i] = false;
			path.deleteCharAt(path.length()-1);
		}
	}
}
//lai: solution 2 using swap
public List<String> permutations(String set){
	List<String> res = new ArrayList<>();
	if(set == null)
		return res;
	char[] arr = set.toCharArray();
	//StringBuilder path = new StringBuilder();
	// boolean[] visited = new boolean[arr.length];
	dfs(arr, res, 0);
	return res;
}
private void dfs(char[] arr, List<String> res, int index){
	//base case
	if(index == arr.length){
		res.add(new String(arr));
		return;
	}
	for(int i = index; i < arr.length; i++){
		swap(arr, index, i);
		dfs(arr, res, index+1);
		swap(arr, index, i);
	}
}
private void swap(char[] arr, int left, int right){
	char temp = arr[left];
	arr[left] = arr[right];
	arr[right] = temp;
}
//[123, 132, 213, 231, 321, 312]%
