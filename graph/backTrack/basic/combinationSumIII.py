'''
Find all possible combinations of k numbers that add up to a number n,
given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Note:

All numbers will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
'''
def combinationSum3(k, n):
    res = []
    self.dfs(k, n, 1, [], res, 0)
    return res

def dfs(self, k, target, start, path, res, depth):
    if depth == k:
        if sum(path) == target:
            res.append(path)
        return

    for i in range(start, 10):
        self.dfs(k, target, i+1, path+[i], res, depth+1)
