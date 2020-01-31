# looping backwards
def merge2SortedArr(arr1, arr2):
	index_1 = len(arr1) - 1
	index_2 = len(arr2) - 1
	index = index_1 + 1 + index_2 + 1 - 1

	# looping backwards
	while index_1 >= 0 and index_2 >= 0:
		if arr1[index_1] > arr2[index_2]:
			arr1[index] = arr1[index_1]
			index_1 -= 1
		else:
			arr1[index] = arr2[index_2]
			index_2 -= 1
		index -= 1

	# while index_1 >= 0:
	# 	arr1[index] = arr1[index_1]
	# 	index_1 -= 1
	# 	index -= 1

	while index_2 >= 0:
		arr1[index] = arr2[index_2]
		index_2 -= 1
		index -= 1


def merge2sortedLists(list1, list2):
	dummy = ListNode(0)
	cur = dummy
	while not one and not two:
		if one.value < two.value:
			cur.next = one.value
			one = one.next
		else:
			cur.next = two.value
			cur = cur.next
		two = one.next

	while not one:
		cur.next = one.next

	while not two:
		cur.next = two.next

	return dummy.next


def mergeKSortedArr(arrayOfArrays):
	from Queue import PriorityQueue
	# .get(), .put(), .empty()

	res = []
	minheap = PriorityQueue()

	for index, arr in enumerate(arrayOfArrays):
		if len(arr):
			minheap.put((arr[0], index, 0))

	while not minheap.empty():
		value, row, col = minheap.get()
		res.append(value)
		if col + 1 < len(arrayOfArrays[row]):
			minheap.put((arrayOfArrays[row][col+1], row, col + 1))

	return res

def mergeKSortedList(listoflists):
	if not listoflists:
		return None

	dummy = cur = ListNode(0)

	import heapq
	heap = []
	for head in listoflists:
		if head:
			heapq.heappush(heap, head)

	while heap:
		head = heapq.heappop(heap)
		cur.next = head
		cur = cur.next

		if head.next:
			heaoq.heappush(heap, head)

	return dummy.next

## using priorityQueue()
def mergeKSortedList(listoflists):
	from Queue import priorityQueue

	if not listoflists:
		return None

	dummy = cur = ListNode(0)
	minheap = PriorityQueue()

	for head in listoflists:
		if head:
			minheap.put(head)

	while heap:
		head = minheap.get()
		cur.next = head
		cur = cur.next

		if head.next:
			minheap.put(head)

	return dummy.next

# minheap.put()
# minheap.get()

# heapq.heappush(minheap, object)
# heapq.heappop(minheap)






