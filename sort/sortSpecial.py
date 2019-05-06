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
	unused.sort()

	used.extend(unused)


##############################################
# lose duplicate
# list all elements in a list but not in another list
tem = set(list)-set(my_own_order)

# special order
L = [("Alice", 25), ("Bob", 20), ("Alex", 5)]
L.sort(key=lambda x: x[1])
print(L)
# output
# [('Alex', 5), ('Bob', 20), ('Alice', 25)]



In [71]: list = [
    ...:     {'value': "typeA"},
    ...:     {'value': "typeC"},
    ...:     {'value': "typeB"},
    ...:     {'value': "typeC"},
    ...:     {'value': "typeB"},
    ...:     {'value': "typeA"}
    ...: ]

In [72]: my_own_order = ['typeB', 'typeC', 'typeA']

In [73]: order = {key : i for key, i in enumerate(my_own_order)}

In [74]: order
Out[74]: {0: 'typeB', 1: 'typeC', 2: 'typeA'}

In [79]: order = {i : key  for key, i in enumerate(my_own_order)}

In [80]: order
Out[80]: {'typeA': 2, 'typeB': 0, 'typeC': 1}

In [75]: order = {i: key for key, i in enumerate(my_own_order)}

In [76]: order
Out[76]: {'typeA': 2, 'typeB': 0, 'typeC': 1}

In [77]: order = {key : i for i, key in enumerate(my_own_order)}

In [78]: order
Out[78]: {'typeA': 2, 'typeB': 0, 'typeC': 1}

>>> sorted(lst, key=lambda d: order[d['value']])
[{'value': 'typeB'},
 {'value': 'typeB'},
 {'value': 'typeC'},
 {'value': 'typeC'},
 {'value': 'typeA'},
 {'value': 'typeA'}]
