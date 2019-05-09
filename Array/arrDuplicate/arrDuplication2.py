def removeduplicate2(A):
    if A == []:
        return

    slow = 0   # lazy
    counter = 1

    for fast in range(1, len(A)):
        if A[fast] == A[slow]:
            if counter < 2:
                counter += 1
                slow += 1
                A[slow] = A[fast]
        else:
            counter = 1
            slow += 1
            A[slow] = A[fast]

    return A[:slow+1]
