# using swap: laioffer
def permutation2(arr):
	res = []
	self.dfs(arr, res, 0)
	return res

def dfs(arr, res, depth):
	if depth == len(arr):
		res.append(arr)
		return
    # for curretn level, do not add duplicate char
    visited = set()
	for index in range(depth, len(arr)):
        if arr[index] not in visited:
            arr[depth], arr[index] = arr[index], arr[depth]
            self.dfs(res, arr, depth+1)
            arr[depth], arr[] = arr[index], arr[depth]


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
