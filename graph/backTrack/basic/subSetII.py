def subsets2(self, arr):
    res = []
    self.dfs(sorted(arr), res, [], 0)
    return res

def dfs(self, arr, res, path, index):
    if index == len(arr):
        res.append(path)
        return

    self.dfs(arr, res, path+[arr[index]], index+1)
    while index + 1 < len(arr) and arr[index] == arr[index+1]:
        index += 1

    self.dfs(arr, res, path, index+1)
