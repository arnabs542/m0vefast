class Solution:
    def mergeKIntervals(self, intervals):
        intervals = sorted(intervals, key=lambda x:x.start)
        res = []
        for each in intervals:
            if(len(res) == 0 or res[-1].end < each.start):
                res.append(each)
            else:
                res[-1].end = max(res[-1].end, each.end)
        return res




"""
Definition of Interval.
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""
