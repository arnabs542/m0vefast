def permute2(self, nums: List[int]) -> List[List[int]]:
    if nums is None:
        return []
    if nums is []:
        return [[]]
    res = []
    self.dfs(sorted(nums), res, [])
    return res

def dfs(self, arr, res, path):
    if arr is []:
        res.append(path)
        return
    for i in range(len(arr)):
        if i > 0 and arr[i] == arr[i-1]:
            continue
        self.dfs(arr[:i] + arr[i+1:], res, path + [arr[i]])
