# the majority number is the number that occurs more than half of the size of the array.
# soloution1: hashmap   O(n) O(n)

# solution2: k-1 counter O(n)  O(1)
# // map<candidate, counter>
# // case1: counter==0,counter++, update candidate
# // case2.1: if cur == candidate, counter++
# // case2.2: if not, counter--
def majority1(arr):
    res = None
    counter = 1
    for each in arr:
        if each == res:
            counter += 1
        else:
            counter -= 1
            if counter == 0:
                res = each
                counter = 1

    return res


# Boyer–Moore majority vote algorithm
