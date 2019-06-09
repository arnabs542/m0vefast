# find unique combination
# Each number in candidates may only be used once in the combination.
'''
Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7]
]
'''
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
    visited = set()
    for i in range(index, len(candidates)):
        if candidates[i] not in visited:
            visited.add(candidates[i])
            self.dfs(candidates, res, path + [candidates[i]], target - candidates[i], i+1)
