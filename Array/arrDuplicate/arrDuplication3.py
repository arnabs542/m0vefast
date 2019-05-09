def removeduplicate0(A):
    if A == []:
        return A

    slow = 0  #lazy
    flag = False

    for fast in range(1, len(A)):
        if A[slow] == A[fast]:
            flag = True
        elif flag:  # not same, slow = prefast, over-writed
            A[slow] = A[fast]
            flag = False
        else:      # not same, slow is not dupliate, write
            slow += 1
            A[slow] = A[fast]

    return A[:slow if flag else slow+1]
