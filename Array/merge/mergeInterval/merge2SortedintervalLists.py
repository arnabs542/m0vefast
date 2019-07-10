def merge2SortedIntervals(self, list1, list2):
    res = []
    i, j = 0, 0
    while i < len(list1) and j < len(list2):
        if list1[i].start < list2[j].start:
            merge(res, list1[i])
            i += 1
        else:
            merge(res, list2[j])
            i+= 1
    while i < len(list1):
        merge(res, list1[i])
        i += 1
    while j < len(list2):
        merge(res, list2[j])
        i += 1
    return res

def merge(res, interval):
    if not res:
        res.append(interval)
        return
    last = res[-1]
    if last.end >= interval.start:
        last.end = max(last.end, interval.end)

    return
