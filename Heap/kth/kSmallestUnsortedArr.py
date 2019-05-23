# using minheap
def findKthSmallest(self, nums: List[int], k: int) -> int:
    import heapq
    heap = []
    for num in nums:
        heapq.heappush(heap, -num)
        if len(heap) > k:
            heapq.heappop(heap)

    return heapq.heappop(heap)

# using quickselect: O(n)   https://zh.wikipedia.org/wiki/%E5%BF%AB%E9%80%9F%E9%80%89%E6%8B%A9
def findKthSmallest(self, k, nums):
    return self.quickSelect(nums, 0, len(nums)-1, k-1)   # index compare
# return kth smallest
def quickSelect(self, nums, start, end, k):
    if k > 0 and k <= end - start + 1:
        index = partition(nums, start, end)
    if index - left == k - 1:
        return nums[index]
    elif index - left > k-1:
        return self.quickSelect(nums, start, index-1, k)
    else:
        return self.quickSelect(nums, index+1, end, k-(index-left+1))

def partition(arr, left, right):
    pivot_index = right
    pivot_value = arr[pivot_index]
    i = left
    j = right
    while i <= j:
        if arr[i] < pivot_value:
            i += 1
        elif arr[j] > pivot_value:
            j -= 1
        else:
            arr[i], arr[j] = arr[j], arr[i]
            i -= 1
            j -= 1

    arr[i], arr[pivot_index] = arr[pivot_index], arr[i]
    return pivot_index
