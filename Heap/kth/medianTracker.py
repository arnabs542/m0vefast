class MedianFinder:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.smallhalf = []
        self.largehalf = []

    def addNum(self, num: int) -> None:
        # add value
        if not self.smallhalf or num <= self.smallhalf[0]:
            heapq.heappush(self.smallhalf, num)
        else:
            heapq.heappush(self.largehalf, -num)
        # maintain balance
        if len(self.smallhalf) - len(self.largehalf) >= 2:
            heapq.heappush(self.largehalf, (-heapq.heappop(self.smallhalf)))
        elif len(self.smallhalf) < len(self.largehalf):
            heapq.heappush(self.smallhalf, (-heapq.heappop(self.largehalf)))



    def findMedian(self) -> float:
        size = len(self.smallhalf) + len(self.largehalf)
        if size == 0:
            return None
        if size % 2 == 0:
            return self.smallhalf[0]
        else:
            return (self.smallhalf[0] + self.largehalf[0])/2


# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()
