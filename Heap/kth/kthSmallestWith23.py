def kthSmallest23(k):
    import heapq
    heap = []
    visited = set()

    heapq.heappush(heap, 1)
    visited.add(1)

    while k > 1:
        cur = heapq.heappop(heap)
        if cur * 2 not in visited:
            visited.add(cur * 2)
            heapq.heappush(heap, cur * 2)
        if cur * 3 not in visited:
            visited.add(cur * 3)
            heapq.heappush(heap, cur * 3)
        k -= 1

    return heapq.heappop(heap)
