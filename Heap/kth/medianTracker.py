class MedianFinder:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.small = []  # use minheap to mock maxheap by negate value added
        self.big = []


    def addNum(self, num: int) -> None:
        if not self.small or -self.small[0] > num:   # if value is smaller than maxheap, then add to maxheap 
            heapq.heappush(self.small, -num)
        else:
            heapq.heappush(self.big, num)

        if len(self.small) - len(self.big) >= 2:
            heapq.heappush(self.big, -heapq.heappop(self.small))
        elif len(self.small) < len(self.big):
            heapq.heappush(self.small, -heapq.heappop(self.big))


    def findMedian(self) -> float:
        #print(self.small, self.big)

        size = len(self.small) + len(self.big)
        if size == 0:
            return None

        elif size %2 == 0:

            return (self.big[0] - self.small[0])/2.0

        else:
            return -self.small[0]
