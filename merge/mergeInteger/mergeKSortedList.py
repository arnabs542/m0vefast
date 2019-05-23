from queue import PriorityQueue   # python 3
import heapq
# overwrite the compare function
# so that we can directly put ListNode into heapq
ListNode.__lt__ = lambda x, y: (x.val < y.val)

def mergeksortedlist(self, listoflists):
    if not lists:
        return None
    dummy = cur = ListNode(0)

    heap = []
    for head in lists:
        if head:
            heapq.heappush(heap, head)

    while heap:
        head = heapq.heappop(heap)
        cur.next = head
        cur = cur.next

        if head.next:
            heapq.heappush(heap, head.next)

    return dummy.next




minheap.put()
minheap.get()


heapq.heappush(minheap, object)
heapq.heappop(minheap)

# python 2 and python3 heap: https://leetcode.com/problems/merge-k-sorted-lists/discuss/190398/Python2-and-Python3-heap

# python2:
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

import heapq
class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        heap = []
        for i in range(len(lists)):
            if lists[i]:
                heap.append((lists[i].val,lists[i]))
        heapq.heapify(heap)

        dummy = ListNode(None)
        cur = dummy
        while heap:
            num,node = heapq.heappop(heap)
            cur.next = node
            cur = cur.next
            if node.next:
                heapq.heappush(heap,(node.next.val,node.next))
        return dummy.next


# python3 :
# # Definition for singly-linked list.
# class ListNode:

#     def __init__(self, x):
#         self.val = x
#         self.next = None
#     def __lt__(self, other):
#         return self.val < other.val


import heapq
class Solution:
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        ListNode.__eq__ = lambda self, other: self.val == other.val
        ListNode.__lt__ = lambda self, other: self.val < other.val

        heap = []
        for arr in lists:
            if arr:
                heap.append((arr.val,arr))
        heapq.heapify(heap)

        dummy = ListNode(None)
        cur = dummy
        while heap:
            value,popNode = heapq.heappop(heap)
            cur.next = popNode
            cur = cur.next
            if popNode.next:
                heapq.heappush(heap,(popNode.next.val,popNode.next))
        return dummy.next
