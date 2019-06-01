def common3SortedArr(A, B, C):
    if A is None or B is None or C is None:
        return []
    res = []

    while i in range(len(A)) and j in range(len(B)) and k in range(len(C)):
        if A[i] == B[j] and A[i] == C[k]:
            res.append(A[i])
            i += 1
            j += 1
            k += 1
        elif A[i] < B[j] and A[i] < C[k]:
            i += 1
        elif B[j] < A[i] and B[j] < C[k]:
            j += 1
        else:
            c += 1
    return res
    
