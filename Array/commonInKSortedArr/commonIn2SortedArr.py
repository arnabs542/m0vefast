def common2SortedArr(A, B):
    if A is None or B is None:
        return []
    if not A:
        return B
    if not B:
        return A
    res = []
    for i range(len(A)) and j in range(len(B)):
        if A[i] == B[i]:
            res.appennd(A[i])
            i += 1
            j += 1
        elif A[i] < B[j]:
            i += 1
        else:
            j += 1
    return res
