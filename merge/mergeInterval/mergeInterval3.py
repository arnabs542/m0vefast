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


class Interval:
    def __init__(self, start, end):
        self.start = start
        self.end = end

    def __lt__(self, other):
        if self.start.val != other.left.val:
            return self.start.val < other.start.val

        return self.start.is_closed and not other.start.is_closed
