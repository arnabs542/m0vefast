# solution1: tracking each row in maxheap
def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
    import heapq

    sortedMatrix = []
    for each_row in matrix:
        if each_row:
            sortedMatrix.append(sorted(each_row, reverse=True))

   # maxheap = [(-each_sorted_row[0], row_index, 0) for row_index, row in enumerate(sortedMatrix)]
   # heapq.heapify(maxheap)

   maxheap = []
   for row_index, row in enumerate(sortedMatrix):
       heapq.heappush(maxheap, (-row[0], row_index, 0))

   for i in range(k):
       value, x, y = heapq.heappop(maxheap)
       value = -value
       if y + 1 < len(sortedMatrix[x]):
           heapq.heappush(maxheap, (-sortedMatrix[x][y+1], x, y+1))

   return value


# solution2: tracking one element in maxheap
def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
    import heapq


    sortedMatrix = []
    for row in matrix:
        if row:
            sortedMatrix.append(sorted(row, reverse=True))

    maxheap = [(-each_row[0], row_index, 0) for row_index, each_row in enumerate(sortedMatrix)]
    heapq.heapify(maxheap)

    for i in range(k):
        value, x, y = heapq.heappop(maxheap)
        value = -value
        if y + 1 < len(sortedMatrix[x]):
            heapq.heappush(maxheap, (-sortedMatrix[x][y+1], x, y))

    return value
