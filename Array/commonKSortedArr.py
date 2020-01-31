def common2SortedArr(arr1, arr2):
	if arr1 is None or arr2 is None:
		return []
	if not arr1:
		return arr2
	if not arr2:
		return arr1
	res = []
	while i in range(len(arr1) - 1) and j in range(len(arr2) - 1):
		if arr1[i] == arr[j]:
			res.append(arr[i])
			i += 1
			j += 1
		elif arr1[i] < arr2[j]:
			i += 1
		else:
			j += 1
	return res


def common3SortedArr(arr1, arr2, arr3):
	if arr1 is None or arr2 is None or arr3 is None:
		return []
	while i in range(len(arr1) - 1) and j in range(len(arr2) - 1) and k in range(len(arr3)):
		if arr1[i] == arr2[j] == arr3[k]:
			res.append(arr1[i])
			i += 1
			j += 1
			k += 1
		elif arr1[i] < arr2[j] and arr1[i] < arr3[k]:
			i += 1
		elif arr2[j] < arr1[i] and arr2[j] < arr3[k]:
			j += 1
		else:
			k += 1
	return res

'''
//FB：firstKCommonElements
//k common elements in n sorted arrays
//https://blog.csdn.net/yaokai_assultmaster/article/details/53938792
'''
def commonkSortedArr(lists, k):
    









