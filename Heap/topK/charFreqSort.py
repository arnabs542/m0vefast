def charFreqSort(str):
    count = collections.Counter(str)

    maxheap = [(-freq, char) for char, freq in count.items()]
    heapq.heapify(maxheap)

    res = ""
    for i in range(len(maxheap)):
        pair = heapq.heappop(maxheap)
        res += pair[1] * (-pair[0])

    return res


def frequencySort(self, s):
    import collections
    if not s:
        return ""
    count = collections.Counter(s)
    counter = count_s.most_common()
    rs = ''
    for i in counter:
        rs += i[0] * i[1]
    return rs
