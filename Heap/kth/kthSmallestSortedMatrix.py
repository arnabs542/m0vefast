# solution1: tracking one item in minheap
def kthSmallestSortedMatrix(self, matrix: List[List[int]], k: int) -> int:
	import heapq
	row = len(matrix)
	col = len(matrix[0]) if row else 0

	minheap = []
	heapq.heappush(minheap, (matrix[0][0], 0, 0))
	visited = set()
	visited.add((0,0))

	for i in range(k):
		value, x, y = heapq.heappop(minheap)
		if y + 1 < col and (x, y+1) not in visited:
			heapq.heappush(minheap, (matrix[x][y+1], x, y+1))
			visited.add((x, y+1))
		if x + 1 < row and (x+1, y) not in visited:
			heapq.heappush(minheap, (matrix[x+1][y], x+1, y))
			visited.add((x+1, y))
	return value

# solution2: tracking each row head in minheap
def kthSmallestSortedMatrix(self, matrix: List[List[int]], k: int) -> int:
	import heapq
	row = len(matrix)
	col = len(matrix[0]) if row else 0
	minheap = [(row[0], row_index, 0) for row_index, row in enumerate(matrix)]
	heapq.heapify(minheap)

	for i in range(k):
	    value, x, y = heapq.heappop(minheap)
	    if y + 1 < col:
	        heapq.heappush(minheap, (matrix[x][y+1], x, y+1))

	return value
