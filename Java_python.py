###################################### SORT ===================================
list.sort()
list.sort(key, reverse)   # inplace sort # key as mapping funciton
list.sort(key=lambda x:str(x))
b = sorted(list, key=lambda x:str(x))  # return a new list

# HOW TO USE FOR LOOP
for each in A[1:]:
# if with condition
a for i, a in enumerate(A)
    if conditionA and conditionB




###################################### SORT ===================================
# reverse list/string
class Solution(Object):
    def reverseString(self, s):
        return s[::-1]
        # seq[start:end:step]
        # -1代表从反序来读该字符串

# https://www.1point3acres.com/bbs/thread-207345-1-1.html

# sort a list
list.sort()    # inplace sort
sorted(list)   # expensive

# xrange is faster than range

#
x if y else z

# matrix    if matrix = [] then row = 0, col = 0
matrix = [[1,2,3], [4,5,6]]
row = len(matrix)
col = len(matrix[0]) if row else 0

# initialize 0 to list
list = [0 for i in range(3)]   # list = [0,0,0]
list = [[0 for i in range(3)] for j in range(2)] # list = [[0,0,0], [0,0,0]]

###################################### HASHMAP ===================================
D = {}
if 1 in D:
    val = D[1]
else
    val = 0
# is equal to
D.get(1, 0)

for key, value in map.items():
    map[key] = value
    
# Counter object
counter = collections.Counter()  #return a hashmap
for word in ['red', 'blue', 'orange']:
    counter[word] += 1

counter
# Counter({'blue': 3, 'red': 2, 'green': 1})
counter['blue']
3

counter.clear()
set(counter) # convert a map to a set


###################################### DEQUE ===================================
TODO: check how to use deque
# fast queue
import collections
import bisect
# from collections import deque
# Collections.deque  # O(1) time to pop() on both side
list.append(x)   # add x to the right side of deque
list.appendleft(x)  # add x to the left side of deque
list.clear()
list.count(x)




# counter
Counter

# no return
yield
