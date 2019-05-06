###################################### ARRAY ===================================
#type: tuple, list (array)
# binary serach fo sorted list:
bisect.bisect(A, 6)
bisect.bisect_left(A, 6)
bisect.bisect_right(A,6)
# copy

list.reverse()  # inplace
list.sort()
reversed(list) # return iterator
del list[i]
del A[i:j]
#slicing
In [200]: list
Out[200]: [1, 3, 4, 29, 5]

In [201]: list[3:] + list[:3]
Out[201]: [29, 5, 1, 3, 4]
# list comprehension
# input sequence
# iterator
# logical condiciont over the iterator
# expression yields the elements of the derived list
[x**2 for x in range(6)] # [0, 1, 4, 9, 16. 25]
range(6)  # 0,1,2,3,4,5
[x**2 for x in range(6) if x % 2 == 0]   #[0, 4, 16]
# map(), filter(), lambdas   can be replaced by list comprehension

# multiple levels looping
A = [1,3,5]
B = ['a', 'b']
[(x,y) for x in A for y in B]   # combination
# [(1, 'a'), (1, 'b'), (3, 'a'), (3, 'b'), (5, 'a'), (5, 'b')].
# 2D -> 1D
M = [['c', 'd', '3'],['a', 'b']]
[x     for row in M     for x in row] # bigger loop, smaller loop
# [c,d,3,a,b]
# iterating over each entry in a 2D list
A = [[1,2,3],[4,5,6]]
[[x**2 for x in row] for row in M]
# [[1,4,9], [16,25,36]]



###################################### SORT ===================================
list.sort()
list.sort(key, reverse)   # inplace sort # key as mapping funciton
list.sort(key=lambda x:str(x))
b = sorted(list, key=lambda x:str(x))  # return a new list

######################################## FOR LOOP
for each in A[1:]:
# if with condition
a for i, a in enumerate(A)
    if conditionA and conditionB

for (i, salary) in enumerate(current_salaries):

# inner and outter for loop
for i in range(len(A)):  # A=[10,20,100,3, -3]  len = 5, range(5) = 0,1,2,3,4
    min_index = i  # 0 1 2 3 4
    for j in range(i + 1, len(A))

# lose duplicate
# list all elements in a list but not in another list
In [112]: tem = set(list)-set(my_own_order)

In [113]: tem
Out[113]: {4, 5}
# not useing filter
In [114]: tem = [x for x in list if x not in my_own_order]

In [115]: tem
Out[115]: [4, 5]
# using filter fuction filter every element in list
In [116]: filter(lambda x : x not in my_own_order, list)
Out[116]: [4, 5]

#list = {2, 1, 2, 5, 7, 1, 9, 3}, my_own_order = {2, 1, 3},
#A1 is sorted to {2, 2, 1, 1, 3, 5, 7, 9}
def sortSpecial(list, my_own_order):
	order = {key : i for key, i in enumerate(my_own_order)}
	used = [x for x in list if x not in my_own_order]
	# used = filter(lambda x:x in my_own_order, list)

	unused = [x for x in my_own_order if x not in list]
	# unused = filter(lambda x:x not in my_own_order, list)
	used.sort(key=lambda x: order[x])
	# sorted(used, key=lambda x:sorted[x])
	used.extend(unused)

###############################expression
res = -1e9, 1e9  # return type, extreme value
List[int]:

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
