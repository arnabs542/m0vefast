# Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
def combine(self, n: int, k: int) -> List[List[int]]:
    res = []
    self.dfs(res, 1, n, k, path, depth)
    return res

def dfs(self, res, start, n, k, path, depth):
    if depth == k:
        res.append(path)
        return

    for first_index in range(start, n+1):
        self.dfs(res, first_index+1, n, k, path + [first_index], depth+1)
