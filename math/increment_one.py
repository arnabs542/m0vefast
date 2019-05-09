def plus_one(A):
    # [1,2,9] -> plue one -> [1,3,0]
    # [1,10,9] -> [1,1,1,0]
    # brute force: convert to integer, overflow
    # optimize: directly modify on array element
    A[-1] += 1              # eg: 1,9,9  ->  1,9,10

    for i in reversed(range(1, len(A))):
        if A[i] != 10:
            break
        else:
            A[i] = 0        # eg: 1,9,9  ->  1,10,0
            A[i-1] += 1     # eg: 1,9,9  ->  2,0,0

    # check if the last digit has a carry out:
    if A[0] == 10: # there is a carry-out
        A[0] = 1
        A.append(0)   # append in the end

    return A
