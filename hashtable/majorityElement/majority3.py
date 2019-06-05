# majority element:
# // map<candidate, counter>
# // step1: if candidate is key, counter++
# // step2: if candidate not key:
# //   case2.1: if map.size == k-1, all counter--; remove counter== 0
# //   case2.2: if map.size < k-1, add cur as key
# // step3: clear map, and iterate list to select results
#
# // time complexity: O(nk)-> n
# // space complexity: O(k)
# solution1: hashmap with k-1 {keys: counter}
def majority3(arr, k):
    res = None
    dict = {}

    for each in arr:
        if each in dict:
            dict[each] += 1
        else:
            if len(dict) == k - 1:
                for key, value in dict.items():
                    dict[key] -= 1
                    if dict[key] == 0:
                        dict.pop(key)
            else:
                dict[each] = 1

    for key, value in dict.items():
        if dict[key] >= len(arr) // k:
            res.append(key)

    return res



def majority(array, k):
    """
    input: int[] array, int k
    return: Integer[]
    """
    # write your solution here
    res = []
    dict = {}

    for each in array:
        if each in dict:
            dict[each] += 1
        else:
            if len(dict) == k-1:
                for key, value in dict.items():
                    dict[key] -= 1
                reduce(dict)
            else:
                dict[each] = 1

    setZero_restore(dict, array)

    for key, value in dict.items():
        if value > len(array) // k:
            res.append(key)
    print(res)
    return res
def setZero_restore(dict, array):
    for key, value in dict.items():
        dict[key] = 0
    for each in array:
        if each in dict:
            dict[each] += 1


def reduce(dict):
    for key,value in list(dict.items()):
        if dict[key] == 0:
            del (dict[key])


if __name__ == '__main__':
    majority([1,2,2],2)
    #solution2_2()
