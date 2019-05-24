class Solution:
    def subsets(self, nums):
        self.res = []
        self.dfs(sorted(nums), [], 0)
        return self.res

    def dfs(self, arr, path, index):
        if index == len(arr):
            self.res.append(path)
            return

        self.dfs(arr, path, index+1)
        # can not use: path.extend(arr[index])
        self.dfs(arr, path + [arr[index]], index+1)