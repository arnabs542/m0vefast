def inRangeKArrs(self, listoflists):
    heap = PriorityQueue()
    res = -1e9, 1e9  # return type, extreme value
    min_range = -1e9

    for index, list in listoflists:
        heap.put(list[0], index, 0)
        right = max(right, list[0])

    #arr = [(row[0], i, 0) for i, row in enumerate(listoflists)]
    #heapq.heapify(arr)
    # right = max(row[0] for row in listoflists)

    while heap:
        value, row, col = heap.get()
        range = right - value
        # check range every time pop
        if range < min_range:
            min_range = range
            res = value, right

        if col + 1 < len(listoflists[row]):
            heap.put(listoflists[row][col + 1], row, col+1)
            # update max when new elements comes in
            right = max(listoflists[row][col + 1], right)

    return res
