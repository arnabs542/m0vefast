# @param candidates, a list of integers
# @param target, intege
#  @return a list of lists of integers
'''
Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
'''
def combinationSum1(self, candidates, target):
    res = []
    self.dfs(sorted(candidates), res, [], target, 0)
    # option: coin candidate types
    # deep: remaining
    return res

def dfs(self, candidates, res, path, target, index):
    if target == 0:
        res.append(path)
        return
    if target < 0:
        return
    for i in range(index, len(candidates)):
        self.dfs(candidates, res, path + [candidates[i]], target - candidates[i], i)
