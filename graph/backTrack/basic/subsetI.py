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


# depth: consider curretn index
# branching factor: pick or not pick



def search(self, nums, S, index):
        if index == len(nums):
            self.results.append(S)
            return

        self.search(nums, S + [nums[index]], index + 1)
        self.search(nums, S, index + 1)

    def subsets(self, nums):
        self.results = []
        self.search(sorted(nums), [], 0)
        return self.results
