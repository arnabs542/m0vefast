# solution1: heap, time out with large number
import heapq
def findKthNumber(self, m: int, n: int, k: int) -> int:
	A = [i for i in range(1,n+1)]
	B = [j for j in range(1,m+1)]

	minheap = []
	for index, value in enumerate(B):
		heapq.heappush(minheap, (value, index, 0))

	for i in range(k):
		value, x, y = heapq.heappop(minheap)
		if y + 1 < len(A) :
			heapq.heappush(minheap, (B[x] * A[y+1], x, y+1))

	return value

# should use binary search
# https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/discuss/262279/Python-Binary-Search-Need-to-Return-the-Smallest-Candidate
