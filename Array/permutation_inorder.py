# key: how to know if an element is permuted or not

def apply_permutation(perm, A):
    for i in range(len(A)):

        # check if A[i] has not been permuted by checking if perm[i] is non-negative
        next = i
        while perm[next] >= 0:
            # i like temp index for swaped original spot value
            # perm[index] is the current A's index to deal with
            # A[X] should be moved to perm[index]
            A[i], A[perm[next]] = A[perm[next]], A[i]
            # temp is the next index of perm to deal with
            temp = perm[next]
            perm[next] -= len(perm)
            next = temp

    perm[:] = [a + len(perm) for a in perm]
    # [:] list.copy()
    print(A)



if __name__ == '__main__':
    A = [7, 8, 9, 10]
    perm = [3, 1, 0, 2]
    apply_permutation(perm, A)
