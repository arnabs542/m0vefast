//combination sumI
public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(candidates);
    dfs(res, new ArrayList<Integer>(), candidates, target, 0);
    return res;
}
//or backtrack 
private void dfs(List<List<Integer>> res, 
                 List<Integer> path, 
                 int[] candidates, 
                 int remain, 
                 int start){
    
    if(remain == 0) //收敛条件
        res.add(new ArrayList<>(path));
    else if(remain < 0) //可以剪枝：if(remain-candidates[i]/remain <0)
        return;
    else{ 
        for(int i = start; i < candidates.length; i++){
            path.add(candidates[i]);
            //i: not i + 1 because we can reuse same elements
            //在for-loop中剪枝：if(remain-candidates[i]/remain <0), return
            dfs(res, path, candidates, remain - candidates[i], i); 
            path.remove(path.size() - 1);
        }
    }
}






























