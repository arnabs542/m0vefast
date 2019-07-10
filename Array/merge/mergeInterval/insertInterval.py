# the lyft question   O(n)
def mergeInterval3(intervals, to_add):
    i = 0
    res = []
    # intervals in intervals which cone before new_interval
    while (i < len(intervals) and to_add.start > intervals[i].end):
        res.append(intervals[i])
        i += 1

    while (i < len(intervals) and to_add.end >= intervals[i].start):
        to_add = Interval(min(to_add.start, intervals[i].start),
                        max(to_add.start, intervals[i].end))
        i += 1

    return res + to_add + intervals[i:]


class Solution:
    def mergeIntervals(self, intervals):
        intervals.sort(key=lambda x:x.start)
        #intervals = sorted(intervals, key=lambda x:x.start)
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
