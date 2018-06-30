//combination sumII
public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<List<>>();
    Arrays.sort(candidates);
    dfs(res, new ArrayList<Integer>(), candidates, target, 0);
    return res;
}

private void dfs(List<List<Integer>> res,
                       List<Integer> path,
                       int[] candidates,
                       int remain,
                       int start){
    if(remain < 0)
        return;
    else if(remain == 0)
        res.add(new ArrayList<>(path));
    else{
        for(int i = start; i < candidates.length; i++){
            //Each number in C may only be used once in the combination.
            if(i == start || candidates[i] != candidates[i-1]) {
              path.add(candidates[i]);
              dfs(res, path, candidates, remain - candidates[i], i + 1);
              path.remove(path.size() - 1);
            }
        }
    }
}
