//all combination of k from n (1-n)
public List<List<Integer>> combine(int n, int k) {
    // Write your solution here
    List<Integer> res = new Arraylist<>();
    List<Integer> path = new ArrayList<>();
    dfs(res, path, n, k, 1);
    return res;
  }
private void dfs(List<Integer> res, List<Integer> path, int n, int k, int startIndex){
  if(path.size() == k){
    res.add(path);
    return res;
  }
  for(int i = startIndex, i <= n; i++){
    path.add(startIndex);
    dfs(res, path, n, k, startIndex+1);
    path.remove(path.size()-1);
  }
}
