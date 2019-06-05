# focus on the end
def mergeInterval2(self, intervals):
    starts = []
    ends = []
    for i in intervals:
        starts.append(i.start)
        ends.append(i.end)

    starts.sort()
    ends.sort()

    start_index = end_index = 0
    res = available = 0

    while start_index < len(starts):
        # overlap: might need a room
        if(starts[start_index] < ends[end_index]):
            if(available == 0):
                res += 1
            else:
                available -= 1

            start_index += 1  # consider next start index
        # no overlap: can reuse room
        else:
            available += 1
            end_index += 1  # consider next end index

    return res
