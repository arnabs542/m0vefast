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
    counter = count_s.most_common()   # O(n log k) return k element
    rs = ''
    for i in counter:
        rs += i[0] * i[1]
    return rs

def mostFreqWordNotBanned(str, banned):

    ban = set(banned)
    words = re.findall(r'\w+', str.lower())
    counter = collection.Counter(each for each in words if each not in ban)
    # most common(1) -> [('ball', 2)]
    return counter.most_common(1)[0][0]
