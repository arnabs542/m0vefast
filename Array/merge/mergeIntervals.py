def canMeet(intervals):
	intervals.sort(key=lambda x : x.start)

	for i in range(1, len(intervals)):
		if intervals[i].end < intervals[i-1].end:
			return False

	return True

def meeting_rooms(intervals):
	starts, ends = [], []
	for each in intervals:
		starts.append(each.start)
		ends.append(each.end)

	starts.sort()
	ends.sort()

	start_index = end_index = 0
	res = available = 0

	while start_index < len(starts) and end_index <len(ends):
		# overlap: might need a room
		if starts[start_index] < ends[end_index]:
			if available == 0:
				res += 1
			else:
				available -= 1

			start_index += 1 # think of next start index
		# no overlap: can reuse a room
		else:
			available += 1
			end_index += 1 # consider next end index

	return res

def insertInterval(intervals, to_add):
	i = 0
	res = []

	while i < len(intervals) and to_add.start > intervals[i].end:
		res.append(intervals[i])
		i += 1
										# >=
	while i < len(intervals) and to_add.end >= intervals[i].start:
		to_add = Interval(min(to_add.start, intervals[i].start),
							max(to_add.end, intervals[i].end))
		i += 1

	return res + to_add + intervals[i:]

# flatten and merge with no overlap 
def flattenIntervals(intervals):
	intervals.sort(key=lambda x: x.start)

	res = []
	i = 0

	while i in range(len(intervals)):
		if len(res) == 0 or res[-1].end < intervals[i].start:
			res.append(intervals[i])
			
		else:
			res[-1].end = max(res[-1].end, intervals[i].end)
		i += 1

	return res


def merge2Intervals(interval1, interval2):
	res = []
	i, j = 0, 0
	while i < len(interval1) and j < len(interval2):
		if interval1[i].start < interval2[j].start:
			merge(res, interval1[i])
			i += 1
		else:
			merge(res, interval2[j])
			j += 1

	while i < len(interval1):
		merge(res, interval1[i])
		i += 1

	while i < len(interval2):
		merge(res, interval2[j])
		j += 1

	return res

def merge(res, interval):
	if not res:
		res.append(interval)
		return

	else:
		last = res[-1]
		if last.end >= interval.start:
			last.end = max(last.end, interval.end)
		else:
			res.append(interval)


def mergekIntervals(intervals):
	from queue import PriorityQueue()
	res = []
	minheap = PriorityQueue()

	for index, array in enumerate(intervals):
		if len(array):
			minheap.put(index, 0, array[0])

	while len(minheap):
		value, row, col = minheap.get()
		append_and_merge(res, Interval(value.start, value.end))

		if col + 1 < len(intervals[row]):
			minheap.put(row, col+1, array[row][col+1])

	return res

def append_and_merge(res, interval):
	if not res:
		res.append(interval)
		return 

	else:
		last = res[-1]
		if last.end >= interval.start:
			last.end = max(last.end, interval.end)
		else:
			res.append(interval)
	return 



























