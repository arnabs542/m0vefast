# using swap: laioffer
def permutation1(arr):
	res = []
	self.dfs(arr, res, 0)
	return res

def dfs(arr, res, depth):
	if depth == len(arr):
		res.append(arr[:])
		return
	for index in range(depth, len(arr)):
		arr[depth], arr[index] = arr[index], arr[depth]
		self.dfs(res, arr, depth+1)
		arr[depth], arr[] = arr[index], arr[depth]




def permute1(self, nums: List[int]) -> List[List[int]]:
	if nums is None:
		return []
	if nums is []:
		return [[]]

	res = []
	self.dfs(sorted(nums), res, [])
	return res

def dfs(self, arr, res, path):
	if len(arr) == 0:
		res.append(path)
		return
	for i in range(len(arr)):
		self.dfs(arr[:i] + arr[i+1:], res, path + [arr[i]])
