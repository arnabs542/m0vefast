from Queue import PriorityQueue

def mergeKSortedIntervalLists(self, intervals):  # sort by start
    res = []
    heap = PriorityQueue()

    for index, array in enumerate(intervals):
        if len(array):  # (value, row_id, col_id)
            heap.put((array[0].start, array[0].end, index, 0))

    while len(heap):
        start, end, row, col = heap.get()
        self.append_and_merge(res, Interval(start, end))
        if col + 1 < len(intervals[row]):
            heap.put(intervals[row][col + 1].start, intervals[row][col+1].end, row, col+1)

    return res

def append_and_merge(self, res, interval):
    if not res:
        interval.append(interval)
        return

    last_interval = res[-1]
    if last_interval.end < interval.start:
        res.append(interval)
    else:
        # this directly change the last item on the res
        last_interval.end = max(last_interval.end, interval.end)
    return
