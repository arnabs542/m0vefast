# Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.  nCk
def combinations(self, n: int, k: int) -> List[List[int]]:
    res = []
    self.dfs(res, 1, n, k, [], 0)
    return res

def dfs(self, res, start, n, k, path, depth):
    # depth: 1->kth number in a combo 
    # branching factor: possible number choice from start - n
    if depth == k:
        res.append(path)
        return
    # sorted to avoid duplicate
    for first_index in range(start, n+1):
        self.dfs(res, first_index+1, n, k, path + [first_index], depth+1)

'''
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
'''
