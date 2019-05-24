# find unique combination
def combinationSum2(self, candidates, target):
    res = []
    self.dfs(sorted(candidates), res, [], target, 0)
    return res

def dfs(self, candidates, res, path, target, index):
    if target == 0:
        res.append(path)
        return
    if target < 0:
        return
    for i in range(index, len(candidates)):
        if i > index and candidates[i] == candidates[i-1]:
            continue
        self.dfs(candidates, res, path + [candidates[i]], target - candidates[i], i+1)
