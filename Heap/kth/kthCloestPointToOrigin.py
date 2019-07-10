"""
    @param points: a list of points
    @param origin: a point
    @param k: An integer
    @return: the k closest points

	class Point:
    def __init__(self, a=0, b=0):
        self.x = a
        self.y = b

    """
# solution: minheap
# O(k) + (n-k)lgk + (n-k)   -> (nlgk), O(k)
 def kClosest(self, points: List[List[int]], K: int) -> List[List[int]]:
        # using priority queue with size k, sorting by distance
        if points is None or not points:
            return points
        minheap = []
        for index, point in enumerate(points):
            heapq.heappush(minheap, (-self.getDistance(point), point))

            if len(minheap) > K:
                heapq.heappop(minheap)

        return [heapq.heappop(minheap)[1] for i in range(K)]

    def getDistance(self, point):
        return point[0]**2 + point[1]**2

# O(nlgn + k) = O(nlgn), O(n)
def kClosest(self, points: List[List[int]], K: int) -> List[List[int]]:
        res = []
        minheap = []
        for point in points:
            heapq.heappush(minheap, (self.getDist(point), point[0], point[1]))

        for i in range(K):
            dis, x, y = heapq.heappop(minheap)
            res.append(Point(x, y))
        return res


    def getDist(self, point):
        return point[0]**2 + point[1]**2

# solution: mapheap O(nlgk), O(k)
def kClosest(self, points, origin, k):
	res = []

	heap = []
	for point in points:
		dist = self.getDistance(point, origin)
		# maxheap: from far to near
		# 按照距离由小到大返回。如果两个点有相同距离，则按照x值来排序；若x值也相同，就再按照y值排序
		heapq.heappush(heap, (-dist, -point.x, -point.y))

		if len(heap) > k:
			heapq.heappop(heap)

	while heap:
		dist, x, y = heapq.heappop(heap)
		res.append(Point(-x, -y))

	res.reverse()
	return res

def getDistance(self, a, b):
	return (a.x - b.x) ** 2 + (a.y - b.y)**2
