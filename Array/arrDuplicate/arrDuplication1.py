def removeduplicate1(A):
    if A == []:
        return A

    slow = 0  #lazy
    for fast in range(1, len(A)):
        if A[slow] != A[fast]:
            slow += 1
            A[slow] = A[fast]
    return A[:slow+1]
