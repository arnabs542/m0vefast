def removeduplicate0(A):
    if A == []:
        return A

    slow = 0  #lazy
    flag = False
    arr = list(A)

    for fast in range(1, len(arr)):
        if arr[slow] == arr[fast]:  # same
            flag = True
        elif flag:  # not same, seen, slow = prefast, over-writed
            arr[slow] = arr[fast]
            flag = False
        else:      # not same, not seen, slow is not dupliate, write
            slow += 1
            arr[slow] = arr[fast]

    return ''.join(arr[:slow if seen else slow+1])
