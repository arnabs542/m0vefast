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
//maintain relative order
public List<String> permutations(String set){
	List<String> res = new ArrayList<>();
	if(set == null)
		return res;
	char[] arr = set.toCharArray();
	Arrays.sort(arr);
	StringBuilder path = new StringBuilder();
	boolean[] visited = new boolean[arr.length];
	dfs(arr, res, path, visited);
	return res;
}
private void dfs(char[] arr, List<String> res, StringBuilder path, boolean[] visited){
	if(path.length() == arr.length){ //termination
		res.add(path.toString());
		return;
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
//[abc, acb, bac, bca, cba, cab]
dfs permutation abc call stack:
dfs->
    i = 0, PATH = a
    dfs->
        i = 0
        i = 1, PATH = ab
        dfs->
            i = 0
            i = 1
            i = 2, PATH = abc
            dfs-> res.add(path),
                  [return1]
            PATH = ab   //选第三层 当然有先删掉第三层的当前选项
            i = 3, end of the loop       //都遍历过当前路径所有可能
            [return2]   //选第二层 当然有先删掉第二层的当前选项
        PATH = a
        i = 2, PATH = ac
        dfs->
            i = 0
            i = 1, PATH = acb
            dfs-> res.add(path)
                  [return]
            PATH = ac
            i = 2
            [return]  //选第二层 当然有先删掉第二 层的当前选项
        PATH = a
        i = 3, end of the loop
        [return]
    PATH = ''
    i = 1, PATH = b
    i = 2, PATH = c
    i = 3 [return]


		dfs permutation abc using swap
		dfs-> index = 0
					i = 0
					INPUT = abc
					dfs-> index=1
								i = 1
								INPUT = abc
								dfs-> index=2
											i = 2
											INPUT = abc
											dfs-> index = 3
														res.add(abc)    //
											INPUT = abc
											i = 3 out of loop, return   //Try out all options
								INPUT = abc
								i = 2
								INPUT = acb
								dfs-> index = 2
											i = 2
											INPUT = acb
											dfs-> index = 3
														res.add(acb)    //
											INPUT = acb
											i = 3 out of loop, return
								INPUT = acb
								i = 3 out of lool, return
					INPUT= abc
					i= 1
					i= 2		
