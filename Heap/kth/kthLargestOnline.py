 class KthLargest:
     def __init__(self, k: int, nums:List[int]):
        self.pool = nums
        self.k = k
        heaqp.heapify(self.pool)
        while self.pool:
            heapq.heappop(self.pool)

     def add(self, val: int)->int:
        if len(self.pool) < self.k:
            heapq.heappush(self.pool, val)

        else:
            heapq.heappushpop(self.pool, val)
        return self.pool[0]


# obj = KthLargest(k, nums)
# param_1 = obj.add(val)
