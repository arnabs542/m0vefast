#
def kthSmallestSum2SortedArr(A, B, k):

    if not A and not B:
        return None
    if not A:
        return B[k-1]
    if not B:
        return A[k-1]


    alen, blen = len(A), len(B)
    import heapq
    minheap = [(0, 0, A[0]+B[0])]
    visited = set() # record if coordinate is visited
    num = None

    for i in range(k):
        x, y, num = heapq.heappop(minheap)
        if x + 1 < alen and (x+1, y) not in visited:
            heapq.heappush(minheap, (x+1, y, A[x+1]+B[y]))
            visited.add((x+1,y))
        if y + 1 < blen and (x, y+1) not in visited:
            heapq.heappush(minheap, (x, y+1, A[x]+B[y+1]))
            visited.add((x,y+1))
    return num


# return k pairs
def kSmallestPairs(self, A: List[int], B: List[int], k: int) -> List[List[int]]:
        if not A or not B:
            return []

        n, m = len(A), len(B)
        minheap = [(A[0] + B[0], 0, 0)]
        visited = set([0])
        res = []
        for _ in range(k):
            if not minheap:
                break
            value, x, y = heapq.heappop(minheap)
            res.append((A[x], B[y]))
            if x + 1 < n and (x + 1) * m + y not in visited:
                heapq.heappush(minheap, (A[x + 1] + B[y], x + 1, y))
                visited.add((x + 1) * m + y)
            if y + 1 < m and x * m + y + 1 not in visited:
                heapq.heappush(minheap, (A[x] + B[y + 1], x, y + 1))
                visited.add(x * m + y + 1)

        return res
