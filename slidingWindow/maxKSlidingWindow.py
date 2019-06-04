'''
Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7]
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
'''

# using a maxheap
def maxKSlidingWindow(arr, k):
    return
# maxheap to put (value, index)



# using a deque
#For every element, the previous smaller elements are useless so remove them from deque， keep bigIndex at leftside,
#deque is decesding in array's value
def maxKSlidingWindow(arr, k):
    if arr is None or not arr or not k:
        return []
    res = []
    deque = collections.deque([])
    for i in range(len(arr)):
        self.push(deque, arr, i)
        if i + 1 >= k:  # start adding to res
            res.append(deque[0])
            if deque[0] <= i - k + 1:
                deque.popleft()

    return res

# keep the deque decending, only the biggest[0] needs to be considered
# invarnat: added index means in the sliding window
def push(self, deque, arr, i):
    while deque and arr[deque[-1] < arr[i]]:
        deque.pop()
    deque.append(i)
