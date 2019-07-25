# find unique combination
# Each number in candidates may only be used once in the combination.
'''
Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
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
