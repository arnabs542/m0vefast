'''
top k frequent elements
top k largest number1 and 2
top k hightest gpa
top k frequent words1 and 2, mapReduce
top k largest number1 and 2
'''

import heapq
from matplotlib import collections
from xlwings import xrange


# solution 1 using hasmap + array(sort)
# words: a list of string
def topKFrequentWords1(self, words, k):
    # step1: hasmap to count
    dict = {}
    for word in words:
        if word not in dict:
            dict[word] = 1
        else:
            dict[word] += 1

    # stet2: pq
    pq = []
    for key, value in dict.items():  # map.entry()
        pq.append((value, key))

    p.sort(cmp=self.cmp)

    res = []
    for i in range(k):
        res.append(pq[i][1])
    return res

# self defined comparator
# only in python 2
def cmp(self, a, b):
    if a[0]>b[0] or (a[0] == b[0] and a[1] <  b[1]):
        return -1
    elif a[0] == b[0] and a[1] == b[1]:
        return 0
    else:
        return 1


# solution2: using map and maxheap
def topKFrequentWords1(words, k):
    # hashmap to count
    count = collections.Counter(words)
    # using minheap->maxheap (-freq, word)
    heap = [(-freq, word) for word, freq in count.items()]
    heapq.heapify(heap)
    # return the top k
    return [heapq.heappop(heap)[1] for _ in range(k)]  # _ for the result of the previous exeution

# print(count)
# Counter({'i': 2, 'love': 2, 'leetcode': 1, 'coding': 1})
# print(heap)
# [(-2, 'i'), (-2, 'love'), (-1, 'leetcode'), (-1, 'coding')]





if __name__ == '__main__':
    words = ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"]
    k = 4
    topKFrequentWords1(words, k)
