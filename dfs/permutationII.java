//permutationII
public List<List<Integer>> permutation(int[] arr){
    List<List<Integer>> res = new ArrayList<>();
    if(arr == null) return res;
    Arrays.sort(arr);
    dfs(res, new ArrayList<Integer>(), arr, new boolean[arr.length]);
    return res;
}
private void dfs(List<List<Integer>> res, 
                 ArrayList<Integer> path, 
                 int[] arr
                 boolean[] visited){ 
    if(path.size() == arr.length)
        res.add(new ArrayList<>(path));
    else{
        for(int i = 0; i<arr.length; i++){
            //cur is visited & cur=prev, but prev is not visited, skip
            if(visited[i] || (i > 0 && arr[i] == arr[i-1] && !visited[i-1]))
                continue;
            /*
            上面的判断主要是为了去除重复元素影响。
            比如，给出一个排好序的数组，[1,2,2]，那么第一个2和第二2如果在结果中互换位置，
            eg: 1, 2a(visited), 2b(visited->delete) ;; 1, 2b(delete), 2a(visited)=>skip
            我们也认为是同一种方案，所以我们强制要求相同的数字，原来排在前面的，在结果
            当中也应该排在前面，这样就保证了唯一性。所以当前面的2还没有使用的时候，就
            不应该让后面的2使用。
            visited index 与arr index 对应to track ith element is visited or not
            */
            visited[i] = true;
            path.add(arr[i]);

            dfs(rs, path, arr);

            visited[i] = false;
            path.remove(path.size()-1);
        }
    }

}

 public List<String> permutations(String set) {
    List<String> res = new ArrayList<>();
    if(set == null) 
        return res;
    char[] arr = set.toCharArray();
    Arrays.sort(arr);
    boolean[] visited = new boolean[arr.length];
    StringBuilder path = new StringBuilder();
    dfs(res, arr, path, visited);
    return res;
 }
 private void dfs(List<String> res, char[] arr, StringBuilder path, boolean[] visited){
    if(path.length() == arr.length)
        res.add(path.toString());
    else{
        for(int i = 0; i < arr.length; i++){
            if(visited[i] || (i > 0 && arr[i] == arr[i-1] && !visited[i-1])){
                //System.out.println(arr[i]);
                continue;
            }
            visited[i] = true;
            path.append(arr[i]);
            dfs(res, path, arr);
            visited[i] = false;
            path.deleteCharAt(path.length()-1);
        }
    }
 }
  //lai version using swap
 public List<String> permutations(String set) {
    List<String> res = new ArrayList<>();
    if(set == null) 
        return res;
    char[] arr = set.toCharArray();
    Arrays.sort(arr);
    dfs(res, arr, 0);
    return res;
 }
 private void dfs(List<String> res, char[] arr, int index){
    if(index == arr.length)
        res.add(new String(arr));
    else{
        Set<Character> visited = new HashSet<>();
        for(int i = 0; i < arr.length; i++){
            if(visited.add(arr[i])){
                swap(arr, i, index);
                dfs(arr, res, index+1);
                swap(arr.i, index);
            }
        }
    }
 }



