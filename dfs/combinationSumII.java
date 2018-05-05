//combination sumII
public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    ArrayList<List<Integer>> res = new ArrayList<List<>>();
    Arrays.sort(nums);
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
            if(i > start && candidates[i] == candidates[i-1]) 
                continue; // skip duplicates
            path.add(candidates[i]);
            dfs(res, path, candidates, remain - candidates[i], i + 1);
            path.remove(path.size() - 1); 
        }
    }
} 