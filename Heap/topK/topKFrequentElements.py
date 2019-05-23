def topKFrequent(self, nums: List[int], k: int) -> List[int]:
    count = collections.Counter(nums)

    heap = [(-freq, num) for num, freq in count.items()]
    heapq.heapify(heap)

    return [heapq.heappop(heap)[1] for i in range(k)]
        
