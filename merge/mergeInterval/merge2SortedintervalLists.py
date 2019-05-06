def merge2SortedIntervals(self, list1, list2):
    res = []
    toAdd = cur = None
    #  toAdd: next to be added
    # since all sorted, so toAdd.end should start <= cur
    # cur: the one just addded in
    i = j = 0

    while i < len(list1) and j < len(list2):
        if list1[i] < list2[j]:
            cur = list1[i]
            i+=1
        else:
            cur = list2[j]
            j+=1
        toAdd = self.merge(res, toAdd, cur)

    while i < len(list1):
        toAdd = self.merge(res, toAdd, list1[i])
        i += 1

    while j < len(list2):
        toAdd = self.merge(res, toAdd, list2[j])
        j += 1

    # list1 and 2 has the same length
    if not toAdd:
        res.append(toAdd)

    return res

# return the toAdd: nextToAdd 来记录最后一个还没有被放到 merge results
# 里的 Interval，用于和新加入的 interval 比较看看能不能合并到一起。
def merge(self, res, toAdd, cur):
    if not toAdd:
        return cur

    if toAdd.end < cur.start:
        res.append(toAdd)
        return cur
    else: # toAdd.end >= cur.start: overlap
        toAdd.end = Math.max(toAdd.end, cur.end)
        return toAdd
